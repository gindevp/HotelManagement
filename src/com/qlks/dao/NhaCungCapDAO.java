/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.NhaCungCap;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markhyun
 */
public class NhaCungCapDAO extends ManageDAO<NhaCungCap, Integer> {

    String insertSql = "insert nhacungcap values(?, ?) ";
    String updateSql = "update nhacungcap set tenncc = ?, diachi = ? where and mancc = ?";
    String deleteSql = "delete nhacungcap where mancc = ?";
    String selectAllSql = "select * from nhacungcap";
    String selectByIdSql = "select * from nhacungcap where mancc = ?";

    @Override
    public boolean insert(NhaCungCap entity) {
        return XJdbc.update(insertSql, entity.getTen(), entity.getDiaChi());
    }

    @Override
    public boolean update(NhaCungCap entity) {
        return XJdbc.update(updateSql, entity.getTen(), entity.getDiaChi(), entity.getMa());
    }

    @Override
    public boolean delete(Integer key) {
        return XJdbc.update(deleteSql, key);
    }

    @Override
    public List<NhaCungCap> selectAll() {
        return selectBySql(selectAllSql);
    }

    @Override
    public NhaCungCap selectByID(Integer key) {
        List<NhaCungCap> list = selectBySql(selectByIdSql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhaCungCap> selectBySql(String sql, Object... args) {
        List<NhaCungCap> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                list.add(ncc);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
