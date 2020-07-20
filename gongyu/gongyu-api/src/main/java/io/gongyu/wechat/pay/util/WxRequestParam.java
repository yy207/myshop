package io.gongyu.wechat.pay.util;

/**
 *
 * @author Mr.wang
 * @version 2019年12月12日 下午4:23:02
 * 
 */
public class WxRequestParam {

	// 微信支付分配的公众账号ID（企业号corpid即为此appId）
	public static final String APP_ID = "wxfc16833f7247d14f";
	// app秘钥
	public static final String APP_SECRET = "1afc5be1911e5849c02ac44a0a10f165";
	// JSAPI -JSAPI支付
	public static final String TRADE_TYPE = "JSAPI";
	// 商户ID
	public static final String MCH_ID = "1489870182";
	// 初始密钥PartnerKey	
	public static final String PATERNER_KEY = "gu04gua13goo04gua13gooo04gua13gu";
	// 统一下单 https://api.mch.weixin.qq.com/pay/unifiedorder
	public static final String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	// 统一下单接口回调路径 
	public static final String NOTIFY_URL  = "http://gongyu.igugua.com/gongyu-api/api/callback";

}
