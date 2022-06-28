package com.demo.shiro;

import com.demo.entity.User;
import com.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Gangamtou
 * @date 2020/1/5 21:18
 */
public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        System.out.println("执行授权");

        //授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //info.addStringPermission("1");
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        User logUser = userService.getById(user.getId());
        info.addStringPermission(logUser.getPosition());
        return info;
    }

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {

        System.out.println("执行认证");

        //用户名密码
        UsernamePasswordToken token = (UsernamePasswordToken) arg0;
        User user = userService.getById(token.getUsername());
        System.out.println(token.getUsername());
        if (user == null) {
            //用户名不存在
            return null;
        }
        //判断密码
        return new SimpleAuthenticationInfo(user, user.getPassword(), "login");
    }
}

