package com.demo.entity;

import java.util.Date;

/**
 * @author Gangamtou
 * @date 2020/2/23 19:38
 */
public class Funds {
    private String uname;
    private String fdetail;
    private float fnumber;
    private Date fdate;
    private int fid;
    private float total;

    @Override
    public String toString() {
        return "Funds{" +
                "uname='" + uname + '\'' +
                ", fdetail='" + fdetail + '\'' +
                ", fnumber=" + fnumber +
                ", fdate=" + fdate +
                ", fid=" + fid +
                ", total=" + total +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getFdetail() {
        return fdetail;
    }

    public void setFdetail(String fdetail) {
        this.fdetail = fdetail;
    }

    public float getFnumber() {
        return fnumber;
    }

    public void setFnumber(float fnumber) {
        this.fnumber = fnumber;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
