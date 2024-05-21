/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.main;


import com.panel.riwayat;
import static com.panel.riwayat.tabel_riwayat;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.konek;

/**
 *
 * @author ASUS
 */
public class tanggal_riwayat extends javax.swing.JFrame {

    public void setTabel_riwayat(String tabel_riwayat) {
        this.tabel_riwayat = tabel_riwayat;
    }

    public String getTabel_riwayat() {
        return tabel_riwayat;
    }
    
    private String tabel_riwayat;
    
    public String a;
    public String b;
    /**
     * Creates new form tanggal_riwayat
     */
    public tanggal_riwayat() {
        initComponents();

//        close1.event(this,background1,Outter);
        dateChooser1.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser1.hidePopup();
                }
            }   
        });
        dateChooser2.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                 System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser2.hidePopup();
                }
            }   
        });
    }
            public void font(){
                try {
            File fontStyle  = new File("src/com/font/Louis George Cafe Bold Italic.ttf");
            File fontStyle2  = new File("src/com/font/Louis George Cafe Italic.ttf");
            File fontStyle3  = new File("src/com/font/Louis George Cafe.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(36f);
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle2).deriveFont(12f);
            Font font3 = Font.createFont(Font.TRUETYPE_FONT, fontStyle3).deriveFont(12f);
            tittle.setFont(font);
            body.setFont(font2);
            batal.setFont(font3);
            selesai.setFont(font3);
            
        } catch (Exception e) {
            e.getMessage();
        }
                
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        shape1 = new com.swing.Shape();
        background1 = new com.swing.background();
        shape73 = new com.swing.Shape7();
        batal = new javax.swing.JLabel();
        shape74 = new com.swing.Shape7();
        selesai = new javax.swing.JLabel();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        shape71 = new com.swing.Shape7();
        txt_date1 = new javax.swing.JTextField();
        shape72 = new com.swing.Shape7();
        txt_date2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tittle = new javax.swing.JLabel();
        body = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(238, 247, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        shape1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background1.setMinimumSize(new java.awt.Dimension(612, 480));
        background1.setPreferredSize(new java.awt.Dimension(612, 480));
        background1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        shape73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        batal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        batal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        batal.setText("Batal");
        batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batalMouseClicked(evt);
            }
        });
        shape73.add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 27));

        background1.add(shape73, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 120, 30));

        shape74.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selesai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selesai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selesai.setText("Selesai");
        selesai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selesaiMouseClicked(evt);
            }
        });
        shape74.add(selesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 28));

        background1.add(shape74, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 120, 30));

        dateChooser2.setForeground(new java.awt.Color(122, 178, 178));
        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(txt_date2);
        background1.add(dateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        dateChooser1.setForeground(new java.awt.Color(122, 178, 178));
        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txt_date1);
        background1.add(dateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        shape71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_date1.setBackground(new java.awt.Color(190, 215, 220));
        txt_date1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_date1.setBorder(null);
        txt_date1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_date1ActionPerformed(evt);
            }
        });
        shape71.add(txt_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 220, 28));

        background1.add(shape71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 240, 30));

        shape72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_date2.setBackground(new java.awt.Color(190, 215, 220));
        txt_date2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_date2.setBorder(null);
        txt_date2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_date2ActionPerformed(evt);
            }
        });
        shape72.add(txt_date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 28));

        background1.add(shape72, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 240, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Dari Tanggal");
        background1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 240, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sampai Tanggal");
        background1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 240, -1));

        tittle.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        tittle.setForeground(new java.awt.Color(0, 153, 153));
        tittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tittle.setText("Pilih Tanggal Transaksi");
        background1.add(tittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        body.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        body.setForeground(new java.awt.Color(0, 153, 153));
        body.setText("Pilih Tanggal Sesuai dengan Data yang Ingin Anda Cari");
        background1.add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 330, 30));

        shape1.add(background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 590, 460));

        jPanel1.add(shape1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_date1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_date1ActionPerformed
        // TODO add your handling code here:
        SelectedDate date1 = dateChooser1.getSelectedDate();
        System.out.println(date1.getDay() + "-" + date1.getMonth() + "-" + date1.getYear());
        System.out.println("Text : " + txt_date1.getText());
    }//GEN-LAST:event_txt_date1ActionPerformed

    private void txt_date2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_date2ActionPerformed
        // TODO add your handling code here:SelectedDate d = dateChooser.getSelectedDate();
        SelectedDate date2 = dateChooser2.getSelectedDate();
        System.out.println(date2.getDay() + "-" + date2.getMonth() + "-" + date2.getYear());
        System.out.println("Text : " + txt_date2.getText());
    }//GEN-LAST:event_txt_date2ActionPerformed

    private void batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batalMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_batalMouseClicked

    private void selesaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selesaiMouseClicked

//       a = txt_date1.getText();
//       b = txt_date2.getText();
//        System.out.println("dari = " +a + " sampai = " +b );
//        this.dispose();

        String tanggal = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tanggal);

        String tanggal1 = txt_date1.getText();
        String tanggal2 = txt_date2.getText();
        DefaultTableModel tbl = (DefaultTableModel) riwayat.tabel_riwayat.getModel();
        tbl.setRowCount(0); 

        try {
            Date date1 = fm.parse(tanggal1);
            Date date2 = fm.parse(tanggal2);
            System.out.println(date1);
            System.out.println(date2);
            Statement statement = (Statement) konek.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM transaksi having "
                    + "tgl_transaksi BETWEEN '" + new java.sql.Date(date1.getTime()) + "' AND '" + new java.sql.Date(date2.getTime()) + "' ORDER BY "
                    + "tgl_transaksi ASC ");

            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getDate("tgl_transaksi"),
                    res.getString("kode_transaksi"),
                    res.getInt("total"),
                    res.getInt("bayar"),
                    res.getInt("kembalian"),
                    res.getString("username")
                });
            }
            // Set the table model after fetching data
            //tabel_riwayat.setModel(tbl);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
        }
        int jumlahBaris = riwayat.tabel_riwayat.getRowCount();
                int totalBiaya = 0;
                int total;
                for (int i = 0; i < jumlahBaris; i++) {
                    total = Integer.parseInt(riwayat.tabel_riwayat.getValueAt(i, 2).toString());
                    totalBiaya = totalBiaya + (total);
                }
                riwayat.txt_pemasukan.setText(String.valueOf("Rp " +totalBiaya +",00"));
    
this.dispose();
    }//GEN-LAST:event_selesaiMouseClicked

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
            java.util.logging.Logger.getLogger(tanggal_riwayat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tanggal_riwayat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tanggal_riwayat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tanggal_riwayat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tanggal_riwayat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.background background1;
    private javax.swing.JLabel batal;
    private javax.swing.JLabel body;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel selesai;
    private com.swing.Shape shape1;
    private com.swing.Shape7 shape71;
    private com.swing.Shape7 shape72;
    private com.swing.Shape7 shape73;
    private com.swing.Shape7 shape74;
    private javax.swing.JLabel tittle;
    private javax.swing.JTextField txt_date1;
    private javax.swing.JTextField txt_date2;
    // End of variables declaration//GEN-END:variables
}