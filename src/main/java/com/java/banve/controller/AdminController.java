package com.java.banve.controller;

import com.java.banve.entity.User;
import com.java.banve.model.UserDTO;
import com.java.banve.service.AdminService;
import com.java.banve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;
    @RequestMapping("")
    public String employee(ModelMap model) {
        model.addAttribute("mode", "MAIN");
        model.addAttribute("employees", this.adminService.findAllEmployee());
        return "admin";
    }

    @GetMapping("them-employee")
    public String themEmployee(ModelMap modelMap) {
        modelMap.addAttribute("mode", "THEM");
        modelMap.addAttribute("employee", new UserDTO());
//        this.userService.themEmployee(id);
        return "admin";
    }


    @PostMapping("them-employee")
    public String themEmployee(@ModelAttribute("employee") UserDTO userDTO) {
        this.adminService.themEmployee(userDTO);
       return "redirect:/admin";
    }

    @GetMapping("/xoa-employee/{id}")
    public String xoaTuyen(@PathVariable("id") Integer id) {
        this.adminService.xoaEmployee(id);
        return "redirect:/admin";
    }
}
