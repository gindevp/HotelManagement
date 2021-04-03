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
public class BoPhan {

    private String ma;
    private String ten;
    private boolean isActive;
    private Date createAt;
    private Date updateAt;

    public BoPhan() {
    }

    public BoPhan(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public BoPhan(String ma, String ten, boolean isActive, Date createAt, Date updateAt) {
        this.ma = ma;
        this.ten = ten;
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
        return ten; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        BoPhan boPhan = (BoPhan) obj;
        return boPhan.getMa().equals(ma); //To change body of generated methods, choose Tools | Templates.
    }

}
