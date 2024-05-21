package com.main;

import com.panel.Transaksi;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import koneksi.konek;

public class Detail_transaksi extends javax.swing.JFrame {

    public String getKode_makanan() {
        return kode_makanan;
    }

    public void setKode_makanan(String kode_makanan) {
        this.kode_makanan = kode_makanan;
    }
    
    private String kode_makanan;
    private String kode_transaksi;
    private String layanan;
    private int jumlah;
    private int porsi;
    
    private Transaksi main;
    
    public Detail_transaksi() {
        initComponents();
        jSeparator1.setForeground(Color.BLACK);
        kode_transaksi();
        font();
        setBackground(new Color(0, 0, 0, 0));
        close1.event(this,background21);
    }
    
    public void layanan(){
        
        if(option1.isSelected()==true){
            layanan="DINE-IN";
        }
        else if(option2.isSelected()==true){
            layanan="TAKE AWAY";
        }
        else{
            layanan=null;
        }
        
        System.out.println(layanan);
    }

    public void font(){
        try {
            File fontStyle  = new File("src/com/font/Louis George Cafe Bold Italic.ttf");
            File fontStyle2  = new File("src/com/font/Louis George Cafe Italic.ttf");
            File fontStyle3  = new File("src/com/font/Louis George Cafe Bold.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(36f);
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle2).deriveFont(12f);
            Font font3 = Font.createFont(Font.TRUETYPE_FONT, fontStyle3).deriveFont(12f);
            jLabel1.setFont(font3);
            jLabel3.setFont(font3);
            option1.setFont(font3);
            option2.setFont(font3);
            jumlahtxt.setFont(font3);
            fbutton1.setFont(font3);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void kode_transaksi(){
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(kode_transaksi) AS invoice FROM transaksi");
            rs.next();
            kode_transaksi = rs.getString("invoice");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void jumlah(){
        porsi = Integer.valueOf(jumlahtxt.getText());
        int harga;
        
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT harga FROM menu WHERE kode_menu = '"+kode_makanan+ "';");
            rs.next();
            harga = rs.getInt("harga");
            jumlah = porsi*harga;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        Outter = new com.swing.Shape();
        background21 = new com.swing.background2();
        close1 = new com.button.Close();
        pictureBox1 = new com.swing.PictureBox();
        jLabel1 = new javax.swing.JLabel();
        jumlahtxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        fbutton1 = new com.button.Fbutton();

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Jumlah Pesanan :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/RawLogo.png"))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Jumlah Pesanan :");

        jumlahtxt.setBackground(new java.awt.Color(255, 255, 255));
        jumlahtxt.setForeground(new java.awt.Color(0, 0, 0));
        jumlahtxt.setBorder(null);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Layanan");

        buttonGroup1.add(option1);
        option1.setForeground(new java.awt.Color(0, 0, 0));
        option1.setText("Dine-in");

        buttonGroup1.add(option2);
        option2.setForeground(new java.awt.Color(0, 0, 0));
        option2.setText("Take-way");
        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });

        fbutton1.setText("Submit");
        fbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbutton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background21Layout = new javax.swing.GroupLayout(background21);
        background21.setLayout(background21Layout);
        background21Layout.setHorizontalGroup(
            background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background21Layout.createSequentialGroup()
                .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background21Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(close1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background21Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background21Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(background21Layout.createSequentialGroup()
                                .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(option2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(background21Layout.createSequentialGroup()
                                .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jumlahtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addGroup(background21Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(fbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        background21Layout.setVerticalGroup(
            background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jumlahtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(option2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(fbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout OutterLayout = new javax.swing.GroupLayout(Outter);
        Outter.setLayout(OutterLayout);
        OutterLayout.setHorizontalGroup(
            OutterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OutterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OutterLayout.setVerticalGroup(
            OutterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OutterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Outter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Outter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed
        
    }//GEN-LAST:event_option2ActionPerformed

    private void fbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbutton1ActionPerformed
        jumlah();
        layanan();
        try {
            Statement st = konek.GetConnection().createStatement();
            st.executeUpdate("INSERT INTO detail_transaksi(kode_transaksi, kode_menu, layanan_pemesanan, jumlah, subtotal) VALUE ('"+kode_transaksi+"','"+kode_makanan+"','"+layanan+"','"+porsi+"','"+jumlah+"')");
            System.out.println("berhasil");
            this.dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_fbutton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detail_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.Shape Outter;
    private com.swing.background2 background21;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.button.Close close1;
    private com.button.Fbutton fbutton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jumlahtxt;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private com.swing.PictureBox pictureBox1;
    // End of variables declaration//GEN-END:variables
}
