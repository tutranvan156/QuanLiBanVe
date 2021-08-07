package com.java.banve.controller;

import com.java.banve.service.DoanhThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class APIController {

    @Autowired
    private DoanhThuService doanhThuService;

    @RequestMapping("/all")
    public ResponseEntity<?> getDataForMultipleLineChart() {
        Map<String, List<Integer>> graphData = new TreeMap<>();
        graphData.put("Phú Yên", this.doanhThuService.countForward());
        graphData.put("Sài Gòn", this.doanhThuService.countReverse());
        return new ResponseEntity<>(graphData, HttpStatus.OK);
    }
}
