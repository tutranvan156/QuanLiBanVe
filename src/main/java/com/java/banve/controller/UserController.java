package com.java.banve.controller;

import com.java.banve.entity.User;
import com.java.banve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("message", null);
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
        this.userService.dangKy(user);
        return "user";
    }
    @GetMapping("dang-nhap")
    public String dangNhap(ModelMap model) {
        model.addAttribute("user", new User());
        return "dangnhap";
    }
    @PostMapping("dang-nhap")
    public String dangNhap(@ModelAttribute("user") User user) {
        if (this.userService.dangNhap(user.getUsername(), user.getPassword()) == false) {
            return "redirect:/user/dang-nhap";
        } else {
            return "redirect:/user";
        }
    }
}
