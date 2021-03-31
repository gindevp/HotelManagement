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
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps;
        if (sql.trim().startsWith("{")) {
            ps = con.prepareCall(sql);
        } else {
            ps = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        return ps;
    }

    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement ps = getStmt(sql, args);
        return ps.executeQuery();
    }

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
    
    public static boolean update(String sql, Object...args) {
        try (PreparedStatement ps = getStmt(sql, args)){
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    

}
