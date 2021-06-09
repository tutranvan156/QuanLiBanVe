package com.java.banve.controller;

import com.java.banve.entity.User;
import com.java.banve.service.UserService;
import com.java.banve.service.RoleService;
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
@RequestMapping("/")
public class IndexController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping("/index")
    public String index() {
        return "index";
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
        this.roleService.addDefaultRole();
        return "dangnhap";
    }
}
