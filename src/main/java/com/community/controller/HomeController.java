package com.community.controller;

import com.community.entity.DiscussPost;
import com.community.entity.Page;
import com.community.entity.User;
import com.community.service.DiscussPostService;
import com.community.service.LikeService;
import com.community.service.MessageService;
import com.community.service.UserService;
import com.community.util.CommunityConstant;
import com.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XD
 * @create 2022-05-18 16:02
 */
@Controller
public class HomeController implements CommunityConstant {
    @Autowired
    DiscussPostService discussPostService;
    @Autowired
    UserService userService;
    @Autowired
    LikeService likeService;
    @Autowired
    MessageService messageService;
    @Autowired
    HostHolder hostHolder;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        // 方法调用前,SpringMVC会自动实例化Model和Page,并将Page注入Model.
        // 所以,在thymeleaf中可以直接访问Page对象中的数据.
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                //我们需要一个帖子得到赞的总数
                long likeCount = likeService.findEntityLikeCount(ENTITY_TYPE_POST, post.getId());
                map.put("likeCount", likeCount);

                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        //我需要我总共有多少条未读消息
        User user = hostHolder.getUser();
        int unreadMessageCount = messageService.findLetterUnreadCount(user.getId(), null);
        model.addAttribute("unreadMessageCount", unreadMessageCount);

        return "/index";
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String getErrorPage() {
        return "/error/500";
    }
}
