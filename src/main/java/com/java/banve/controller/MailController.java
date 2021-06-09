package com.java.banve.controller;

import com.java.banve.entity.User;
import com.java.banve.service.MailService;
import com.java.banve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/")
public class MailController {
    @Autowired
    MailService mailService;
    @Autowired
    UserService userService;

    @GetMapping("mat-khau")
    public String matKhau(Model model) {
        model.addAttribute("user", new User());
        return "matkhau";
    }

    @PostMapping("mat-khau")
    public String matKhau(@ModelAttribute("user") User user) {

        if (this.mailService.checkUserExit(user.getEmail()) == true) {
            String password = this.mailService.generateRandomPassword(8);
            this.mailService.sendEmail(user.getEmail(), password);
            this.mailService.thayMatKhau(user.getEmail(), password);
            return "redirect:/dang-nhap";
        }
        return "redirect:/dang-nhap";
    }
}
