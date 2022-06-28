package com.demo.common;

import com.demo.entity.User;
import com.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Gangamtou
 * @date 2020/2/20 16:35
 */
public class userTool {
    public static User getUserinfo(){
        Subject subject = SecurityUtils.getSubject();
        User userinfo = (User) subject.getPrincipal();
        return userinfo;
    }

}
