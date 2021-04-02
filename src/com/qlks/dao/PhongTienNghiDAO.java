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
    String updateSql = "update phong_tiennghi set soluong = ?, tinhtrang = ? where id = ?";
    String deleteSql = "delete from phong_tiennghi where id = ?";
    String selectBySoPhong = "select * from PHONG_TIENNGHI where SOPHONG = ?";
    String selectByIdSql = "select * from phong_tiennghi where id = ?";

    @Override
    public boolean insert(PhongTienNghi entity) {
        return XJdbc.update(insertSql, entity.getSoPhong(), entity.getMaTienNghi(), entity.getSoLuong(), entity.getTinhTrang());
    }

    @Override
    public boolean update(PhongTienNghi entity) {
        return XJdbc.update(updateSql, entity.getSoLuong(), entity.getTinhTrang(), entity.getId());
    }

    @Override
    public boolean delete(Integer key) {
        return XJdbc.update(deleteSql, key);
    }

    @Override
    public List<PhongTienNghi> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PhongTienNghi selectByID(Integer key) {
        List<PhongTienNghi> list = selectBySql(selectByIdSql, key);
        return list.size() > 0 ? list.get(0) : null;
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
