package com.java.banve.controller;

import com.java.banve.model.Search;
import com.java.banve.model.SearchListVeDTO;
import com.java.banve.model.UserDTO;
import com.java.banve.model.UserInforDTO;
import com.java.banve.repository.SeatRepository;
import com.java.banve.service.UserService;
import com.java.banve.service.VeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    VeService veService;

    @RequestMapping("")
    public String user() {
        return "index";
    }

    @GetMapping("/user-infor/{username}")
    public String userInfor(@PathVariable("username") String username, ModelMap modelMap) {
        UserInforDTO userInforDTO = this.userService.findUserInforDTOByUsername(username);
        modelMap.addAttribute("mode", "USER_INFOR");
        modelMap.addAttribute("userDTO", userInforDTO);
        return "user-infor";
    }

    @GetMapping("/{username}/thay-thong-tin")
    public String thayThongTin(@PathVariable("username") String username, ModelMap modelMap) {
        UserInforDTO userInforDTO = this.userService.findUserInforDTOByUsername(username);
        modelMap.addAttribute("mode", "USER_CHANGE_INFOR");
        modelMap.addAttribute("userDTO", userInforDTO);
        return "user-infor";
    }

    @PostMapping("/thay-thong-tin")
    public String thayThongTin(@ModelAttribute("userDTO") UserDTO userDTO) {
        this.userService.changeUserInforDTO(userDTO);
        return "redirect:/dang-nhap";
    }

    @GetMapping("/{username}/thay-mat-khau")
    public String thayMatKhau(@PathVariable("username") String username, ModelMap modelMap) {
        UserInforDTO userInforDTO = this.userService.findUserInforDTOByUsername(username);
        modelMap.addAttribute("mode", "USER_CHANGE_PASS");
        modelMap.addAttribute("message", "");
        modelMap.addAttribute("userDTO", userInforDTO);
        return "user-infor";
    }

    @PostMapping("/thay-mat-khau")
    public String thayMatKhau(@ModelAttribute("userDTO") UserInforDTO userInforDTO, ModelMap modelMap) {
        if (!this.userService.confirmPassword(userInforDTO.getPasswordFirst(), userInforDTO.getPasswordSecond())) {
            modelMap.addAttribute("message", "Mật khẩu không khớp. Vui lòng nhập lại.");
            modelMap.addAttribute("mode", "USER_CHANGE_PASS");
            modelMap.addAttribute("userDTO", userInforDTO);
            return "user-infor";
        }
        this.userService.changePassword(userInforDTO.getUsername(), userInforDTO.getPasswordFirst());
        return "redirect:/dang-nhap";
    }



    @GetMapping("/user-ticket-infor/{username}")
    public String thongTinVe(@PathVariable("username") String username,  ModelMap modelMap ) {
        modelMap.addAttribute("mode", "LIST_VE");
        modelMap.addAttribute("ves", this.veService.findAllVeByUsername(username));
        modelMap.addAttribute("search", new Search());
        return "user-ticket-infor";
    }

//    @PostMapping("/search-list-ve/{username}")
//    public String searchListVe()

//    @GetMapping("/user-ticket-infor/{id}")
//    public String thongTinVeChiTiet(@PathVariable("id") Integer id, ModelMap modelMap) {
//        modelMap.addAttribute("mode", "VE_INFOR");
//        return "user-ticket-infor";
//    }
}
