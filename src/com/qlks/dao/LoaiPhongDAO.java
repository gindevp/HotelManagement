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
    private String selectAll = "select * from loaiphong where isactive = 1";
    private String selectById = "select * from loaiPhong where maLP = ? and isactive = 1";
    private String selectByName = "select * from loaiPhong where tenlp = ? and isactive = 1";

    @Override
    public boolean insert(LoaiPhong entity) {
        return XJdbc.update(insertSql, entity.getMa(), entity.getTen(), entity.getMoTa());
    }

    @Override
    public boolean update(LoaiPhong entity) {
        return XJdbc.update(insertSql, entity.getMa(), entity.getTen(), entity.getMoTa(), entity.isIsActive(), entity.getCreateAt(), entity.getUpdateAt());
    }

    @Override
    public boolean delete(String key) {
        return XJdbc.update(deleteSql, key);

    }

    @Override
    public List<LoaiPhong> selectAll() {
        return selectBySql(selectAll);
    }

    public List<LoaiPhong> selectByName(String key) {
        return selectBySql(selectByName, key);
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
                LoaiPhong lp = new LoaiPhong();
                lp.setMa(rs.getString(1));
                lp.setTen(rs.getString(2));
                lp.setMoTa(rs.getString(3));
                lp.setIsActive(rs.getBoolean(4));
                lp.setCreateAt(rs.getDate(5));
                lp.setUpdateAt(rs.getDate(6));
                list.add(lp);
                ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
