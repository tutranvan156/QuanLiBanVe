package com.java.banve.controller;

import com.java.banve.model.ChartData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@CrossOrigin
@RequestMapping("/doanh-thu")

public class DoanhThuController {


   @RequestMapping("")
   public String test() {
       return "linechart";
   }
    @RequestMapping("/a")
    @ResponseBody
    public ResponseEntity<?> doanhthu() {

        ChartData chartData = new ChartData();
        Map<Character, List<Integer>> mappedData = new HashMap<>();
        String s = "abc";
        for (int i = 0; i < 3; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                Random random = new Random();
                int value = random.nextInt(20) + 1;
                temp.add(value);
            }
            mappedData.put(s.charAt(i), temp);
        }
        return new ResponseEntity<>(mappedData, HttpStatus.OK);
    }

}
