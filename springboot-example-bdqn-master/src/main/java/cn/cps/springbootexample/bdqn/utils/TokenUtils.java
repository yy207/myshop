package cn.cps.springbootexample.bdqn.utils;

import cn.cps.springbootexample.bdqn.entity.GlobalConstants;

/**
 * @Author: Cai Peishen
 * @Date: 2020/7/2 15:34
 * @Description: Token工具类
 */
public class TokenUtils {

    /**
     * 根据参数生成 Token
     * @param messages
     * @return
     */
    public static String getToken(String... messages) {
        if(null == messages || messages.length <= 0) {
            throw new IllegalArgumentException("Illegal Argument");
        }

        StringBuilder msg = new StringBuilder();
        for(String message : messages){
            msg.append(message);
        }

        //使用MD5生成字符串
        String sign = EncryptUtils.MD5(msg.toString());
        String content = sign.substring(GlobalConstants.TOKEN_START, GlobalConstants.TOKEN_OFFSET);
        //示例：token_HIA1561SUD26GUY2:1593676199590
        String token = new StringBuffer()
                .append(GlobalConstants.TOKEN_PREFIX)
                .append(content)
                .append(GlobalConstants.SYMBOL_COLON)
                .append(System.currentTimeMillis()).toString();
        return token;
    }

}
