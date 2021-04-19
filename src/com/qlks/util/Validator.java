/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.util;

import com.qlks.dao.KhachHangDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author hungn
 */
public class Validator {

    KhachHangDAO khdao = new KhachHangDAO();

    public static boolean checkBlack(Component parent, String[] title, JTextComponent... args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].getText().trim().isEmpty()) {
                MsgBox.alert(parent, "Không được để trống " + title[i] + "!");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkSelectedBgr(Component parent, ButtonGroup b, String s) {
        if (b.getSelection() == null) {
            MsgBox.alert(parent, "Chưa chọn " + s);
            return false;
        }
        return b.getSelection() != null;
    }

    public static boolean checkSimiliar(Component parent, JTextField t1, JTextField t2) {
        if (!t1.getText().trim().equalsIgnoreCase(t2.getText().trim())) {
            MsgBox.alert(parent, "Mật khẩu không trùng khớp!");
            t2.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean checkPosNum(Component parent, String[] title, JTextComponent... args) {
        for (int i = 0; i < args.length; i++) {
            try {
                if (Double.parseDouble(args[i].getText().trim()) < 0) {
                    MsgBox.alert(parent, title[i] + " phải lớn hơn 0!");
                    args[i].requestFocus();
                    return false;
                }
            } catch (Exception e) {
                MsgBox.alert(parent, "Giá trị " + title[i] + " không hợp lệ!");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkSelectedDate(Component parent, String[] title, JDateChooser... args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].getDate() == null) {
                MsgBox.alert(parent, "Vui lòng chọn thời gian cho " + title[i]);
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkSelectedDob(Component parent, JDateChooser... args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].getDate() == null) {
                MsgBox.alert(parent, "Vui lòng chọn ngày sinh!");
                args[i].requestFocus();
                return false;
            } else if (new Date().getYear() - args[i].getDate().getYear() < 18
                    || new Date().getYear() - args[i].getDate().getYear() > 65) {
                MsgBox.alert(parent, "Tuổi không hợp lệ (Phải từ 18-65)");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkEmail(Component parent, JTextComponent... args) {
        String reg = "^[a-zA-Z][\\w-]+@fpt.edu.vn$";
        for (int i = 0; i < args.length; i++) {
            if (!args[i].getText().trim().matches(reg)) {
                MsgBox.alert(parent, "Email không hợp lệ!");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkEmail(Component parent, String... args) {
        String reg = "^[a-zA-Z][\\w-]+@fpt.edu.vn$";
        for (int i = 0; i < args.length; i++) {
            if (!args[i].trim().matches(reg)) {
                MsgBox.alert(parent, "Email không hợp lệ!");
                return false;
            }
        }
        return true;
    }

    public static boolean checkPhoneNum(Component parent, JTextComponent... args) {
        String reg = "^0\\d{9}";
        for (int i = 0; i < args.length; i++) {
            if (!args[i].getText().trim().matches(reg)) {
                MsgBox.alert(parent, "SDT không hợp lệ!");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkIdentityCard(Component parent, JTextComponent... args) {
        String reg9 = "\\d{9}";
        String reg12 = "\\d{12}";
        for (int i = 0; i < args.length; i++) {
            if (args[i].getText().trim().matches(reg9)
                    || args[i].getText().trim().matches(reg12)) {
                return true;
            } else {
                MsgBox.alert(parent, "Số chứng minh nhân dân không hợp lệ!");
                args[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean checkAfterNow(Component parent, JDateChooser d1, Date d2, int task) {
        if (d1.getDate().before(d2)) {
            if (task == 1) {
//                MsgBox.alert(parent, "Vui lòng chọn ngày khai giảng sau ngày tạo!");
                MsgBox.alert(parent, "Vui lòng chọn ngày trả phòng sau hôm nay!");
            }
            d1.requestFocus();
            return false;
        } else {
            if (task != 1) {
                MsgBox.alert(parent, "Vui lòng chọn ngày sinh phù hợp!");
                d1.requestFocus();
            }
            return true;
        }
    }
    
    public static boolean checkDates(Component parent, JDateChooser start, JDateChooser end) {
        if (start.getDate().before(end.getDate())) {
            return true;
        } else {
            MsgBox.alert(parent, "Vui lòng chọn ngày bắt đầu nhỏ hơn ngày kết thúc!");
            return false;
        }
    }

    public static boolean checkMark(Component parent, String s) {
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

    public static boolean isExists(Component parent, JTextComponent value, List<String> data, String title) {
        for (Object item : data) {
            if (item.equals(value.getText().trim())) {
                MsgBox.alert(parent, title + " đã tồn tại");
                value.requestFocus();
                return false;
            }
        }
        return true;
    }

    public static boolean isExists(Component parent, String value, List<String> data, String title) {
        for (Object item : data) {
            if (item.equals(value.trim())) {
                MsgBox.alert(parent, title + " đã tồn tại");
                return false;
            }
        }
        return true;
    }

    public static boolean isExists(Component parent, Object item, List<Object> data, String title) {
        for (Object i : data) {
            if (i.equals(item)) {
                MsgBox.alert(parent, title + " đã tồn tại");
                return false;
            }
        }
        return true;
    }
}
