package cn.hg.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "user",description = "用户")
public class UserController {

    @GetMapping("/")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public String helloWord(){
        return "Hello World";
    }

}
