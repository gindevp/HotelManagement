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

    private String insertSql = "insert loaiPhong values (?, ?, ?)";
    private String updateSql = "update loaiPhong set tenLP = ?, moTa = ? where maLP = ?";
    private String deleteSql = "delete from loaiPhong where maLP = ?";
    private String selectAllSql = "select * from loaiphong";
    private String selectByIdSql = "select * from loaiPhong where maLP = ?";
    private String selectByNameSql = "select * from loaiPhong where tenlp = ?";
    private String selectByKeywordSql = "select * from loaiphong where tenlp like ?";

    @Override
    public boolean insert(LoaiPhong entity) {
        return XJdbc.update(insertSql, entity.getMa(), entity.getTen(), entity.getMoTa());
    }

    @Override
    public boolean update(LoaiPhong entity) {
        return XJdbc.update(updateSql, entity.getTen(), entity.getMoTa(), entity.getMa());
    }

    @Override
    public boolean delete(String key) {
        return XJdbc.update(deleteSql, key);
    }

    @Override
    public List<LoaiPhong> selectAll() {
        return selectBySql(selectAllSql);
    }

    public List<LoaiPhong> selectByName(String key) {
        return selectBySql(selectByNameSql, key);
    }

    @Override
    public LoaiPhong selectByID(String key) {
        List<LoaiPhong> list = selectBySql(selectByIdSql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<LoaiPhong> selectByKeyword(String key) {
        return selectBySql(selectByKeywordSql, "%" + key + "%");
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
                list.add(lp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
