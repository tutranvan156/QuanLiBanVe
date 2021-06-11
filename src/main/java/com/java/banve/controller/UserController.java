package com.java.banve.controller;

import com.java.banve.entity.User;
import com.java.banve.model.MyUserDetail;
import com.java.banve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("")
    public String user() {
        return "index";
    }

    @GetMapping("/user-infor/{username}")
    public String userInfor(@PathVariable("username") String username, ModelMap modelMap) {
        MyUserDetail user = this.userService.findUserDetailByUsername(username);
        modelMap.addAttribute("mode", "USER_INFOR");
        modelMap.addAttribute("user", user);
        return "user-infor";
    }

    @GetMapping("/{username}/thay-mat-khau")
    public String thayMatKhau(@PathVariable("username") String username, ModelMap modelMap) {
        MyUserDetail userDetail = this.userService.findUserDetailByUsername(username);
        String temp = userDetail.getPassword();
        modelMap.addAttribute("mode", "USER_CHANGE_PASS");
        modelMap.addAttribute("user", userDetail);
        return "user-infor" ;
    }
    @GetMapping("/{username}/thay-thong-tin")
    public String thayThongTin(@PathVariable("username") String username, ModelMap modelMap) {
        User user = this.userService.findUserByUserName(username);
        modelMap.addAttribute("mode", "USER_CHANGE_INFOR");
        modelMap.addAttribute("user", user);
        return "user-infor" ;
    }
    @PostMapping("/thay-thong-tin")
    public String thayThongTin(@ModelAttribute("user") User user) {
        this.userService.changUserInfor(user);
        return "redirect:/user";
    }



}
