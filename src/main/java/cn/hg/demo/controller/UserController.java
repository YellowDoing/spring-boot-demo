package cn.hg.demo.controller;

import cn.hg.demo.entity.User;
import cn.hg.demo.exception.ValidateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "user",description = "用户")
public class UserController {

    @PostMapping("/")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public String helloWord(@RequestBody @Validated User user, Errors errors) throws ValidateException {

        if (errors.hasErrors()){
            throw new ValidateException(errors);
        }

        return "Hello World";
    }

}
