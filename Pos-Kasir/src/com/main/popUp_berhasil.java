package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class popUp_berhasil extends javax.swing.JFrame {

    public popUp_berhasil() {
        initComponents();
        font();
        setBackground(new Color(0, 0, 0, 0));
        close1.event(this, background21);

    }
    
    public void font(){
        try {
            File fontStyle  = new File("src/com/font/Louis George Cafe Bold.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(18f);
            label1.setFont(font);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shape1 = new com.swing.Shape();
        background21 = new com.swing.background2();
        gambar = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        close1 = new com.button.Close();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        gambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/picture/Resize Check.gif"))); // NOI18N

        label1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("Transaksi Berhasil!!");

        javax.swing.GroupLayout background21Layout = new javax.swing.GroupLayout(background21);
        background21.setLayout(background21Layout);
        background21Layout.setHorizontalGroup(
            background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background21Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background21Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(label1))
                    .addGroup(background21Layout.createSequentialGroup()
                        .addComponent(gambar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(close1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        background21Layout.setVerticalGroup(
            background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background21Layout.createSequentialGroup()
                .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background21Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(close1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label1)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout shape1Layout = new javax.swing.GroupLayout(shape1);
        shape1.setLayout(shape1Layout);
        shape1Layout.setHorizontalGroup(
            shape1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shape1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        shape1Layout.setVerticalGroup(
            shape1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shape1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        font();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(popUp_berhasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popUp_berhasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popUp_berhasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popUp_berhasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popUp_berhasil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.background2 background21;
    private com.button.Close close1;
    private javax.swing.JLabel gambar;
    private javax.swing.JLabel label1;
    private com.swing.Shape shape1;
    // End of variables declaration//GEN-END:variables
}
