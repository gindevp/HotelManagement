/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.HoaDon;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markhyun
 */
public class PDFExportDAO extends ManageDAO<HoaDon, Integer> {

    String selectHDPhongSql = "select b.mahd, b.sophong, a.malg, c.malp, dongia from hoadon a \n"
            + "join hdphong b on b.MAHD = a.MAHD \n"
            + "join phong c on c.SOPHONG = b.SOPHONG\n"
            + "join LOAIPHONG_LOAIGIA d on d.MALP = c.MALP and d.MALG = a.MALG\n"
            + "where b.MAHD = ?";

    public List<String> selectDonGiaPhong(Integer key) {
        List<String> list = selectColumnPhong(selectHDPhongSql, "dongia", key);
        return list;
    }

    public List<String> selectMaLG(Integer key) {
        List<String> list = selectColumnPhong(selectHDPhongSql, "malg", key);
        return list;
    }

    public List<String> selectMaLP(Integer key) {
        List<String> list = selectColumnPhong(selectHDPhongSql, "malp", key);
        return list;
    }

    public List<String> selectPhong(Integer key) {
        List<String> list = selectColumnPhong(selectHDPhongSql, "sophong", key);
        return list;
    }

    protected List<String> selectColumnPhong(String sql, String column, Object... args) {
        List<String> list = new ArrayList<String>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                String item = rs.getString(column);
                list.add(item);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public boolean insert(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDon> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HoaDon selectByID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
