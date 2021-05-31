package com.java.banve.service;

import com.java.banve.entity.User;

public interface UserService {
    Boolean dangKy(User user);
    Boolean dangNhap(String userName, String password);
    Boolean checkIfEmailExist(String email);
    Boolean checkIfUsernameExist(String username);
}
