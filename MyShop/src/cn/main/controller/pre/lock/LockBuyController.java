package cn.main.controller.pre.lock;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;

import cn.main.pojo.Address;
import cn.main.pojo.Good;
import cn.main.pojo.Order;
import cn.main.pojo.Shop;
import cn.main.pojo.User;
import cn.main.service.GoodService;
import cn.main.service.OrderService;
import cn.main.service.ShopService;
import cn.main.service.UserService;
import cn.main.service.address.AddressService;
import cn.main.utils.AlipayConfig;
import cn.main.utils.Contains;
import cn.main.utils.StringUtil;

@Controller
@RequestMapping("pre/buy")
public class LockBuyController {
	private Logger logger = Logger.getLogger(getClass());
	@Resource
	private ShopService shopService;
	
	@Resource
	private GoodService goodService;
	
	@Resource
	private AddressService addressService;
	@Resource
	private UserService userService;
	
	@Resource
	private OrderService orderService;
	
	AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, // 请求网关
			AlipayConfig.APPID, // APPID 沙箱测试
			AlipayConfig.RSA_PRIVATE_KEY,// 开发者私钥 开发者创建
			AlipayConfig.FORMAT,// 参数返回格式json
			AlipayConfig.CHARSET, // 字符编码
			AlipayConfig.ALIPAY_PUBLIC_KEY, // 支付宝公钥 支付宝创建
			AlipayConfig.SIGNTYPE // ，目前支持 RSA2 和 RSA，推荐使用 RSA2
	); // 获得初始化的AlipayClient，可以使用同一个对象，通过set 商户授权令牌（app_auth_token） 代替商户发起请求
	/**
	 * 请求订单页
	 * @param session
	 * @param request
	 * @param gid
	 * @param sid
	 * @param number
	 * @param price
	 * @return
	 */
	@RequestMapping("buypage")
	public String buyPage(HttpSession session,
						HttpServletRequest request,
						@RequestParam(value="gid")Integer[] gids,
						@RequestParam(value="sid")Integer[] sids,
						@RequestParam(value="number")Integer[] numbers,
						@RequestParam(value="price")Double[] prices) {
		
		User user = (User)session.getAttribute(Contains.SESSION_USER);
		List<Order> orderList = new ArrayList<Order>();
		List<Address> addressList = addressService.getAddress(null, user.getId(), null, null);
		Double totalPrice = 0.0;
		for (int i = 0; i < gids.length; i++) {
			Integer gid = gids[i];
			Integer num = numbers[i];
			Good good = goodService.getGoodList(gid, null, null, null, null, null, null, null, null).get(0);
			Shop shop = shopService.getShopById(good.getSid(), null, null); 
			
			Order order = new Order(); 
				order.setUid(user.getId());
				order.setGid(good.getId());
				order.setSid(shop.getId()); 
				order.setPrice(good.getPrice()*num);
				order.setOrderCode(StringUtil.getRandomOrderId(user.getId(), shop.getId(), gid));
				order.setNumber(num);
				order.setShop(shop);
				order.setGood(good);
				orderList.add(order);
				totalPrice+=(good.getPrice()*num);
		}
		request.setAttribute("totalPrice", totalPrice);  
		request.setAttribute("orderList", orderList);  
		request.setAttribute("addressList", addressList); 
		return "buy";
	}
	/**
	 * 生成订单跳转支付
	 * @param session
	 * @param request
	 * @param response
	 * @param gid
	 * @param sid
	 * @param address
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("order")
	public String order(HttpSession session,
						HttpServletRequest request,
						HttpServletResponse response,
						@RequestParam(value="gid")Integer[] gids,
						@RequestParam(value="sid")Integer[] sids,
						@RequestParam(value="addressRadio")Integer address,
						@RequestParam(value="remark")String[] remarks,
						@RequestParam(value="number")Integer[] numbers) throws IOException {
		
		
		List<Order> orderList = new ArrayList<Order>();
		logger.debug(">>>>>>>>>>>>>>gid"+gids);
		logger.debug(">>>>>>>>>>>>>>sid"+sids);
		logger.debug(">>>>>>>>>>>>>>address"+address);
		logger.debug(">>>>>>>>>>>>>>number"+numbers);
		//购买者
		User user = (User)session.getAttribute(Contains.SESSION_USER);
		String orderCode = null;
		
		for (int i = 0; i < gids.length; i++) {
			
			Integer gid = gids[i];
			Integer sid = sids[i];
			String remark = null; 
			if(remarks!=null&&remarks.length!=0) {
				remark = remarks[i];
			}
			
			Integer number = numbers[i];
			Shop shop = shopService.getShopById(sid, null, null);
			Good good = goodService.getGoodList(gid, sid, null, null, null, null, null, null, null).get(0);
			
			//按次序生成订单
			if(orderCode==null) {
				orderCode =  StringUtil .getRandomOrderId(user.getId(),sid, good.getId());
			}else {
				orderCode = orderCode +i ;
			}
			Order order = new Order();
			order.setAddress(address);
			order.setUid(user.getId());
			order.setGid(gid);
			order.setGood(good);
			order.setSid(sid);
			order.setRemark(remark);
			order.setPrice(good.getPrice()*number);
			order.setOrderCode(orderCode);
			order.setNumber(number); 
			orderList.add(order);
		} 

		return pay(session, request, response, orderList);
	}
	/**
	 * 支付现有订单
	 * @param session
	 * @param request
	 * @param response
	 * @param gid
	 * @param sid
	 * @param address
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("orderbuy/{oid}")
	public String orderBuy(HttpSession session,
						HttpServletRequest request,
						HttpServletResponse response,
						@PathVariable(value="oid")Integer oid) throws IOException {
		//订单
		Order order = orderService.getOrderList(oid, null, null, null, null, null, null, null, null, null, 1, null, null, null).get(0);
		Good good = goodService.getGoodList(order.getGid(), null, null, null, null, null, null, null, null).get(0);
		
		
		String c = "{" + "\"out_trade_no\":\"" + order.getOrderCode() + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\","
				+ "\"total_amount\":\"" + order.getPrice() + "\","
				+ "\"subject\":\"" + good.getName() + "\"," + "\"body\":\"" + good.getName()
				+ "\"" + "}";

		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); // 创建API对应的request
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url); // 在公共参数中设置回跳和通知地址
		logger.debug(">>>>>>>  " + c);
		alipayRequest.setBizContent(c); // 填充业务参数

		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
		response.getWriter().write(form); // 直接将完整的表单html输出到页面
		response.getWriter().flush();
		response.getWriter().close();
		return "redirect:/pre/nav/orderpage";
	}
	/**
	 * 删除现有订单
	 * @param session
	 * @param request
	 * @param response
	 * @param gid
	 * @param sid
	 * @param address
	 * @param number
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("orderdelete/{oid}")
	public String orderDelete(HttpSession session,
						HttpServletRequest request,
						HttpServletResponse response,
						@PathVariable(value="oid")Integer oid) throws IOException {
		orderService.deleteOrder(oid);
		return "redirect:/pre/nav/orderpage";
	}
	@RequestMapping(value = "return_url")
	public String return_url(HttpServletRequest request)
			throws UnsupportedEncodingException, AlipayApiException {
		
			return result(request);
	}

	@RequestMapping(value = "notify_url")
	@ResponseBody//异步请求
	public String notify_url(HttpServletRequest request)
			throws UnsupportedEncodingException, AlipayApiException {

			return result(request);
	}
	
	
	//支付操作
	private String  pay(HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response,List<Order> orderList) throws IOException {
		int count =0;
		Double totalPrice = 0.0;
		Good good = null;
		StringBuilder sb = new StringBuilder();
		for (Order order : orderList) {
			if(orderService.addOrder(order)>0) {//添加
				count++;
				good = order.getGood();
				totalPrice += (good.getPrice()*order.getNumber());
				sb.append(good.getName()+"x"+order.getNumber()+",");
			} 
		}
		if(count==orderList.size()) {
			String c = "{" + "\"out_trade_no\":\"" + orderList.get(0).getOrderCode() + "\","
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\","
					+ "\"total_amount\":\"" + totalPrice+ "\","
					+ "\"subject\":\"  共计" + count+"件商品" + "\"," + "\"body\":\"" +""+sb.toString()
					+ "\"" + "}";

			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); // 创建API对应的request
			alipayRequest.setReturnUrl(AlipayConfig.return_url);
			alipayRequest.setNotifyUrl(AlipayConfig.notify_url); // 在公共参数中设置回跳和通知地址
			logger.debug(">>>>>>>  " + c);
			alipayRequest.setBizContent(c); // 填充业务参数

			String form = "";
			try {
				form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
			} catch (AlipayApiException e) {
				e.printStackTrace();
			}
			response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
			response.getWriter().write(form); // 直接将完整的表单html输出到页面
			response.getWriter().flush();
			response.getWriter().close();
			return "order";
		}else {
			request.setAttribute("orderMsg", "* 订单生成失败！");	
			return "buy";
		}  
	}
	/**
	 * 接受支付宝的返回结果
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws AlipayApiException
	 */
	private String result(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException{
		
		 Map<String,String> params = new HashMap<String,String>();
		 Map requestParams = request.getParameterMap();
		 for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			 String name = (String) iter.next();
			 logger.debug("==========name:"+name);
			 String[] values = (String[]) requestParams.get(name);
			 String valueStr = "";
			 for (int i = 0; i < values.length; i++) {
			 valueStr = (i == values.length - 1) ? valueStr + values[i]
			 : valueStr + values[i] + ",";
			 }
			 valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			 params.put(name, valueStr);
		 }
		 String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		 String trade_no = new  String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
		 logger.debug(">>>>>>>>>>>>out_trade_no:"+out_trade_no);
		 logger.debug(">>>>>>>>>trade_no:"+trade_no);
		 boolean verify_result = AlipaySignature.rsaCheckV1(params,  AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, "RSA2");
		 if(verify_result){//验证成功
			 
			 Order order = orderService.getOrderList(null, null, null, null, null, out_trade_no, null, null, null, null, null, null, null, null).get(0);
			 order.setState(2);//已支付
			 order.setAlipayCode(trade_no);//ali订单号
			 orderService.updateOrderAll(order);//修改状态信息
			 return "redirect:/pre/nav/orderpage";//返回订单信息
		 }else{
			 return "redirect:/pre/nav/orderpage";
		 }   
	}
}
