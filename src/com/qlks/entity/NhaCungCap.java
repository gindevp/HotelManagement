package com.qlks.entity;

import java.util.Date;

/**
 *
 * @author markhyun
 */
public class NhaCungCap {

    private int ma;
    private String ten;
    private String diaChi;

    public NhaCungCap() {

    }

    public NhaCungCap(int ma, String ten, String diaChi) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
    }

    public NhaCungCap(String ten, String diaChi) {
        this.ten = ten;
        this.diaChi = diaChi;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return this.ten;
    }

}
