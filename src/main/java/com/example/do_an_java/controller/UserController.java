package com.example.do_an_java.controller;

import com.example.do_an_java.entity.KhachHang;
import com.example.do_an_java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("message", null);
        return "user";
    }
    @GetMapping("dang-ky")
    public String dangKy(@ModelAttribute("user") KhachHang khachHang, ModelMap model, @ModelAttribute("message") String message) {
        model.addAttribute("user", khachHang);
        model.addAttribute("message", message);
        return "dangky";
    }
    @PostMapping("dang-ky")
    public String dangKy(@ModelAttribute("user") KhachHang khachHang, ModelMap model) {
        if (userService.dangKy(khachHang) == false) {
           model.addAttribute("user", khachHang);
           model.addAttribute("message", "Tai khoan khong hop le");
           return "redirect:/user/dang-ky";
        }
        this.userService.dangKy(khachHang);
        return "user";
    }
    @GetMapping("dang-nhap")
    public String dangNhap(ModelMap model) {
        model.addAttribute("user", new KhachHang());
        return "dangnhap";
    }

    @PostMapping("dang-nhap")
    public String dangNhap(@ModelAttribute("user") KhachHang khachHang) {
        if (this.userService.dangNhap(khachHang.getUsername(), khachHang.getPassword()) == false) {
            return "redirect:/user/dang-nhap";
        } else {
            return "redirect:/user";
        }
    }
}
