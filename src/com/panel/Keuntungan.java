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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.swing.background();
        date2 = new com.toedter.calendar.JDateChooser();
        date1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totaluntungField = new javax.swing.JTextField();
        ButtonHitung = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ttabel = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        belanjatabel = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        background1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date2.setBackground(new java.awt.Color(204, 204, 204));
        date2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date2.setAutoscrolls(true);
        date2.setDateFormatString("yyyy-MM- dd");
        date2.setFocusCycleRoot(true);
        date2.setFocusable(false);
        date2.setOpaque(false);
        background1.add(date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 400, 30));

        date1.setBackground(new java.awt.Color(204, 204, 204));
        date1.setDateFormatString("yyyy-MM- dd");
        date1.setFocusCycleRoot(true);
        date1.setFocusable(false);
        date1.setOpaque(false);
        background1.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 410, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Perhitungan Keuntungan");
        background1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setText("Dari Tanggal");
        background1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 88, 110, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setText("Sampai Tanggal");
        background1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 140, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel6.setText("Keuntungan");
        background1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 160, -1));

        totaluntungField.setBackground(new java.awt.Color(204, 255, 204));
        totaluntungField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        background1.add(totaluntungField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 510, 30));

        ButtonHitung.setText("hitung");
        ButtonHitung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonHitungMouseClicked(evt);
            }
        });
        ButtonHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHitungActionPerformed(evt);
            }
        });
        background1.add(ButtonHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 100, 30));

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

        background1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 166, 507, 250));

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

        background1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 164, 500, 250));

        add(background1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHitungActionPerformed
        String tanggalPattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(tanggalPattern);

        String tanggal1 = dateFormat.format(date1.getDate());
        String tanggal2 = dateFormat.format(date2.getDate());

        try {
            String queryTransaksi = "SELECT tgl_transaksi, kode_transaksi, total "
            + "FROM transaksi WHERE tgl_transaksi BETWEEN ? AND ? order by tgl_transaksi asc";
            PreparedStatement statementTransaksi = konek.GetConnection().prepareStatement(queryTransaksi);
            statementTransaksi.setString(1, tanggal1);
            statementTransaksi.setString(2, tanggal2);

            ResultSet resTransaksi = statementTransaksi.executeQuery();

            DefaultTableModel tblTransaksi = new DefaultTableModel();
            tblTransaksi.addColumn("Tanggal");
            tblTransaksi.addColumn("Kode Transaksi");
            tblTransaksi.addColumn("Pemasukan");

            while (resTransaksi.next()) {
                tblTransaksi.addRow(new Object[]{
                    resTransaksi.getDate("tgl_transaksi"),
                    resTransaksi.getString("kode_transaksi"),
                    resTransaksi.getInt("total")
                });
            }
            String queryBelanja = "SELECT tanggal, total, keterangan "
            + "FROM belanja WHERE tanggal BETWEEN ? AND ? order by tanggal asc";
            PreparedStatement statementBelanja = konek.GetConnection().prepareStatement(queryBelanja);
            statementBelanja.setString(1, tanggal1);
            statementBelanja.setString(2, tanggal2);

            ResultSet resBelanja = statementBelanja.executeQuery();

            DefaultTableModel tblBelanja = new DefaultTableModel();
            tblBelanja.addColumn("Tanggal");
            tblBelanja.addColumn("Total Belanja");
            tblBelanja.addColumn("Keterangan");

            while (resBelanja.next()) {
                tblBelanja.addRow(new Object[]{
                    resBelanja.getDate("tanggal"),
                    resBelanja.getInt("total"),
                    resBelanja.getString("keterangan")
                });
            }
            Ttabel.setModel(tblTransaksi);
            belanjatabel.setModel(tblBelanja);

            double modal = modal(tanggal1, tanggal2);
            double transaksi = transaksi(tanggal1, tanggal2);
            double keuntungan = transaksi - modal;
            totaluntungField.setText(String.valueOf(keuntungan));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonHitungActionPerformed

    private void ButtonHitungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonHitungMouseClicked
        String tanggalPattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(tanggalPattern);

        String tanggal1 = dateFormat.format(date1.getDate());
        String tanggal2 = dateFormat.format(date2.getDate());

        try {
            String queryTransaksi = "SELECT tgl_transaksi, kode_transaksi, total "
            + "FROM transaksi WHERE tgl_transaksi BETWEEN ? AND ? order by tgl_transaksi asc";
            PreparedStatement statementTransaksi = konek.GetConnection().prepareStatement(queryTransaksi);
            statementTransaksi.setString(1, tanggal1);
            statementTransaksi.setString(2, tanggal2);

            ResultSet resTransaksi = statementTransaksi.executeQuery();

            DefaultTableModel tblTransaksi = new DefaultTableModel();
            tblTransaksi.addColumn("Tanggal");
            tblTransaksi.addColumn("Kode Transaksi");
            tblTransaksi.addColumn("Pemasukan");

            while (resTransaksi.next()) {
                tblTransaksi.addRow(new Object[]{
                    resTransaksi.getDate("tgl_transaksi"),
                    resTransaksi.getString("kode_transaksi"),
                    resTransaksi.getInt("total")
                });
            }
            String queryBelanja = "SELECT tanggal, total, keterangan "
            + "FROM belanja WHERE tanggal BETWEEN ? AND ? order by tanggal asc";
            PreparedStatement statementBelanja = konek.GetConnection().prepareStatement(queryBelanja);
            statementBelanja.setString(1, tanggal1);
            statementBelanja.setString(2, tanggal2);

            ResultSet resBelanja = statementBelanja.executeQuery();

            DefaultTableModel tblBelanja = new DefaultTableModel();
            tblBelanja.addColumn("Tanggal");
            tblBelanja.addColumn("Total Belanja");
            tblBelanja.addColumn("Keterangan");

            while (resBelanja.next()) {
                tblBelanja.addRow(new Object[]{
                    resBelanja.getDate("tanggal"),
                    resBelanja.getInt("total"),
                    resBelanja.getString("keterangan")
                });
            }
            Ttabel.setModel(tblTransaksi);
            belanjatabel.setModel(tblBelanja);

            double modal = modal(tanggal1, tanggal2);
            double transaksi = transaksi(tanggal1, tanggal2);
            double keuntungan = transaksi - modal;
            totaluntungField.setText(String.valueOf(keuntungan));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonHitungMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonHitung;
    private javax.swing.JTable Ttabel;
    private com.swing.background background1;
    private javax.swing.JTable belanjatabel;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField totaluntungField;
    // End of variables declaration//GEN-END:variables
}