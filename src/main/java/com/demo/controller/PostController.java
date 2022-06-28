package com.demo.controller;

import com.demo.common.userTool;
import com.demo.entity.Post;
import com.demo.entity.Reply;
import com.demo.entity.User;
import com.demo.service.PostService;
import com.demo.service.ReplyService;
import com.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/2/13 22:13
 */
@Controller
@RequestMapping(value = {"Post"})
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    @Autowired
    ReplyService replyService;

    @RequestMapping(value = "postManage")
    public String postManage(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) {
        List<Post> posts = postService.listPost(start, size);
        PageInfo<Post> postPageInfo = new PageInfo<>(posts);
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        model.addAttribute("posts", postPageInfo);
        return "html/admin/post/postManage";
    }

    @RequestMapping(value = "postManage1")
    public String postManage1(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) {
        List<Post> posts = postService.listPost1(start, size);
        PageInfo<Post> postPageInfo = new PageInfo<>(posts);
        System.out.println(posts);
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        model.addAttribute("posts", postPageInfo);
        return "html/admin/post/postManageN";
    }

    @RequestMapping(value = "postManage2")
    public String postManage2(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) {
        List<Post> posts = postService.listPost2(start, size);
        PageInfo<Post> postPageInfo = new PageInfo<>(posts);
        System.out.println(posts);
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        model.addAttribute("posts", postPageInfo);
        return "html/admin/post/postManageA";
    }

    @RequestMapping(value = "toAdd")
    public String toaddPost(Model model) {
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        return "html/admin/post/postAdd";
    }

    @RequestMapping(value = "addPost")
    public String addPost(String ptitle, String pcontent, int psession) {
        User userinfo = userTool.getUserinfo();
        String id = userinfo.getId();
        String name = userinfo.getName();
        String papartment = userinfo.getApartment();
        postService.addpost(id, name, papartment, ptitle, pcontent, psession);
        return "redirect:/Post/postManage";
    }

    @RequestMapping(value = "deletePostByPId")
    public String deletePost(int pid) {
        postService.deletePost(pid);
        return "redirect:/Post/postManage";
    }

    @RequestMapping(value = "editPost")
    public String toedit(int pid, Model model) {
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        Post post = postService.getPostById(pid);
        model.addAttribute("post", post);
        return "html/admin/post/editPost";
    }

    @RequestMapping(value = "updatePost")
    public String updatePost(String ptitle, String pcontent, int psession, int pid) {
        postService.updatePost(ptitle, pcontent, psession, pid);
        return "redirect:/Post/postManage";
    }

    @RequestMapping(value = "showReply")
    public String showReply(int pid, Model model) {
        List<Reply> reply = postService.getPostRepliesByPid(pid);
        List<Reply> gomi = postService.getReply_GomiByPid(pid);
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        model.addAttribute("reply", reply);
        model.addAttribute("gomi", gomi);
        return "html/admin/post/postReply";
    }

    @RequestMapping(value = "deleteReplyByRid")
    public String deleteReplyByRid(int rid, int pid) {
        replyService.deleteReplyByRid(rid);
        return "redirect:/Post/showReply?pid=" + pid;
    }

    @RequestMapping(value = "replyBack")
    public String replyBack(int rid, int pid) {
        replyService.replyBack(rid);
        return "redirect:/Post/showReply?pid=" + pid;
    }


}
