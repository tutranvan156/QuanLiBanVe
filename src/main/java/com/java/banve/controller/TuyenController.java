package com.java.banve.controller;

import com.java.banve.entity.Tuyen;
import com.java.banve.model.PathDTO;
import com.java.banve.model.TuyenDTO;
import com.java.banve.service.TuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


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
        model.addAttribute("tuyenDTO", new TuyenDTO());
        model.addAttribute("mode", "THEM");
        model.addAttribute("message", "");
        model.addAttribute("path", new PathDTO());
        return "tuyen";
    }
    @PostMapping("them-tuyen")
    public String themTuyen(@ModelAttribute("tuyenDTO") TuyenDTO tuyenDTO, ModelMap model) throws ParseException {
        if (this.tuyenService.isTuyenExisted(tuyenDTO)) {
            model.addAttribute("tuyenDTO", new TuyenDTO());
            model.addAttribute("mode", "THEM");
            model.addAttribute("message", "Tuyến đã tồn tại.");
            model.addAttribute("path", new PathDTO());
            return "tuyen";
        }
        this.tuyenService.themTuyenDTO(tuyenDTO);
        return "redirect:/tuyen";
    }

    @RequestMapping("them-tuyen/back")
    public String backThem() {
        return "redirect:/tuyen";

    }

    @GetMapping("sua-tuyen/{id}")
    public String suaTuyen(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("tuyenDTO", tuyenService.timTuyenDTO(id));
        model.addAttribute("path", new PathDTO());
        model.addAttribute("mode", "SUA");
        return "tuyen";
    }

    @PostMapping("sua-tuyen")
    public String suaTuyen(@ModelAttribute("tuyenDTO") TuyenDTO tuyenDTO) throws ParseException {
        this.tuyenService.suaTuyenDTO(tuyenDTO);
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
