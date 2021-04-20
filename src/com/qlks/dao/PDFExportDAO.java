/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markhyun
 */
public class PDFExportDAO {

    String selectHDByIDSql = "select * from hoadon where maHD = ?";

    String selectHDPhongSql = "select b.mahd, b.sophong, a.malg, e.tenlg, c.malp, dongia "
            + "from hoadon a join hdphong b on b.MAHD = a.MAHD "
            + "join phong c on c.SOPHONG = b.SOPHONG "
            + "join LOAIPHONG_LOAIGIA d on d.MALP = c.MALP and d.MALG = a.MALG "
            + "join loaigia e on e.MALG = a.MALG "
            + "where b.MAHD = ?";

    String selectHDDVSql = "select c.mahd, c.madv, tendv, soluong, d.dongia, d.dongia*soluong as tong from hoadon a \n"
            + "join HDDICHVU c on c.MAHD = a.MAHD\n"
            + "join dichvu d on d.MADV = c.MADV\n"
            + "where c.MAHD = ?";

    public List<String> selectTongTienHD(Integer key) {
        List<String> list = selectColumn(selectHDByIDSql, "tongtien", key);
        return list;
    }

    public List<String> selectTongTien(Integer key) {
        List<String> list = selectColumn(selectHDDVSql, "tong", key);
        return list;
    }

    public List<String> selectDGDV(Integer key) {
        List<String> list = selectColumn(selectHDDVSql, "dongia", key);
        return list;
    }

    public List<String> selectSoLuong(Integer key) {
        List<String> list = selectColumn(selectHDDVSql, "soluong", key);
        return list;
    }

    public List<String> selectTenDV(Integer key) {
        List<String> list = selectColumn(selectHDDVSql, "tenDV", key);
        return list;
    }

    public List<String> selectDonGiaPhong(Integer key) {
        List<String> list = selectColumn(selectHDPhongSql, "dongia", key);
        return list;
    }

    public List<String> selectTenLG(Integer key) {
        List<String> list = selectColumn(selectHDPhongSql, "tenlg", key);
        return list;
    }

    public List<String> selectMaLP(Integer key) {
        List<String> list = selectColumn(selectHDPhongSql, "malp", key);
        return list;
    }

    public List<String> selectPhong(Integer key) {
        List<String> list = selectColumn(selectHDPhongSql, "sophong", key);
        return list;
    }

    protected List<String> selectColumn(String sql, String column, Object... args) {
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
}
