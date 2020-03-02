package com.geek.test.exception.http;

/**
 * @Classname: ForbiddenException
 * @Author: Ming
 * @Date: 2020/3/2 2:33 下午
 * @Version: 1.0
 * @Description: 没有权限
 **/
public class ForbiddenException extends HttpException {
    public ForbiddenException(int code) {
        this.httpStatusCode = 403;
        this.code = code;
    }
}
