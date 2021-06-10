package com.java.banve.controller;

import com.java.banve.model.VeDTO;
import com.java.banve.model.XeDTO;
import com.java.banve.service.ChuyenService;
import com.java.banve.service.LoaiService;
import com.java.banve.service.VeService;
import com.java.banve.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        model.addAttribute("ves", this.veService.tatCaVeChuaDuyet());
        return "ve";
    }

//    @GetMapping("/them-ve")
//    public String themXe(ModelMap model) {
//        model.addAttribute("mode", "THEM");
//        model.addAttribute("veDTO", new VeDTO());
//        model.addAttribute("chuyens", this.chuyenService.tatCaChuyen());
//        return "ve";
//    }

//    @PostMapping("/them-ve")
//    public String themVe(VeDTO veDTO) {
//
//        this.veService.themVe(veDTO);
//        return "redirect:/xe";
//    }
//
//    @RequestMapping("them-ve/back")
//    public String backThem() {
//        return "redirect:/ve";
//    }

//    @GetMapping("sua-ve/{id}")
//    public String suaVe(@PathVariable("id") Integer id, ModelMap model) {
////        VeDTO veDTO = this.veService.
////                XeDTO xeDTO = this.xeService.timXeDTO(id);
////        model.addAttribute("mode", "SUA");
////        model.addAttribute("xeDTO", xeDTO);
////        model.addAttribute("loais", this.loaiService.tatCaLoai());
////        return "xe";
//        VeDTO veDTO = this.veService.timVeDTO(id);
//        model.addAttribute("mode", "SUA");
//        model.addAttribute("veDTO", veDTO);
//        model.addAttribute("chuyens", )
//    }
//
//    @PostMapping("sua-xe")
//    public String suaXe(@ModelAttribute("xeDTO") XeDTO xeDTO) {
//        this.xeService.suaXe(xeDTO);
//        return "redirect:/xe";
//    }
//
//    @GetMapping("sua-xe/back")
//    public String backSua() {
//        return "redirect:/xe";
//    }
//
    @GetMapping("/xac-nhan/{id}")
    public String xacNhan(@PathVariable("id") Integer id) {
        this.veService.xacNhanVe(id);
        return "redirect:/ve";
    }
}
