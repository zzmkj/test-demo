package com.geek.test.exception.http;

/**
 * @Classname: NotFoundException
 * @Author: Ming
 * @Date: 2020/3/2 2:33 下午
 * @Version: 1.0
 * @Description: 没有找到
 **/
public class NotFoundException extends HttpException {
    public NotFoundException(int code) {
        this.httpStatusCode = 404;
        this.code = code;
    }


}
