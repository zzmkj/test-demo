package com.geek.test.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * @Classname: Dept
 * @Author: Ming
 * @Date: 2020/3/2 3:19 下午
 * @Version: 1.0
 * @Description: TODO
 **/
@Getter
@Setter
public class Dept {
    @Length(min = 3)
    private String name;
}
