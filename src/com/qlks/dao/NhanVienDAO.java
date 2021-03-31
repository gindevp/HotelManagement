/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.NhanVien;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungn
 */
public class NhanVienDAO extends ManageDAO<NhanVien, String> {

    String insertSql = "insert Nhanvien values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default, default, default)";
    String updateSql = "update nhanvien set tennv = ?, password = ?, ngaysinh = ?, gioitinh = ?, "
            + "diachi = ?, sdt = ?, email = ?, anh = ?, mabp = ?, updateat = default "
            + "where manv = ?";
    String deleteSql = "update nhanvien set isactive = 0 where manv = ?";
    String selectAllSql = "select * from nhanvien where isactive = 1";
    String selectById = "select * from nhanvien where manv = ?";
    String updatePassForgot = "update nhanvien set password = (select top 1 "
            + "code from maxacnhan where maxacnhan.manv = nhanvien.manv order "
            + "by createat desc), updateat = default where manv = ? and isactive = 1";
    String selectByEmailSql = "select * from nhanvien where manv = ? and email = ? and isactive = 1";
    String selectByKeyword = "select * from nhanvien where tennv like ? and isactive = 1";

    @Override
    public boolean insert(NhanVien entity) {
        return XJdbc.update(insertSql, entity.getMa(), entity.getTen(), entity.getPass(),
                entity.getNs(), entity.isGt(), entity.getDiaChi(), entity.getSdt(),
                entity.getEmail(), entity.getAnh(), entity.getMaBoPhan());
    }

    @Override
    public boolean update(NhanVien entity) {
        return XJdbc.update(updateSql, entity.getTen(), entity.getPass(),
                entity.getNs(), entity.isGt(), entity.getDiaChi(), entity.getSdt(),
                entity.getEmail(), entity.getAnh(), entity.getMaBoPhan(), entity.getMa());
    }

    public boolean updateForgotPass(String ma) {
        return XJdbc.update(updatePassForgot, ma);
    }

    @Override
    public boolean delete(String key) {
        return XJdbc.update(deleteSql, key);
    }

    @Override
    public List<NhanVien> selectAll() {
        List<NhanVien> list = selectBySql(selectAllSql);
        return list;
    }

    @Override
    public NhanVien selectByID(String key) {
        List<NhanVien> list = selectBySql(selectById, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    public NhanVien selectByEmail(String ma, String email) {
        List<NhanVien> list = selectBySql(selectByEmailSql, ma, email);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<NhanVien> selectByKeyword(String key) {
        List<NhanVien> list = selectBySql(selectByKeyword, "%" + key + "%");
        return list;
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getBoolean(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getBoolean(11),
                        rs.getDate(12),
                        rs.getDate(13)
                );
                list.add(nhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
