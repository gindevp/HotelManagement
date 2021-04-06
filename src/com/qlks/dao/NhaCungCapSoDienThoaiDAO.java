/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.NhaCungCapSoDienThoai;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markhyun
 */
public class NhaCungCapSoDienThoaiDAO extends ManageDAO<NhaCungCapSoDienThoai, Integer> {

    String selectAllSdtSql = "select sdt from ncc_sdt where mancc = ?";

    public List<NhaCungCapSoDienThoai> selectAllSdt(Integer key) {
        List<NhaCungCapSoDienThoai> list = selectBySql(selectAllSdtSql, key);
        return list;
    }

    @Override
    public boolean insert(NhaCungCapSoDienThoai entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(NhaCungCapSoDienThoai entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NhaCungCapSoDienThoai> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NhaCungCapSoDienThoai selectByID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<NhaCungCapSoDienThoai> selectBySql(String sql, Object... args) {
        List<NhaCungCapSoDienThoai> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                NhaCungCapSoDienThoai nccSdt = new NhaCungCapSoDienThoai(
                        rs.getString(3));
                list.add(nccSdt);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
