package com.java.banve.service;


import java.util.List;

public interface DoanhThuService {

    List<Integer> countForward();
    List<Integer> countReverse();
    List<Integer> count(String location);



}
