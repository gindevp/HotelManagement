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
public class BoPhanDAO extends ManageDAO<BoPhan, String>{

    private String insertSql = "insert bophan values (?, ?, default, default, default";
    private String updateSql = "update bophan set tenbp = ?, updateat = default where mabp = ?";
    private String deleteSql = "update bophan set isactive = 0, updateat = default where mabp = ?";
    private String selectAll = "select * from bophan where isactive = 1";
    private String selectById = "select * from bophan where mabp = ? and isactive = 1";
    
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
        return selectBySql(selectAll);
    }

    @Override
    public BoPhan selectByID(String key) {
        List<BoPhan> list = selectBySql(selectById, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<BoPhan> selectBySql(String sql, Object... args) {
        List<BoPhan> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);
                ){
            while (rs.next()) {
                BoPhan boPhan = new BoPhan(
                        rs.getString(1), 
                        rs.getString(2), 
                        rs.getBoolean(3), 
                        rs.getDate(4), 
                        rs.getDate(5)
                );
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
