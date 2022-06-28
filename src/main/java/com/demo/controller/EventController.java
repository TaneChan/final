package com.demo.controller;

import com.demo.common.MyDateConverter;
import com.demo.common.userTool;
import com.demo.entity.Event;
import com.demo.entity.Event_Reply;
import com.demo.entity.User;
import com.demo.service.EventService;
import com.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @author Gangamtou
 * @date 2020/2/22 0:47
 */
@Controller
@RequestMapping(value = {"Event"})
public class EventController {
    @Autowired
    EventService eventService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "eventManage")
    public String eventManage(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) {
        List<Event> event = eventService.listAllEvent(start, size);
        PageInfo<Event> eventPageInfo = new PageInfo<>(event);
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        model.addAttribute("event", eventPageInfo);
        return "html/admin/event/eventManage";
    }

    @RequestMapping(value = "toEventAdd")
    public String toeventadd(Model model) {
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        return "html/admin/event/postevent";
    }

    @RequestMapping(value = "eventAdd")
    public String eventAdd(String etitle, String econtent, int epoint1, int epoint2, String startime, String endtime) {
        Date startime1 = MyDateConverter.convert(startime);
        Date endtime1 = MyDateConverter.convert(endtime);
        eventService.addEvent(etitle, econtent, epoint1, epoint2, startime1, endtime1);
        return "redirect:/Event/eventManage";
    }

    @RequestMapping(value = "eventEdit")
    public String eventEdit(Model model, int eid) {
        Event event = eventService.getEventById(eid);
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        model.addAttribute("event", event);
        return "html/admin/event/editEvent";
    }

    @RequestMapping(value = "eventUpdate")
    public String eventUpdate(String etitle, int eid, String econtent, int epoint1, int epoint2, String startime, String endtime) {
        Date startime1 = MyDateConverter.convert(startime);
        Date endtime1 = MyDateConverter.convert(endtime);
        eventService.updateEvent(etitle, eid, econtent, epoint1, epoint2, startime1, endtime1);
        /*eventService.updateUser_Event(etitle, eid);*/
        return "redirect:/Event/eventManage";
    }

    @RequestMapping(value = "getReplyByEid")
    public String showEventReply(Model model, int eid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "1000") int size) {
        List<Event_Reply> ere = eventService.erbyEid(eid, start, size);
        Event event = eventService.getEventById(eid);
        List<Event_Reply> goodreply=eventService.evshow(eid);
        PageInfo<Event_Reply> pageInfo = new PageInfo<>(ere);
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        model.addAttribute("event", event);
        model.addAttribute("goodreply", goodreply);
        model.addAttribute("reply", pageInfo);
        return "html/admin/event/EventReply";
    }

    @RequestMapping(value = "goodev")
    public String goodev(int erid,String uid,int eid){
        eventService.goodevr(erid);
        int epoint1=eventService.getEventById(eid).getEpoint1();
        int epoint2=eventService.getEventById(eid).getEpoint2();
        eventService.goodEvrPoi(epoint1,epoint2,uid);
        return "redirect:/Event/getReplyByEid?eid="+eid;
    }

    @RequestMapping(value = "deleteGood")
    public String deletegood(int id,String uid,int eid){
        eventService.deleteGood(id);
        int epoint1=eventService.getEventById(eid).getEpoint1();
        int epoint2=eventService.getEventById(eid).getEpoint2();
        eventService.goodEvrPoiOut(epoint1,epoint2,uid);
        return "redirect:/Event/getReplyByEid?eid="+eid;
    }

    @RequestMapping(value = "deleteEventById")
    public String deleteEbyid(int eid) {
        eventService.deleteEByid(eid);
        return "redirect:/Event/eventManage";
    }
    @RequestMapping(value = "searchERByUid")
    public String searchERByUid(String uid,int eid,Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "1000") int size){
        List<Event_Reply> eru=eventService.searchERByUid(uid,start,size);
        PageInfo<Event_Reply> pageInfo = new PageInfo<>(eru);
        User userinfo = userTool.getUserinfo();
        Event event = eventService.getEventById(eid);
        List<Event_Reply> goodreply=eventService.evshow(eid);
        model.addAttribute("event",event);
        model.addAttribute("goodreply",goodreply);
        model.addAttribute("userinfo", userinfo);
        model.addAttribute("reply",pageInfo);
        return "html/admin/event/EventReply";
    }

    @RequestMapping(value = "searchEvent")
    public String searchEvent(Model model,String etitle,@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "1000") int size){
        List<Event> ev=eventService.searchEvent(etitle,start,size);
        PageInfo<Event> pageInfo=new PageInfo<>(ev);
        User userinfo = userTool.getUserinfo();
        model.addAttribute("userinfo", userinfo);
        model.addAttribute("event",pageInfo);
        return "html/admin/event/eventManage";
    }
    @RequestMapping(value = "deleteER")
    public String deleteER(int erid,int eid){
        eventService.deleteERByid(erid);
        return "redirect:/Event/getReplyByEid?eid="+eid;
    }
}
