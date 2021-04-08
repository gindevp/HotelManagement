/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.LoaiGia;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungn
 */
public class LoaiGiaDAO extends ManageDAO<LoaiGia, Integer> {

    private String selectAllSql = "select * from loaigia";
    private String selectByMaLpSql = "select a.MALG, a.TENLG from LOAIGIA a\n"
            + "join LOAIPHONG_LOAIGIA b on a.MALG = b.MALG\n"
            + "where MALP = ?";
    private String selectByNameSql = "select * from loaigia where tenlg  = ?";
    private String selectByIdSql = "select * from loaigia where malg = ?";

    @Override
    public boolean insert(LoaiGia entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(LoaiGia entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LoaiGia> selectAll() {
        return selectBySql(selectAllSql);
    }

    public List<LoaiGia> selectByMaLp(String maLp) {
        return selectBySql(selectByMaLpSql, maLp);
    }

    @Override
    public LoaiGia selectByID(Integer key) {
        List<LoaiGia> list = selectBySql(selectByIdSql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    public LoaiGia selectByName(String name) {
        List<LoaiGia> list = selectBySql(selectByNameSql, name);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<LoaiGia> selectBySql(String sql, Object... args) {
        List<LoaiGia> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                LoaiGia g = new LoaiGia(rs.getInt(1), rs.getString(2));
                list.add(g);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
