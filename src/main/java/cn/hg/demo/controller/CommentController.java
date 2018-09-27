package cn.hg.demo.controller;

import cn.hg.demo.entity.Comment;
import cn.hg.demo.entity.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "comment",description = "评论")
public class CommentController {

    @PostMapping("/comment")
    @ApiOperation(value = "评论")
    public Response comment(@RequestBody @ApiParam(value = "评论json数据") Comment comment){

        return new Response();
    }
}
