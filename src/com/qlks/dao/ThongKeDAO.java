/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hungn
 */
public class ThongKeDAO {

    private String sp_topphong = "{call sp_topphong(?, ?)}";
    private String sp_topdv = "{call sp_topdv(?, ?)}";
    private String sp_hoadon = " {call sp_hoadon}";
    private String sp_hoadon1 = "{call sp_hoadon1(?, ?)}";
    private String sp_ssdt = "{call sp_sosanhdoanhthu(?)}";

    public List<Object[]> getDoanhThu(Integer year) {
        String[] title = {"THANG", "DOANHTHU"};
        return getListOfArray(sp_ssdt, title, year);
    }

    public List<Object[]> getHoaDon() {
        String[] title = {"MAHD", "NGAYTHUE", "NGAYTT", "TONGTIEN", "TENLG", "TENKH", "TENNV"};
        return getListOfArray(sp_hoadon, title);
    }

    public List<Object[]> getHoaDon1(Date start, Date end) {
        String[] title = {"MAHD", "NGAYTHUE", "NGAYTT", "TONGTIEN", "TENLG", "TENKH", "TENNV"};
        return getListOfArray(sp_hoadon1, title, start, end);
    }

    public List<Object[]> getTopPhong(Integer year, Integer month) {
        String[] title = {"SOPHONG", "DOANHTHU"};
        return getListOfArray(sp_topphong, title, year, month);
    }

    public List<Object[]> getTopDv(Integer year, Integer month) {
        String[] title = {"TENDICHVU", "DOANHTHU"};
        return getListOfArray(sp_topdv, title, year, month);
    }

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        List<Object[]> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = (Object) rs.getObject(i + 1);
                }
                list.add(vals);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
