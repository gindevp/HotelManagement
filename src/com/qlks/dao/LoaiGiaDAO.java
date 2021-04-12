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

    private String insertSql = "insert loaigia values (?)";
    private String updateSql = "update loaigia set tenlg = ? where malg = ?";
    private String deleteSql = "delete from loaigia where malg = ?";
    private String selectAllSql = "select * from loaigia";
    private String selectByMaLpSql = "select a.MALG, a.TENLG from LOAIGIA a\n"
            + "join LOAIPHONG_LOAIGIA b on a.MALG = b.MALG\n"
            + "where MALP = ?";
    private String selectByNameSql = "select * from loaigia where tenlg  = ?";
    private String selectByIdSql = "select * from loaigia where malg = ?";

    private String selectTenSql = "select tenlg from loaigia";
    private String selectTenNotLikeSql = "select tenlg from loaigia where tenlg not like ?";

    @Override
    public boolean insert(LoaiGia entity) {
        return XJdbc.update(insertSql, entity.getTen());
    }

    @Override
    public boolean update(LoaiGia entity) {
        return XJdbc.update(updateSql, entity.getTen(), entity.getMa());
    }

    @Override
    public boolean delete(Integer key) {
        return XJdbc.update(deleteSql, key);
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

    public List<String> selectTen() {
        return selectColumn(selectTenSql);
    }

    public List<String> selectTen(LoaiGia entity) {
        return selectColumn(selectTenNotLikeSql, entity.getTen());
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

    public List<String> selectColumn(String sql, Object... args) {
        List<String> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                String item = rs.getString(1);
                list.add(item);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
