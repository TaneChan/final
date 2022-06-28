package com.demo.service;

import com.demo.entity.Event;
import com.demo.entity.Event_Reply;

import java.util.Date;
import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/2/22 0:10
 */
public interface EventService {
    List<Event> listAllEvent(int start, int size);

    Event getEventById(int eid);

    void addEvent(String etitle, String econtent, int point1, int point2, Date startime, Date endtime);

    void updateEvent(String etitle, int eid, String econtent, int point1, int point2, Date startime, Date endtime);

    void enterEvent(String uid, int eid, String etitle);

    void eventCountPlus(int eid);

    void deleteEByid(int eid);

    void deleteERByid(int erid);

    List<Event_Reply> erbyEid(int eid, int start, int size);

    List<Event_Reply> erbyUid(int uid, int start, int size);

    void updateUser_Event(String etitle, int eid);

    List<Event_Reply> searchERByUid(String uid, int start, int size);

    List<Event> searchEvent(String etitle, int start, int size);

    void goodevr(int erid);

    void goodEvrPoi(int epoint1, int epoint2, String uid);

    List<Event_Reply> evshow(int eid);

    void deleteGood(int id);

    void goodEvrPoiOut(int epoint1, int epoint2, String uid);

    List<Event_Reply> getEventReplyByUid(String uid);
}
