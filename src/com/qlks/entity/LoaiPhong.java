/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.entity;

import java.util.Date;

/**
 *
 * @author markhyun
 */
public class LoaiPhong {

    private String ma;
    private String ten;
    private String moTa;

    public LoaiPhong() {

    }

    public LoaiPhong(String ma, String ten, String moTa) {
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return this.ten;
    }

    @Override
    public boolean equals(Object obj) {
        LoaiPhong lp = (LoaiPhong) obj;
        return lp.getMa().equals(this.ma);
    }

}
