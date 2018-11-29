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
    public Response createPost(@RequestHeader(name = "token",defaultValue = "") String token,
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
    @PostMapping("/great/{id}")
    public Response great(@RequestHeader(name = "token",defaultValue = "") String token,
                          @RequestParam(name = "user_id")Integer user_id,
                          @PathVariable("id") Integer id) throws TokenException{
        checkToken(token);
        if (postMapper.insertGreat(id,user_id) == 1)
            return new Response();
        else
            return new Response(CODE,"点赞失败");
    }

    /**
     * 取赞
     * @param token
     */
    @PostMapping("/unGreat/{id}")
    public Response unGreat(@RequestHeader(name = "token") String token,
                          @RequestParam(name = "user_id")Integer user_id,
                          @PathVariable("id") Integer id) throws TokenException{
        checkToken(token);
        if (postMapper.deleteGreat(id,user_id) == 1)
            return new Response();
        else
            return new Response(CODE,"取赞失败");
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
