package com.panel;

import java.awt.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import koneksi.konek;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class Keuntungan extends javax.swing.JPanel {

   double modal;
    double transaksi;
    double keuntungan;
    
    private DefaultCategoryDataset defaultDataset;
    private DefaultCategoryDataset selectedDataset;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    
    Date tanggalAwal; 
    Date tanggalAkhir;
    
   public Keuntungan() {
        initComponents();
        data_table();
        data_table_belanja();
        tanggalAwal = new Date();
        tanggalAkhir = new Date();
       }
   
   
     public void data_table() {
    DefaultTableModel tbl = new DefaultTableModel();
    tbl.addColumn("Tanggal");
    tbl.addColumn("Kode Transaksi");
    tbl.addColumn("Pemasukan");
    Ttabel.setModel(tbl);

    try {
      Statement statement = konek.GetConnection().createStatement();
      ResultSet res = statement.executeQuery(
            "select transaksi.tgl_transaksi, transaksi.kode_transaksi, transaksi.total"
                    + " FROM transaksi order by tgl_transaksi ASC");
 
        while (res.next()) {
        tbl.addRow(new Object[]{
                res.getDate("tgl_transaksi"),
                res.getString("kode_transaksi"),
                res.getInt("total")   
        });
    }
    Ttabel.setModel(tbl);

} catch (Exception e) {
    
}
     }

 public void data_table_belanja() {
    DefaultTableModel tblB = new DefaultTableModel();
    tblB.addColumn("Tanggal");
    tblB.addColumn("Total Belanja");
    tblB.addColumn("Keterangan");
    belanjatabel.setModel(tblB);

    try {
      Statement statement = konek.GetConnection().createStatement();
    ResultSet res = statement.executeQuery("select belanja.tanggal, belanja.total, belanja.keterangan "
            + "FROM belanja ORDER BY tanggal ASC;");
 
          while (res.next()) {
        tblB.addRow(new Object[]{
                res.getDate("tanggal"),
                res.getInt("total"),
                res.getString("keterangan"),
                
        });
    }
    belanjatabel.setModel(tblB);
    }catch (Exception e) { 
        JOptionPane.showMessageDialog(this.getRootPane(),"error : " + e.getMessage());
    }
    }
 public double modal(String tanggal1, String tanggal2) {
    double nilaiModal = 0.0;
    try {
        String query = "SELECT SUM(belanja.total) AS total_belanja FROM belanja WHERE tanggal BETWEEN ? AND ?";
        PreparedStatement preparedStatement = konek.GetConnection().prepareStatement(query);

        preparedStatement.setString(1, tanggal1);
        preparedStatement.setString(2, tanggal2);

        ResultSet res = preparedStatement.executeQuery();

        while (res.next()) {
            nilaiModal = res.getDouble("total_belanja");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return nilaiModal;
}
 public double transaksi(String tanggal1, String tanggal2) {
    double nilaiTotal = 0.0;
    try {
        String query = "SELECT SUM(transaksi.total) AS total_transaksi FROM transaksi WHERE tgl_transaksi BETWEEN ? AND ?";
        PreparedStatement preparedStatement = konek.GetConnection().prepareStatement(query);

        preparedStatement.setString(1, tanggal1);
        preparedStatement.setString(2, tanggal2);

        ResultSet res = preparedStatement.executeQuery();

        while (res.next()) {
            nilaiTotal = res.getDouble("total_transaksi");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return nilaiTotal;
}
public JTextField getTotaluntungField() {
    return totaluntungField;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.swing.background();
        totaluntungField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ttabel = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        belanjatabel = new javax.swing.JTable();
        title = new javax.swing.JLabel();
        body = new javax.swing.JLabel();
        tanggalbt = new com.button.Fbutton();
        title1 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        background1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totaluntungField.setBackground(new java.awt.Color(204, 255, 204));
        totaluntungField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        background1.add(totaluntungField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 510, 30));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Ttabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Ttabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tanggal", "Kode Transaksi", "Pemasukan"
            }
        ));
        Ttabel.setRowHeight(25);
        Ttabel.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Ttabel.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(Ttabel);

        background1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 507, 250));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        belanjatabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        belanjatabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Total Belanja", "Keterangan"
            }
        ));
        belanjatabel.setCellSelectionEnabled(true);
        belanjatabel.setRowHeight(25);
        belanjatabel.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        belanjatabel.setShowHorizontalLines(true);
        jScrollPane2.setViewportView(belanjatabel);

        background1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 510, 250));

        title.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 153, 153));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Keuntungan : ");
        title.setToolTipText("");
        background1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        body.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        body.setForeground(new java.awt.Color(0, 153, 153));
        body.setText("Menghitung Keuntungan Berdasarkan Tanggal yang Dipilih");
        background1.add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        tanggalbt.setText("Pilih Tanggal");
        tanggalbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalbtActionPerformed(evt);
            }
        });
        background1.add(tanggalbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 40));

        title1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        title1.setForeground(new java.awt.Color(0, 153, 153));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("Keuntungan");
        title1.setToolTipText("");
        background1.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        add(background1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void tanggalbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalbtActionPerformed
   pilihTanggal framePilihTanggal = new pilihTanggal(this);
    framePilihTanggal.setVisible(true);
    }//GEN-LAST:event_tanggalbtActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Ttabel;
    private com.swing.background background1;
    public javax.swing.JTable belanjatabel;
    private javax.swing.JLabel body;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.button.Fbutton tanggalbt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    public javax.swing.JTextField totaluntungField;
    // End of variables declaration//GEN-END:variables

}