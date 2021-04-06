/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.Phong;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markhyun
 */
public class PhongDAO extends ManageDAO<Phong, String> {

    private String insertSql = "insert phong values (?, ?, ?, default, ?)";
    private String updateSql = "update phong set sucChua = ?, donGia = ?, trangThai = ?, malp = ? where soPhong = ?";
    private String deleteSql = "delete phong where soPhong = ?";
    private String selectAllSql = "select * from phong";
    private String selectbByLoaiPhongSql = "select * from phong where malp = ?";
    private String selectByIdSql = "select * from phong where soPhong = ?";

    @Override
    public boolean insert(Phong entity) {
        return XJdbc.update(insertSql, entity.getSoPhong(), entity.getSucChua(), entity.getDonGia(), entity.getMaLP());
    }

    @Override
    public boolean update(Phong entity) {
        return XJdbc.update(updateSql, entity.getSucChua(), entity.getDonGia(), entity.isTrangThai(), entity.getMaLP(), entity.getSoPhong());
    }

    @Override
    public boolean delete(String key) {
        return XJdbc.update(deleteSql, key);
    }

    @Override
    public List<Phong> selectAll() {
        return selectBySql(selectAllSql);
    }

    public List<Phong> selectByLoaiPhong(String id) {
        return selectBySql(selectbByLoaiPhongSql, id);
    }

    @Override
    public Phong selectByID(String key) {
        List<Phong> list = selectBySql(selectByIdSql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Phong> selectBySql(String sql, Object... args) {
        List<Phong> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                Phong phong = new Phong(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getBoolean(4),
                        rs.getString(5));
                list.add(phong);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
