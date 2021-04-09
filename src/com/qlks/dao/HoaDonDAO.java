/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.HoaDon;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hungn
 */
public class HoaDonDAO extends ManageDAO<HoaDon, Integer> {

    private String insertSql = "insert hoadon values (getdate(), ?, 0, default, ?, ?, ?)";
    private String updateSql = "update hoadon set ngaytt = ?, trangthai = 1 where mahd = ?";
    private String deleteSql;
    private String selectAll = "select * from hoadon";
    private String selectById = "select * from hoadon where mahd = ?";
    private String selectByKhAndNvSql = "select top 1 * from hoadon where makh = ? and manv = ? order by ngaythue desc";
    private String selectBySttSql = "select * from hoadon where trangthai = 0";

    @Override
    public boolean insert(HoaDon entity) {
        return XJdbc.update(insertSql, entity.getNgayThanhToan(), entity.getMaLg(), entity.getMaKh(), entity.getMaNv());
    }

    @Override
    public boolean update(HoaDon entity) {
        return XJdbc.update(updateSql, entity.getNgayThanhToan(), entity.getMa());
    }

    @Override
    public boolean delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDon> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<HoaDon> selectByStt() {
        return selectBySql(selectBySttSql);
    }

    @Override
    public HoaDon selectByID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public HoaDon selectByKhAndNv(Integer maKH, String maNv) {
        List<HoaDon> list = selectBySql(selectByKhAndNvSql, maKH, maNv);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                HoaDon hd = new HoaDon(
                        rs.getInt(1),
                        rs.getTimestamp(2),
                        rs.getTimestamp(3),
                        rs.getDouble(4),
                        rs.getBoolean(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8)
                );
                list.add(hd);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
