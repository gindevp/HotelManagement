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
public class KhachHang {

    private int ma;
    private String ten;
    private String cmnd;
    private String sdt;
    private boolean gioiTinh;
    private String diaChi;
    private String quocTich;

    public KhachHang() {

    }

    public KhachHang(String ten, String cmnd, String sdt, boolean gioiTinh, String diaChi, String quocTich) {
        this.ten = ten;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.quocTich = quocTich;
    }

    public KhachHang(int ma, String ten, String cmnd, String sdt, boolean gioiTinh, String diaChi, String quocTich) {
        this.ma = ma;
        this.ten = ten;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.quocTich = quocTich;
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

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String isGender(boolean gioiTinh) {
        String gender = "";
        gender = gioiTinh == true ? "Nam" : "Nữ";
        return gender;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        return this.ten;
    }

}
