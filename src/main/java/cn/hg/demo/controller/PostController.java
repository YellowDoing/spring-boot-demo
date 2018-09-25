package cn.hg.demo.controller;


import cn.hg.demo.entity.Post;
import cn.hg.demo.entity.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "post",description = "帖子")
public class PostController {


    @GetMapping("/posts")
    @ApiOperation(value = "获取帖子列表")
    public Response<List<Post>> getPosts(){

        return new Response<>();
    }


}
