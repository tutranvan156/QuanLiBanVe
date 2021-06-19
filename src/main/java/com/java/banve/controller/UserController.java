package com.java.banve.controller;

import com.java.banve.model.*;
import com.java.banve.service.ChuyenService;
import com.java.banve.service.SeatService;
import com.java.banve.service.UserService;
import com.java.banve.service.VeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ChuyenService chuyenService;

    @Autowired
    VeService veService;

    @Autowired
    SeatService seatService;

    @RequestMapping("")
    public String user(ModelMap modelMap) {
        modelMap.addAttribute("location", new Location());
        modelMap.addAttribute("message", "");
        modelMap.addAttribute("searchChuyenDTO", new SearchChuyenDTO());
        return "index";
    }
    @PostMapping("/user-chuyen-infor")
    public String timChuyen(@ModelAttribute("searchChuyenDTO") SearchChuyenDTO searchChuyenDTO, ModelMap modelMap) throws ParseException {
        if (searchChuyenDTO.getDiemDi().equals(searchChuyenDTO.getDiemDen())) {
           modelMap.addAttribute("message", "Điểm đến và điểm đi phải khác nhau");
            modelMap.addAttribute("location", new Location());
            modelMap.addAttribute("searchChuyenDTO", new SearchChuyenDTO());
           return "index";
        }
        modelMap.addAttribute("listChuyenDTO", this.chuyenService.listSearchChuyenDTO(searchChuyenDTO.getDiemDi(), searchChuyenDTO.getDiemDen(), searchChuyenDTO.getNgay()));
        return "user-select-chuyen";
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
    public String thongTinVe(@PathVariable("username") String username, ModelMap modelMap) {
        modelMap.addAttribute("mode", "LIST_VE");
        modelMap.addAttribute("ves", this.veService.findAllVeByUsername(username));
        modelMap.addAttribute("search", new Search());
        return "user-ticket-infor";
    }
    @GetMapping("/user-ticket-infor-detail/{id}")
    public String thongTinVeChiTiet(@PathVariable("id") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("mode", "VE_INFOR");
        modelMap.addAttribute("veDTO", this.veService.timVeDTO(id));
        return "user-ticket-infor";
    }
    @GetMapping("/user-chuyen-infor")





    public String thongTinChuyen(ModelMap modelMap) {
        modelMap.addAttribute("chuyens", this.chuyenService.tatCaChuyen());
        return "user-select-chuyen";
    }

    @GetMapping("/mua-ve/{id}/{username}")
    public String muaVe(@PathVariable("id") Integer id, @PathVariable("username") String username, ModelMap modelMap) {
        modelMap.addAttribute("seats", this.seatService.findAllSeatByChuyenID(id));
        modelMap.addAttribute("userTicketDTO", this.userService.findUserTicketDTO(username, id));
        modelMap.addAttribute("message", "");
        return "user-select-seat";
    }
    @PostMapping("/luu-ve-da-mua/")
    public String luuVe(@ModelAttribute("userTicketDTO") UserTicketDTO userTicketDTO) {
//        if (this.veService.checkHopLe())
        return null;
    }
}
