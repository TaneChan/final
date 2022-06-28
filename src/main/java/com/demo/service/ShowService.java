package com.demo.service;

import com.demo.entity.*;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/3/6 22:54
 */
public interface ShowService {
    List<Post> indexPostAll();

    List<Post> indexPost1();

    List<Post> indexPost2();

    List<Event> indexEvent();

    List<User> ranking();

    List<User> ranking1();

    List<User> ranking2();

    List<Event_Reply> indexEventReplyList();

    Event eventDetails(int eid);

    Post postDetails(int pid);

    List<Event_Reply> erDetails(int eid);

    List<Reply> rDetails(int pid);

    void addReply(String rapartment, String rname, int pid, String id, String rcontent);

    void replyEvent(String etitle, int eid, String uid, String uname, String content);
}
