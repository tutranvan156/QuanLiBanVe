package com.java.banve.controller;

import com.java.banve.entity.Chuyen;
import com.java.banve.model.ChuyenDTO;
import com.java.banve.service.ChuyenService;
import com.java.banve.service.TuyenService;
import com.java.banve.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/chuyen")
public class ChuyenController {

    @Autowired
    ChuyenService chuyenService;
    @Autowired
    TuyenService tuyenService;
    @Autowired
    XeService xeService;

    @RequestMapping("")
    public String chuyen(ModelMap model) {
        model.addAttribute("mode", "MAIN");
        model.addAttribute("chuyens", this.chuyenService.tatCaChuyen());
        model.addAttribute("xes", this.xeService.tatCaXe());
        model.addAttribute("tuyens", this.tuyenService.tatCaTuyenXe());
        model.addAttribute("chuyen", new Chuyen());
        return "chuyen";
    }

    @GetMapping("them-chuyen")
    public String themChuyen(ModelMap model) {
        model.addAttribute("mode", "THEM");
        model.addAttribute("chuyenDTO", new ChuyenDTO());
        model.addAttribute("tuyens", this.tuyenService.tatCaTuyenXe());
        model.addAttribute("xes", this.xeService.tatCaXe());
        return "chuyen";
    }

    @PostMapping("them-chuyen")
    public String themChuyen(@ModelAttribute("chuyenDTO") ChuyenDTO chuyenDTO) {
        this.chuyenService.themChuyen(chuyenDTO);
        return "redirect:/chuyen";
    }

    @RequestMapping("them-chuyen/back")
    public String backThem() {
        return "redirect:/chuyen";
    }

    @GetMapping("sua-chuyen/{id}")
    public String suaChuyen(@PathVariable("id") Integer id, ModelMap model) {
        ChuyenDTO chuyenDTO = this.chuyenService.timChuyenDTO(id);
        model.addAttribute("mode", "SUA");
        model.addAttribute("chuyenDTO", chuyenDTO);
        return "chuyen";
    }

    @PostMapping("sua-chuyen")
    public String suaChuyen(@ModelAttribute("chuyenDTO") ChuyenDTO chuyenDTO) {
        this.chuyenService.suaChuyen(chuyenDTO);
        return "redirect:/chuyen";
    }

    @GetMapping("sua-chuyen/back")
    public String backSua() {
        return "redirect:/chuyen";
    }

    @GetMapping("/xoa-chuyen/{id}")
    public String xoaChuyen(@PathVariable("id") Integer id) {
        this.chuyenService.xoaChuyen(id);
        return "redirect:/chuyen";
    }
}
