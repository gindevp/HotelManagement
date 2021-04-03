/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.util;

import com.qlks.dao.KhachHangDAO;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author hungn
 */
public class Validator {

    KhachHangDAO khdao = new KhachHangDAO();
    
    public static boolean checkBlack(JTextComponent... args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].getText().trim().isEmpty()) {
                MsgBox.alert(null, "Không được để trống!");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkSelectedBgr(ButtonGroup b, String s) {
        if (b.getSelection() == null) {
            MsgBox.alert(null, "Chưa chọn " + s);
            return false;
        }
        return b.getSelection() != null;
    }

    public static boolean checkSimiliar(JTextField t1, JTextField t2) {
        if (!t1.getText().trim().equalsIgnoreCase(t2.getText().trim())) {
            MsgBox.alert(t2, "Mật khẩu không trùng khớp!");
            t2.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean checkPosNum(JTextComponent... args) {
        for (int i = 0; i < args.length; i++) {
            try {
                if (Double.parseDouble(args[i].getText().trim()) < 0) {
                    MsgBox.alert(null, "Giá trị phải lớn hơn 0!");
                    args[i].requestFocus();
                    return false;
                }
            } catch (Exception e) {
                MsgBox.alert(null, "Giá trị không hợp lệ!");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkSelectedDate(JDateChooser... args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].getDate() == null) {
                MsgBox.alert(null, "Vui lòng chọn thời gian!");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkSelectedDob(JDateChooser... args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].getDate() == null) {
                MsgBox.alert(null, "Vui lòng chọn thời gian!");
                args[i].requestFocus();
                return false;
            } else if (new Date().getYear() - args[i].getDate().getYear() < 18
                    || new Date().getYear() - args[i].getDate().getYear() > 65) {
                MsgBox.alert(null, "Tuổi không hợp lệ (Phải từ 18-65)");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkEmail(JTextComponent... args) {
        String reg = "^[a-zA-Z][\\w-]+@fpt.edu.vn$";
        for (int i = 0; i < args.length; i++) {
            if (!args[i].getText().trim().matches(reg)) {
                MsgBox.alert(null, "Email không hợp lệ!");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkEmail(String... args) {
        String reg = "^[a-zA-Z][\\w-]+@fpt.edu.vn$";
        for (int i = 0; i < args.length; i++) {
            if (!args[i].trim().matches(reg)) {
                MsgBox.alert(null, "Email không hợp lệ!");
                return false;
            }
        }
        return true;
    }

    public static boolean checkPhoneNum(JTextComponent... args) {
        String reg = "^0\\d{9}";
        for (int i = 0; i < args.length; i++) {
            if (!args[i].getText().trim().matches(reg)) {
                MsgBox.alert(null, "SDT không hợp lệ!");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkiDentityCard(JTextComponent... args) {
        String reg9 = "\\d{9}";
        String reg12 = "\\d{12}";
        for (int i = 0; i < args.length; i++) {
            if (args[i].getText().trim().matches(reg9)
                    || args[i].getText().trim().matches(reg12)) {
                return true;
            } else {
                MsgBox.alert(null, "Số chứng minh nhân dân không hợp lệ!");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkAfterNow(JDateChooser d1, Date d2, int task) {
        if (d1.getDate().before(d2)) {
            if (task == 1) {
                MsgBox.alert(null, "Vui lòng chọn ngày khai giảng sau ngày tạo!");
            }
            d1.requestFocus();
            return false;
        } else {
            if (task != 1) {
                MsgBox.alert(null, "Vui lòng chọn ngày sinh phù hợp!");
                d1.requestFocus();
            }
            return true;
        }
    }

    public static boolean checkMark(String s) {
        try {
            if (!s.equalsIgnoreCase("0.0")) {
                double mark = Double.parseDouble(s);
                if (mark < 0 || mark > 10) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
