package com.java.banve.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class SearchListVeDTO {
    public Integer id;
    public String tenChuyen;
    public String tenXe;
    public Integer gia;
    public Date ngay;
    public Date start;
    public Date end;
}
