package com.java.banve.controller;

import com.java.banve.entity.Loai;
import com.java.banve.model.LoaiDTO;
import com.java.banve.service.LoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

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
        model.addAttribute("mode", "THEM");
        model.addAttribute("loai", new LoaiDTO());
        return "loai";
    }

    @PostMapping("them-loai")
    public String themLoai(@ModelAttribute("loai") LoaiDTO loaiDTO) throws ParseException {
        this.loaiService.themLoai(loaiDTO);
        return "redirect:/loai";
    }

    @RequestMapping("them-loai/back")
    public String backThem() {
        return "redirect:/loai";
    }

    @GetMapping("sua-loai/{id}")
    public String suaLoai(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("loai", this.loaiService.timLoaiDTO(id));
        model.addAttribute("mode", "SUA");
        return "loai";
    }

    @PostMapping("sua-loai")
    public String suaLoai(@ModelAttribute("loai") LoaiDTO loaiDTO) throws ParseException {
        this.loaiService.suaLoai(loaiDTO);
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
