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
public class HDThanhToan {
    private int ma;
    private Date ngayLap;
    private Date ngayThanhToan;
    private double tongTien;
    private int maKh;
    private String maNv;

    public HDThanhToan() {
    }

    public HDThanhToan(Date ngayLap, Date ngayThanhToan, double tongTien, int maKh, String maNv) {
        this.ngayLap = ngayLap;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.maKh = maKh;
        this.maNv = maNv;
    }

    public HDThanhToan(int ma, Date ngayLap, Date ngayThanhToan, double tongTien, int maKh, String maNv) {
        this.ma = ma;
        this.ngayLap = ngayLap;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.maKh = maKh;
        this.maNv = maNv;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
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
