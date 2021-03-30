/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hungn
 */
public class XDate {

    static SimpleDateFormat sdf = new SimpleDateFormat();

    public static Date toDate(String date, String pattern) {
        try {
            sdf.applyPattern(pattern);
            return sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(null, "Ngày tháng không hợp lệ");
            return null;
        }
    }

    public static String toString(Date date, String pattern) {
        try {
            sdf.applyPattern(pattern);
            return sdf.format(date);
        } catch (Exception e) {
//            MsgBox.alert(null, "Ngày tháng không hợp lệ");
            return "";
        }
    }

    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    public static Date now() {
        return new Date();
    }
}
