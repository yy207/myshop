package cn.cps.springbootexample.bdqn.core;

import java.io.Serializable;

/**
 * @Author: Cai Peishen
 * @Date: 2020/6/29 11:02
 * @Description: 统一返回数据格式
 */
public class Result implements Serializable {

    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }
}