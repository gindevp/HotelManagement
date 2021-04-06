/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.entity;

/**
 *
 * @author hungn
 */
public class HDDichVu {
    private int id;
    private int maHd;
    private int maDv;
    private int soLuong;

    public HDDichVu() {
    }

    public HDDichVu(int maHd, int maDv, int soLuong) {
        this.maHd = maHd;
        this.maDv = maDv;
        this.soLuong = soLuong;
    }

    public HDDichVu(int id, int maHd, int maDv, int soLuong) {
        this.id = id;
        this.maHd = maHd;
        this.maDv = maDv;
        this.soLuong = soLuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaHd() {
        return maHd;
    }

    public void setMaHd(int maHd) {
        this.maHd = maHd;
    }

    public int getMaDv() {
        return maDv;
    }

    public void setMaDv(int maDv) {
        this.maDv = maDv;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
