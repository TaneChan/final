package com.demo.entity;

import java.util.Date;

/**
 * @author Gangamtou
 * @date 2020/2/22 18:39
 */
public class Event_Reply {
    private int id;
    private String etitle;
    private String uname;
    private int eid;
    private int erid;
    private String uid;
    private String content;
    private Date date;

    @Override
    public String toString() {
        return "Event_Reply{" +
                "id=" + id +
                ", etitle='" + etitle + '\'' +
                ", uname='" + uname + '\'' +
                ", eid=" + eid +
                ", erid=" + erid +
                ", uid='" + uid + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEtitle() {
        return etitle;
    }

    public void setEtitle(String etitle) {
        this.etitle = etitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getErid() {
        return erid;
    }

    public void setErid(int erid) {
        this.erid = erid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
