package com.java.banve.controller;

import com.java.banve.entity.Loai;
import com.java.banve.entity.Xe;
import com.java.banve.model.XeDTO;
import com.java.banve.model.XeSeatNumber;
import com.java.banve.service.LoaiService;
import com.java.banve.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/xe")
@CrossOrigin
public class XeController {

    @Autowired
    XeService xeService;

    @Autowired
    LoaiService loaiService;

    @RequestMapping("")
    public String xe(ModelMap model) {
        model.addAttribute("mode", "MAIN");
        model.addAttribute("xes", this.xeService.tatCaXe());
        return "xe";
    }

    @GetMapping("/them-xe")
    public String themXe(ModelMap model) {
        model.addAttribute("mode", "THEM");
        model.addAttribute("message", "");
        model.addAttribute("xeDTO", new XeDTO());
        model.addAttribute("xeSeatNumber", new XeSeatNumber());
        model.addAttribute("loais", this.loaiService.tatCaLoai());
        return "xe";
    }

    @PostMapping("/them-xe")
    public String themXe(XeDTO xeDTO, ModelMap model) {
        if (this.xeService.isXeExisted(xeDTO)) {
            model.addAttribute("mode", "THEM");
            model.addAttribute("xeDTO", new XeDTO());
            model.addAttribute("message", "Tên xe đã tồn tại.");
            model.addAttribute("xeSeatNumber", new XeSeatNumber());
            model.addAttribute("loais", this.loaiService.tatCaLoai());
            return "xe";
        }
        this.xeService.themXe(xeDTO);
        return "redirect:/xe";
    }

    @RequestMapping("them-xe/back")
    public String backThem() {
        return "redirect:/xe";
    }

    @GetMapping("sua-xe/{id}")
    public String suaXe(@PathVariable("id") Integer id, ModelMap model) {
        XeDTO xeDTO = this.xeService.timXeDTO(id);
        model.addAttribute("mode", "SUA");
        model.addAttribute("xeDTO", xeDTO);
        model.addAttribute("xeSeatNumber", new XeSeatNumber());
        model.addAttribute("loais", this.loaiService.tatCaLoai());
        return "xe";
    }

    @PostMapping("sua-xe")
    public String suaXe(@ModelAttribute("xeDTO") XeDTO xeDTO) {
        this.xeService.suaXe(xeDTO);
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
