package cn.hg.demo.controller;


import cn.hg.demo.dao.CommentMapper;
import cn.hg.demo.dao.PostMapper;
import cn.hg.demo.entity.Comment;
import cn.hg.demo.entity.Post;
import cn.hg.demo.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static cn.hg.demo.exception.DemoExceptionEnum.INSERT_DATA_EXCEPTION;

/**
 * 社区接口
 */
@RestController
public class CommunityController {


    @Autowired
    private PostMapper postMapper;
    @Autowired
    private CommentMapper commentMapper;


    /**
     * 发帖
     * @param token post errors
     */
    @PostMapping("/post")
    public Response createPost(@RequestHeader(name = "token") String token,
                               @RequestBody @Validated Post post, Errors errors) {

        postMapper.createPost(post);

        return new Response();
    }


    /**
     * 查询帖子列表
     */
    @GetMapping("/post")
    public Response<List<Post>> getPosts(@RequestHeader(name = "page", defaultValue = "1") int page,
                                         @RequestHeader(name = "rows", defaultValue = "10") int rows) {

        return new Response<>(postMapper.selectPosts((page - 1) * rows, page * rows));
    }

    @PatchMapping("/post/{id}/great")
    public Response great(@RequestHeader(name = "token") String token,
                          @PathVariable("id") Integer id) {

        if (postMapper.great(id) == 1)
            return new Response();
        else
            return new Response().setMessage("点赞失败").setCode(10355);
    }


    /**
     * 评论
     */
    @PostMapping("/comment")
    public Response comment(@RequestBody @Validated Comment comment, Errors errors) {
        if (commentMapper.insertComment(comment) == 1)
            return new Response();
        else
            return new Response(INSERT_DATA_EXCEPTION);
    }

    /**
     * 获取相关评论列表
     */
    public Response<Comment> getComments(){
        return new Response();
    }
}
