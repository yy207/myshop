package cn.cps.springbootexample.bdqn.entity;

/**
 * @author _Cps
 * @create 2019-02-14 10:12
 * @Description: 全局常量与枚举
 */
public class GlobalConstants {

	/** token前缀 */
	public static final String TOKEN_PREFIX = "token_";

	/** token截取开始下标 */
	public static final int TOKEN_START = 0;

	/** token截取偏移量 */
	public static final int TOKEN_OFFSET = 16;

	/** 冒号 **/
	public static final String SYMBOL_COLON = ":";



	/** 性别映射 **/
	public enum GenderCode{

		WO_MAN(0,"女"),//女
		MAN(1,"男");//男

		int code;
		String value;

		GenderCode(int code,String value){
			this.code = code;
			this.value = value;
		}

		public int getCode(){
			return this.code;
		}
		public String getValue(){
			return this.value;
		}
	}

}
