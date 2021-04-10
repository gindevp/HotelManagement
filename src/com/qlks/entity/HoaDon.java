/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author hungn
 */
public class HoaDon {

    private int ma;
    private Timestamp ngayThue;
    private Timestamp ngayThanhToan;
    private double tongTien;
    private boolean trangThai;
    private int maLg;
    private int maKh;
    private String maNv;

    public HoaDon() {
    }

    public HoaDon(int maLg, int maKh, String maNv) {
        this.maLg = maLg;
        this.maKh = maKh;
        this.maNv = maNv;
    }

    public HoaDon(Timestamp ngayThanhToan, int maLg, int maKh, String maNv) {
        this.ngayThanhToan = ngayThanhToan;
        this.maLg = maLg;
        this.maKh = maKh;
        this.maNv = maNv;
    }

    public HoaDon(int ma, Timestamp ngayThue, Timestamp ngayThanhToan, double tongTien, boolean trangThai, int maLg, int maKh, String maNv) {
        this.ma = ma;
        this.ngayThue = ngayThue;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.maLg = maLg;
        this.maKh = maKh;
        this.maNv = maNv;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Timestamp ngayThue) {
        this.ngayThue = ngayThue;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Timestamp ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaLg() {
        return maLg;
    }

    public void setMaLg(int maLg) {
        this.maLg = maLg;
    }

    public int getMaKh() {
        return maKh;
    }

    public void setMaKh(int maKh) {
        this.maKh = maKh;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

}
