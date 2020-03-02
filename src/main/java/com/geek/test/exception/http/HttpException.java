package com.geek.test.exception.http;

/**
 * @Classname: HttpException
 * @Author: Ming
 * @Date: 2020/3/2 2:32 下午
 * @Version: 1.0
 * @Description: http 异常
 **/
public class HttpException extends RuntimeException {
    protected Integer code;
    protected Integer httpStatusCode = 500;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
}
