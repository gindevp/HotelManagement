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
    private String insertWithoutNgayTtSql = "insert hoadon values (getdate(), null, 0, default, ?, ?, ?)";
    private String updateSql = "update hoadon set ngaytt = getdate(), trangthai = 1, tongtien = ? where mahd = ?";
    private String updateWithoutNgayttSql = "update hoadon set tongtien = ?, trangthai = 1 where mahd = ?";
    private String deleteSql;
    private String selectAll = "select * from hoadon";
    private String selectById = "select * from hoadon where mahd = ?";
    private String selectByLgKhNvSql = "select top 1 * from hoadon where malg = ? and makh = ? and manv = ? order by ngaythue desc";
    
    private String selectDsThueSql = "select a.* from hoadon a join khachhang b "
            + "on a.makh = b.makh where trangthai = 0 and (b.tenkh like ? "
            + "or b.sdt like ? or b.cmnd like ?)";

    private String thanhtoanSql = "{call sp_thanhtoanhd(?,?)}";
    
    private String selectYearSql = "select distinct year(ngaytt) from hoadon";
    private String selectMonthByYearSql = "select distinct month(ngaytt) from hoadon where year(ngaytt) = ?";
    
    public List<Object> selectYear() {
        return XJdbc.column(selectYearSql);
    }
    
    public List<Object> selectMonthByYear(int year) {
        return XJdbc.column(selectMonthByYearSql, year);
    }
    
    @Override
    public boolean insert(HoaDon entity) {
        return XJdbc.update(insertSql, entity.getNgayThanhToan(), entity.getMaLg(), entity.getMaKh(), entity.getMaNv());
    }

    public boolean insertWithoutNgayTt(HoaDon entity) {
        return XJdbc.update(insertWithoutNgayTtSql, entity.getMaLg(), entity.getMaKh(), entity.getMaNv());
    }
    
    public boolean thanhToanHd(Integer maHd, Integer maLg) {
        return XJdbc.update(thanhtoanSql, maHd, maLg);
    }

    @Override
    public boolean update(HoaDon entity) {
        return XJdbc.update(updateSql, entity.getTongTien(), entity.getMa());
    }

    public boolean updateWithoutNgaytt(HoaDon entity) {
        return XJdbc.update(updateWithoutNgayttSql, entity.getTongTien(), entity.getMa());
    }

    @Override
    public boolean delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDon> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<HoaDon> selectDsThue(String keyword) {
        return selectBySql(selectDsThueSql, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
    }

    @Override
    public HoaDon selectByID(Integer key) {
        List<HoaDon> list = selectBySql(selectById, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    public HoaDon selectByLgKhNv(Integer maLg, Integer maKH, String maNv) {
        List<HoaDon> list = selectBySql(selectByLgKhNvSql, maLg, maKH, maNv);
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
