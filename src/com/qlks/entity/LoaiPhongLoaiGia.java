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
public class LoaiPhongLoaiGia {
    private int id;
    private String maLp;
    private int maLg;
    private double donGia;

    public LoaiPhongLoaiGia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaLp() {
        return maLp;
    }

    public void setMaLp(String maLp) {
        this.maLp = maLp;
    }

    public int getMaLg() {
        return maLg;
    }

    public void setMaLg(int maLg) {
        this.maLg = maLg;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public LoaiPhongLoaiGia(int id, String maLp, int maLg, double donGia) {
        this.id = id;
        this.maLp = maLp;
        this.maLg = maLg;
        this.donGia = donGia;
    }

    public LoaiPhongLoaiGia(String maLp, int maLg, double donGia) {
        this.maLp = maLp;
        this.maLg = maLg;
        this.donGia = donGia;
    }

    
    
}
