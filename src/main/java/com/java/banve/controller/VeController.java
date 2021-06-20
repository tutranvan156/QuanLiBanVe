package com.java.banve.controller;

import com.java.banve.model.VeDTO;
import com.java.banve.model.XeDTO;
import com.java.banve.service.ChuyenService;
import com.java.banve.service.LoaiService;
import com.java.banve.service.VeService;
import com.java.banve.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/ve")
public class VeController {


    @Autowired
    XeService xeService;

    @Autowired
    LoaiService loaiService;

    @Autowired
    VeService veService;

    @Autowired
    ChuyenService chuyenService;
    @RequestMapping("")
    public String xe(ModelMap model) {
        model.addAttribute("mode", "MAIN");
        model.addAttribute("veDTO", this.veService.tatCaVeChuaDuyet());
        return "ve";
    }

    @GetMapping("/xac-nhan/{id}")
    public String xacNhan(@PathVariable("id") Integer id) {
        this.veService.xacNhanVe(id);
        return "redirect:/ve";
    }

    @GetMapping("/xoa-ve/{id}")
    public String xoaVe(@PathVariable("id") Integer id) {
        this.veService.xoaVe(id);
        return "redirect:/ve";
    }
}
