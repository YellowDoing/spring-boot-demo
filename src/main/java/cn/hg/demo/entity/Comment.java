package cn.hg.demo.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Comment extends BaseBean{

    private int id;
    private String content;
    private int user_id;

    @NotNull(message = "请传入type")
    @Size(max = 2,message = "请输入正确的type")
    private int type;

    @NotNull(message = "请输入正确的level")
    @Size(max = 2,message = "请输入正确的type")
    private int level;

    private int comment_id;
    private int comment_user_id;
    private int like_num;

    @NotNull(message = "请输入post_id")
    @Size(min = 1 ,message = "请输入正确的post_id")
    private int post_id;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getComment_user_id() {
        return comment_user_id;
    }

    public void setComment_user_id(int comment_user_id) {
        this.comment_user_id = comment_user_id;
    }

    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
}
