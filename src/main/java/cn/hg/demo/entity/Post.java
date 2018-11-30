package cn.hg.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Post extends BaseBean{

    private String content;
    private User creator;
    private List<Comment> comments;
    @NotNull(message = "user_id不能为空")
    private int user_id;
    private String media_attachment;
    private int comment_num;
    private List<Great> greatList;
    private List<Comment> commentList;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Great> getGreatList() {
        return greatList;
    }

    public void setGreatList(List<Great> greatList) {
        this.greatList = greatList;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public int getComment_num() {
        return comment_num;
    }


    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
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
