package com.geek.test.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Classname: UnifyResponse
 * @Author: Ming
 * @Date: 2020/3/2 2:24 下午
 * @Version: 1.0
 * @Description: http 异常返回结果封装
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnifyResponse {
    private int code;
    private String message;
    private String request;

}
