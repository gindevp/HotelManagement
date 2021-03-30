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
public class MaXacNhan {
    private int id;
    private String code, maNv;
    private Date createAt; 
    
    public MaXacNhan() {
    }

    public MaXacNhan(String code, String maNv) {
        this.code = code;
        this.maNv = maNv;
    }

    public MaXacNhan(int id, String code, String maNv, Date createAt) {
        this.id = id;
        this.code = code;
        this.maNv = maNv;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }


    

}
