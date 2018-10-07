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
public class PostController extends BaseController {

    @Autowired
    PostMapper postMapper;


    @PostMapping("/post")
    public Response createPost(@RequestHeader(name = "token") String token, @RequestBody @Validated Post post, Errors errors) {

        postMapper.createPost(post);

        return new Response();
    }

    @GetMapping("/post")
    public Response<List<Post>> getPosts(@RequestHeader(name = "page", defaultValue = "1") int page,
                                                @RequestHeader(name = "rows", defaultValue = "10") int rows) {

        return new Response<>(postMapper.selectPosts((page - 1) * rows, page* rows));
    }

    @PatchMapping("/post/great/{id}")
    public Response great(@RequestHeader(name = "token") String token,
                          @PathVariable("id") Integer id,
                          @RequestParam(name = "great") Integer great){


        return new Response().setMessage("" + postMapper.great(id));
    }

    @PostMapping("/")
    public void test(String token) {


    }

}
