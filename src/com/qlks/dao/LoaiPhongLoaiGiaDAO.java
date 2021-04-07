/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.LoaiGia;
import com.qlks.entity.LoaiPhongLoaiGia;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungn
 */
public class LoaiPhongLoaiGiaDAO extends ManageDAO<LoaiPhongLoaiGia, Integer> {

    private String insertSql = "insert loaiphong_loaigia values (?, ?, ?)";
    private String updateSql = "update loaiphong_loaigia set dongia = ? where id = ?";
    private String deleteSql = "delete from loaiphong_loaigia where id = ?";
    private String selectByIdSql = "select * from loaiphong_loaigia where id = ?";

    private String selectByLpAndMaGiaSql = "select * from loaiphong_loaigia where malp = ? and malg = ?";
    private String selectTenGiaByMaLpSql = "select tenlg from loaigia\n"
            + "  join loaiphong_loaigia on loaigia.MAlg = loaiphong_loaigia.malg\n"
            + "  where MALP = ?";

    private String selectByMalgSql = "select * from loaiphong_loaigia where malg = ?";

    @Override

    public boolean insert(LoaiPhongLoaiGia entity) {
        return XJdbc.update(insertSql, entity.getMaLp(), entity.getMaLg(), entity.getDonGia());
    }

    @Override
    public boolean update(LoaiPhongLoaiGia entity) {
        return XJdbc.update(updateSql, entity.getDonGia(), entity.getId());
    }

    @Override
    public boolean delete(Integer key) {
        return XJdbc.update(deleteSql, key);
    }

    @Override
    public List<LoaiPhongLoaiGia> selectAll() {
        return selectBySql(selectByIdSql);//sai
    }

    public List<LoaiPhongLoaiGia> selectByMalg(Integer maGia) {
        return selectBySql(selectByMalgSql, maGia);
    }

    @Override
    public LoaiPhongLoaiGia selectByID(Integer key) {
        List<LoaiPhongLoaiGia> list = selectBySql(selectByIdSql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    public LoaiPhongLoaiGia selectByLpAndMaGia(String maLp, Integer maGia) {
        List<LoaiPhongLoaiGia> list = selectBySql(selectByLpAndMaGiaSql, maLp, maGia);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<String> selectTenGiaByMaLpSql(String maLp) {
        return selectColumn(selectTenGiaByMaLpSql, maLp);
    }

    private List<String> selectColumn(String sql, Object... args) {
        List<String> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                String value = rs.getString(1);
                list.add(value);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    protected List<LoaiPhongLoaiGia> selectBySql(String sql, Object... args) {
        List<LoaiPhongLoaiGia> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                LoaiPhongLoaiGia lpg = new LoaiPhongLoaiGia(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4)
                );
                list.add(lpg);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
