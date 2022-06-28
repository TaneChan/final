package com.demo.mapper;

import com.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/1/5 0:53
 */
@Component
public interface UserMapper {
    /**
     * 查询全部用户信息
     *
     * @return
     */
    @Select("select * from User")
    List<User> listAll();

    /**
     * 根据id查询用户信息
     *
     * @param uid
     * @return
     */
    @Select("select * " +
            "from User " +
            "where id=#{uid}")
    User getById(@Param("uid") String uid);

    /**
     * 根据id删除用户
     *
     * @param uid
     */
    @Delete("delete  " +
            "from User " +
            "where id=#{uid}")
    void deleteById(@Param("uid") String uid);

    /**
     * 修改用户信息
     *
     * @param uid
     * @param name
     * @param sex
     * @param password
     * @param email
     * @param point1
     * @param point2
     * @param position
     */
    @Update("UPDATE " +
            "User set " +
            "name=" + "#{name}" + "," +
            "sexual=#{sex}," +
            "password=" + "#{password}" + "," +
            "email=" + "#{email}" + "," +
            "apartment=#{apartment}," +
            "point1=#{point1}," +
            "point2=#{point2}," +
            "position=#{position} " +
            "where id=#{uid}")
    void updateUserInfo(@Param("uid") String uid, @Param("name") String name, @Param("sex") int sex, @Param("password") String password, @Param("apartment") String apartment, @Param("email") String email, @Param("point1") int point1, @Param("point2") int point2, @Param("position") int position);

    @Update("update post set papartment=#{apartment} where id=#{uid}")
    void updateUserInfoPost(@Param("uid") String uid, @Param("apartment") String apartment);

    @Update("update reply set rapartment=#{apartment} where id=#{uid}")
    void updateUserInfoReply(@Param("uid") String uid, @Param("apartment") String apartment);

    /**
     * 添加用户
     *
     * @param uid
     * @param username
     * @param sex
     * @param password
     * @param apartment
     * @param email
     * @param position
     */
    @Insert("insert into User (id,sexual,password,name,email,apartment,point1,point2,position,date) " +
            "values (#{uid},#{sex},#{password},#{name},#{email},#{apartment},0,0,#{position},now())")
    void addUser(@Param("uid") String uid,
                 @Param("name") String username,
                 @Param("sex") int sex,
                 @Param("password") String password,
                 @Param("email") String email,
                 @Param("apartment") String apartment,
                 @Param("position") int position);

    /**
     * 添加管理员用户
     *
     * @param uid
     * @param username
     * @param sex
     * @param password
     * @param email
     * @param point1
     * @param point2
     * @param position
     */
    @Insert("insert into Admin (id,sexual,password,name,email,apartment,point1,point2,position,date) " +
            "values (#{uid},#{sex},#{password},#{name},#{email},#{apartment},#{point1},#{point2},#{position},now())")
    void addAdmin(@Param("uid") String uid,
                  @Param("name") String username,
                  @Param("sex") int sex,
                  @Param("password") String password,
                  @Param("email") String email,
                  @Param("apartment") String apartment,
                  @Param("point1") int point1,
                  @Param("point2") int point2,
                  @Param("position") int position);

    /**
     * 删除管理员用户
     *
     * @param uid
     */
    @Delete("delete  " +
            "from Admin " +
            "where id=#{uid}")
    void moveAdmin(@Param("uid") String uid);

    /**
     * 根据id或用户名查询用户信息
     *
     * @param sid
     * @return
     */
    @Select("select * " +
            "from User " +
            "where CONCAT(id,name,apartment) like  CONCAT('%',#{sid},'%')")
    List<User> searchUserById(@Param("sid") String sid);

    @Update("update user set point1=0,point2=0")
    void schedulerTaskEmty();

    @Select("select * from user order by (point1+point2) desc limit 12")
    List<User> getRanking();

    @Select("select *  from user order by point1 desc limit 12")
    List<User> getRanking1();

    @Select("select *  from user order by point2 desc limit 12")
    List<User> getRanking2();

    @Insert("insert into user_best (id,apartment,name,point1,point2,position) select id,apartment,name,point1,point2,position from user order by (point1+point2) desc limit 12")
    void schedulerTaskInsert();


}

