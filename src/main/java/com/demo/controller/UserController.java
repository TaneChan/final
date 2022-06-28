package com.demo.controller;

import com.demo.common.MD5Encoder;
import com.demo.common.userTool;
import com.demo.entity.User;
import com.demo.service.*;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/1/5 0:50
 */
@Controller
@RequestMapping(value = {"User"})
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    EventService eventService;
    @Autowired
    ReplyService replyService;
    @Autowired
    FundService fundService;

    /*@Scheduled(cron = "0 00 4 ? * 1")
    private void process() {
        userService.schedulerTaskInsert();
        userService.schedulerTaskEmty();
    }*/

    @Scheduled(cron = "0 09 6 ? * SAT")
    private void process() {
        userService.schedulerTaskInsert();
        userService.schedulerTaskEmty();
        System.out.println("积分重置");
    }

    /*@Scheduled(fixedDelayString = "5000")
    void testPlaceholder1() {
        System.out.println("Execute at " + System.currentTimeMillis());
    }*/

    @RequestMapping(value = {"add"})
    public String add() {
        return "html/user/add";
    }

    /**
     * 用户登录页面路由
     *
     * @return
     */
    @RequestMapping(value = {"toLogin"})
    public String login() {
        return "html/user/login";
    }

    @RequestMapping(value = {"toReg"})
    public String reg() {
        return "html/user/reg";
    }

    @RequestMapping(value = {"Logout"})
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return "html/user/login";
    }

    /**
     * 用户登录时间
     *
     * @param username
     * @param pass
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = {"Login"})
    public String login(String username, String pass, String name, Model model) {
        System.out.println(username);
        Subject subject = SecurityUtils.getSubject();
        String md5pass = MD5Encoder.getMD5String(pass);
        UsernamePasswordToken token = new UsernamePasswordToken(username, md5pass);
        User user = userService.getById(token.getUsername());
        /*name = user.getName();*/
        /*System.out.println(userinfo);*/
        model.addAttribute("user", user);
        model.addAttribute("uid", token.getUsername());
        try {
            subject.login(token);
           /* User userinfo = (User) subject.getPrincipal();
            model.addAttribute("userinfo", userinfo);*/
            return "redirect:/HRLY/home";
            //success
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //failed,用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return "html/user/login";

        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "html/user/login";
        }
    }

    /**
     * 用户管理页面（展示全部用户信息
     *
     * @param model
     * @param start
     * @param size
     * @return
     */
    @RequestMapping(value = "userManage")
    public String userManage(Model model, @RequestParam(value = "start", defaultValue = "0") int start
            , @RequestParam(value = "size", defaultValue = "10") int size) {
        List<User> user = userService.listAllUser(start, size);
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        PageInfo<User> pageInfo = new PageInfo<>(user);
        System.out.println(pageInfo);
        model.addAttribute("users", pageInfo);
        return "html/admin/userManage";
    }

    /**
     * 用户修改页面路由
     *
     * @param uid
     * @param username
     * @param model
     * @return
     */
    @RequestMapping(value = "userEdit")
    public String userEdit(String uid, String username, Model model) {
        User user = userService.getById(uid);
        System.out.println(uid);
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        model.addAttribute("user", user);
        return "html/admin/editform";
    }

    /**
     * 删除用户
     *
     * @param uid
     * @param username
     * @return
     */
    @RequestMapping(value = "userDelete")
    public String userDelete(String uid, String username) {
        userService.deleteById(uid);
        return "redirect:/User/userManage";
    }

    /**
     * 用户信息修改
     *
     * @param uid
     * @param sex
     * @param password
     * @param name
     * @param email
     * @param point1
     * @param point2
     * @param position
     * @return
     */
    @RequestMapping(value = "userUpdate")
    public String userUpdate(String uid, int sex, String password, String name, String apartment, String email, int point1, int point2, int position) {
        String md5password = MD5Encoder.getMD5String(password);
        userService.updateUserInfo(uid, sex, md5password, name, apartment, email, point1, point2, position);
        return "redirect:/User/userManage";
    }

    @RequestMapping(value = "toAdd")
    public String toAdd(Model model) {
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        return "html/admin/addUser";
    }

    /**
     * 添加用户
     *
     * @param uid
     * @param sex
     * @param password
     * @param apartment
     * @param name
     * @param email
     * @param position
     * @return
     */
    @RequestMapping(value = "userAdd")
    public String userAdd(String uid, int sex, String password, String name, String email, String apartment, int position, Model model) {
        String md5password = MD5Encoder.getMD5String(password);
        try {
            userService.addUser(uid, sex, md5password, name, email, apartment, position);
            fundService.add(name, "入会费", 30);
            String msg = "注册成功";
            model.addAttribute("msg", msg);
            return "redirect:/User/userManage";
        } catch (Exception e) {
            String msg = "注册失败，该用户已存在";
            model.addAttribute("msg", msg);
            User userinfo = userTool.getUserinfo();
            model.addAttribute("userinfo", userinfo);
            return "html/admin/addUser";
        }
    }

    @RequestMapping(value = "userReg")
    public String userReg(String uid, int sex, String password, String name, String email, String apartment, Model model) {
        int position = 0;
        String md5password = MD5Encoder.getMD5String(password);
        try {
            userService.addUser(uid, sex, md5password, name, email, apartment, position);
            fundService.add(name, "入会费", 30);
            String msg = "注册成功";
            model.addAttribute("msg", msg);
            return "redirect:/User/toLogin";
        } catch (Exception e) {
            String msg = "注册失败，该用户已存在";
            model.addAttribute("msg", msg);
            return "html/user/reg";
        }
    }


    /**
     * 根据id或用户名模糊查询用户
     *
     * @param sid
     * @param model
     * @param start
     * @param size
     * @return
     */
    @RequestMapping(value = "userSearch")
    public String userSearch(String sid, Model model, @RequestParam(value = "start", defaultValue = "0") int start
            , @RequestParam(value = "size", defaultValue = "10") int size) {
        System.out.println(sid);
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        List<User> user = userService.searchById(sid, start, size);
        PageInfo<User> pageInfo = new PageInfo<>(user);
        model.addAttribute("sid", sid);
        model.addAttribute("users", pageInfo);
        return "html/admin/userSearch";
    }

/*    @RequestMapping(value = "batchDelete")
    public String batchUserDelete(@RequestParam(value = "user")List<String> user){
       userService.BatchDelete(user);
       return "redirect:/User/userManage";
    }*/

/*
    @RequestMapping(value = {"addUser"})
    public String addUser(){

        return userService.addUser();
    }*/
}
