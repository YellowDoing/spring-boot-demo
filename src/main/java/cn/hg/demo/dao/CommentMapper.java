package cn.hg.demo.dao;


import cn.hg.demo.entity.Comment;
import cn.hg.demo.entity.Post;
import org.apache.ibatis.annotations.Insert;

public interface CommentMapper {

    @Insert("INSERT INTO comment (user_id,comment_id,comment_user_id,post_id,level,content, type, media_attachment)" +
            " VALUES (#{user_id},#{comment_id},#{comment_user_id},#{post_id},#{level},#{content},#{type},#{media_attachment})")
    int insertComment(Comment comment);

}
