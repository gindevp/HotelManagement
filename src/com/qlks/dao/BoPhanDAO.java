/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.BoPhan;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungn
 */
public class BoPhanDAO extends ManageDAO<BoPhan, String> {

    String insertSql = "insert bophan values (?, ?)";
    String updateSql = "update bophan set tenbp = ? where mabp = ?";
    String deleteSql = "delete from bophan where mabp = ?";
    String selectAllSql = "select * from bophan";
    String selectByIdSql = "select * from bophan where mabp = ?";
    String selectNameByIdSql = "select tenbp from bophan where mabp = ?";
    String selectByKeywordSql = "select * from bophan where tenbp like ?";

    @Override
    public boolean insert(BoPhan entity) {
        return XJdbc.update(insertSql, entity.getMa(), entity.getTen());
    }

    @Override
    public boolean update(BoPhan entity) {
        return XJdbc.update(updateSql, entity.getTen(), entity.getMa());
    }

    @Override
    public boolean delete(String key) {
        return XJdbc.update(deleteSql, key);
    }

    @Override
    public List<BoPhan> selectAll() {
        return selectBySql(selectAllSql);
    }

    @Override
    public BoPhan selectByID(String key) {
        List<BoPhan> list = selectBySql(selectByIdSql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    public String selectNameById(String id) {
        return (String) XJdbc.value(selectNameByIdSql, id);
    }

    public List<BoPhan> selectByKeyword(String key) {
        return selectBySql(selectByKeywordSql, "%" + key + "%");
    }

    @Override
    protected List<BoPhan> selectBySql(String sql, Object... args) {
        List<BoPhan> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                BoPhan boPhan = new BoPhan(
                        rs.getString(1),
                        rs.getString(2)
                );
                list.add(boPhan);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
