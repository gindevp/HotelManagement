/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.HDDichVu;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungn
 */
public class HDDichVuDAO extends ManageDAO<HDDichVu, Integer> {

    private String insertSql = "insert hddichvu values (?, ?, ?)";
    private String updateSql;
    private String deleteSql = "delete from hddichvu where id = ?";
    private String selectAllSql = "select * from hddichvu";
    private String selectByIdSql = "select * from hddichvu where id = ?";
    private String selectByMaHdSql = "select * from hddichvu where mahd = ?";
    private String selectDgByHdSql = "select DONGIA from hoadon a\n"
            + "join HDDICHVU b on a.MAHD = b.MAHD\n"
            + "join DICHVU c on b.MADV = c.MADV\n"
            + "where a.MAHD = ?";
    private String deleteByHdSql = "{call sp_xoahddv(?)}";
    @Override

    public boolean insert(HDDichVu entity) {
        return XJdbc.update(insertSql, entity.getMaHd(), entity.getMaDv(), entity.getSoLuong());
    }

    @Override
    public boolean update(HDDichVu entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer key) {
        return XJdbc.update(deleteSql, key);
    }

    @Override
    public List<HDDichVu> selectAll() {
        return selectBySql(selectAllSql);
    }

    @Override
    public HDDichVu selectByID(Integer key) {
        List<HDDichVu> list = selectBySql(selectByIdSql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<HDDichVu> selectByMaHd(Integer key) {
        return selectBySql(selectByMaHdSql, key);
    }

    public boolean deleteByHd(Integer maHd) {
        return XJdbc.update(deleteByHdSql, maHd);
    }
    
    public List<Object> selectDgByHd(Integer maHd) {
        return XJdbc.column(selectDgByHdSql, maHd);
    }

    @Override
    protected List<HDDichVu> selectBySql(String sql, Object... args) {
        List<HDDichVu> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                HDDichVu hddv = new HDDichVu(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
                list.add(hddv);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
