package com.java.banve.service;

import com.java.banve.entity.User;
import com.java.banve.model.MyUserDetail;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    Boolean dangKy(User user);
    Boolean dangNhap(String userName, String password);
    Boolean checkIfEmailExist(String email);
    Boolean checkIfUsernameExist(String username);
    MyUserDetail findUserDetailByUsername(String username);
    User findUserByUserName(String username);
    void xoaUser(Integer id);
    void changUserInfor(User user);
}
