package cn.hg.demo.controller;

import cn.hg.demo.dao.UserMapper;
import cn.hg.demo.entity.Response;
import cn.hg.demo.entity.User;
import cn.hg.demo.exception.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    public User login(@Validated @RequestBody User user, Errors errors) {
        return userMapper.login(user);
    }


    @PostMapping("/user")
    public Response register(@RequestBody User user , Errors errors){
        int isSuccess = userMapper.register(user);
        return new Response();
    }


    @PutMapping("/user")
    public int updateUserInfo(@RequestBody User user,Errors errors) {
        userMapper.updateUserInfo(user);
        return userMapper.updateUserInfo(user);
    }
}
