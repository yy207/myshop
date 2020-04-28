package cn.main.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
 /**
  * 页面信息提示,时间转换工具类
  * @author sff
  *
  */
public class Contains { 
	
	public static final String IMAGECODE = "imageCode";//验证码
	public static final String ERROR ="error";//错误信息
	public static final String SUCCESS ="success";//成功信息
	public static final String SESSION_USER = "sessionUser";//当前会话用户信息
	public static final String USER_LOGIN_ERROR_USERCODE=" * 用户名不存在！";
	public static final String USER_LOGIN_ERROR_USERPWD=" * 密码错误！"; 
	public static final String LOGN_DATE_FORMAT_24 = "yyyy-MM-dd HH:mm:ss";
	public static final String SHORT_DATE_FORMAT_24 = "yyyy-MM-dd";
	public static final List<String> IMG_TYPE  =new ArrayList<String>(){{add("jpg");add("gif");add("png");add("jpeg");}};
	/**
	 * 获取当前时间字符串
	 * @return
	 */
	public static String getDate(){
		return new SimpleDateFormat(LOGN_DATE_FORMAT_24).format(new Date()).toString();
	}
	public static String getShortDate(){
		return new SimpleDateFormat(SHORT_DATE_FORMAT_24).format(new Date()).toString();
	}
	/**
	 * 获取指定时间字符串
	 * @param date
	 * @return
	 */
	public static String getDate(Date date){
		return new SimpleDateFormat(LOGN_DATE_FORMAT_24).format(date).toString();
	}
	public static String getShortDate(Date date){
		return new SimpleDateFormat(SHORT_DATE_FORMAT_24).format(date).toString();
	}
	/**
	 * 通过格式化的字符串获取时间
	 * @param date
	 * @return
	 */
	public static String getDate(String date){ 
		try {
			Date d = new SimpleDateFormat(LOGN_DATE_FORMAT_24,Locale.SIMPLIFIED_CHINESE).parse(date);
			return new SimpleDateFormat(LOGN_DATE_FORMAT_24).format(date);
		} catch (ParseException e) { 
			return null;
		}
	}
	/**
	 * 从时间戳获取时间
	 * @param time
	 * @return
	 */
	public static String getDate(long time){
		String d =null;
		d = new SimpleDateFormat(LOGN_DATE_FORMAT_24).format(time); 
		return d;
	}
	
}
