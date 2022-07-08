package com.community.dao;

import com.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XD
 * @create 2022-05-18 14:41
 */
@Mapper
public interface DiscussPostMapper {
    //显示所有的帖子；显示这个用户所有的帖子（不为空）;并且还要按照第一个和多少个显示
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    //得到所有的帖子的数目，之后要用
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id, int commentCount);
}


















