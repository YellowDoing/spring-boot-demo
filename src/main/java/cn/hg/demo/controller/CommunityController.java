package cn.hg.demo.controller;


import cn.hg.demo.dao.CommunityMapper;
import cn.hg.demo.entity.Comment;
import cn.hg.demo.entity.Post;
import cn.hg.demo.entity.Response;
import cn.hg.demo.exception.ExceptionEnum;
import cn.hg.demo.exception.TokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 社区接口
 */
@RestController
public class CommunityController extends BaseController{

    private final int CODE = 10354;
    @Autowired
    private CommunityMapper postMapper;

    /**
     * 发帖
     */
    @PostMapping("/post")
    public Response createPost(@RequestHeader(name = "token") String token,
                               @RequestBody @Validated Post post, Errors errors) throws TokenException {
        checkToken(token);
        int isSuccess = postMapper.createPost(post);
        if (isSuccess == 1)
            return new Response();
        else
            return new Response(ExceptionEnum.EXCEPTION_INSERT_DATA);
    }


    /**
     * 查询帖子列表
     */
    @GetMapping("/post")
    public Response<List<Post>> getPosts(@RequestHeader(name = "page", defaultValue = "1") int page,
                                         @RequestHeader(name = "rows", defaultValue = "10") int rows) {
        return new Response<>(postMapper.selectPosts((page - 1) * rows, page * rows));
    }

    /**
     * 点赞
     * @param token
     */
    @PatchMapping("/post/{id}/great")
    public Response great(@RequestHeader(name = "token") String token, @PathVariable("id") Integer id) {
        if (postMapper.great(id) == 1)
            return new Response();
        else
            return new Response(CODE,"点赞失败");
    }


    /**
     * 评论
     */
    @PostMapping("/comment")
    public Response comment(@RequestBody @Validated Comment comment, Errors errors) {
        if (postMapper.insertComment(comment) == 1)
            return new Response();
        else
            return new Response(ExceptionEnum.EXCEPTION_INSERT_DATA);
    }

    /**
     * 获取相关评论列表
     */
    public Response<Comment> getComments(){
        return new Response();
    }
}
