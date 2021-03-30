/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author hungn
 */
public class MsgBox {

    public static void alert(Component c, String mess) {
        JOptionPane.showMessageDialog(c, mess, "Startup Hotel", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(Component c, String mess) {
        return JOptionPane.showConfirmDialog(c, mess, "Startup Hotel",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION;
    }

    public static String prompt(Component c, String mess) {
        return JOptionPane.showInputDialog(c, mess, "Startup Hotel",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void dialogAutoClose(Component com, String mess) {
        JOptionPane optionPane = new JOptionPane(mess, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);//        JOptionPane jOptionPane = new JOptionPane("Hello ChungmAy", JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(com, "Startup Hotel");
        dialog.setModal(false);
        dialog.setVisible(true);
        new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        }).start();
    }
}
