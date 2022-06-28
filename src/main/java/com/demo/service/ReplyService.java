package com.demo.service;

/**
 * @author Gangamtou
 * @date 2020/3/15 21:19
 */
public interface ReplyService {
    void deleteReplyByRid(int rid);

    void replyBack(int rid);

    void addReply(String rapartment, String rname, int pid, String id, String rcontent);
}
