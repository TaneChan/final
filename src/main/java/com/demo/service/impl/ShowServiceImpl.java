package com.demo.service.impl;

import com.demo.entity.*;
import com.demo.mapper.EventMapper;
import com.demo.mapper.PostMapper;
import com.demo.mapper.ReplyMapper;
import com.demo.mapper.UserMapper;
import com.demo.service.EventService;
import com.demo.service.ShowService;
import com.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/3/24 19:45
 */
@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PostMapper postMapper;
    @Autowired
    ReplyMapper replyMapper;
    @Autowired
    EventMapper eventMapper;

    @Override
    public List<Post> indexPostAll() {
        PageHelper.startPage(0,10,"pdate desc");
        return postMapper.list();
    }

    @Override
    public List<Post> indexPost1() {
        PageHelper.startPage(0,10,"pdate desc");
        return postMapper.list1();
    }

    @Override
    public List<Post> indexPost2() {
        PageHelper.startPage(0,10,"pdate desc");
        return postMapper.list2();
    }

    @Override
    public List<Event> indexEvent() {
        /*PageHelper.startPage(0,5,"pdate desc");*/
        return eventMapper.indexEvent();
    }

    @Override
    public List<User> ranking() {
        return userMapper.getRanking();
    }

    @Override
    public List<User> ranking1() {
        return userMapper.getRanking1();
    }

    @Override
    public List<User> ranking2() {
        return userMapper.getRanking2();
    }

    @Override
    public List<Event_Reply> indexEventReplyList() {
        return eventMapper.indexEventReplyList();
    }

    @Override
    public Event eventDetails(int eid) {
        return eventMapper.getEventById(eid);
    }

    @Override
    public Post postDetails(int pid) {
        return postMapper.getPostById(pid);
    }

    @Override
    public List<Event_Reply> erDetails(int eid) {
        return eventMapper.erbyEid(eid);
    }

    @Override
    public List<Reply> rDetails(int pid) {
        return postMapper.getPostRepliesByPid(pid);
    }

    @Override
    public void addReply(String rapartment, String rname, int pid, String id, String rcontent) {
        replyMapper.addReply(rapartment, rname, pid, id, rcontent);
    }

    @Override
    public void replyEvent(String etitle, int eid, String uid, String uname, String content) {
        eventMapper.replyEvent(etitle, eid, uid, uname, content);
    }
}
