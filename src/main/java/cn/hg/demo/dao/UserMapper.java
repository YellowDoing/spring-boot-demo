package cn.hg.demo.dao;

import cn.hg.demo.dao.provider.UserSqlProvider;
import cn.hg.demo.entity.User;
import org.apache.ibatis.annotations.*;


public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    User login(User user);

    @Insert("INSERT INTO user (username, password) VALUES (#{username},#{password})")
    @Options(useGeneratedKeys = true)
    void register(User user);

    @UpdateProvider(type = UserSqlProvider.class, method = "getUserInfoUpdateSql")
    int updateUserInfo(User user);


}
