package cn.hg.demo.entity;
import javax.validation.constraints.NotNull;

public class Comment extends BaseBean{

    @NotNull(message = "请传入content")
    private String content;

    @NotNull(message = "请传入user_id")
    private Integer user_id;

    @NotNull(message = "请传入level")
    private Integer level;

    @NotNull(message = "请传入comment_id")
    private Integer comment_id;

    @NotNull(message = "请传入comment_user_id")
    private Integer comment_user_id;

    @NotNull(message = "请输入post_id")
    private Integer post_id;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

}
