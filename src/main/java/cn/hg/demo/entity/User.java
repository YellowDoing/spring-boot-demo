package cn.hg.demo.entity;

import javax.validation.constraints.NotNull;

public class User {

    @NotNull(message = "username不能为空")
    private String username;
    @NotNull(message = "password不能为空")
    private String password;

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
