package cn.hg.demo.controller;

import cn.hg.demo.dao.TokenMapper;
import cn.hg.demo.dao.UserMapper;
import cn.hg.demo.entity.Response;
import cn.hg.demo.entity.User;
import cn.hg.demo.exception.DemoExceptionEnum;
import cn.hg.demo.exception.ValidateException;
import cn.hg.demo.util.TokenFatory;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

@RestController
@Api(description = "用户相关接口")
public class UserController extends BaseController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TokenMapper tokenMapper;

    @PostMapping("/login")
    public Response<User> login(@Validated @RequestBody User user, Errors errors) {
        User selecteUser = userMapper.login(user.getUsername());
        if (selecteUser == null)
            return new Response<>(DemoExceptionEnum.USER_NULL_EXCEPTION);
        else {
            if (selecteUser.getPassword().equals(user.getPassword())) {
                String token = TokenFatory.createToken();
                int i = tokenMapper.updateUserToken(selecteUser.getId(), token);
                System.out.println(i);
                selecteUser.setToken(token);
                return new Response<>(selecteUser);
            } else
                return new Response<>(DemoExceptionEnum.PASSWORD_EXCEPTION);
        }
    }


    @PostMapping("/user")
    public Response register(@RequestBody User user, Errors errors) {
        if (userMapper.findUserIsExist(user.getUsername()) > 0) {
            return new Response(DemoExceptionEnum.USER_ALREADY_REGISTERED_EXCEPTION);
        } else {
            int isSuccess = userMapper.register(user);
            if (isSuccess == 1)
                return new Response().setMessage("注册成功");
            else
                return new Response(DemoExceptionEnum.REGISTER_EXCEPTION);
        }
    }


    @PutMapping("/user")
    public Response updateUserInfo(@RequestHeader String token, @RequestBody User user, Errors errors) {
            int isSuccess = userMapper.updateUserInfo(user);
            if (isSuccess == 1)
                return new Response();
            else
                return new Response(DemoExceptionEnum.USER_UPDATE_EXCEPTION);
    }
}
