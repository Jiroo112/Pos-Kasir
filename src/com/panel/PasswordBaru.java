package com.panel;


import java.awt.Color;
import koneksi.konek;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PasswordBaru extends javax.swing.JFrame {
  private String username;
    private String recoveryCode;
    

    public PasswordBaru(String username, String recoveryCode) {
        this.username = username;
        this.recoveryCode = recoveryCode;
        initComponents();
    }
    private void updatePassword(String username, String newPassword) {
    try {
        String query = "UPDATE data_karyawan SET password = ? WHERE username = ?";
        PreparedStatement pst = konek.GetConnection().prepareStatement(query);
        pst.setString(1, newPassword);
        pst.setString(2, username);
        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Password berhasil diubah!");
        } else {
            JOptionPane.showMessageDialog(this, "Gagal mengubah password!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        background1 = new com.swing.background();
        konfirmPasswordbaru = new javax.swing.JTextField();
        passwordBaru = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kode_otp = new javax.swing.JTextField();
        kirim_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Outter = new com.swing.Shape();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        konfirmPasswordbaru.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        konfirmPasswordbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konfirmPasswordbaruActionPerformed(evt);
            }
        });
        background1.add(konfirmPasswordbaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 300, 30));

        passwordBaru.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        background1.add(passwordBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 300, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password Baru");
        background1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Konfirmasi Password Baru");
        background1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        kode_otp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        background1.add(kode_otp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 300, 30));

        kirim_btn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kirim_btn.setText("kirim");
        kirim_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirim_btnActionPerformed(evt);
            }
        });
        background1.add(kirim_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Kode OTP");
        background1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jPanel1.add(background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 290));

        javax.swing.GroupLayout OutterLayout = new javax.swing.GroupLayout(Outter);
        Outter.setLayout(OutterLayout);
        OutterLayout.setHorizontalGroup(
            OutterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        OutterLayout.setVerticalGroup(
            OutterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        jPanel1.add(Outter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void konfirmPasswordbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konfirmPasswordbaruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_konfirmPasswordbaruActionPerformed

    private void kirim_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirim_btnActionPerformed
      String kodeOtp = kode_otp.getText();
        String newPassword = passwordBaru.getText();
        String confirmPassword = konfirmPasswordbaru.getText();

        if (!kodeOtp.equals(recoveryCode)) {
            JOptionPane.showMessageDialog(this, "Kode OTP tidak cocok!");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Password baru dan konfirmasi tidak cocok!");
            return;
        }
        updatePassword(username, newPassword);
    
    }//GEN-LAST:event_kirim_btnActionPerformed

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
            java.util.logging.Logger.getLogger(PasswordBaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordBaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordBaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordBaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.Shape Outter;
    private com.swing.background background1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton kirim_btn;
    private javax.swing.JTextField kode_otp;
    private javax.swing.JTextField konfirmPasswordbaru;
    private javax.swing.JTextField passwordBaru;
    // End of variables declaration//GEN-END:variables
}
