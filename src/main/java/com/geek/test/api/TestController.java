package com.geek.test.api;

import com.geek.test.dto.PersonDTO;
import com.geek.test.exception.http.ForbiddenException;
import com.geek.test.exception.http.NotFoundException;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @Classname: TestController
 * @Author: Ming
 * @Date: 2020/3/2 2:15 下午
 * @Version: 1.0
 * @Description: TODO
 **/
@Validated
@Controller
public class TestController {

    @ResponseBody
    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") @Range(min = 1, max = 10) String id,
                       @RequestParam @Length(min = 4) String name,
                       @RequestBody @Validated PersonDTO personDTO) throws Exception {
        System.out.println("test...");
//        throw new Exception("这是一个异常～");
//        throw new ForbiddenException(10002);
        return "success";
    }

}
