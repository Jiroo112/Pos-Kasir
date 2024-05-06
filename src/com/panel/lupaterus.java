package com.panel;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.SSLSocketFactory;

import koneksi.konek;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class lupaterus extends javax.swing.JFrame {
    
    private static final String email_pengirim = "newmooojiwon@gmail.com";
    private static final String pw_pengirim = "kjdd axbr eftw mrfr";

    private Map<String, String> credentials;
    private Map<String, String> recoveryCodes;
    
    private static final int panjang_kode = 6; 

    public lupaterus() {
    credentials = new HashMap<>();
    recoveryCodes = new HashMap<>();
      initComponents();
    setBackground(new Color(0, 0, 0, 0));
    close1.event(this,background1,Outter);
    
  
}
   private boolean cekEmail(String email) {
    try {
        String query = "SELECT * FROM data_karyawan WHERE email = ?";
        PreparedStatement pst = konek.GetConnection().prepareStatement(query);
        
        pst.setString(1, email);
        ResultSet res = pst.executeQuery();
        
        return res.next(); // 
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
   }
    private boolean cekUsername(String username){
    try {
        String query = "SELECT * FROM data_karyawan WHERE username= ?";
        PreparedStatement pst = konek.GetConnection().prepareStatement(query);
        
        pst.setString(1, username);
        ResultSet res = pst.executeQuery();
        
        return res.next(); // 
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    private void updatePassword(String username, String newPassword) {
    try {
        String query = "UPDATE data_karyawan SET password = '" + newPassword + "' WHERE username = '" + username + "'";  
        Statement statement = konek.GetConnection().createStatement();
        int rowsUpdated = statement.executeUpdate(query);
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Password berhasil diubah!");
        } else {
            JOptionPane.showMessageDialog(this, "Gagal mengubah password!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
     private String generateKodeAcak() {
         
        SecureRandom random = new SecureRandom();
        StringBuilder codeBuilder = new StringBuilder(panjang_kode);

        for (int i = 0; i < panjang_kode; i++) {
            int digit = random.nextInt(10); 
            codeBuilder.append(digit);
        }

        return codeBuilder.toString();
    }

    private boolean FormatEmail(String email) {
        String cekValidEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(cekValidEmail);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Outter = new com.swing.Shape();
        background1 = new com.swing.background();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        username_txt = new javax.swing.JTextField();
        email_txt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        kirimKode_txt = new javax.swing.JButton();
        close1 = new com.button.Close();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Email         :");
        background1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 100, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Lupa Password");
        background1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 190, 40));

        username_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        username_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_txtActionPerformed(evt);
            }
        });
        background1.add(username_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 290, -1));

        email_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_txtActionPerformed(evt);
            }
        });
        background1.add(email_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 290, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Username  :");
        background1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        kirimKode_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kirimKode_txt.setText("kirim");
        kirimKode_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimKode_txtActionPerformed(evt);
            }
        });
        background1.add(kirimKode_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 187, 80, 30));
        background1.add(close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, 30));

        javax.swing.GroupLayout OutterLayout = new javax.swing.GroupLayout(Outter);
        Outter.setLayout(OutterLayout);
        OutterLayout.setHorizontalGroup(
            OutterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OutterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );
        OutterLayout.setVerticalGroup(
            OutterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OutterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(Outter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kirimKode_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimKode_txtActionPerformed
        String username = username_txt.getText();
        String email = email_txt.getText();

        String subject = "Kode Lupa Password Lalapan Warung 8";
        String object = "kode lupa password anda adalah : ";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");

        // SSL
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.ssl.ciphersuites", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");

        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email_pengirim, pw_pengirim);
                }
            });
            try {
                if (!FormatEmail(email)) {
                    JOptionPane.showMessageDialog(this, "Email tidak benar");
                    return;
                }
                if (!cekEmail(email)) {
                    JOptionPane.showMessageDialog(this, "Email tidak ditemukan dalam database!");
                    return;
                }
                if (!cekUsername(username)) {
                    JOptionPane.showMessageDialog(this, "username tidak ditemukan dalam database!");
                    return;
                }

                Message pesanMasuk = new MimeMessage(session);
                pesanMasuk.setFrom(new InternetAddress(email_pengirim));
                pesanMasuk.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                pesanMasuk.setSubject(subject);
                String recoveryCode = generateKodeAcak();
                recoveryCodes.put(username, recoveryCode);
                pesanMasuk.setText(object + recoveryCode);
                Transport.send(pesanMasuk);
                JOptionPane.showMessageDialog(this, "Kode berhasil dikirim ke email Anda!");

                PasswordBaru pwb = new PasswordBaru(username, recoveryCode);
                pwb.setLocationRelativeTo(null);
                pwb.setVisible(true);

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            dispose();
    }//GEN-LAST:event_kirimKode_txtActionPerformed

    private void email_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_txtActionPerformed

    private void username_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_txtActionPerformed

    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(lupaterus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lupaterus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lupaterus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lupaterus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                lupaterus frame = new lupaterus();
                new lupaterus().setVisible(true);
                 frame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.Shape Outter;
    private com.swing.background background1;
    private com.button.Close close1;
    private javax.swing.JTextField email_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton kirimKode_txt;
    private javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables
}
