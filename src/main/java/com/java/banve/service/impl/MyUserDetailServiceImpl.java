package com.java.banve.service.impl;

import com.java.banve.entity.User;
import com.java.banve.model.MyUserDetail;
import com.java.banve.repository.UserRepository;
import com.java.banve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userService.findUserDetailByUsername(username);
//        User user = userRepository.findByUsername(username);
        if(user == null){
            throw  new UsernameNotFoundException("user name not found: "+ username);
        }
//        return new MyUserDetail(user);
        return user;
    }
}

