package cn.hg.demo.dao;

import cn.hg.demo.dao.provider.UserSqlProvider;
import cn.hg.demo.entity.User;
import org.apache.ibatis.annotations.*;


public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username}")
    User login(String username);

    @Insert("INSERT INTO user (username, password) VALUES (#{username},#{password})")
    @Options(useGeneratedKeys = true)
    int register(User user);

    @UpdateProvider(type = UserSqlProvider.class, method = "getUserInfoUpdateSql")
    int updateUserInfo(User user);

    User findUserByToken();

    @Select("SELECT count(*) FROM user WHERE username = #{username}")
    int findUserIsExist(String username);

}
