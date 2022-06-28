package com.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Gangamtou
 * @date 2020/1/5 0:54
 */
public class User {
    private String id;
    private int sexual;
    private String password;
    private String apartment;
    private String name;
    private String email;
    private int point1;
    private int point2;
    private String position;
    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSexual() {
        return sexual;
    }

    public void setSexual(int sexual) {
        this.sexual = sexual;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint1() {
        return point1;
    }

    public void setPoint1(int point1) {
        this.point1 = point1;
    }

    public int getPoint2() {
        return point2;
    }

    public void setPoint2(int point2) {
        this.point2 = point2;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", sexual=" + sexual +
                ", password='" + password + '\'' +
                ", apartment='" + apartment + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", point1=" + point1 +
                ", point2=" + point2 +
                ", position='" + position + '\'' +
                ", date=" + date +
                '}';
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}