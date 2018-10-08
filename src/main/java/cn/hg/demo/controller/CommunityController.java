package cn.hg.demo.controller;


import cn.hg.demo.dao.PostMapper;
import cn.hg.demo.entity.Comment;
import cn.hg.demo.entity.Post;
import cn.hg.demo.entity.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@Api(description ="社区相关接口")
public class CommunityController {


    @Autowired
    private PostMapper postMapper;



    @PostMapping("/post")
    @ApiOperation(value = "发帖")
    public Response createPost(@RequestHeader(name = "token") String token,
                               @RequestBody @Validated Post post,
                               @ApiIgnore Errors errors) {

        postMapper.createPost(post);

        return new Response();
    }



    @GetMapping("/post")
    @ApiOperation(value = "帖子列表")
    public Response<List<Post>> getPosts(@RequestHeader(name = "page", defaultValue = "1") int page,
                                         @RequestHeader(name = "rows", defaultValue = "10") int rows) {

        return new Response<>(postMapper.selectPosts((page - 1) * rows, page* rows));
    }

    @PatchMapping("/post/{id}/great")
    @ApiOperation(value = "点赞")
    public Response great(@RequestHeader(name = "token") String token,
                          @PathVariable("id") Integer id){



        return new Response().setMessage("" + postMapper.great(id));
    }


    @PostMapping("/comment")
    @ApiOperation(value = "评论")
    public Response comment(@RequestBody Comment comment){

        return new Response();
    }

}
