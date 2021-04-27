/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.ui;

import com.email.durgesh.Email;
import com.qlks.dao.MaXacNhanDAO;
import com.qlks.dao.NhanVienDAO;
import com.qlks.entity.MaXacNhan;
import com.qlks.entity.NhanVien;
import com.qlks.util.Auth;
import com.qlks.util.MsgBox;
import com.qlks.util.Validator;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

public class LoginDialog extends javax.swing.JDialog {

    private NhanVienDAO nvdao = new NhanVienDAO();
    private MaXacNhanDAO mxndao = new MaXacNhanDAO();

    private JDesktopPane desktop = new JDesktopPane();

    private String user = null;

    /**
     * Creates new form LoginDialog
     */
    public LoginDialog() {
        initComponents();
        this.init();
    }

    public LoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edtTenDangNhap = new javax.swing.JTextField();
        sptTen = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        edtMatKhau = new javax.swing.JPasswordField();
        sptMatKhau = new javax.swing.JSeparator();
        btnDangNhap = new javax.swing.JButton();
        lblQuenMatKhau = new javax.swing.JLabel();
        btnDangKy = new javax.swing.JButton();
        chkShowPass = new javax.swing.JCheckBox();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(37, 49, 62));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 750));

        lblClose.setBackground(new java.awt.Color(37, 49, 62));
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/closel_24px.png"))); // NOI18N
        lblClose.setToolTipText("Close");
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(37, 49, 62));

        jLabel2.setBackground(new java.awt.Color(37, 49, 62));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlks/icon/logo.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 195, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STARUP HOTEL");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username:");

        edtTenDangNhap.setBackground(new java.awt.Color(37, 49, 62));
        edtTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        edtTenDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        edtTenDangNhap.setBorder(null);
        edtTenDangNhap.setCaretColor(new java.awt.Color(255, 255, 255));
        edtTenDangNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtTenDangNhapKeyPressed(evt);
            }
        });

        sptTen.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password:");

        edtMatKhau.setBackground(new java.awt.Color(37, 49, 62));
        edtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        edtMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        edtMatKhau.setBorder(null);
        edtMatKhau.setCaretColor(new java.awt.Color(255, 255, 255));
        edtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtMatKhauKeyPressed(evt);
            }
        });

        sptMatKhau.setForeground(new java.awt.Color(255, 255, 255));

        btnDangNhap.setBackground(new java.awt.Color(46, 62, 78));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("SIGN IN");
        btnDangNhap.setToolTipText("");
        btnDangNhap.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        btnDangNhap.setContentAreaFilled(false);
        btnDangNhap.setFocusPainted(false);
        btnDangNhap.setOpaque(true);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        lblQuenMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQuenMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblQuenMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQuenMatKhau.setText("Forgot password?");
        lblQuenMatKhau.setToolTipText("");
        lblQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseClicked(evt);
            }
        });

        btnDangKy.setBackground(new java.awt.Color(255, 255, 255));
        btnDangKy.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnDangKy.setForeground(new java.awt.Color(255, 255, 255));
        btnDangKy.setText("Create new account...");
        btnDangKy.setToolTipText("");
        btnDangKy.setBorder(null);
        btnDangKy.setContentAreaFilled(false);
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        chkShowPass.setBackground(new java.awt.Color(37, 49, 62));
        chkShowPass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        chkShowPass.setForeground(new java.awt.Color(255, 255, 255));
        chkShowPass.setText("Show password");
        chkShowPass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkShowPassItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(chkShowPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblQuenMatKhau))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sptMatKhau, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edtTenDangNhap, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sptTen, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addComponent(btnDangKy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sptTen, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(sptMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuenMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkShowPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        this.login();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void edtTenDangNhapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtTenDangNhapKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.login();
        }
    }//GEN-LAST:event_edtTenDangNhapKeyPressed

    private void edtMatKhauKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtMatKhauKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.login();
        }
    }//GEN-LAST:event_edtMatKhauKeyPressed

    private void lblQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseClicked
        this.forgotPassword();
    }//GEN-LAST:event_lblQuenMatKhauMouseClicked


    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
//        this.register();
        this.openRegisterDialog();

    }//GEN-LAST:event_btnDangKyActionPerformed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        if (MsgBox.confirm(this, "Bạn có chắc muốn thoát?")) {
            System.exit(0);
        }
    }//GEN-LAST:event_lblCloseMouseClicked

    private void chkShowPassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkShowPassItemStateChanged
        this.showPass(evt);
    }//GEN-LAST:event_chkShowPassItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginDialog dialog = new LoginDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JCheckBox chkShowPass;
    private javax.swing.JPasswordField edtMatKhau;
    private javax.swing.JTextField edtTenDangNhap;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblQuenMatKhau;
    private javax.swing.JSeparator sptMatKhau;
    private javax.swing.JSeparator sptTen;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.setLocationRelativeTo(null);
        edtTenDangNhap.setText("ph01");
        edtMatKhau.setText("hungnn");
    }

    private String login() {
        String[] title = new String[]{"Tên đăng nhập", "Mật khẩu"};
        if (Validator.checkBlack(this, title, edtTenDangNhap, edtMatKhau)) {
            String user = edtTenDangNhap.getText().trim();
            String pass = String.valueOf(edtMatKhau.getText().trim());
            NhanVien nhanVien = nvdao.selectByID(user);
            if (nhanVien == null) {
                MsgBox.alert(this, "Sai tên đăng nhập!");
            } else {
                if (nhanVien.getPass().equalsIgnoreCase(pass)) {
                    MsgBox.alert(this, "Đăng nhập thành công!");
                    //next code
                    Auth.user = nhanVien;
                    LoginDialog.this.dispose();
                } else {
                    MsgBox.alert(this, "Sai mật khẩu!");
                }
            }
        }
        return user;
    }

    private void forgotPassword() {
        try {
            String username = MsgBox.prompt(this, "Nhập tên đăng nhập...");
            if (!username.isEmpty()) {
                String email = MsgBox.prompt(this, "Nhập email...");
                if (!email.isEmpty()) {
                    NhanVien nhanVien = nvdao.selectByEmail(username, email);
                    if (nhanVien == null) {
                        MsgBox.alert(this, "Email không đúng!");
                    } else {
                        MsgBox.dialogAutoClose(this, "Vui lòng đợi trong giây lát!");
                        sendMail(email, nhanVien.getMa());
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private void sendMail(String s, String maNv) {
        String fE = "huamanhhung13@gmail.com";
        String fP = "hung18052000";
        String sub = "Reset Password!";
        int newPass = getNewPass();
        String con = "<h1>Your new password: " + newPass + "</h1>";

        try {
            Email email = new Email(fE, fP);
            email.setFrom("Startup Hotel", "Startup Hotel");
            email.setSubject(sub);
            email.setContent(con, "text/html");
            email.addRecipient(s);
            email.send();
            MsgBox.dialogAutoClose(this, "Vui lòng đợi trong giây lát!");

            MsgBox.alert(this, "Hệ thống đã gửi mật khẩu mới đến Email của bạn!");

            MaXacNhan maXacNhan = new MaXacNhan(newPass + "", maNv);
            mxndao.insert(maXacNhan);
            nvdao.updateForgotPass(maNv);
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Email không hợp lệ!");
        }
    }

    private int getNewPass() {
        return new Random().nextInt(90000000) + 10000000;
    }

    private void register() {
        MsgBox.dialogAutoClose(this, "Vui lòng đợi trong giây lát!");
    }

    private void close() {
        if (MsgBox.confirm(this, "Bạn có chắc muốn thoát?")) {
            System.exit(0);
        }

    }

    private void showPass(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            edtMatKhau.setEchoChar((char) 0);
        } else {
            edtMatKhau.setEchoChar('*');
        }
    }

    private void openRegisterDialog() {
        Window ancestor = SwingUtilities.getWindowAncestor(btnDangKy);
        LoginDialog.this.setVisible(false);
        RegisterDialog regis = new RegisterDialog(this, true);
        regis.setLocationRelativeTo(null);
        regis.setVisible(true);
    }

}
