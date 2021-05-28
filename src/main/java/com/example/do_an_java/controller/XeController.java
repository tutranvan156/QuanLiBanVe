package com.example.do_an_java.controller;

import com.example.do_an_java.entity.Loai;
import com.example.do_an_java.entity.Xe;
import com.example.do_an_java.service.LoaiService;
import com.example.do_an_java.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/xe")
@CrossOrigin
public class XeController {

    @Autowired
    XeService xeService;

    @RequestMapping("")
    public String xe(ModelMap model) {
        model.addAttribute("mode", "MAIN");
        model.addAttribute("xes", this.xeService.tatCaXe());
        model.addAttribute("xe", new Xe());
        return "xe";
    }

    @GetMapping("them-xe")
    public String themXe(ModelMap model) {
        model.addAttribute("xe", new Xe());
        model.addAttribute("mode", "THEM");
        return "xe";
    }

    @PostMapping("/them-xe")
    public String themXe(@ModelAttribute("xe") Xe xe) {
        this.xeService.themXe(xe);
        return "redirect:/xe";
    }

    @RequestMapping("them-xe/back")
    public String backThem() {
        return "redirect:/xe";
    }

    @GetMapping("sua-xe/{id}")
    public String suaXe(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("xe", this.xeService.timXe(id));
        model.addAttribute("mode", "SUA");
        return "xe";
    }

    @PostMapping("sua-xe")
    public String suaXe(@ModelAttribute("xe") Xe xe) {
        this.xeService.suaXe(xe);
        return "redirect:/xe";
    }

    @GetMapping("sua-xe/back")
    public String backSua() {
        return "redirect:/xe";
    }

    @GetMapping("/xoa-xe/{id}")
    public String xoaXe(@PathVariable("id") Integer id) {
        this.xeService.xoaXe(id);
        return "redirect:/xe";
    }
}
