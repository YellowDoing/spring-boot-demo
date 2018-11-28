package cn.hg.demo.dao;

import cn.hg.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TokenMapper {

    @Select("SELECT count(*) FROM user WHERE token = #{token}")
    int checkToken(@Param(value = "token")String token);

    @Update("UPDATE user SET token = #{token} WHERE id = #{user_id}")
    int updateUserToken(@Param(value = "user_id") int user_id,@Param(value = "token") String token);

}
