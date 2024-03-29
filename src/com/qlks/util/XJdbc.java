/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hungn
 */
public class XJdbc {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost;database=qlks";
    static String user = "sa";
    static String pass = "123456";

    static {
        try {
            // Nạp driver
            Class.forName(driver);          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Trả về câu lệnh SQL hoàn chỉnh
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        // Tạo connection 
        Connection con = DriverManager.getConnection(url, user, pass); 
        // Tạo pstmt và thực hiện call hoặc stmt
        PreparedStatement ps;
        if (sql.trim().startsWith("{")) {
            ps = con.prepareCall(sql);
        } else {
            ps = con.prepareStatement(sql);
        }
        // Thực hiện gán tham số cho sql
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        return ps;  // Trả về câu lệnh SQL hoàn chỉnh
    }

    // Trả về kết quả sau khi querry
    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement ps = getStmt(sql, args);
        return ps.executeQuery();
    }

    // Trả về kết quả 1 record
    public static Object value(String sql, Object... args) {        
        try (ResultSet rs = XJdbc.query(sql, args);) {
            if (rs.next()) {
                return rs.getObject(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Trả về kết quả sau khi querry
    public static boolean update(String sql, Object... args) {
        try (PreparedStatement ps = getStmt(sql, args)) {
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    // Trả về kết quả 1 cột 
    public static List<Object> column(String sql, Object... args) {
        List<Object> list = new ArrayList<>();
        try (ResultSet rs = XJdbc.query(sql, args);) {
            while (rs.next()) {
                Object obj = rs.getObject(1);
                list.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
