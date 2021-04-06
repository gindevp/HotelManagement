/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.entity;

/**
 *
 * @author markhyun
 */
public class NhaCungCapSoDienThoai {

    int ma;
    int mancc;
    String sdt;

    public NhaCungCapSoDienThoai() {

    }

    public NhaCungCapSoDienThoai(String sdt) {
        this.sdt = sdt;
    }

    public NhaCungCapSoDienThoai(int ma, int mancc, String sdt) {
        this.ma = ma;
        this.mancc = mancc;
        this.sdt = sdt;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getMancc() {
        return mancc;
    }

    public void setMancc(int mancc) {
        this.mancc = mancc;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "NhaCungCapSoDienThoai{" + "sdt=" + sdt + '}';
    }
}
