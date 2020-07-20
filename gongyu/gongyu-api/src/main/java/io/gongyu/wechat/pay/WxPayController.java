package io.gongyu.wechat.pay;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.gongyu.common.utils.R;
import io.gongyu.gy.service.UserAllService;
import io.gongyu.wechat.pay.entity.PaySuccessEntity;
import io.gongyu.wechat.pay.entity.WxpayEntity;
import io.gongyu.wechat.pay.util.HttpRequestUtil;
import io.gongyu.wechat.pay.util.WxRequestParam;
import io.gongyu.wechat.pay.wxutil.WXPayUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @author Mr.wang
 * @version 2019年12月12日 下午4:13:56 微信支付接口
 */
@RestController
@RequestMapping("/api")
@Api(tags = "微信支付->pay")
public class WxPayController {

	@Autowired
    private UserAllService userAllService;
	/**
	 * 获取openID
	 * 
	 * @param wxpay
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getOpenId", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation("获取openid")
	public R pay(WxpayEntity wxpay, HttpServletRequest request) throws Exception {
		System.out.println("请求参数：" + wxpay.toString());
		/**
		 * 第一步 通过code获取openId
		 */
		// 页面获取openId接口
		String getopenid_url = "https://api.weixin.qq.com/sns/oauth2/access_token";
		String param = "appid=" + WxRequestParam.APP_ID + "&secret=" + WxRequestParam.APP_SECRET + "&code="
				+ wxpay.getCode() + "&grant_type=authorization_code";
		String openIdStr = HttpRequestUtil.sendGet(getopenid_url, param);
		// 转成Json格式
		JSONObject json = JSONObject.parseObject(openIdStr);
		if ("40029".equals(json.getString("errcode"))) {
			return R.error().put("msg", "code码无效！").put("json", json);
		}
		// 获取openId
		String openId = json.getString("openid");
		System.out.println("openId-->" + openId);
		if (openId == null) {
			return R.error().put("msg", "openId为空值！");
		}
		return R.ok().put("openId", openId);
	}

	/**
	 * 获取预getPrepayId支付结果
	 * 
	 * @param request
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getPrepayId", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation("获取预getPrepayId支付结果")
	public R getOpenid(WxpayEntity wxpay, HttpServletRequest request) throws Exception {
		/**
		 * 第二步 通过openId 去获取prepay_id
		 */
		// 拼接统一下单地址参数
		Map<String, String> paraMap = new HashMap<String, String>();
		// 获取请求ip地址
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.indexOf(",") != -1) {
			String[] ips = ip.split(",");
			ip = ips[0].trim();
		}
		paraMap.put("appid", WxRequestParam.APP_ID);
		// 详情信息
		String body = "谷瓜公寓充值";
		String attach = wxpay.getUserId() + "-" + wxpay.getMobile() + "=" + wxpay.getPayType();
		paraMap.put("body", new String(body.getBytes(), "utf-8"));
		paraMap.put("attach", new String(attach.getBytes(), "utf-8"));
		// 商户ID
		paraMap.put("mch_id", WxRequestParam.MCH_ID);
		// 随机字符串，长度要求在32位以内
		paraMap.put("nonce_str", WXPayUtil.generateNonceStr());
		// 此参数为微信用户在商户对应appid下的唯一标识
		paraMap.put("openid", wxpay.getOpenId());
		// 订单号:当前时间+商户对应appid
		paraMap.put("out_trade_no", WXPayUtil.generateNonceStr());
		// APP和网页支付提交用户端ip
		paraMap.put("spbill_create_ip", wxpay.getSpbillCreateIp());
		// 订单总金额，单位为分 , 分转元单位
		Double money = Double.valueOf(wxpay.getMoneyType()) * 100;
//		Double money = Double.valueOf(wxpay.getMoneyType());
		paraMap.put("total_fee", money.toString().replace(".0", ""));
		// JSAPI -JSAPI支付
		paraMap.put("trade_type", WxRequestParam.TRADE_TYPE);
		// 此路径是微信服务器调用支付结果通知路径随意写
		paraMap.put("notify_url", WxRequestParam.NOTIFY_URL);
		String sign = WXPayUtil.generateSignature(paraMap, WxRequestParam.PATERNER_KEY);
		paraMap.put("sign", sign);
		String xml = WXPayUtil.mapToXml(paraMap);
		// 将所有参数(map)转xml格式
		System.out.println("xml---->" + xml);
		// 预支付id
		String prepay_id = "";
		try {
			// 发送post请求"统一下单接口"返回预支付id:prepay_id
			String xmlStr = HttpRequestUtil.sendPost(WxRequestParam.UNIFIEDORDER_URL, xml);
			System.out.println("xmlStr---->" + xmlStr.toString());
			if (xmlStr.indexOf("SUCCESS") != -1) {
				// 以下内容是返回前端页面的json数据
				Map<String, String> map = WXPayUtil.xmlToMap(xmlStr);
				prepay_id = (String) map.get("prepay_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * 第三步 通过prepay_id 向前端返回对应的参数
		 */
		if ("".equals(prepay_id) || prepay_id.isEmpty()) {
			return R.error().put("msg", "prepay_id为空值！");
		}
		if (prepay_id != null) {
			Map<String, String> payMap = new HashMap<String, String>();
			payMap.put("appId", WxRequestParam.APP_ID);
			// 时间戳
			payMap.put("timeStamp", WXPayUtil.getCurrentTimestamp() + "");
			// 随机字符串
			payMap.put("nonceStr", WXPayUtil.generateNonceStr());
			// 签名类型
			payMap.put("signType", "MD5");
			// package
			payMap.put("package", "prepay_id=" + prepay_id);
			String paySign;
			try {
				paySign = WXPayUtil.generateSignature(payMap, WxRequestParam.PATERNER_KEY);
				payMap.put("paySign", paySign);
				System.out.println("paySign-->" + payMap);
				return R.ok().put("message", payMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return R.error().put("msg", "失败！");
	}

	/**
	 * 回调接口微信服务器直接调取 不需要前端进行调取
	 * 
	 * 支付成功后的回调
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/callback")
	public void callBack(HttpServletRequest request, HttpServletResponse response) {
		InputStream is = null;
		try {
			is = request.getInputStream();// 获取请求的流信息(这里是微信发的xml格式所有只能使用流来读)
			String xml = WXPayUtil.inputStream2String(is, "UTF-8");
			Map<String, String> notifyMap = WXPayUtil.xmlToMap(xml);// 将微信发的xml转map
			System.out.println("notifyMap--->" + notifyMap);
			if (notifyMap.get("result_code").equals("SUCCESS")) {
				WXPayUtil.getLogger().info("wxnotify:微信支付----返回成功");
				if (WXPayUtil.isSignatureValid(notifyMap, WxRequestParam.PATERNER_KEY)) {
					// 订单处理 操作 orderconroller 的回写操作?
					WXPayUtil.getLogger().info("wxnotify:微信支付----验证签名成功");
					/***
					 * 业务逻辑
					 */
					PaySuccessEntity payMessage = new PaySuccessEntity();
					// 微信支付订单号
					payMessage.setTransactionId(notifyMap.get("transaction_id"));
					// 实际支付的订单金额:单位 分
					payMessage.setTotalFee(notifyMap.get("total_fee"));
					// 支付完成时间--time_end
					// String timeEnd = notifyMap.get("time_end");
					payMessage.setTimeEnd(new Date());
					// 商户订单号--out_trade_no
					payMessage.setOutTradeNo(notifyMap.get("out_trade_no"));
					// 业务结果 --result_code
					payMessage.setResultCode(notifyMap.get("result_code"));
					// 商家数据包
					String attach = notifyMap.get("attach");
					//用户id
					payMessage.setUserId(attach.substring(0, attach.indexOf("-")));
					//用户手机号
					payMessage.setMobile(attach.substring(attach.indexOf("-")+1, attach.indexOf("=")));
					//支付类型
					payMessage.setPayType(attach.substring(attach.lastIndexOf("=") + 1));
					System.out.println("payMessage--->" + payMessage.toString());
					// 业务处理
					userAllService.insertWxOrder(payMessage);
					// 告诉微信服务器收到信息了，不要在调用回调action了========这里很重要回复微信服务器信息用流发送一个xml即可
					response.getWriter().write(
							"<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
					is.close();
				} else {
					WXPayUtil.getLogger().error("wxnotify:微信支付----判断签名错误");
				}
			} else {
				// 告诉微信服务器收到信息了，不要在调用回调action了========这里很重要回复微信服务器信息用流发送一个xml即可
				response.getWriter().write(
						"<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[报文为空]]></return_msg></xml>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
