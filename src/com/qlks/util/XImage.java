/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.util;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

/**
 *
 * @author hungn
 */
public class XImage {

    //gan logo vao cac form hien ra
    public static Image getAppIcon() {
        URL url = XImage.class.getResource("/com/sof204/icons/fpt.png");
        return new ImageIcon(url).getImage();
    }

    public static void save(File src) {
        File dst = new File("img", src.getName());
        if (!dst.getParentFile().exists()) {
            //tao thu muc logos neu chua ton tai
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            //copy file vao thu muc logo
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static ImageIcon read(String fileName, JLabel lbl) {
        try {
            File path = new File("img", fileName);
            return new ImageIcon(new ImageIcon(path.getAbsolutePath())
                    .getImage()
                    .getScaledInstance(
                            lbl.getWidth(),
                            lbl.getHeight(),
                            Image.SCALE_AREA_AVERAGING));
        } catch (Exception e) {
            return null;
        }
    }
    

}
