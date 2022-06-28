package com.demo.entity;

import java.util.Date;

/**
 * @author Gangamtou
 * @date 2020/2/18 23:57
 */
public class Reply {
    private int rid;
    private String id;
    private int pid;
    private String rapartment;
    private String rname;
    private String rcontent;
    private Date rdate;

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", id='" + id + '\'' +
                ", pid=" + pid +
                ", rapartment='" + rapartment + '\'' +
                ", rname='" + rname + '\'' +
                ", rcontent='" + rcontent + '\'' +
                ", rdate=" + rdate +
                '}';
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getRapartment() {
        return rapartment;
    }

    public void setRapartment(String rapartment) {
        this.rapartment = rapartment;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRcontent() {
        return rcontent;
    }

    public void setRcontent(String rcontent) {
        this.rcontent = rcontent;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }
}
