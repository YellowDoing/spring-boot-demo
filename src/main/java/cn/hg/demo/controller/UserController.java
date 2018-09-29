package cn.hg.demo.controller;

import cn.hg.demo.dao.UserMapper;
import cn.hg.demo.entity.Response;
import cn.hg.demo.entity.User;
import cn.hg.demo.exception.ValidateException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

@RestController
@Api(tags = "user", description = "用户")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public User login(@RequestBody @Validated @ApiParam(example = "{username:\"asdawd\"}") User user, @ApiIgnore Errors errors) {
        return userMapper.login(user);
    }


    @PostMapping("/user")
    @ApiOperation(value = "注册")
    public String register(@RequestBody @Validated User user, @ApiIgnore Errors errors) {
        userMapper.register(user);
        return user.getId() + "";
    }


    @PutMapping("/user")
    @ApiOperation(value = "修改用户信息")
    public int updateUserInfo(@RequestBody User user, @ApiIgnore Errors errors) {
        userMapper.updateUserInfo(user);
        return userMapper.updateUserInfo(user);
    }
}
