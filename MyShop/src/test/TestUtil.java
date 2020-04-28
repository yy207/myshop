package test;

import java.util.Date;

import cn.main.utils.Contains;
/**
 * 
 * @author sff
 *
 */
public class TestUtil {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println(Contains.getDate());
		System.out.println(Contains.getDate("2012-12-03 24:12:12"));
		System.out.println(Contains.getDate(new Date("2012-12-03 15:02:06")));
	}
	
}
