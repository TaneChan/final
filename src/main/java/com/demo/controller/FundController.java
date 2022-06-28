package com.demo.controller;

import com.demo.common.userTool;
import com.demo.entity.Funds;
import com.demo.entity.User;
import com.demo.service.FundService;
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
 * @date 2020/4/9 18:56
 */
@Controller
@RequestMapping(value = {"Funds"})
public class FundController {
    @Autowired
    FundService fundService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "manage")
    public String fundsManage(Model model,@RequestParam(value = "start", defaultValue = "0") int start
            , @RequestParam(value = "size", defaultValue = "10") int size) {
        User userinfo = userTool.getUserinfo();
        String uid = userinfo.getId();
        User log = userService.getById(userinfo.getId());
        model.addAttribute("userinfo", log);
        List<Funds> funds = fundService.all(start, size);
        PageInfo<Funds> pageInfo = new PageInfo<>(funds);
        model.addAttribute("funds", pageInfo);
        String total = fundService.total();
        model.addAttribute("total", total);
        return "html/admin/funds/FundsManage";
    }

    @RequestMapping(value = "delete")
    public String delete(int fid) {
        fundService.delete(fid);
        return "redirect:/Funds/manage";
    }
    @RequestMapping(value = "add")
    public String add(String fdetail,float fnumber){
        User userinfo = userTool.getUserinfo();
        String uname=userinfo.getName();
        fundService.add(uname,fdetail,fnumber);
        return "redirect:/Funds/manage";
    }
}
