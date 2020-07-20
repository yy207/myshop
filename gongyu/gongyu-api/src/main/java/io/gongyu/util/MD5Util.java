package io.gongyu.util;

/** 
 * 采用MD5加密解密 
 */  
public class MD5Util {  
  
    /** 
     * 加密解密算法 执行一次加密，两次解密 
     */   
    public static String convertMD5(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
  
    // 测试主函数  
    public static void main(String args[]) {  
        String s = new String("411424199306042817");
        System.out.println("原始：" + s);  
        System.out.println("加密的：" + convertMD5(s));
        System.out.println("解密的：" + convertMD5("@EE@FFEMLCEEDC@FEE"));
  
    }  
}