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
public class HDPhong {

    private int id;
    private int maHd;
    private String soPhong;

    public HDPhong() {
    }

    public HDPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    public HDPhong(int maHd, String soPhong) {
        this.maHd = maHd;
        this.soPhong = soPhong;
    }

    public HDPhong(int id, int maHd, String soPhong) {
        this.id = id;
        this.maHd = maHd;
        this.soPhong = soPhong;
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

    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

}
