package com.example.do_an_java.controller;

import com.example.do_an_java.entity.Tuyen;
import com.example.do_an_java.service.TuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
@RequestMapping("tuyen")
public class TuyenController {
    @Autowired
    TuyenService tuyenService;

    @RequestMapping("")
    public String tuyen(ModelMap model) {
        model.addAttribute("mode", "MAIN");
        model.addAttribute("tuyens", this.tuyenService.tatCaTuyenXe());
        model.addAttribute("tuyen", new Tuyen());
        return "tuyen";
    }

    @GetMapping("them-tuyen")
    public String themTuyen(ModelMap model) {
        model.addAttribute("tuyen", new Tuyen());
        model.addAttribute("mode", "THEM");
        return "tuyen";
    }

    @PostMapping("them-tuyen")
    public String themTuyen(@ModelAttribute("tuyen") Tuyen tuyen) {
        this.tuyenService.themTuyenXe(tuyen);
        return "redirect:/tuyen";
    }

    @RequestMapping("them-tuyen/back")
    public String backThem() {
        return "redirect:/tuyen";

    }

    @GetMapping("sua-tuyen/{id}")
    public String suaTuyen(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("tuyen", tuyenService.timTuyen(id));
        model.addAttribute("mode", "SUA");
        return "tuyen";
    }

    @PostMapping("sua-tuyen")
    public String suaTuyen(@ModelAttribute("tuyen") Tuyen tuyen) {
        this.tuyenService.suaTuyenXe(tuyen);
        return "redirect:/tuyen";
    }

    @GetMapping("sua-tuyen/back")
    public String backSua() {
        return "redirect:/tuyen";
    }

    @GetMapping("/xoa-tuyen/{id}")
    public String xoaTuyen(@PathVariable("id") Integer id) {
        this.tuyenService.xoaTuyenXe(id);
        return "redirect:/tuyen";
    }
}
