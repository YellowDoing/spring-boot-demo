package cn.hg.demo.dao;

import cn.hg.demo.dao.provider.UserSqlProvider;
import cn.hg.demo.entity.User;
import cn.hg.demo.exception.ExceptionEnum;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findUserById(Integer id);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User getUserByUserName(String username);

    @UpdateProvider(type = UserSqlProvider.class, method = "getUserInfoUpdateSql")
    int updateUserInfo(User user);

    @Select("SELECT count(*) FROM user WHERE username = #{username}")
    int findUserByUserName(String username);

    @Insert("INSERT INTO user (username, password) VALUES (#{username},#{password})")
    @Options(useGeneratedKeys = true) //返回主键
    int register(User user);


}
