/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.util;

import com.qlks.entity.NhanVien;

/**
 *
 * @author hungn
 */
public class Auth {
//    quan ly thong tin dang nhap

    public static NhanVien user = null;

    public static void clean() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }

    //quan ly
    public static boolean isManager() {
        return Auth.isLogin() && Auth.user.getMaBoPhan().equalsIgnoreCase("QL");
    }

    //ke toan
    public static boolean isAccountant() {
        return Auth.isLogin() && Auth.user.getMaBoPhan().equalsIgnoreCase("KT");
    }
    
    //le tan
    public static boolean isReceptionist() {
        return Auth.isLogin() && Auth.user.getMaBoPhan().equalsIgnoreCase("LT");        
    }
    
    public static boolean isRoomStaff() {
        return Auth.isLogin() && Auth.user.getMaBoPhan().equalsIgnoreCase("PB");        
    }
    

}
