package com.main;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.konek;


public class scanrfid extends javax.swing.JFrame {
    
    private Admin ad;
    private Karyawan kr;
    private login lg;
    
    public scanrfid(login login) {
        this.lg = login;
        initComponents();
        font();
        ad = new Admin();
        kr = new Karyawan();
        id.requestFocusInWindow();
        jSeparator1.setForeground(Color.BLACK);
        close1.event(ad, background21);
    }
    
    public void font(){
        try {
            File fontStyle  = new File("src/com/font/Louis George Cafe Bold.ttf");
            File fontStyle2  = new File("src/com/font/Louis George Cafe.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(35f);
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle2).deriveFont(18f);
            title.setFont(font);
            body.setFont(font2);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void login(){
        String itemId = id.getText();
        
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT barcodenumber, jabatan FROM data_karyawan WHERE barcodenumber = '"+itemId+"'");
            if(rs.next()){
                String jabatan = rs.getString("jabatan");
                if(jabatan.equals("Admin")){
                    ad.setVisible(true);
                }
                else if(jabatan.equals("Kasir")){
                    kr.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Kartu tidak terdeteksi");
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Outer = new com.swing.Shape();
        background21 = new com.swing.background2();
        title = new javax.swing.JLabel();
        close1 = new com.button.Close();
        body = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        title.setText("Scan RFID");

        body.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        body.setText("Mohon Tap Kartu Anda!");

        id.setBorder(null);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/picture/rf.gif"))); // NOI18N

        javax.swing.GroupLayout background21Layout = new javax.swing.GroupLayout(background21);
        background21.setLayout(background21Layout);
        background21Layout.setHorizontalGroup(
            background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background21Layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background21Layout.createSequentialGroup()
                        .addComponent(close1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background21Layout.createSequentialGroup()
                        .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background21Layout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))
                        .addGap(111, 111, 111))))
        );
        background21Layout.setVerticalGroup(
            background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title)
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout OuterLayout = new javax.swing.GroupLayout(Outer);
        Outer.setLayout(OuterLayout);
        OuterLayout.setHorizontalGroup(
            OuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OuterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        OuterLayout.setVerticalGroup(
            OuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OuterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Outer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Outer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        String itemId = id.getText();
        
        if(itemId.length()==10){
            login();
            this.dispose();
            lg.dispose();
        }
        else{
            id.setText("");
        }
    }//GEN-LAST:event_idActionPerformed

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
            java.util.logging.Logger.getLogger(scanrfid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scanrfid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scanrfid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scanrfid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                login lg = new login();
                new scanrfid(lg).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.Shape Outer;
    private com.swing.background2 background21;
    private javax.swing.JLabel body;
    private com.button.Close close1;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
