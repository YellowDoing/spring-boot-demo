package cn.hg.demo.dao.provider;

import cn.hg.demo.entity.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String getUserInfoUpdateSql(User user) {
        SQL sql = new SQL().UPDATE("user");

        if (user.getToken() != null) {
            sql.SET("token = \"" + user.getToken() + "\"");
        }

        if (user.getPhone() != null) {
            sql.SET("phone = \"" + user.getPhone() + "\"");
        }

        if (user.getAvatar() != null) {
            sql.SET("avatar = \"" + user.getAvatar() + "\"");
        }

        if (user.getNickname() != null) {
            sql.SET("nickname = \"" + user.getNickname()+"\"");
        }

        return sql.WHERE("id = " + user.getId()).toString();
    }
}
