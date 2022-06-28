package com.demo.service.impl;

import com.demo.entity.Event;
import com.demo.entity.Event_Reply;
import com.demo.mapper.EventMapper;
import com.demo.service.EventService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/2/22 0:09
 */
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventMapper eventMapper;

    @Override
    public List<Event> listAllEvent(int start, int size) {
        PageHelper.startPage(start, size);
        return eventMapper.listAllEvent();
    }

    @Override
    public Event getEventById(int eid) {
        return eventMapper.getEventById(eid);
    }

    @Override
    public void addEvent(String etitle, String econtent, int point1, int point2, Date startime, Date endtime) {
        try {
            eventMapper.addEvent(etitle, econtent, point1, point2, startime, endtime);
            System.out.println("添加成功");
        } catch (Exception e) {
            System.out.println("添加失败");
        }
    }

    @Override
    public void updateEvent(String etitle, int eid, String econtent, int point1, int point2, Date startime, Date endtime) {
        try {
            eventMapper.updateEvent(etitle, eid, econtent, point1, point2, startime, endtime);
            System.out.println("添加成功");
        } catch (Exception e) {
            System.out.println("添加失败");
        }
    }

    @Override
    public void enterEvent(String uid, int eid, String etitle) {
        try {
            eventMapper.enterEvent(uid, eid, etitle);
            System.out.println("添加成功");
        } catch (Exception e) {
            System.out.println("添加失败");
        }
    }

    @Override
    public void eventCountPlus(int eid) {
        eventMapper.eventCountPlus(eid);
    }

    @Override
    public List<Event_Reply> erbyEid(int eid, int start, int size) {
        PageHelper.startPage(start, size);
        List<Event_Reply> erbyeid = eventMapper.erbyEid(eid);
        return erbyeid;
    }

    @Override
    public List<Event_Reply> erbyUid(int uid, int start, int size) {
        PageHelper.startPage(start, size);
        List<Event_Reply> erbyuid = eventMapper.erbyUid(uid);
        return erbyuid;
    }

    @Override
    public void updateUser_Event(String etitle, int eid) {
        eventMapper.updateUser_event(etitle, eid);
    }

    @Override
    public void deleteEByid(int eid) {
        eventMapper.deleteEById(eid);
    }

    @Override
    public  List<Event_Reply> searchERByUid(String uid, int start, int size) {
        PageHelper.startPage(start, size);
        return eventMapper.searchERByUid(uid);
    }

    @Override
    public void deleteERByid(int erid) {
        eventMapper.deleteer(erid);
    }

    @Override
    public List<Event> searchEvent(String etitle, int start, int size) {
        PageHelper.startPage(start,size);
        return eventMapper.searchEvent(etitle);
    }

    @Override
    public List<Event_Reply> evshow(int eid) {
        return eventMapper.evshow(eid);
    }

    @Override
    public void goodevr(int erid) {
        eventMapper.goodevr(erid);
    }

    @Override
    public void goodEvrPoi(int epoint1, int epoint2, String uid) {
        eventMapper.goodEvrPoi(epoint1, epoint2, uid);
    }

    @Override
    public void deleteGood(int id) {
        eventMapper.deleteGood(id);
    }

    @Override
    public void goodEvrPoiOut(int epoint1, int epoint2, String uid) {
        eventMapper.goodEvrPoiOut(epoint1,epoint2,uid);
    }

    @Override
    public List<Event_Reply> getEventReplyByUid(String uid) {
        PageHelper.startPage(0,5);
        return eventMapper.getEventReplyByUid(uid);
    }
}
