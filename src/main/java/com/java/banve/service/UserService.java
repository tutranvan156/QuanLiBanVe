package com.java.banve.service;

import com.java.banve.entity.User;
import com.java.banve.model.MyUserDetail;
import com.java.banve.model.UserDTO;
import com.java.banve.model.UserInforDTO;
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
    UserInforDTO findUserInforDTOByUsername(String username);
    void changeUserInforDTO(UserDTO userDTO);
    Boolean confirmPassword(String passwordFirst, String passwordSecond);
    void changePassword(String username, String password);
}
