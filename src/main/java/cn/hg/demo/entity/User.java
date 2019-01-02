package cn.hg.demo.entity;

import cn.hg.demo.validation.LoginRegisterGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class User extends BaseBean{

    @NotNull(message = "用户名不能为空",groups = {LoginRegisterGroup.class})
    private String username;

    @NotNull(message = "密码不能为空",groups = {LoginRegisterGroup.class})
    private String password;

    private String phone;
    private String avatar;
    private String nickname;
    private String token;


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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

