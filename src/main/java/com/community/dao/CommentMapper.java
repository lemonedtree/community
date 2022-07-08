package com.community.dao;


import com.community.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author XD
 * @create 2022-07-06 21:12
 */
@Mapper
public interface CommentMapper {
    List<Comment> selectCommentsByEntity(int entityType, int entityId, int offset, int limit);
    int selectCountByEntity(int entityType, int entityId);
    int insertComment(Comment comment);

}













