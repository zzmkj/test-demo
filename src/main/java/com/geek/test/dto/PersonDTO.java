package com.geek.test.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;

/**
 * @Classname: PersonDTO
 * @Author: Ming
 * @Date: 2020/3/2 3:10 下午
 * @Version: 1.0
 * @Description: TODO
 **/
@Getter
@Setter
public class PersonDTO {

    @Length(min = 2, max = 10, message = "大于2位，小于10位")
    private String name;

    private Integer age;

    @Valid
    private Dept dept;

}
