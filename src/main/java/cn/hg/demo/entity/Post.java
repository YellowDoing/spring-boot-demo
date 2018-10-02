package cn.hg.demo.entity;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Post extends BaseBean{

    private Integer id;

    private String content;

    @Range(min = 1,max = 4,message = "请输入正确的type类型")
    @NotNull(message = "type不能为空")
    private Integer type;



    private User creator;

    private List<Comment> comments;

    @NotNull(message = "user_id不能为空")
    private Integer user_id;

    @NotNull(message = "token不能为空")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
