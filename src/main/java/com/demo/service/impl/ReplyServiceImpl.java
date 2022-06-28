package com.demo.service.impl;

import com.demo.mapper.ReplyMapper;
import com.demo.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gangamtou
 * @date 2020/2/25 21:19
 */
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;
    @Override
    public void deleteReplyByRid(int rid) {
        replyMapper.addReply_gomi(rid);
        replyMapper.deleteReply(rid);
    }

    @Override
    public void replyBack(int rid) {
        replyMapper.replyBack(rid);
        replyMapper.deleteReply_gomi(rid);
    }

    @Override
    public void addReply(String rapartment, String rname, int pid, String id, String rcontent) {
        replyMapper.addReply(rapartment, rname, pid, id, rcontent);
    }
}
