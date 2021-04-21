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

    private String insertSql = "insert Nhanvien values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String updateSql = "update nhanvien set tennv = ?, password = ?, ngaysinh = ?, gioitinh = ?, "
            + "diachi = ?, sdt = ?, email = ?, anh = ?, mabp = ? where manv = ?";
    private String deleteSql = "delete from nhanvien where manv = ?";
    private String selectAllSql = "select * from nhanvien";
    private String selectById = "select * from nhanvien where manv = ?";
    private String updatePassForgot = "update nhanvien set password = (select top 1 "
            + "code from maxacnhan where maxacnhan.manv = nhanvien.manv order "
            + "by createat desc) where manv = ?";
    private String selectByEmailSql = "select * from nhanvien where manv = ? and email = ?";
    private String selectByKeyword = "select * from nhanvien where (tennv like ? or email like ?)";

    private String selectEmailSql = "select email from nhanvien";
    private String selectEmailSql1 = "select email from nhanvien where email not like ?";

    private String selectSdtSql = "select sdt from nhanvien";
    private String selectSdtSql1 = "select sdt from nhanvien where sdt not like ?";

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
        List<NhanVien> list = selectBySql(selectByKeyword, "%" + key + "%", "%" + key + "%");
        return list;
    }

    public List<String> selectEmail() {
        return selectColumn(selectEmailSql);
    }

    public List<String> selectEmail1(String key) {
        return selectColumn(selectEmailSql1, key);
    }

    public List<String> selectSdt() {
        return selectColumn(selectSdtSql);
    }

    public List<String> selectSdt1(String key) {
        return selectColumn(selectSdtSql1, key);
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
                        rs.getString(10)
                );
                list.add(nhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
