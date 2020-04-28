package cn.main.utils;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.mysql.jdbc.StringUtils;
/**
 * 字符串工具类
 * @author sff
 *
 */
public class StringUtil {
	/**
	 * 	判断字符传是否为空
	 * @param obj 对象
	 * @return
	 */
	public static boolean isEmpty(Object obj){
		boolean result = true;
		if(obj instanceof String){
			String str = (String)obj;
			if(!StringUtils.isNullOrEmpty(str)){
				for (int i = 0; i < str.length(); i++) {
					if(' '!=str.charAt(i))
						result  = false;
				} 
			}
		} 
		return result;
	} 
	/**
	 * 随机订单号
	 * @param uid 用户id
	 * @param sid 商店id
	 * @param gid 商品id
	 * @return 唯一订单号
	 */
	public static String getRandomOrderId(Integer uid,Integer sid,Integer gid){
		String id =null;
		long n1 = System.currentTimeMillis();//时间戳 
		int y =(int)((Math.random())*(10000-1000)+1000);//四位随机数
		String u = uid==null?"00":uid.toString();
		String s = sid==null?"00":sid.toString();
		String g = gid==null?"00":gid.toString(); 
		id = n1+u+s+g+y; 
		return id;
	} 
	
//	public static String str;
//	public static final String EMPTY_STRING = "";
// 
//	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
//			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
// 
//	private static String byteToHexString(byte b) {
//		int n = b;
//		if (n < 0)
//			n = 256 + n;
//		int d1 = n / 16;
//		int d2 = n % 16;
//		return hexDigits[d1] + hexDigits[d2];
//	}
 
//	/**
//	 * 转换字节数组为16进制字串
//	 * @param b 字节数组
//	 * @return 16进制字串
//	 */
//	public static String byteArrayToHexString(byte[] b) {
//		StringBuffer resultSb = new StringBuffer();
//		for (int i = 0; i < b.length; i++) {
//			resultSb.append(byteToHexString(b[i]));
//		}
//		return resultSb.toString();
//	}
// 
//	public static String MD5Encode(String origin) {
//		String resultString = null;
//		try {
//			resultString = new String(origin);
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			resultString = byteArrayToHexString(md.digest(resultString
//					.getBytes()));
//		} catch (Exception ex) {
//		}
//		return resultString;
//	}
// 
	
	
	
	
	
	
	
	
	
	
	
}
