package cn.hg.demo.dao;

import cn.hg.demo.entity.Comment;
import cn.hg.demo.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommunityMapper {


    @Insert("INSERT INTO post (user_id,content, type, media_attachment) VALUES (#{user_id},#{content},#{type},#{media_attachment})")
    int createPost(Post post);

    @Select("SELECT * FROM post ORDER BY update_time DESC limit #{start},#{end} ")
    @Results({
            @Result(property = "creator",column = "user_id",one = @One(select = "cn.hg.demo.dao.UserMapper.findUserById"))
    })
    List<Post> selectPosts(@Param(value = "start")int start, @Param(value = "end")int end);

    @Update("UPDATE post SET great_num = great_num + 1 WHERE id = #{post_id}")
    int great(int post_id);

    @Insert("INSERT INTO comment (user_id,comment_id,comment_user_id,post_id,level,content, type, media_attachment)" +
            " VALUES (#{user_id},#{comment_id},#{comment_user_id},#{post_id},#{level},#{content},#{type},#{media_attachment})")
    int insertComment(Comment comment);

    int deletCommentById();
}
