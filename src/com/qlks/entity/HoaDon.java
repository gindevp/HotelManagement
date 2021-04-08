/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.entity;

import java.util.Date;

/**
 *
 * @author hungn
 */
public class HoaDon {

    private int ma;
    private Date ngayThue;
    private Date ngayThanhToan;
    private double tongTien;
    private boolean trangThai;
    private int maKh;
    private String maNv;

    public HoaDon() {
    }

    public HoaDon(int maKh, String maNv) {
        this.maKh = maKh;
        this.maNv = maNv;
    }

    public HoaDon(Date ngayThanhToan, int maKh, String maNv) {
        this.ngayThanhToan = ngayThanhToan;
        this.maKh = maKh;
        this.maNv = maNv;
    }

    public HoaDon(Date ngayThue, Date ngayThanhToan, double tongTien, boolean trangThai, int maKh, String maNv) {
        this.ngayThue = ngayThue;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.maKh = maKh;
        this.maNv = maNv;
    }

    public HoaDon(int ma, Date ngayThue, Date ngayThanhToan, double tongTien, boolean trangThai, int maKh, String maNv) {
        this.ma = ma;
        this.ngayThue = ngayThue;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
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

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
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
