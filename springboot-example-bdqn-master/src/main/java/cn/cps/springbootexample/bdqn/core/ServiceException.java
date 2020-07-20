package cn.cps.springbootexample.bdqn.core;

/**
 * 自定义服务（业务）异常如“ 账号或密码错误 ”
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {

    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
