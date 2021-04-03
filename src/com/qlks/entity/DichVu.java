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
public class DichVu {

    private int ma;
    private String ten;
    private double gia;
    private String moTa;
    private boolean trangThai;
    private boolean isActive;
    private Date createAt;
    private Date updateAt;

    public DichVu() {

    }

    public DichVu(int ma, String ten, double gia, String moTa, boolean trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public DichVu(int ma, String ten, double gia, String moTa, boolean trangThai, boolean isActive, Date createAt, Date updateAt) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.isActive = isActive;
        this.createAt = createAt;
        this.updateAt = updateAt;
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

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return this.ten;
    }

    
}
