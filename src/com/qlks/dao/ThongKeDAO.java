/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungn
 */
public class ThongKeDAO {

    private String sp_topphong = "{call sp_topphong(?, ?)}";
    private String sp_topdv = "{call sp_topdv(?, ?)}";

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
