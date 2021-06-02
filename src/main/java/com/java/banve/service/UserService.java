package com.java.banve.service;

import com.java.banve.entity.User;
import com.java.banve.model.MyUserDetail;

public interface UserService {
    Boolean dangKy(User user);
    Boolean dangNhap(String userName, String password);
    Boolean checkIfEmailExist(String email);
    Boolean checkIfUsernameExist(String username);
    MyUserDetail findUserDetailByUsername(String username);
}
