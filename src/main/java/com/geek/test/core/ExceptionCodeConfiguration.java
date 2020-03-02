package com.geek.test.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname: ExceptionCodeConfiguration
 * @Author: Ming
 * @Date: 2020/3/2 2:45 下午
 * @Version: 1.0
 * @Description: 错误码对应错误信息的 配置管理类
 **/
@Component
@ConfigurationProperties(prefix = "geek")
@PropertySource(value = "classpath:config/exception-code.properties")
public class ExceptionCodeConfiguration {
    private Map<Integer, String> codes = new HashMap<>();

    public String getMessage(int code) {
        return codes.get(code);
    }

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setCodes(Map<Integer, String> codes) {
        this.codes = codes;
    }
}
