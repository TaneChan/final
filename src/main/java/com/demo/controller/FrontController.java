package com.demo.controller;

import com.demo.common.MD5Encoder;
import com.demo.common.userTool;
import com.demo.entity.*;
import com.demo.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/2/24 6:58
 */
@Controller
@RequestMapping(value = {"HRLY"})
public class FrontController {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    EventService eventService;
    @Autowired
    ReplyService replyService;
    @Autowired
    ShowService showService;

    @RequestMapping(value = "home")
    public String home(Model model) {
        User userinfo = userTool.getUserinfo();
        String uid = userinfo.getId();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);
        List<Post> posts = postService.getPostsById(uid);
        model.addAttribute("posts", posts);
        List<Event_Reply> event_replies = eventService.getEventReplyByUid(uid);
        model.addAttribute("event_reply", event_replies);
        return "html/user/home";
    }

    @RequestMapping(value = "seehome")
    public String seehome(Model model, String id) {
        User userinfo = userTool.getUserinfo();
        String uid = userinfo.getId();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);

        User user = userService.getById(id);
        model.addAttribute("user", user);

        List<Post> posts = postService.getPostsById(id);
        model.addAttribute("posts", posts);

        List<Event_Reply> event_replies = eventService.getEventReplyByUid(uid);
        model.addAttribute("event_reply", event_replies);
        return "html/user/seehome";
    }

    @RequestMapping(value = "userIndex")
    public String userIndex(Model model) {
        User userinfo = userTool.getUserinfo();
        String uid = userinfo.getId();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);
        List<Post> posts = postService.getPostsById(uid);
        model.addAttribute("posts", posts);
        List<Event_Reply> event_replies = eventService.getEventReplyByUid(uid);
        model.addAttribute("event_reply", event_replies);
        return "html/user/index";
    }

    @RequestMapping(value = "setting")
    public String setting(Model model) {
        User userinfo = userTool.getUserinfo();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);
        return "html/user/set";
    }

    @RequestMapping(value = "userUpdate")
    public String userUpdate(String uid, int sex, String password, String name, String apartment, String email, int point1, int point2, int position) {
        String md5password= MD5Encoder.getMD5String(password);
        userService.updateUserInfo(uid, sex, md5password, name, apartment, email, point1, point2, position);
        return "redirect:/HRLY/userIndex";
    }

    @RequestMapping(value = "index")
    public String index(Model model) {
        User userinfo = userTool.getUserinfo();
        String uid = userinfo.getId();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);
        List<Post> posts = postService.getPostsById(uid);
        model.addAttribute("posts", posts);
        List<Event_Reply> event_replies = eventService.getEventReplyByUid(uid);
        model.addAttribute("event_reply", event_replies);
        List<Post> postAll = showService.indexPostAll();
        PageInfo<Post> postPageInfo = new PageInfo<>(postAll);
        model.addAttribute("indexPost", postPageInfo);
        List<Event> events = showService.indexEvent();
        model.addAttribute("events", events);
        List<User> ranking = showService.ranking();
        model.addAttribute("ranking", ranking);
        List<Event_Reply> indexER = showService.indexEventReplyList();
        model.addAttribute("indexER", indexER);
        return "html/index";
    }

    @RequestMapping(value = "indexAll")
    public String indexAll(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) {
        User userinfo = userTool.getUserinfo();
        String uid = userinfo.getId();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);
        List<Post> posts = postService.getPostsById(uid);
        model.addAttribute("posts", posts);
        List<Event_Reply> event_replies = eventService.getEventReplyByUid(uid);
        model.addAttribute("event_reply", event_replies);
        List<Post> postAll = postService.listPost(start, size);
        PageInfo<Post> postPageInfo = new PageInfo<>(postAll);
        model.addAttribute("indexPost", postPageInfo);
        List<Event> events = showService.indexEvent();
        model.addAttribute("events", events);
        List<User> ranking = showService.ranking();
        model.addAttribute("ranking", ranking);
        List<Event_Reply> indexER = showService.indexEventReplyList();
        model.addAttribute("indexER", indexER);
        return "html/indexAll";
    }

    @RequestMapping(value = "index1")
    public String index1(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) {
        User userinfo = userTool.getUserinfo();
        String uid = userinfo.getId();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);
        List<Post> posts = postService.getPostsById(uid);
        model.addAttribute("posts", posts);
        List<Event_Reply> event_replies = eventService.getEventReplyByUid(uid);
        model.addAttribute("event_reply", event_replies);
        List<Post> postAll = postService.listPost1(start, size);
        PageInfo<Post> postPageInfo = new PageInfo<>(postAll);
        model.addAttribute("indexPost", postPageInfo);
        List<Event> events = showService.indexEvent();
        model.addAttribute("events", events);
        List<User> ranking = showService.ranking1();
        model.addAttribute("ranking", ranking);
        List<Event_Reply> indexER = showService.indexEventReplyList();
        model.addAttribute("indexER", indexER);
        return "html/index1";
    }

    @RequestMapping(value = "index2")
    public String index2(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) {
        User userinfo = userTool.getUserinfo();
        String uid = userinfo.getId();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);
        List<Post> posts = postService.getPostsById(uid);
        model.addAttribute("posts", posts);
        List<Event_Reply> event_replies = eventService.getEventReplyByUid(uid);
        model.addAttribute("event_reply", event_replies);
        List<Post> postAll = postService.listPost2(start, size);
        PageInfo<Post> postPageInfo = new PageInfo<>(postAll);
        model.addAttribute("indexPost", postPageInfo);
        List<Event> events = showService.indexEvent();
        model.addAttribute("events", events);
        List<User> ranking = showService.ranking2();
        model.addAttribute("ranking", ranking);
        List<Event_Reply> indexER = showService.indexEventReplyList();
        model.addAttribute("indexER", indexER);
        return "html/index2";
    }

    @RequestMapping(value = "postDetail")
    public String postDetails(int pid, Model model) {
        User userinfo = userTool.getUserinfo();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);

        List<Event_Reply> indexER = showService.indexEventReplyList();
        model.addAttribute("indexER", indexER);

        List<User> ranking = showService.ranking();
        model.addAttribute("ranking", ranking);

        List<Post> postAll = showService.indexPostAll();
        PageInfo<Post> postPageInfo = new PageInfo<>(postAll);
        model.addAttribute("indexPost", postPageInfo);

        List<Reply> replies = showService.rDetails(pid);
        model.addAttribute("replies", replies);

        Post post = showService.postDetails(pid);
        model.addAttribute("detail", post);
        return "html/jie/detail";
    }

    @RequestMapping(value = "toEditPost")
    public String toedit(int pid, Model model) {
        User userinfo = userTool.getUserinfo();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);
        Post post = postService.getPostById(pid);
        model.addAttribute("post", post);
        return "html/jie/edit";
    }

    @RequestMapping(value = "updatePost")
    public String updatePost(String ptitle, String pcontent, int psession, int pid) {
        postService.updatePost(ptitle, pcontent, psession, pid);
        return "redirect:/HRLY/postDetail?pid=" + pid;
    }

    @RequestMapping(value = "postReply")
    public String postReply(String rapartment, String rname, int pid, String id, String rcontent) {
        showService.addReply(rapartment, rname, pid, id, rcontent);
        return "redirect:/HRLY/postDetail?pid=" + pid;
    }

    @RequestMapping(value = "moveReply")
    public String moveReply(int rid, int pid) {
        replyService.deleteReplyByRid(rid);
        return "redirect:/HRLY/postDetail?pid=" + pid;
    }

    @RequestMapping(value = "eventDetail")
    public String eventDetails(int eid, Model model) {
        User userinfo = userTool.getUserinfo();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);

        List<Event_Reply> indexER = showService.indexEventReplyList();
        model.addAttribute("indexER", indexER);

        List<User> ranking = showService.ranking();
        model.addAttribute("ranking", ranking);

        List<Post> postAll = showService.indexPostAll();
        PageInfo<Post> postPageInfo = new PageInfo<>(postAll);
        model.addAttribute("indexPost", postPageInfo);

        List<Event_Reply> replies = showService.erDetails(eid);
        model.addAttribute("replies", replies);

        List<Event_Reply> goods = eventService.evshow(eid);
        model.addAttribute("goods", goods);

        Event event = showService.eventDetails(eid);
        model.addAttribute("detail", event);
        return "html/jie/eventDetail";
    }

    @RequestMapping(value = "replyEvent")
    public String replyEvent(String etitle, int eid, String uid, String uname, String content) {
        showService.replyEvent(etitle, eid, uid, uname, content);
        eventService.eventCountPlus(eid);
        return "redirect:/HRLY/eventDetail?eid=" + eid;
    }


    @RequestMapping(value = "moveEventReply")
    public String moveEReply(int erid, int eid) {
        eventService.deleteERByid(erid);
        return "redirect:/HRLY/eventDetail?eid=" + eid;
    }

    @RequestMapping(value = "moveGood")
    public String moveGood(int eid, String uid, int id) {
        eventService.deleteGood(id);
        int epoint1 = eventService.getEventById(eid).getEpoint1();
        int epoint2 = eventService.getEventById(eid).getEpoint2();
        eventService.goodEvrPoiOut(epoint1, epoint2, uid);
        return "redirect:/HRLY/eventDetail?eid=" + eid;
    }

    @RequestMapping(value = "like")
    public String like(int eid, int epoint1, int epoint2, int erid, String uid) {
        eventService.goodevr(erid);
        eventService.goodEvrPoi(epoint1, epoint2, uid);
        return "redirect:/HRLY/eventDetail?eid=" + eid;
    }

    @RequestMapping(value = "toAdd")
    public String toadd(Model model) {
        User userinfo = userTool.getUserinfo();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);
        return "html/jie/add";
    }

    @RequestMapping(value = "addPost")
    public String addPost(String ptitle, String pcontent, int psession) {
        User userinfo = userTool.getUserinfo();
        String id = userinfo.getId();
        String name = userinfo.getName();
        String papartment = userinfo.getApartment();
        postService.addpost(id, name, papartment, ptitle, pcontent, psession);
        return "redirect:/HRLY/home";
    }

    @RequestMapping(value = "search")
    public String Search(String search,Model model,@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size){
        User userinfo = userTool.getUserinfo();
        String uid = userinfo.getId();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);

        List<Post> posts = postService.getPostsById(uid);
        model.addAttribute("posts", posts);

        List<Event_Reply> event_replies = eventService.getEventReplyByUid(uid);
        model.addAttribute("event_reply", event_replies);

        List<Post> postAll = postService.search(search,start, size);
        PageInfo<Post> postPageInfo = new PageInfo<>(postAll);
        model.addAttribute("indexPost", postPageInfo);

        List<Event> events = showService.indexEvent();
        model.addAttribute("events", events);

        List<User> ranking = showService.ranking();
        model.addAttribute("ranking", ranking);

        List<Event_Reply> indexER = showService.indexEventReplyList();
        model.addAttribute("indexER", indexER);
        return "html/index1";
    }
}
