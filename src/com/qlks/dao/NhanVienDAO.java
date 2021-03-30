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

    String insert = "insert Nhanvien values (?, ?, ?, ?, ?, ?, ?, ?, default, ?, default, default, default)";
    String selectById = "select * from nhanvien where manv = ?";
    String updatePassForgot = "update nhanvien set password = (select top 1 code from maxacnhan where "
            + "maxacnhan.manv = nhanvien.manv order by createat desc), updateat = default where manv = ?";
    String selectByEmailSql = "select * from nhanvien where manv = ? and email = ?";
    @Override
    public boolean insert(NhanVien entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(NhanVien entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean updateForgotPass(String ma) {
        return XJdbc.update(updatePassForgot, ma);
    }

    @Override
    public boolean delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NhanVien> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
