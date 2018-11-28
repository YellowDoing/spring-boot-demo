package cn.hg.demo.entity;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Post extends BaseBean{

    private String content;
    private User creator;
    private List<Comment> comments;
    @NotNull(message = "user_id不能为空")
    private Integer user_id;
    private String media_attachment;
    private Integer great_num;
    private Integer comment_num;
    private boolean isGreat;

    public boolean isGreat() {
        return isGreat;
    }

    public void setGreat(boolean great) {
        isGreat = great;
    }

    public Integer getGreat_num() {
        return great_num;
    }

    public void setGreat_num(Integer great_num) {
        this.great_num = great_num;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getMedia_attachment() {
        return media_attachment;
    }

    public void setMedia_attachment(String media_attachment) {
        this.media_attachment = media_attachment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
