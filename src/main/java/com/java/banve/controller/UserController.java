package com.java.banve.controller;

import com.java.banve.entity.User;
import com.java.banve.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TuyenService tuyenService;
    @Autowired
    ChuyenService chuyenService;
    @Autowired
    LoaiService  loaiService;
    @Autowired
    XeService xeService;

    @RequestMapping("")
    public String index(ModelMap model) {
        model.addAttribute("message", null);
        model.addAttribute("tuyens", this.tuyenService.findTuyenLimit());
        model.addAttribute("chuyens", this.chuyenService.findChuyenLimit());
        model.addAttribute("loais", this.loaiService.findLoaiLimit());
        model.addAttribute("xes", this.xeService.findXeLimit());
        return "user";
    }

    @GetMapping("dang-ky")
    public String dangKy(@ModelAttribute("user") User user, ModelMap model, @ModelAttribute("message") String message) {
        model.addAttribute("user", user);
        return "dangky";
    }

    @PostMapping("dang-ky")
    public String dangKy(@Valid User user, BindingResult bindingResult, Model model) {
        if (userService.checkIfEmailExist(user.getEmail())) {
            bindingResult.addError(new FieldError("user", "email", "Email đã tồn tại"));
        }
        if (userService.checkIfUsernameExist(user.getUsername())) {
            bindingResult.addError(new FieldError("user", "username", "Tên đăng nhập đã tồn tại"));
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "dangky";
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        this.userService.dangKy(user);
        return "dangnhap";
    }

    @GetMapping("dang-nhap")
    public String dangNhap() {
        return "dangnhap";
    }
}
