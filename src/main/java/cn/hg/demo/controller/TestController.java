package cn.hg.demo.controller;

import cn.hg.demo.dao.UserMapper;
import cn.hg.demo.entity.Response;
import cn.hg.demo.entity.User;
import cn.hg.demo.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 测试接口
 */
@RestController
public class TestController extends BaseController{

    @Resource
    private RedisService redisService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/test1")
    public Response redisGetString(String key){
        return new Response().setMessage(redisService.getString(key));
    }

    @PostMapping("/test2")
    public Response redisSetString(String key,String value){
        redisService.setString(key,value);
        return new Response();
    }

    @PostMapping("/test3")
    public Response<List<User>> test3(){
        return new Response(userMapper.selectList(null));
    }
}
