package com.java.banve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/doanh-thu")
public class DoanhThuController {

    @RequestMapping("")
    public String doanhthu(Model model) {
        model.addAttribute("month", "1");
        return "doanhthu";
    }


}
