package com.java.banve.service.impl;

import com.java.banve.entity.KhachHang;
import com.java.banve.repository.UserRepository;
import com.java.banve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Boolean dangKy(KhachHang khachHang) {
        List<KhachHang> allUser = (List<KhachHang>) userRepository.findAll();
        for (int i = 0; i < allUser.size(); i++) {
            if (allUser.get(i).getUsername().equals(khachHang.getUsername())) {
                return false;
            }
        }
        this.userRepository.save(khachHang);
        return true;
    }

    @Override
    public Boolean dangNhap(String userName, String password) {
        List<KhachHang> allUsers = (List<KhachHang>) userRepository.findAll();
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getUsername().equals(userName) && allUsers.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void matKhau(String email) {
       KhachHang khachHang = new KhachHang();
       khachHang = this.userRepository.findKhachHangByEmail(email);


    }
}
