package com.community.controller;

import com.community.entity.User;
import com.community.service.LikeService;
import com.community.util.CommunityUtil;
import com.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XD
 * @create 2022-07-10 16:37
 */
@Controller
public class LikeController {
    @Autowired
    private HostHolder hostHolder;
    @Autowired
    LikeService likeService;

    @RequestMapping(path = "/like", method = RequestMethod.POST)
    @ResponseBody
    public String like(int entityType, int entityId, int entityUserId) {
        User user = hostHolder.getUser();

        //点赞
        likeService.like(user.getId(), entityType, entityId, entityUserId);

        //数量
        long likeCount = likeService.findEntityLikeCount(entityType, entityId);
        //状态
        int likeStatus = likeService.findEntityLikeStatus(user.getId(), entityType, entityId);
        //返回的结果
        Map<String, Object> map = new HashMap<>();
        map.put("likeCount", likeCount);
        map.put("likeStatus", likeStatus);
        return CommunityUtil.getJSONString(0, null, map);
    }
}

















