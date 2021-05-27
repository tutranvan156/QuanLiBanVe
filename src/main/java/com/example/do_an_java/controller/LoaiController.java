package com.example.do_an_java.controller;

import com.example.do_an_java.entity.Loai;
import com.example.do_an_java.entity.Tuyen;
import com.example.do_an_java.service.LoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
@Controller
@CrossOrigin
@RequestMapping("/loai")
public class LoaiController {

    @Autowired
    LoaiService loaiService;

    @RequestMapping("")
    public String loai(ModelMap model) {
        model.addAttribute("mode", "MAIN");
        model.addAttribute("loais", this.loaiService.tatCaLoai());
        model.addAttribute("loai", new Loai());
        return "loai";
    }

    @GetMapping("them-loai")
    public String themLoai(ModelMap model) {
        model.addAttribute("loai", new Loai());
        model.addAttribute("mode", "THEM");
        return "loai";
    }

    @PostMapping("them-loai")
    public String themLoai(@ModelAttribute("loai") Loai loai) {
        this.loaiService.themLoai(loai);
        return "redirect:/loai";
    }

    @RequestMapping("them-loai/back")
    public String backThem() {
        return "redirect:/loai";
    }

    @GetMapping("sua-loai/{id}")
    public String suaLoai(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("loai", this.loaiService.timLoai(id));
        model.addAttribute("mode", "SUA");
        return "loai";
    }

    @PostMapping("sua-loai")
    public String suaLoai(@ModelAttribute("loai") Loai loai) {
        this.loaiService.suaLoai(loai);
        return "redirect:/loai";
    }

    @GetMapping("sua-loai/back")
    public String backSua() {
        return "redirect:/loai";
    }

    @GetMapping("/xoa-loai/{id}")
    public String xoaLoai(@PathVariable("id") Integer id) {
        this.loaiService.xoaLoai(id);
        return "redirect:/loai";
    }
}
