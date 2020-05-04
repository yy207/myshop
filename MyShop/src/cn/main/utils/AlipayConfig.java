package cn.main.utils;

import org.apache.log4j.chainsaw.Main;

public class AlipayConfig {
	 // 商户appid 沙箱测试账号
	 public static String APPID = "2016102300743463";//2021001150659729
	 // 私钥 pkcs8格式的
	 public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDeqFBEM9najji05oQvVotRRhN4pOCHE+YlSOIcYZV9C1tvhCxWsLX7jWWwmcrZA7bW6a3XEZ4LEdNl4FrhJz9P6/0bs/sZ7L23wBwAOYcWhvu1RRZw9EbrW9eb9JKUkByTenl7JZazPcEyv1huCS7xTsENpdUNQKbP8rfnHew4fAq222T8mJQGUv0e/157rTWcwdOtb2phk1jF0qdGdLfuMBxzBxB+IzJX0wtEAFqzPeGyZgfb+m0tn327nAPE7XfZIyFRmcZp1xcBX/uSqw7w0YMGj74FpM3QSMXqn0rqSrg9uupcYIl7YdqOScnpSrFriC950FCVMLY+Y2CW3QT7AgMBAAECggEAJQS206ALSFr88pagw34QC6Mq+ZPwAIU+blR/w1g2EmQg/5lqBb+7gecwUPxAzXPgojqXvHohXJXKH9X9RhHQZOlHW6PAy76gjDxUa3UlEInAr5Kc+Iqkf9z1K+ittiV/msVyDRdixsotpNJLUYAVXelKD4rSsTFeipRAHxzKeVlWnJhh2XyhgGj9yPy2mhXqxJW3m6SCCYzdLWNb3GGSSeJGyyF4shcIS5jkzeuGRG0kgPYaMbsRDuOTh5zAtKlri8KjlM/MrYrTlHmMWJ6XS0+e8ulmAQD37dsASYc7SelTwfcVZdM0QEFIlvL2PVo9LOOvreICG+/s8rUsL4hogQKBgQD/fpNKnUjdn40WAEK0Yo9uRIMxOSp3xwlU00wAZ9HcvbhGXMoYLjhRexhnLhAS/YVu9WtI7K21WqOIikxjBY3GXb6S4YdOy58iwEegAYwtzapIavv2BLJKZYchnjV3hPhbFbYz2pzXbxapc9TTnmMyd+SPbThf6sTAwgv0U6B8zQKBgQDfGRqnTCzesbXH31YMbceUWVxr6gXZFj3sBg+k/waBc6ZvJXTkTgtW1q+620mmcTktnSc3y9b9gs4J+ywYodB2t5UQtMkg1+7/7JTEZaITp1BWvfcwo+6LVsOQpPQM4mTWsDjK4Quijdr15A2mlzRPy2VNr7PCGaVD/Zt9cb4I5wKBgQDx5YRM06emdSZeGzcMlHhaHTHdC9PCfca+8iL2C1Wt2k47CCUrSa92rcYIApujbzbDPEcsTzGUD9HfN5lk82As3JrPdAnot27etw/ZVT3ELAG5+Ni/L+kh+Qg88w6KL3H4wxCz/ZobeokJPKrXBRHEObFDflQutBc+rTomRHshTQKBgEq3wKp5I6ntwKDRFqOQ/L+dcgueVBkRjumGWiT7WHVwgzRESjLQRJHv0uj02mTJFMpHEMRqG3XKIjFLksgpIYUxFNaEhbvfNec2l9hy5WZJqelzM99xd8no5BSEekv6YqVYXZzs5BWsBsJFf6DkkRuMVkA/cSe3qRbtT+8ice/PAoGANnOHPYjoMmshahqcq1KtBZwNUxg15qRz4VfQxSEzn0sRjN/+dfYfC5PgrsQOLbGDAegadceLcZci2WS5FOR8MzC8BfMh3NnCHBwUgpVUiHun/y392V7segI9X9eeEYGnUESqaiWcw+sxfs4ex+Y0Mq5rxJpALCeJ5TWPePw/1fs=";
	 // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	 public static String notify_url =  "http://localhost:8080/MyShop/pre/buy/notify_url";
	 // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问商户可以自定义同步跳转地址
	 public static String return_url =  "http://localhost:8080/MyShop/pre/buy/return_url";
	 // 请求网关地址 沙箱测试网管
	 public static String URL =  "https://openapi.alipaydev.com/gateway.do";//https://openapi.alipay.com/gateway.do
	 // 编码
	 public static String CHARSET = "UTF-8";
	 // 返回格式
	 public static String FORMAT = "json";
	 // 支付宝公钥
	 public static String ALIPAY_PUBLIC_KEY =  "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5M0omU9X7xbz8st0lQL6BRw/El9+QJIPLJtMfLPIQhaLS8B5XL3msrQL1HPDBCfopwIGurFdipI2Fyz3okbt9s/R8BKzvIzZeDBo7sX6Vi4aCNA3P903hbo5BquAginto/GQ+Vm7cV8sd/GduYVf9mE/6KkPr1A2mqziPYJg5PrUM1ljSdrdVMEUH/9wnGfg4NsKKBPGJu5JwuFyD1xe6zykEzncXXdPbOBpJSXQ4bf5sS3ep0SiBRzlmsWThJmP/0QB6+NKSBi74B3d9fls2VWOsb7FvSHF4c9IJ85Ac5iD6/hmxrjILFCcjZdSCgwuz9jes3XzcSpV8ymvpSUk1wIDAQAB";
	 // 日志记录目录
	 public static String log_path = "/log";
	 // RSA2
	 public static String SIGNTYPE = "RSA2";
	 // PID
	 public static String PID = "2088522022441226";

//	public static String APPID = Property.getPropertyValue("APPID");
//	public static String RSA_PRIVATE_KEY =  Property.getPropertyValue("RSA+PRIVATE_KEY");;
//	public static String notify_url =  Property.getPropertyValue("notify_url");;
//	public static String return_url =  Property.getPropertyValue("return_url");;
//	public static String URL =  Property.getPropertyValue("URL");
//	public static String CHARSET = Property.getPropertyValue("CHARSET");
//	public static String FORMAT =  Property.getPropertyValue("FORMAT");
//	public static String ALIPAY_PUBLIC_KEY =  Property.getPropertyValue("ALIPAY_PUBLIC_KEY");
//	public static String log_path = Property.getPropertyValue("log_path");
//	public static String SIGNTYPE = Property.getPropertyValue("SIGNTYPE");
//	public static String PID =  Property.getPropertyValue("PID");
}