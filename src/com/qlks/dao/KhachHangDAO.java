/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.KhachHang;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markhyun
 */
public class KhachHangDAO extends ManageDAO<KhachHang, Integer> {

    String insertSql = "insert khachhang values (?, ?, ?, ?, ?, ?)";
    String updateSql = "update khachhang set tenkh = ?, cmnd = ?, sdt = ?, gioitinh = ?, diachi = ?, quoctich = ? where makh = ?";
    String deleteSql = "delete from khachhang where makh = ?";
    String selectAllSql = "select * from khachhang";

    String selectByKeywordSql = "select * from khachhang where tenkh like ?";
    String selectByIdSql = "select * from khachhang where makh = ?";
    
    String selectCmndSql = "select cmnd from khachhang";
    String selectCmndSql1 = "select cmnd from khachhang where cmnd not like ?";

    String selectSdtSql = "select sdt from khachhang";
    String selectSdtSql1 = "select sdt from khachhang where sdt not like ?";

    @Override
    public boolean insert(KhachHang entity) {
        return XJdbc.update(insertSql, entity.getTen(), entity.getCmnd(), entity.getSdt(), entity.isGioiTinh(), entity.getDiaChi(), entity.getQuocTich());
    }

    @Override
    public boolean update(KhachHang entity) {
        return XJdbc.update(updateSql, entity.getTen(), entity.getCmnd(), entity.getSdt(), entity.isGioiTinh(), entity.getDiaChi(), entity.getQuocTich(), entity.getMa());
    }

    @Override
    public boolean delete(Integer key) {
        return XJdbc.update(deleteSql, key);
    }

    @Override
    public List<KhachHang> selectAll() {
        return selectBySql(selectAllSql);
    }

    public List<KhachHang> selectByKeyword(String key) {
        return selectBySql(selectByKeywordSql, "%" + key + "%");
    }

    @Override
    public KhachHang selectByID(Integer key) {
        List<KhachHang> list = selectBySql(selectByIdSql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<String> selectCmnd() {
        return selectColumn(selectCmndSql);
    }

    public List<String> selectCmnd1(String key) {
        return selectColumn(selectCmndSql1, key);
    }

    public List<String> selectSdt() {
        return selectColumn(selectSdtSql);
    }
    
    public List<String> selectSdt1(String key) {
        return selectColumn(selectSdtSql1, key);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                KhachHang kh = new KhachHang(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5),
                        rs.getString(6),
                        rs.getString(7));
                list.add(kh);
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
