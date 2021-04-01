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
public class Phong {

    private String soPhong;
    private int sucChua;
    private double donGia;
    private boolean trangThai;
    private String maLP;
    private boolean isActive;
    private Date createAt;
    private Date updateAt;

    public Phong() {

    }

    public Phong(String soPhong, int sucChua, double donGia, boolean trangThai, String maLP) {
        this.soPhong = soPhong;
        this.sucChua = sucChua;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.maLP = maLP;
    }

    public Phong(String soPhong, int sucChua, double donGia, boolean trangThai, String maLP, boolean isActive, Date createAt, Date updateAt) {
        this.soPhong = soPhong;
        this.sucChua = sucChua;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.maLP = maLP;
        this.isActive = isActive;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getSoPhong() {
        return soPhong;
    }

    public int getSucChua() {
        return sucChua;
    }

    public double getDonGia() {
        return donGia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public String getMaLP() {
        return maLP;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public void setMaLP(String maLP) {
        this.maLP = maLP;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Phong{" + "soPhong=" + soPhong + ", sucChua=" + sucChua + ", donGia=" + donGia + ", trangThai=" + trangThai + ", maLP=" + maLP + ", isActive=" + isActive + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }
    
    

}
