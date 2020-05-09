package cn.main.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

	/**
	 * Cookie是否存在
	 * @param resuest
	 * @return
	 */
	public static boolean exists(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		int count=0;
		boolean flag = false;
		if(cookies==null) {
			return false;
		}
		for (Cookie cookie : cookies) {
			if("userCode".equals(cookie.getName())) {
				count++;
			}
			if("userPassword".equals(cookie.getName())) {
				count++;
			} 
		}
		if(count==2) {
			flag = true;
		}
		return flag;
	}
	/**
	 * Cookie获取信息
	 * @param resuest
	 * @return
	 */
	public static String[] getCookieValue(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String [] values=new String[2]; 
		for (Cookie cookie : cookies) {
			if("userCode".equals(cookie.getName())) {
				values[0] = cookie.getValue();
			}
			if("userPassword".equals(cookie.getName())) {
				values[1] = cookie.getValue();
			} 
		}
		return values;
	}
	
}
