package cn.hg.demo.entity;
import javax.validation.constraints.NotNull;

public class Comment extends BaseBean{

    private int like_num;
    private String content;
    private String media_attachment;

    @NotNull(message = "请传入type")
    private Integer type;

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

    public String getMedia_attachment() {
        return media_attachment;
    }

    public void setMedia_attachment(String media_attachment) {
        this.media_attachment = media_attachment;
    }
}
