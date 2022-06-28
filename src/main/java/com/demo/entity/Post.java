package com.demo.entity;

import java.util.Date;

/**
 * @author Gangamtou
 * @date 2020/2/18 23:53
 */
public class Post {
    private int pid;
    private String id;
    private String pname;
    private String papartment;
    private String ptitle;
    private String pcontent;
    private int psession;
    private Date pdate;

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", id='" + id + '\'' +
                ", pname='" + pname + '\'' +
                ", papartment='" + papartment + '\'' +
                ", ptitle='" + ptitle + '\'' +
                ", pcontent='" + pcontent + '\'' +
                ", psession=" + psession +
                ", pdate=" + pdate +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPapartment() {
        return papartment;
    }

    public void setPapartment(String papartment) {
        this.papartment = papartment;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public int getPsession() {
        return psession;
    }

    public void setPsession(int psession) {
        this.psession = psession;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }
}
