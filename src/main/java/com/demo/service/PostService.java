package com.demo.service;

import com.demo.entity.Post;
import com.demo.entity.Reply;

import java.util.List;


/**
 * @author Gangamtou
 * @date 2020/2/17 23:12
 */
public interface PostService {
    void addpost(String id, String pname, String papartment, String ptitle, String pcontent, int psession);

    void adduserpost(String id, int pid);

    List<Post> listPost1(int start, int size);

    List<Post> listPost2(int start, int size);

    List<Post> listPost(int start, int size);

    void updatePost(String ptitle, String pcontent, int psession, int pid);

    void deletePost(int pid);

    void deleteBack(int pid);

    List<Post> searchPost(String ps);

    Post getPostById(int pid);

    List<Reply> getPostRepliesByPid(int pid);

    List<Reply> getReply_GomiByPid(int pid);

    List<Post> getPostsById(String id);

    List<Post> search(String search,int start,int size);
}
