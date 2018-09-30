package cn.hg.demo.dao;

import cn.hg.demo.entity.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface PostMapper {


    @Insert("INSERT INTO post (user_id,content, type) VALUES (#{user_id},#{content},#{type})")
    int createPost(Post post);

   // List<Post> selectPosts



}
