/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.MaXacNhan;
import com.qlks.util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungn
 */
public class MaXacNhanDAO extends ManageDAO<MaXacNhan, Integer>{
    
    String insertSql = "insert maxacnhan values (?, ?, default)";
    
    String selectAllSql = "select * from maxacnhan";

    @Override
    public boolean insert(MaXacNhan entity) {
        return XJdbc.update(insertSql, entity.getCode(), entity.getMaNv());
    }

    @Override
    public boolean update(MaXacNhan entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MaXacNhan> selectAll() {
        return selectBySql(selectAllSql);
    }

    @Override
    public MaXacNhan selectByID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<MaXacNhan> selectBySql(String sql, Object... args) {
        List<MaXacNhan> list = new ArrayList<>();
        try (
                ResultSet rs = XJdbc.query(sql, args);
                ){
            while (rs.next()) {
                MaXacNhan mxn = new MaXacNhan(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3),
                        rs.getDate(4)
                );
                list.add(mxn);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
