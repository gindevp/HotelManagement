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

    private String maLP;
    private String tenLP;
    private String moTa;
    private boolean isActive;
    private Date createAt;
    private Date updateAt;

    public LoaiPhong() {

    }

    public LoaiPhong(String maLP, String tenLP, String moTa) {
        this.maLP = maLP;
        this.tenLP = tenLP;
        this.moTa = moTa;
    }

    public LoaiPhong(String maLP, String tenLP, String moTa, boolean isActive, Date createAt, Date updateAt) {
        this.maLP = maLP;
        this.tenLP = tenLP;
        this.moTa = moTa;
        this.isActive = isActive;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getMaLP() {
        return maLP;
    }

    public String getTenLP() {
        return tenLP;
    }

    public String getMoTa() {
        return moTa;
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

    public void setMaLP(String maLP) {
        this.maLP = maLP;
    }

    public void setTenLP(String tenLP) {
        this.tenLP = tenLP;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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
        return tenLP;
    }

    @Override
    public boolean equals(Object obj) {
        LoaiPhong lp = (LoaiPhong) obj;
        return lp.getMaLP().equals(maLP);
    }

}
