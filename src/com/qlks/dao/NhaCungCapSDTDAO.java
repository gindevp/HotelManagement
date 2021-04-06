/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.NhaCungCapSDT;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markhyun
 */
public class NhaCungCapSDTDAO extends ManageDAO<NhaCungCapSDT, Integer> {

    private String insertSql = "insert ncc_sdt values (?, ?)";
    private String updateSql = "update ncc_sdt set mancc = ?, sdt = ? where id = ?";
    private String deleteSql = "delete from ncc_sdt where id = ?";
    private String selectAllSql = "select * from ncc_sdt";
    private String selectByNccSql = "select * from ncc_sdt where mancc = ?";
    private String selectById = "select * from ncc_sdt where id = ?";

    public List<NhaCungCapSDT> selectByNcc(Integer key) {
        List<NhaCungCapSDT> list = selectBySql(selectByNccSql, key);
        return list;
    }

    @Override
    public boolean insert(NhaCungCapSDT entity) {
        return XJdbc.update(insertSql, entity.getMancc(), entity.getSdt());
    }

    @Override
    public boolean update(NhaCungCapSDT entity) {
        return XJdbc.update(updateSql, entity.getMancc(), entity.getSdt(), entity.getId());        
    }

    @Override
    public boolean delete(Integer key) {
        return XJdbc.update(deleteSql, key);
    }

    @Override
    public List<NhaCungCapSDT> selectAll() {
        return selectBySql(selectAllSql);
    }

    @Override
    public NhaCungCapSDT selectByID(Integer key) {
        List<NhaCungCapSDT> list = selectBySql(selectById, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhaCungCapSDT> selectBySql(String sql, Object... args) {
        List<NhaCungCapSDT> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                NhaCungCapSDT nccSdt = new NhaCungCapSDT(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3));
                list.add(nccSdt);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
