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
public class LoaiPhong {

    private String ma;
    private String ten;
    private String moTa;
    private boolean isActive;
    private Date createAt;
    private Date updateAt;

    public LoaiPhong() {

    }

    public LoaiPhong(String ma, String ten, String moTa) {
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
    }

    public LoaiPhong(String ma, String ten, String moTa, boolean isActive, Date createAt, Date updateAt) {
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
        this.isActive = isActive;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    @Override
    public boolean equals(Object obj) {
        LoaiPhong lp = (LoaiPhong) obj;
        return lp.getMa().equals(this.ma);
    }

}
