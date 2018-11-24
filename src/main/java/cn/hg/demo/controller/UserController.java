package cn.hg.demo.controller;


import cn.hg.demo.dao.UserMapper;
import cn.hg.demo.entity.Response;
import cn.hg.demo.entity.User;
import cn.hg.demo.exception.ExceptionEnum;
import cn.hg.demo.exception.TokenException;
import cn.hg.demo.util.TokenFactory;
import cn.hg.demo.validation.LoginRegisterGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.hg.demo.exception.ExceptionEnum.EXCEPTION_UPDATE_DATA;


/**
 * 用户接口
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)//跨域
public class UserController extends BaseController {

    @Autowired
    private UserMapper userMapper;
    private final int CODE = 10100;

    /**
     * 登陆
     */
    @PostMapping("/user/login")
    public Response<User> login(@RequestBody @Validated(value = {LoginRegisterGroup.class}) User user, Errors errors) {
        User loginUser = userMapper.getUserByUserName(user.getUsername());
        if (loginUser == null)
            return new Response<>(CODE, "用户名不存在");
        else if (!loginUser.getPassword().equals(user.getPassword()))
            return new Response<>(CODE, "密码错误");
        else {
            String token = TokenFactory.createToken();
            loginUser.setToken(token);
            userMapper.updateUserInfo(loginUser);
            return new Response<>(loginUser);
        }
    }


    /**
     * 注册
     */
    @PostMapping("/user")
    public Response register(@RequestBody @Validated(value = {LoginRegisterGroup.class}) User user, Errors errors) {
        if (userMapper.findUserByUserName(user.getUsername()) > 0)
            return new Response<>(CODE, "用户名已存在");
        else {
            int isSuccess = userMapper.register(user);
            if (isSuccess == 1)
                return new Response().setMessage("注册成功");
            else
                return new Response(ExceptionEnum.EXCEPTION_INSERT_DATA);
        }
    }


    /**
     * 更新用户信息
     */
    @PutMapping("/user/{id}")
    public Response updateUserInfo(@RequestHeader(name = "token") String token,
                                   @RequestBody User user) throws TokenException {
        checkToken(token);
        int isSuccess = userMapper.updateUserInfo(user);
        if (isSuccess == 1)
            return new Response();
        else
            return new Response<>(EXCEPTION_UPDATE_DATA);
    }
}
