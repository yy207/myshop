package io.gongyu.test;


public class Testjiamijiemi {
	public static void main(String[] args) {
		String ss = "12-13=14";
			System.out.println(ss.substring(0, ss.indexOf("-")));
	        System.out.println(ss.substring(ss.indexOf("-")+1, ss.indexOf("=")));
	        System.out.println(ss.substring(ss.lastIndexOf("=") + 1));
			int mobile_code = (int)((Math.random()*9+1)*100000);
			System.out.println(mobile_code);
	        
	}
}
