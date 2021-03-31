/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.LoaiPhong;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author markhyun
 */
public class LoaiPhongDAO extends ManageDAO<LoaiPhong, String> {

    private String insertSql = "insert loaiPhong values (?, ?, ?, default, default, default";
    private String updateSql = "update loaiPhong set tenLP = ?, moTa = ?, updateat = default where maLP = ?";
    private String deleteSql = "update loaiPhong set isactive = 0, updateat = default where maLP = ?";
    private String selectAll = "select * from loaiPhong where isactive = 1";
    private String selectById = "select * from loaiPhong where maLP = ? and isactive = 1";

    @Override
    public boolean insert(LoaiPhong entity) {
        return XJdbc.update(insertSql, entity.getMaLP(), entity.getTenLP(), entity.getMoTa());
    }

    @Override
    public boolean update(LoaiPhong entity) {
        return XJdbc.update(insertSql, entity.getMaLP(), entity.getTenLP(), entity.getMoTa());
    }

    @Override
    public boolean delete(String key) {
        return XJdbc.update(deleteSql, key);

    }

    @Override
    public List<LoaiPhong> selectAll() {
        return selectBySql(selectAll);
    }

    @Override
    public LoaiPhong selectByID(String key) {
        List<LoaiPhong> list = selectBySql(selectById, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<LoaiPhong> selectBySql(String sql, Object... args) {
        List<LoaiPhong> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                LoaiPhong loaiPhong = new LoaiPhong(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getDate(5),
                        rs.getDate(6)
                );
            }
        } catch (Exception e) {
        }
        return list;
    }

}
