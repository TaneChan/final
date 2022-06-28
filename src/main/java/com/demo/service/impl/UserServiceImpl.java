package com.demo.service.impl;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/1/5 0:53
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /*    @Override
        public Map<String, Object> listAllUsers() {
            List<User> users = userMapper.listAll();
            *//*        userMapper.listAll().forEach(System.out::println);*//*
        users.forEach(System.out::println);
        Map<String, Object> rs = new HashMap<>();
        rs.put("users", users);

        return rs;
    }*/
    @Override
    public List<User> listAllUser(int start, int size) {
        System.out.println(userMapper.listAll());
        PageHelper.startPage(start, size);
        return userMapper.listAll();
    }

    @Override
    public List<User> searchById(String sid,int start, int size) {
        System.out.println(userMapper.searchUserById(sid));
        PageHelper.startPage(start, size);
        return userMapper.searchUserById(sid);
    }

    @Override
    public User getById(String uid) {
        System.out.println(userMapper.getById(uid));
        return userMapper.getById(uid);
    }

    @Override
    public void deleteById(String uid) {
        System.out.println(uid);
        try {
            userMapper.deleteById(uid);
            System.out.println("删除成功");
        } catch (Exception e) {
            System.out.println("删除失败");
        }
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
     */
    @Override
    public void addUser(String uid, int sex, String password, String name, String email, String apartment, int position) {
            userMapper.addUser(uid,  name, sex, password,email, apartment, position);
    }

    /**
     * 更新用户信息
     *
     * @param uid
     * @param sex
     * @param password
     * @param name
     * @param email
     * @param point1
     * @param point2
     * @param position
     */
    @Override
    public void updateUserInfo(
            String uid,
            int sex,
            String password,
            String name,
            String apartment,
            String email,
            int point1,
            int point2,
            int position) {
        try {
            userMapper.updateUserInfo(uid, name, sex, password, apartment,email,  point1, point2, position);
            userMapper.updateUserInfoPost(uid, apartment);
            userMapper.updateUserInfoReply(uid, apartment);
            System.out.println("修改成功");
        } catch (Exception e) {
            System.out.println("修改失败");
        }

    }

    /**
     * 添加管理员
     *
     * @param uid
     * @param sex
     * @param password
     * @param name
     * @param email
     * @param point1
     * @param point2
     * @param position
     */
    @Override
    public void addAdmin(String uid, int sex, String password, String name, String email, String apartment, int point1, int point2, int position) {
        try {
            userMapper.addAdmin(uid, name, sex, password, email, apartment, point1, point2, position);
            System.out.println("添加成功");
        } catch (Exception e) {
            System.out.println("添加失败");
        }
    }

    /**
     * 删除管理员用户
     *
     * @param uid
     */
    @Override
    public void moveAdmin(String uid) {
        try {
            userMapper.moveAdmin(uid);
            System.out.println("删除成功");
        } catch (Exception e) {
            System.out.println("删除失败");
        }
    }

    /**
     * 每周清空积分
     */
    @Override
    public void schedulerTaskEmty() {
        try {
            userMapper.schedulerTaskEmty();
            System.out.println("删除成功");
        } catch (Exception e) {
            System.out.println("删除失败");
        }
    }

    @Override
    public void schedulerTaskInsert() {
        userMapper.schedulerTaskInsert();
    }
/*@Override
    public void BatchDelete(List<String> users) {
        userMapper.batchDelete(users);
    }*/
    /*@Override
        public String addUser(){
        Date date=new Date();
        User user=new User();
        user.setId("1640129359");
        user.setHead("");
        user.setDate(date);
        user.setEmail("");
        user.setName("江锦涛");
        user.setPassword("1640129359");
        user.setPoint1(100);
        user.setPoint2(100);
        user.setPosition(1);
        user.setSexual(1);
        userMapper.adduser();
        String msg="complete";
        return msg;
    }*/
}
