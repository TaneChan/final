package com.demo.entity;

import java.util.Date;

/**
 * @author Gangamtou
 * @date 2020/2/22 0:04
 */
public class Event {
    private int eid;
    private String etitle;
    private String econtent;
    private int epoint1;
    private int epoint2;
    private int ecount;
    private Date startime;
    private Date endtime;

    @Override
    public String toString() {
        return "Event{" +
                "eid=" + eid +
                ", etitle='" + etitle + '\'' +
                ", econtent='" + econtent + '\'' +
                ", epoint1=" + epoint1 +
                ", epoint2=" + epoint2 +
                ", ecount=" + ecount +
                ", startime=" + startime +
                ", endtime=" + endtime +
                '}';
    }

    public int getEpoint1() {
        return epoint1;
    }

    public void setEpoint1(int epoint1) {
        this.epoint1 = epoint1;
    }

    public int getEpoint2() {
        return epoint2;
    }

    public void setEpoint2(int epoint2) {
        this.epoint2 = epoint2;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEtitle() {
        return etitle;
    }

    public void setEtitle(String etitle) {
        this.etitle = etitle;
    }

    public String getEcontent() {
        return econtent;
    }

    public void setEcontent(String econtent) {
        this.econtent = econtent;
    }

    public int getEcount() {
        return ecount;
    }

    public void setEcount(int ecount) {
        this.ecount = ecount;
    }

    public Date getStartime() {
        return startime;
    }

    public void setStartime(Date startime) {
        this.startime = startime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
