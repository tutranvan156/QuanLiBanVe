package com.java.banve.service.impl;

import com.java.banve.entity.Role;
import com.java.banve.entity.User;
import com.java.banve.model.MyUserDetail;
import com.java.banve.model.UserDTO;
import com.java.banve.model.UserInforDTO;
import com.java.banve.repository.UserRepository;
import com.java.banve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Boolean dangKy(User user) {
        user.setStatus(true);
        Role role = new Role(3, "USER");
        user.setRoles(Set.of(role));
        this.userRepository.save(user);
        return true;
    }

    @Override
    public Boolean dangNhap(String userName, String password) {
        List<User> allUsers = (List<User>) userRepository.findAll();
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getUsername().equals(userName) && allUsers.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean checkIfEmailExist(String email) {
        if (this.userRepository.findUserByEmail(email) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkIfUsernameExist(String username) {
        if (this.userRepository.findUserByUsername(username) != null) {
            return true;
        }
        return false;
    }

    @Override
    public MyUserDetail findUserDetailByUsername(String username) {
        User user = userRepository.findByUsername(username);
        MyUserDetail myUserDetail = new MyUserDetail();
        myUserDetail.setUser(user);
        myUserDetail.setFullName(user.getHo() + " " + user.getTen());
        return myUserDetail;
    }

    @Override
    public User findUserByUserName(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void xoaUser(Integer id) {
        User user = userRepository.findById(id).get();
        user.setStatus(false);
        this.userRepository.save(user);
    }

    @Override
    public void changUserInfor(User user) {
        this.userRepository.save(user);
    }

    @Override
    public UserInforDTO findUserInforDTOByUsername(String username) {
        User user = userRepository.findByUsername(username);
        UserInforDTO userInforDTO = new UserInforDTO();
        userInforDTO.setUsername(user.getUsername());
        userInforDTO.setDiachi(user.getDiachi());
        userInforDTO.setHo(user.getHo());
        userInforDTO.setTen(user.getTen());
        userInforDTO.setFullName(userInforDTO.getHo() + " " + userInforDTO.getTen());
        userInforDTO.setSdt(user.getSdt());
        userInforDTO.setEmail(user.getEmail());
        return userInforDTO;
    }


    @Override
    public void changeUserInforDTO(UserDTO userDTO) {
        User user = this.userRepository.findByUsername(userDTO.getUsername());
        user.setSdt(userDTO.getSdt());
        user.setTen(userDTO.getTen());
        user.setHo(userDTO.getHo());
        user.setDiachi(userDTO.getDiachi());
        this.userRepository.save(user);
    }

    @Override
    public Boolean confirmPassword(String passwordFirst, String passwordSecond) {
        return passwordFirst.equals(passwordSecond);
    }

    @Override
    public void changePassword(String username, String password) {
        User user = userRepository.findByUsername(username);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        this.userRepository.save(user);
    }


    @Override
    public void themEmployee(Integer id) {
        User user = this.userRepository.findById(id).get();
        Role role1 = new Role(2, "EMPLOYEE");
        Role role2 = new Role(3, "USER");
        user.setRoles(Set.of(role1, role2));
        this.userRepository.save(user);
    }

    @Override
    public void xoaEmployee(Integer id) {
       User user = this.userRepository.findById(id).get();
       user.setStatus(false);
       this.userRepository.save(user);
    }

    @Override
    public List<UserInforDTO> findAllUserStatusEqualsTrue() {
        List<User> listUser =this.userRepository.findAllByStatusEqualsTrue();
        ArrayList<UserInforDTO> userInforDTOArrayList = new ArrayList<>();
        for (int i = 0; i < listUser.size(); i++) {
            UserInforDTO temp = new UserInforDTO();
            temp.setId(listUser.get(i).getId());
            temp.setFullName(listUser.get(i).getHo() + " " + listUser.get(i).getTen());
            temp.setUsername(listUser.get(i).getUsername());
            temp.setSdt(listUser.get(i).getSdt());
            temp.setDiachi(listUser.get(i).getDiachi());
            userInforDTOArrayList.add(temp);
        }
        return userInforDTOArrayList;
    }
}
