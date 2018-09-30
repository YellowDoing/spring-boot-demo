package cn.hg.demo.controller;

import cn.hg.demo.dao.PostMapper;
import cn.hg.demo.entity.Post;
import cn.hg.demo.entity.Response;
import cn.hg.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostMapper postMapper;


    @PostMapping("/post")
    public int createPost(@RequestBody @Validated Post post, Errors errors){
        return postMapper.createPost(post);
    }


}
