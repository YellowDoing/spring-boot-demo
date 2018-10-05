package cn.hg.demo.dao;

import cn.hg.demo.entity.Post;
import cn.hg.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PostMapper {


    @Insert("INSERT INTO post (user_id,content, type, media_attachment) VALUES (#{user_id},#{content},#{type},#{media_attachment})")
    int createPost(Post post);

    @Select("SELECT * FROM post limit #{start},#{end}")
    @Results({
            @Result(property = "creator",column = "user_id",one = @One(select = "cn.hg.demo.dao.UserMapper.findUserById"))
    })
    List<Post> selectPosts(@Param(value = "start")int start,@Param(value = "end")int end);

}
