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

    private String selectHDByIDSql = "select * from hoadon where maHD = ?";

    private String selectTongGioThueSql = "select tongGioThue = DATEDIFF(HOUR, ngaythue, ngaytt) from hoadon where MAHD = ?";
    private String selectTongNgayThueSql = "tongNgayThue = DATEDIFF(day, ngaythue, ngaytt) from hoadon where MAHD = ?";
    private String selectTenLPSql = "select d.tenlp \n"
            + "from hoadon a join hdphong b on b.MAHD = a.MAHD \n"
            + "join phong c on c.SOPHONG = b.SOPHONG \n"
            + "join loaiphong d on d.malp = c.malp\n"
            + "where b.MAHD = ?";

    private String selectGioTre_QuaDemSql = "select giotre_quadem = DATEPART(hour, ngaytt) from hoadon where MAHD = ?";

    private String selectHDPhongSql = "select b.mahd, b.sophong, a.malg, e.tenlg, c.malp, dongia "
            + "from hoadon a join hdphong b on b.MAHD = a.MAHD "
            + "join phong c on c.SOPHONG = b.SOPHONG "
            + "join LOAIPHONG_LOAIGIA d on d.MALP = c.MALP and d.MALG = a.MALG "
            + "join loaigia e on e.MALG = a.MALG "
            + "where b.MAHD = ?";

    private String selectHDDVSql = "select c.mahd, c.madv, tendv, soluong, d.dongia, d.dongia*soluong as tong from hoadon a \n"
            + "join HDDICHVU c on c.MAHD = a.MAHD\n"
            + "join dichvu d on d.MADV = c.MADV\n"
            + "where c.MAHD = ?";

    public Integer selectMaLG(Integer key) {
        return selectColumInt(selectHDPhongSql, "malg", key);
    }

    public Integer selecHour3(Integer key) {
        return selectColumInt(selectTongNgayThueSql, "tongngaythue", key);

    }

    public Integer selecHour2(Integer key) {
        return selectColumInt(selectGioTre_QuaDemSql, "giotre_quadem", key);

    }

    public Integer selectHour(Integer key) {
        return selectColumInt(selectTongGioThueSql, "tonggiothue", key);
    }

    public List<Double> selectTongTienHD(Integer key) {
        List<Double> list = selectNumValue(selectHDByIDSql, "tongtien", key);
        return list;
    }

    public List<Double> selectTongTienDV(Integer key) {
        List<Double> list = selectNumValue(selectHDDVSql, "tong", key);
        return list;
    }

    public List<Double> selectDGDV(Integer key) {
        List<Double> list = selectNumValue(selectHDDVSql, "dongia", key);
        return list;
    }

    public List<Integer> selectSoLuong(Integer key) {
        List<Integer> list = selectNumIntValue(selectHDDVSql, "soluong", key);
        return list;
    }

    public List<String> selectTenDV(Integer key) {
        List<String> list = selectColumn(selectHDDVSql, "tenDV", key);
        return list;
    }

    public List<Double> selectDonGiaPhong(Integer key) {
        List<Double> list = selectNumValue(selectHDPhongSql, "dongia", key);
        return list;
    }

    public List<String> selectTenLG(Integer key) {
        List<String> list = selectColumn(selectHDPhongSql, "tenlg", key);
        return list;
    }

    public List<String> selectTenLP(Integer key) {
        List<String> list = selectColumn(selectTenLPSql, "tenlp", key);
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

    protected List<Double> selectNumValue(String sql, String column, Object... args) {
        List<Double> list = new ArrayList<Double>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                double item = rs.getDouble(column);
                list.add(item);
            }
        } catch (Exception e) {
        }
        return list;
    }

    protected List<Integer> selectNumIntValue(String sql, String column, Object... args) {
        List<Integer> list = new ArrayList<Integer>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                int item = rs.getInt(column);
                list.add(item);
            }
        } catch (Exception e) {
        }
        return list;
    }

    protected Integer selectColumInt(String sql, String column, Object... args) {
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                return rs.getInt(column);
            }
        } catch (Exception e) {
        }
        return -1;
    }
}
