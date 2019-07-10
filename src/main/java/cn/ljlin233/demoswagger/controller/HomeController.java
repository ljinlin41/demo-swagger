package cn.ljlin233.demoswagger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author lvjinlin@yunrong.cn
 * @version V2.1
 * @date 2019/7/10 11:41
 * @since 2.1.0
 */
@RestController
@Api(tags = "TestController") // 注意不要带中文，扩展时按钮无效
public class HomeController {

    @ApiOperation(value="hello", notes="无参数GET请求测试")
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @ApiOperation(value = "hello2", notes = "单简单参数")
    @ApiImplicitParam(name = "name", value = "姓名", paramType = "query", dataType = "String")
    @GetMapping("/hello2")
    public String hello2(@RequestParam String name) {
        return "Hello " + name;
    }

    @ApiOperation(value = "hello3", notes = "多简单参数")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "姓名", paramType = "query", dataType = "string"),
        @ApiImplicitParam(name = "age", value = "年龄", paramType = "query", dataType = "int")
    })
    @GetMapping("/hello3")
    public String hello3(@RequestParam String name, @RequestParam Integer age) {
        return "Hello " + name + ", age " + age.toString();
    }

    @ApiOperation(value = "hello4", notes = "传递对象参数")
    @ApiImplicitParam(name = "person", value = "人", paramType = "body", dataType = "Person")
    @PostMapping("/hello4")
    public String hello4(@RequestBody Person person) {
        return "Hello, " + person.getName() + " " + person.getAge();
    }

    @ApiOperation(value = "hello5", notes = "传递集合参数")
    @ApiImplicitParam(name = "persons", value = "集合列表", paramType = "body", dataType = "ArrayList<String>")
    @PostMapping("/hello5")
    public String hello5(@RequestBody ArrayList<String> persons) {
        StringBuilder sb = new StringBuilder();
        persons.forEach(t -> sb.append(t).append("\n"));
        return sb.toString();
    }
}
