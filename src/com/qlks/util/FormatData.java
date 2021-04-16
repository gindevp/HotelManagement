/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author hungn
 */
public class FormatData {

    public static String formatMoney(double money) {
        return NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(money);
    }
}
