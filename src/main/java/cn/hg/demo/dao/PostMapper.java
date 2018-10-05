package cn.hg.demo.dao;

import cn.hg.demo.entity.Post;
import cn.hg.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PostMapper {


    @Insert("INSERT INTO post (user_id,content, type, media_attachment) VALUES (#{user_id},#{content},#{type},#{media_attachment})")
    int createPost(Post post);

    // List<Post>
    @Select("SELECT * FROM post limit #{start},#{end}")
    List<Post> selectPosts(@Param(value = "start")int start,@Param(value = "end")int end);

}
