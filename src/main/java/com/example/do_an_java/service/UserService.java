package com.example.do_an_java.service;

import com.example.do_an_java.entity.KhachHang;

public interface UserService {
    Boolean dangKy(KhachHang khachHang);
    Boolean dangNhap(String userName, String password);
}
