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
public class NhaCungCapSDT {

    int id;
    int mancc;
    String sdt;

    public NhaCungCapSDT() {

    }

    public NhaCungCapSDT(int mancc, String sdt) {
        this.mancc = mancc;
        this.sdt = sdt;
    }

    public NhaCungCapSDT(int id, int mancc, String sdt) {
        this.id = id;
        this.mancc = mancc;
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
