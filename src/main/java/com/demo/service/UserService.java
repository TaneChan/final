package com.demo.service;

import com.demo.entity.User;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/1/5 0:52
 */

public interface UserService {
    /**
     * fetch  all data
     *
     * @param jsonContext json format context
     * @return Result<XxxxDO>
     */
    /*Map<String, Object> listAllUsers();*/

    /**
     * 查询全部用户信息
     *
     * @param start
     * @param size
     * @return
     */
    List<User> listAllUser(int start, int size);

    /**
     * 根据id查询用户
     *
     * @param uid
     * @return
     */
    User getById(String uid);

    /**
     * 根据id或用户名查询用户信息
     *
     * @param sid
     * @param start
     * @param size
     * @return
     */
    List<User> searchById(String sid, int start, int size);

    /**
     * 删除用户
     *
     * @param uid
     */
    void deleteById(String uid);

    /**
     * 删除管理员用户
     *
     * @param uid
     */
    void moveAdmin(String uid);

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
    void updateUserInfo(
            String uid, int sex,
            String password,
            String name,
            String email,
            String apartment,
            int point1,
            int point2,
            int position);

    /**
     * +
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
    void addUser(String uid, int sex, String password, String name, String email, String apartment, int position);

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
    void addAdmin(
            String uid,
            int sex,
            String password,
            String name,
            String email,
            String apartment,
            int point1,
            int point2,
            int position);

    /**
     * 每周清空积分
     */
    void schedulerTaskEmty();
    void schedulerTaskInsert();

    /* void BatchDelete(List<String> users);*/

}
