/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.DichVu;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markhyun
 */
public class DichVuDAO extends ManageDAO<DichVu, Integer> {

    private String insertSql = "insert dichvu values (?, ?, ?, ?)";
    private String updateSql = "update dichvu set tendv = ?, dongia = ?, mota = ?, trangthai = ? where madv = ?";
    private String deleteSql = "delete from dichvu where madv = ?";
    private String selectAllSql = "select * from dichvu";
    private String selectEnableSql = "select * from dichvu where trangthai = 1";
    private String selectByIdSql = "select * from dichvu where madv = ?";

    @Override
    public boolean insert(DichVu entity) {
        return XJdbc.update(insertSql, entity.getTen(), entity.getGia(), entity.getMoTa(), entity.isTrangThai());
    }

    @Override
    public boolean update(DichVu entity) {
        return XJdbc.update(updateSql, entity.getTen(), entity.getGia(), entity.getMoTa(), entity.isTrangThai(), entity.getMa());
    }

    @Override
    public boolean delete(Integer key) {
        return XJdbc.update(deleteSql, key);
    }

    @Override
    public List<DichVu> selectAll() {
        return selectBySql(selectAllSql);
    }

    public List<DichVu> selectEnable() {
        return selectBySql(selectEnableSql);
    }

    @Override
    public DichVu selectByID(Integer key) {
        List<DichVu> list = selectBySql(selectByIdSql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<DichVu> selectBySql(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                DichVu dv = new DichVu(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getBoolean(5));
                list.add(dv);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
