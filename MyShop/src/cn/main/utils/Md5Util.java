package cn.main.utils;
import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
	private static final String MD5="md5";
	 /**
     * MD5方法
     * 
     * @param text 明文
     * @param key 密钥
     * @return 密文
     * @throws Exception
     */
    public static String MD5(String text) throws Exception {
        //加密后的字符串
        String encodeStr=DigestUtils.md5Hex(text + MD5);
        System.out.println(">>>>>>>>>"+text);
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
        }

    /**
     * MD5验证方法
     * 
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
    public static boolean MD5Verify(String text, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = MD5(text);
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }
            return false;
    }
    
    public static void main(String[] args) throws Exception {
    	String  m =MD5("KmlfyG");
		System.out.println(m); 
		
		MD5Verify("KmlfyG", m);
	}
}
