package com.java.banve.service;

import com.java.banve.entity.KhachHang;

public interface UserService {
    Boolean dangKy(KhachHang khachHang);
    Boolean dangNhap(String userName, String password);
    void matKhau(String email);
}
