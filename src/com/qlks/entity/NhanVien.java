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
public class NhanVien {
    private String ma;
    private String ten;
    private String pass;
    private Date ns;
    private boolean gt;
    private String diaChi;
    private String sdt;
    private String email;
    private String anh;
    private String maBoPhan;
    private boolean isActive;
    private Date createAt;
    private Date updateAt;

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String pass, Date ns, boolean gt, String diaChi, String sdt, String email, String anh, String maBoPhan) {
        this.ma = ma;
        this.ten = ten;
        this.pass = pass;
        this.ns = ns;
        this.gt = gt;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.anh = anh;
        this.maBoPhan = maBoPhan;
    }

    public NhanVien(String ma, String ten, String pass, Date ns, boolean gt, String diaChi, String sdt, String email, String anh, String maBoPhan, boolean isActive, Date createAt, Date updateAt) {
        this.ma = ma;
        this.ten = ten;
        this.pass = pass;
        this.ns = ns;
        this.gt = gt;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.anh = anh;
        this.maBoPhan = maBoPhan;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getNs() {
        return ns;
    }

    public void setNs(Date ns) {
        this.ns = ns;
    }

    public boolean isGt() {
        return gt;
    }

    public void setGt(boolean gt) {
        this.gt = gt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
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


    
}
