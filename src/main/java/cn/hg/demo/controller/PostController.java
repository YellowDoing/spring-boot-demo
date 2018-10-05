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

//postMapper.createPost(post)

        return new Response();
    }

    @GetMapping("/post")
    public int/*Response<List<Post>>*/ getPosts(@RequestHeader(name = "page", defaultValue = "1") int page,
                                                @RequestHeader(name = "size", defaultValue = "10") int rows) {


        return page;
    }

    @PostMapping("/")
    public void test(String token) {




    }

}
