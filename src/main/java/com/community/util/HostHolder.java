package com.community.util;

import com.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author XD
 * @create 2022-06-23 14:23
 * 持有用户信息，用来代替session对象
 * 用ThreadLocal来实现
 */
@Component
public class HostHolder {
    private ThreadLocal<User> users = new ThreadLocal<>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();
    }
}
















