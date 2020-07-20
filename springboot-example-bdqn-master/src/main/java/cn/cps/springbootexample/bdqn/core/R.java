package cn.cps.springbootexample.bdqn.core;

/**
 * 响应结果
 */
public class R {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";

    //成功
    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }
    //成功
    public static Result genSuccessResult(String message) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message);
    }

    //携带数据
    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    //失败
    public static Result genFailResult() {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(DEFAULT_FAIL_MESSAGE);
    }
    //失败
    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    //自定义返回状态码
    public static Result genResult(ResultCode resultCode, String message) {
        return new Result()
                .setCode(resultCode)
                .setMessage(message);
    }

}
