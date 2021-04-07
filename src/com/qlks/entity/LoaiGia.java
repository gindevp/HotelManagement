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
public class LoaiGia {
    private int ma;
    private String ten;

    public LoaiGia() {
    }

    public LoaiGia(String ten) {
        this.ten = ten;
    }

    public LoaiGia(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return this.ten; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        LoaiGia lg = (LoaiGia) obj;
        return Integer.valueOf(lg.getMa()).compareTo(Integer.valueOf(this.ma)) == 0;
    }
    
    
    
}
