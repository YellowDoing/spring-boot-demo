package cn.hg.demo.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotNull;

@ApiModel
public class User {

    @ApiModelProperty(value = "用户id")
    private int id;

    @NotNull(message = "username不能为空")
    @ApiModelProperty(value = "账号")
    private String username;

    @ApiModelProperty(hidden = true)
    @NotNull(message = "password不能为空")
    private String password;


    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "昵称")
    private String nickname;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
