package cn.hg.demo.controller;

import cn.hg.demo.entity.Comment;
import cn.hg.demo.entity.Response;

import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController extends BaseController{

    @PostMapping("/comment")
    public Response comment(@RequestBody  Comment comment){

        return new Response();
    }
}
