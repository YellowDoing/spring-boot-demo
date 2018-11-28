package cn.hg.demo.dao;

import cn.hg.demo.entity.Comment;
import cn.hg.demo.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommunityMapper {


    //发帖
    @Insert("INSERT INTO post (user_id,content, media_attachment) VALUES (#{user_id},#{content},#{media_attachment})")
    int createPost(Post post);

    //获取帖子
    @Select("SELECT * FROM post ORDER BY update_time DESC limit #{start},#{end} ")
    @Results({
            @Result(property = "creator",column = "user_id",one = @One(select = "cn.hg.demo.dao.UserMapper.findUserById")),
            @Result(property = "greatList",column = "id",many = @Many(select = "cn.hg.demo.dao.CommunityMapper.GreatsByPostId"))
    })
    List<Post> selectPosts(@Param(value = "start")int start, @Param(value = "end")int end);

    //点赞
    @Insert("INSERT INTO great (post_id,user_id) VALUES (#{post_id},#{user_id})")
    int insertGreat(@Param(value = "post_id")int post_id,@Param(value = "user_id")int user_id);

    //删除点赞
    @Delete("DELETE FROM great WHERE post_id = #{post_id} AND user_id = #{user_id}")
    int deleteGreat(@Param(value = "post_id")int post_id,@Param(value = "user_id")int user_id);

    //获取所有点赞的人
    @Select("SELECT * FROM great WHERE post_id = #{post_id}")
    List<Post> getGreatsByPostId(int post_id);

    //评论
    @Insert("INSERT INTO comment (user_id,comment_id,comment_user_id,post_id,level,content, type, media_attachment)" +
            " VALUES (#{user_id},#{comment_id},#{comment_user_id},#{post_id},#{level},#{content},#{type},#{media_attachment})")
    int insertComment(Comment comment);

    int deletCommentById();
}
