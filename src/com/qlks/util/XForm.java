/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.util;

import com.qlks.ui.LoaiPhongFrm;
import java.awt.Component;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author hungn
 */
public class XForm {

    public static void openChildFrm(Component parent, JDesktopPane des, JInternalFrame frm) {
        for (JInternalFrame frmItem : des.getAllFrames()) {
            frmItem.dispose();
        }
        frm.setLocation((des.getWidth() - frm.getWidth()) / 2,
                (des.getHeight() - 20) / 2 - frm.getHeight() / 2 - 20);
        des.add(frm);
        frm.setVisible(true);
    }

    public static void closeFrame(JFrame frm) {
        frm.dispose();
    }

}
