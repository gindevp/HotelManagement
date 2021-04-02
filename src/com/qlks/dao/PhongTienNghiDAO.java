/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.PhongTienNghi;
import com.qlks.entity.TienNghi;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungn
 */
public class PhongTienNghiDAO extends ManageDAO<PhongTienNghi, Integer> {

    String insertSql = "insert phong_tiennghi values (?, ?, ?, ?)";
    String updateSql = "update phong_tiennghi set soluong = ?, tinh trang = ? where id = ?";
    String selectBySoPhong = "select * from PHONG_TIENNGHI where SOPHONG = ?";
    String selectByIdSql = "select * from phong_tiennghi where id = ?";

    @Override
    public boolean insert(PhongTienNghi entity) {
        return XJdbc.update(insertSql, entity.getSoPhong(), entity.getMaTienNghi(), entity.getSoLuong(), entity.getTinhTrang());
    }

    @Override
    public boolean update(PhongTienNghi entity) {
        return XJdbc.update(insertSql, entity.getSoLuong(), entity.getTinhTrang(), entity.getId());
    }

    @Override
    public boolean delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PhongTienNghi> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PhongTienNghi selectByID(Integer key) {
        return (PhongTienNghi) XJdbc.value(selectByIdSql, key);
    }

    public List<PhongTienNghi> selectBySoPhong(String soPhong) {
        return selectBySql(selectBySoPhong, soPhong);
    }

    @Override
    protected List<PhongTienNghi> selectBySql(String sql, Object... args) {
        List<PhongTienNghi> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                PhongTienNghi PhongTienNghi = new PhongTienNghi(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5)
                );
                list.add(PhongTienNghi);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
