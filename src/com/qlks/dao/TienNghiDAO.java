/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.TienNghi;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungn
 */
public class TienNghiDAO extends ManageDAO<TienNghi, Integer> {

    String insertSql = "insert tiennghi values (?, default, default, default)";
    String updateSql = "update tiennghi set tentn = ?, updateAt = default where matn = ? and isactive = 1";
    String deleteSql = "update tiennghi set isactive = 0 where matn = ?";
    String selectAllSql = "select * from tiennghi where isactive = 1";
    String selectByIdSql = "select * from tiennghi where matn = ? and isactive = 1";
    String selectNameByIdSql = "select tentn from tiennghi where matn = ?";
    String selectBySPSql = "select * from tiennghi where sophong = ?";

    @Override
    public boolean insert(TienNghi entity) {
        return XJdbc.update(insertSql, entity.getTen());
    }

    @Override
    public boolean update(TienNghi entity) {
        return XJdbc.update(updateSql, entity.getTen(), entity.getMa());
    }

    @Override
    public boolean delete(Integer key) {
        return XJdbc.update(deleteSql, key);
    }

    @Override
    public List<TienNghi> selectAll() {
        return selectBySql(selectAllSql);
    }

    @Override
    public TienNghi selectByID(Integer key) {
        List<TienNghi> list = selectBySql(selectByIdSql, key);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<TienNghi> selectBySP(String sp) {
        return selectBySql(selectBySPSql, sp);
    }
    
    public String selectNameById(Integer id) {
        return (String) XJdbc.value(selectNameByIdSql, id);
    }

    @Override
    protected List<TienNghi> selectBySql(String sql, Object... args) {
        List<TienNghi> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                TienNghi tienNghi = new TienNghi(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getBoolean(3),
                        rs.getDate(4),
                        rs.getDate(5)
                );
                list.add(tienNghi);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
