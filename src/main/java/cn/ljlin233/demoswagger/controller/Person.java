package cn.ljlin233.demoswagger.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author lvjinlin@yunrong.cn
 * @version V2.1
 * @date 2019/7/10 14:16
 * @since 2.1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String name;
    private Integer age;
}
