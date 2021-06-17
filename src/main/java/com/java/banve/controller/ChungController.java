package com.java.banve.controller;

import com.java.banve.interceptor.UserInterceptor;
import com.java.banve.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/chung")
public class ChungController {

    @Autowired
    UserService userService;
    @Autowired
    TuyenService tuyenService;
    @Autowired
    ChuyenService chuyenService;
    @Autowired
    LoaiService loaiService;
    @Autowired
    XeService xeService;
    @Autowired
    UserInterceptor userInterceptor;
    @RequestMapping("")

    public String index(ModelMap model) {
        model.addAttribute("tuyens", this.tuyenService.findTuyenLimit());
        model.addAttribute("chuyens", this.chuyenService.findChuyenLimit());
        model.addAttribute("loais", this.loaiService.findLoaiLimit());
        model.addAttribute("xes", this.xeService.findXeLimit());
        return "chung";
    }

}
