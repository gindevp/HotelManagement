/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.entity.HDThanhToan;
import java.util.List;

/**
 *
 * @author hungn
 */
public class HDThanhToanDAO extends ManageDAO<HDThanhToan, Integer>{

    private String insertSql = "insert hdthanhtoan values (?, default, ?, ?, ?)";
    private String updateSql;
    private String deleteSql;
    private String selectAll = "select * from hdthanhtoan";
    private String selectById = "select * from hdthanhtoan where mahd = ?";
    
    @Override
    public boolean insert(HDThanhToan entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(HDThanhToan entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HDThanhToan> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HDThanhToan selectByID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<HDThanhToan> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
