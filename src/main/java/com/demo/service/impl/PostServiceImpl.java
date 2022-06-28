package com.demo.service.impl;

import com.demo.entity.Post;
import com.demo.entity.Reply;
import com.demo.mapper.PostMapper;
import com.demo.mapper.ReplyMapper;
import com.demo.service.PostService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/2/17 23:12
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;
    @Autowired
    ReplyMapper replyMapper;
    @Override
    public void addpost(String id, String pname, String papartment, String ptitle, String pcontent,int psession) {
        postMapper.addpost(id,pname,papartment,ptitle,pcontent,psession);
    }

    @Override
    public void adduserpost(String id, int pid) {
        postMapper.adduserpost(id,pid);
    }

    @Override
    public List<Post> listPost(int start, int size) {
        PageHelper.startPage(start, size);
        PageHelper.orderBy("pdate desc");
        return postMapper.list();
    }

    @Override
    public List<Post> listPost1(int start, int size) {

        PageHelper.startPage(start, size);
        PageHelper.orderBy("pdate desc");
        return postMapper.list1();
    }

    @Override
    public List<Post> listPost2(int start,int size) {
        PageHelper.startPage(start, size);
        PageHelper.orderBy("pdate desc");
        return postMapper.list2();
    }

    @Override
    public void updatePost(String ptitle, String pcontent, int psession, int pid) {
        postMapper.updatePost(ptitle,pcontent,psession,pid);
    }

    @Override
    public void deletePost(int pid) {
        postMapper.Post_gomi(pid);
        postMapper.deletePost(pid);
    }

    @Override
    public void deleteBack(int pid) {
        postMapper.postBack(pid);
        postMapper.deletePost_gomi(pid);
    }

    @Override
    public List<Post> searchPost(String ps) {
        return postMapper.postSearch(ps);
    }

    @Override
    public Post getPostById(int pid) {
        return postMapper.getPostById(pid);
    }

    @Override
    public List<Reply> getPostRepliesByPid(int pid) {
        return postMapper.getPostRepliesByPid(pid);
    }

    @Override
    public List<Reply> getReply_GomiByPid(int pid) {
        return replyMapper.getReply_GomiByPid(pid);
    }

    @Override
    public List<Post> getPostsById(String id) {
        PageHelper.startPage(0,10);
        return postMapper.getPostsById(id);
    }

    @Override
    public List<Post> search(String search,int start,int size) {
        PageHelper.startPage(start,size);
        return postMapper.search(search);
    }
}
