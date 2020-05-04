package cn.main.controller.backed.lock;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.main.dao.orderdetails.OrderDetailsMapper;
import cn.main.pojo.Address;
import cn.main.pojo.Good;
import cn.main.pojo.Order;
import cn.main.pojo.OrderDetails;
import cn.main.pojo.Shop;
import cn.main.pojo.User;
import cn.main.service.GoodService;
import cn.main.service.OrderDetailsService;
import cn.main.service.OrderService;
import cn.main.service.ShopService;
import cn.main.utils.AlipayConfig;
import cn.main.utils.Contains; 
import cn.main.utils.StringUtil;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient; 
import com.alipay.api.request.AlipayTradePagePayRequest; 

//@Controller
//@RequestMapping("pay")
public class AlipayController {
	AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, // 请求网关
			AlipayConfig.APPID, // APPID 沙箱测试
			AlipayConfig.RSA_PRIVATE_KEY,// 开发者私钥 开发者创建
			AlipayConfig.FORMAT,// 参数返回格式json
			AlipayConfig.CHARSET, // 字符编码
			AlipayConfig.ALIPAY_PUBLIC_KEY, // 支付宝公钥 支付宝创建
			AlipayConfig.SIGNTYPE // ，目前支持 RSA2 和 RSA，推荐使用 RSA2
	); // 获得初始化的AlipayClient，可以使用同一个对象，通过set 商户授权令牌（app_auth_token） 代替商户发起请求
	private Logger logger = Logger.getLogger(getClass());

	@Resource
	private GoodService goodService;

	@Resource
	private ShopService shopService;

	@Resource
	private OrderDetailsService detailsService;

	@Resource
	private OrderService orderService;

	@RequestMapping("alipay")
	// POST请求 请求此页面,输出一个带有字符二维码的表单,
	public void doPost(HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) throws ServletException,
			IOException {
		// 根据post请求的参数获取信息 sid 、 gid 和 number
		Integer gid = Integer.parseInt(httpRequest.getParameter("gid"));
		Integer sid = Integer.parseInt(httpRequest.getParameter("sid"));
		Integer number = Integer.parseInt(httpRequest.getParameter("number"));

		logger.debug(">>>>>>" + gid);
		logger.debug(">>>>>>" + sid);
		logger.debug(">>>>>>" + number);
		// 根据id获取商品
		Good good = goodService.getGoodList(gid, sid, null, null, null, null,
				null, null, null).get(0);
		// 根据id获取商店
		Shop shop = shopService.getShopById(sid,null, null);
		// session获取用户
		User user = (User) httpRequest.getSession().getAttribute(
				Contains.SESSION_USER);
		//获取用户的默认收货地址
		
		//Address address =
		
		
		// 生成订单
		Order order = new Order();
		// 唯一订单，作为订单参数和邮递参数
		String code = StringUtil.getRandomOrderId(user.getId(), sid, gid);
		order.setOrderCode(code);
		order.setUid(user.getId());
		order.setLogidtics(code);
		logger.debug(good.getPrice());
		order.setPrice(good.getPrice() * number);
		if (orderService.addOrder(order) > 0) {// 添加到数据库一条记录
			// 刚刚添加进去的订单外键，匹配code,
//			Integer oid = orderService
//					.getOrderList(null, null, code, null, null, null, null,
//							null, null, null).get(0).getId();
			Integer oid = orderService
					.getOrderList(null, null, null, null, null, code, null,null, null, null, null, null, null, null).get(0).getId();
			OrderDetails details = new OrderDetails();
			details.setGid(gid);
			details.setSid(sid);
			details.setNumber(number);
			details.setOid(oid);// 设置外键
			details.setPrice(good.getPrice() * number);
			detailsService.addOrderDatils(details);
			// 将集合设置到集合对象
			List<OrderDetails> list = detailsService.getOrderDetailsList(null,
					oid, sid, gid, null, null, null, null);
			order.setOrderDetails(list);
			Double price = (double) 0;
			for (OrderDetails orderDetails : list) {
				price += orderDetails.getPrice();
			}
		}
		String title = order.getOrderDetails().size()+ "件商品:";
		String name = "";
		for (OrderDetails details : order.getOrderDetails()) {
			Good g = goodService.getGoodList(details.getGid(),
					details.getSid(), null, null, null, null, null, null, null)
					.get(0);
			name += g.getName()+"*"+details.getNumber() + ",";
		}
		String c = "{" + "\"out_trade_no\":\"" + order.getOrderCode() + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\","
				+ "\"total_amount\":\"" + order.getPrice() + "\","
				+ "\"subject\":\"" + title + "\"," + "\"body\":\"" + name
				+ "\"" + "}";

		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); // 创建API对应的request
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url); // 在公共参数中设置回跳和通知地址
		// alipayRequest.putOtherTextParam("app_auth_token","202003BBc9d587122db64a839d4a0e462b487X22");
		// //isv子调用app_auth_token参数
		logger.debug(">>>>>>>  " + c);
		alipayRequest.setBizContent(c); // 填充业务参数

		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		httpResponse
				.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
		httpResponse.getWriter().write(form); // 直接将完整的表单html输出到页面
		httpResponse.getWriter().flush();
		httpResponse.getWriter().close();
	}

	@RequestMapping(value = "return_url")
	// @ResponseBody
	public String return_url(HttpServletRequest request)
			throws UnsupportedEncodingException, AlipayApiException {
		// Map<String,String> params = new HashMap<String,String>();
		// Map requestParams = request.getParameterMap();
		// for (Iterator iter = requestParams.keySet().iterator();
		// iter.hasNext();) {
		// String name = (String) iter.next();
		// String[] values = (String[]) requestParams.get(name);
		// String valueStr = "";
		// for (int i = 0; i < values.length; i++) {
		// valueStr = (i == values.length - 1) ? valueStr + values[i]
		// : valueStr + values[i] + ",";
		// }
		// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
		// params.put(name, valueStr);
		// }
		// String out_trade_no = new
		// String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		// String trade_no = new
		// String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		// boolean verify_result = AlipaySignature.rsaCheckV1(params,
		// AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, "RSA2");
		// if(verify_result){//验证成功
		// out.println("验证成功--<h1>支付成功！</h1>");
		// //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
		// }else{
		// out.println("验证失败--<h1>支付失败！</h1>");
		// } 
		
		return "pay/return_url";
	}

	@RequestMapping(value = "notify_url")
	@ResponseBody
	public String notify_url(HttpServletRequest request)
			throws UnsupportedEncodingException, AlipayApiException {
//		Map<String, String> params = new HashMap<String, String>();
//		Map requestParams = request.getParameterMap();
//		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
//			String name = (String) iter.next();
//			String[] values = (String[]) requestParams.get(name);
//			String valueStr = "";
//			for (int i = 0; i < values.length; i++) {
//				valueStr = (i == values.length - 1) ? valueStr + values[i]
//						: valueStr + values[i] + ",";
//			}
//			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
//			params.put(name, valueStr);
//		}
//		// 商户订单号 
//		String out_trade_no = new String(request.getParameter("out_trade_no")
//				.getBytes("ISO-8859-1"), "UTF-8");
//		// 支付宝交易号 
//		String trade_no = new String(request.getParameter("trade_no").getBytes(
//				"ISO-8859-1"), "UTF-8"); 
//		// 交易状态
		String trade_status = new String(request.getParameter("trade_status")
				.getBytes("ISO-8859-1"), "UTF-8");
//		logger.debug(">>>>>>>>>>>>>out_trade_no"+out_trade_no);
//		logger.debug(">>>>>>>>>>>>>trade_no"+trade_no);
//		logger.debug(">>>>>>>>>>>>>trade_status"+trade_status);
//		boolean verify_result = AlipaySignature.rsaCheckV1(params,
//				AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, "RSA2");
//		if (verify_result) {// 验证成功
//			if (trade_status.equals("TRADE_FINISHED")) {
//					orderService.updateOrder(out_trade_no, 2);
//			} else if (trade_status.equals("TRADE_SUCCESS")) {
//			}
//			return "success";
//		} else {// 验证失败
//			return "fail";
//		} 
		return "pay/notify_url";
	}

}
