/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.entity;

import com.qlks.dao.TienNghiDAO;

/**
 *
 * @author hungn
 */
public class PhongTienNghi {

    private int id;
    private String soPhong;
    private int maTienNghi;
    private int soLuong;
    private String tinhTrang;

    public PhongTienNghi() {
    }

    public PhongTienNghi(String soPhong, int maTienNghi, int soLuong, String tinhTrang) {
        this.soPhong = soPhong;
        this.maTienNghi = maTienNghi;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public PhongTienNghi(int id, String soPhong, int maTienNghi, int soLuong, String tinhTrang) {
        this.id = id;
        this.soPhong = soPhong;
        this.maTienNghi = maTienNghi;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    public int getMaTienNghi() {
        return maTienNghi;
    }

    public void setMaTienNghi(int maTienNghi) {
        this.maTienNghi = maTienNghi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "PhongTienNghi{" + "id=" + id + ", soPhong=" + soPhong + ", maTienNghi=" + maTienNghi + ", soLuong=" + soLuong + ", tinhTrang=" + tinhTrang + '}';
    }

}
