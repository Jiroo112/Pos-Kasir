package com.panel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import koneksi.konek;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.util.Calendar;
import java.util.Date;
import org.jfree.data.general.Dataset;

public class GrafikBaru extends javax.swing.JPanel {
    
    private JFreeChart chart;
    private DefaultCategoryDataset defaultDataset;
    private Date tanggalAwal;
    private Date tanggalAkhir;
    
   public GrafikBaru() {
    initComponents();
    setBackground(new Color(250, 250, 250));
    chart1.addLegend("belanja", new Color(245, 189, 135)); // Orange
    chart1.addLegend("transaksi", new Color(135, 189, 245));   // Blue
    chart1.addLegend("keuntungan", new Color(189, 135, 245)); // Purp
    updateChart();
    
    tampilkanTopSellerMakanan();
    tampilkanTopSellerMinuman();
    makanan();
    minuman();

}
private Date getOneMonthAgoDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1); 
        return calendar.getTime();
}
  public void updateChart() {
    String tanggalPattern = "yyyy-MM-dd";
    SimpleDateFormat dateFormat = new SimpleDateFormat(tanggalPattern);

    try {
        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Get start and end date one month ago
        java.util.Date oneMonthAgo = getOneMonthAgoDate();
        java.sql.Date startDate = new java.sql.Date(oneMonthAgo.getTime());
        java.sql.Date endDate = new java.sql.Date(new java.util.Date().getTime());

        // SQL query to fetch transactions and expenses within the last month
        String queryTransaksi = "SELECT DATE_FORMAT(tgl_transaksi, '%Y-%m-%d %H:%i:%s') as tgl_transaksi, SUM(total) as total FROM transaksi WHERE tgl_transaksi BETWEEN ? AND ? GROUP BY tgl_transaksi ORDER BY tgl_transaksi ASC";
        String queryBelanja = "SELECT DATE_FORMAT(tanggal, '%Y-%m-%d %H:%i:%s') as tanggal, SUM(total) as total FROM belanja WHERE tanggal BETWEEN ? AND ? GROUP BY tanggal ORDER BY tanggal ASC";
        PreparedStatement statementTransaksi = konek.GetConnection().prepareStatement(queryTransaksi);
        PreparedStatement statementBelanja = konek.GetConnection().prepareStatement(queryBelanja);
        statementTransaksi.setDate(1, startDate);
        statementTransaksi.setDate(2, endDate);
        statementBelanja.setDate(1, startDate);
        statementBelanja.setDate(2, endDate);

        ResultSet resBelanja = statementBelanja.executeQuery();
        while (resBelanja.next()) {
            dataset.addValue(resBelanja.getDouble("total"), "belanja", resBelanja.getString("tanggal"));
        }

        // Execute queries for transactions and calculate profit
        ResultSet resTransaksi = statementTransaksi.executeQuery();
        while (resTransaksi.next()) {
            String tanggal = resTransaksi.getString("tgl_transaksi");
            double totalTransaksi = resTransaksi.getDouble("total");
            double totalBelanja = 0.0;
            ResultSet resModal = statementBelanja.executeQuery();
            while (resModal.next()) {
                if (resModal.getString("tanggal").equals(tanggal)) {
                    totalBelanja += resModal.getDouble("total");
                }
            }
            double keuntungan = totalTransaksi - totalBelanja;
            dataset.addValue(totalTransaksi, "transaksi", tanggal);
            dataset.addValue(totalBelanja, "belanja", tanggal);
            dataset.addValue(keuntungan, "keuntungan", tanggal);
        }

        // Set dataset to the chart
        String[] seriesKeys = {"belanja", "transaksi", "keuntungan"};
        chart1.setData(seriesKeys, dataset);
        
        chart1.start();

    } catch (SQLException e) {
        e.printStackTrace();
    }    
  }

    public DefaultCategoryDataset makanan() {
       DefaultCategoryDataset defaultDataset = new DefaultCategoryDataset();
      DefaultTableModel tblMakanan = new DefaultTableModel();
      tblMakanan.addColumn("Makanan");
      tblMakanan.addColumn("Harga");
      tblMakanan.addColumn("StokTerjual/Bulan");
      makanan1.setModel(tblMakanan);
      makanan1.getTableHeader().setBackground(new Color(115,206,191));
      makanan1.getTableHeader().setForeground(new Color(0,0,0));
      try {
          Statement st = konek.GetConnection().createStatement();
          ResultSet rs = st.executeQuery("SELECT m.nama_menu, m.harga, SUM(dt.jumlah) AS total_terjual " +
                                         "FROM menu m " +
                                         "LEFT JOIN detail_transaksi dt ON m.kode_menu = dt.kode_menu " +
                                         "JOIN transaksi t ON dt.kode_transaksi = t.kode_transaksi " +
                                         "WHERE m.kode_menu LIKE '%MA%' " +
                                         "AND t.tgl_transaksi >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH) " +
                                         "GROUP BY m.nama_menu");
          while (rs.next()) {
              tblMakanan.addRow(new Object[]{
                  rs.getString("nama_menu"),
                  rs.getString("harga"),
                  rs.getString("total_terjual")
              });
          }
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(this, e.getMessage());
      }
      return defaultDataset;
  }
    public DefaultCategoryDataset minuman() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DefaultTableModel tblMinuman = new DefaultTableModel();
        tblMinuman.addColumn("Minuman");
        tblMinuman.addColumn("Harga");
        tblMinuman.addColumn("StokTerjual/Bulan");
        minuman1.setModel(tblMinuman);
        minuman1.getTableHeader().setBackground(new Color(115,206,191));
        minuman1.getTableHeader().setForeground(new Color(0,0,0));
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT m.nama_menu, m.harga, SUM(dt.jumlah) AS total_terjual " +
                                           "FROM menu m " +
                                           "LEFT JOIN detail_transaksi dt ON m.kode_menu = dt.kode_menu " +
                                           "JOIN transaksi t ON dt.kode_transaksi = t.kode_transaksi " +
                                           "WHERE m.kode_menu LIKE '%MI%' " +
                                           "AND t.tgl_transaksi >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH) " +
                                           "GROUP BY m.nama_menu");
            while(rs.next()){
                tblMinuman.addRow(new Object[]{
                        rs.getString("nama_menu"),
                        rs.getString("harga"),
                        rs.getString("total_terjual")
                });
                dataset.addValue(rs.getDouble("total_terjual"), "Minuman", rs.getString("nama_menu"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return dataset;

        }
    private String topSellerInfo(ResultSet rs) throws SQLException {
       StringBuilder sb = new StringBuilder();
       sb.append("Top 3 Menu Terlaris:\n");
       int rank = 1;
       while (rs.next()) {
           String namaMenu = rs.getString("nama_menu");
           int totalTerjual = rs.getInt("total_terjual");
           sb.append(rank).append(". ").append(namaMenu).append(" - ").append(totalTerjual).append(" terjual\n");
           rank++;
       }
       return sb.toString();
   }

    private void tampilkanTopSellerMakanan() {
       try {
        String queryTopSellerMakanan = "SELECT m.nama_menu, SUM(dt.jumlah) AS total_terjual FROM menu m "
                + "LEFT JOIN detail_transaksi dt ON m.kode_menu = dt.kode_menu AND m.kode_menu LIKE 'MA%' "
                + "JOIN transaksi t ON dt.kode_transaksi = t.kode_transaksi WHERE t.tgl_transaksi >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH) "
                + "GROUP BY m.nama_menu ORDER BY total_terjual DESC LIMIT 3;";

        PreparedStatement psTopSeller = konek.GetConnection().prepareStatement(queryTopSellerMakanan);
        ResultSet rsTopSeller = psTopSeller.executeQuery();

        String topSellerText = "";
        while (rsTopSeller.next()) {
            String namaMenu = rsTopSeller.getString("nama_menu");
            int totalTerjual = rsTopSeller.getInt("total_terjual");
            topSellerText +=  "<html>" +  namaMenu + " : " + totalTerjual + " terjual <br/>";
        }

        bestSeller3makanan1.setText(topSellerText);

        rsTopSeller.close();
        psTopSeller.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    }
    private void tampilkanTopSellerMinuman() {
    try { 
        String queryTopSellerMinuman = "SELECT m.nama_menu, SUM(dt.jumlah) AS total_terjual FROM menu m LEFT "
                + "JOIN detail_transaksi dt ON m.kode_menu = dt.kode_menu AND m.kode_menu LIKE 'MI%' "
                + "JOIN transaksi t ON dt.kode_transaksi = t.kode_transaksi WHERE t.tgl_transaksi >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)"
                + "GROUP BY m.nama_menu ORDER BY total_terjual DESC LIMIT 3;";
                
        PreparedStatement psTopSellerMin = konek.GetConnection().prepareStatement(queryTopSellerMinuman);
        ResultSet rsTopSeller = psTopSellerMin.executeQuery();
        
        String topSellerMin = "";
        while (rsTopSeller.next()){
            String namaMenu = rsTopSeller.getString("nama_menu");
            int totalTerjual = rsTopSeller.getInt("total_terjual");
            topSellerMin += "<html>" + namaMenu + " : " + totalTerjual + " terjual <br/>";
        }
        
        
        bestSeller3minuman1.setText(topSellerMin);
        rsTopSeller.close();
        psTopSellerMin.close();
    }catch (SQLException e ) {
        e.printStackTrace();
        
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrafikGaris = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        makanan = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        minuman = new javax.swing.JTable();
        labelMinuman = new javax.swing.JLabel();
        bestSeller3minuman = new javax.swing.JLabel();
        bestSeller3makanan = new javax.swing.JLabel();
        background1 = new com.swing.background();
        jScrollPane3 = new javax.swing.JScrollPane();
        makanan1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        minuman1 = new javax.swing.JTable();
        shape1 = new com.swing.Shape();
        bestSeller3minuman1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        shape2 = new com.swing.Shape();
        bestSeller3makanan1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chart1 = new com.grafik.Chart();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Makanan");

        makanan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        makanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(makanan);

        minuman.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        minuman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(minuman);

        labelMinuman.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelMinuman.setText("minuman");

        bestSeller3minuman.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        bestSeller3makanan.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        setLayout(new java.awt.BorderLayout());

        makanan1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        makanan1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        makanan1.setRowHeight(25);
        makanan1.setShowHorizontalLines(true);
        jScrollPane3.setViewportView(makanan1);

        minuman1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        minuman1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        minuman1.setRowHeight(25);
        minuman1.setShowHorizontalLines(true);
        jScrollPane4.setViewportView(minuman1);

        bestSeller3minuman1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        bestSeller3minuman1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TOP 3 MINUMAN");

        javax.swing.GroupLayout shape1Layout = new javax.swing.GroupLayout(shape1);
        shape1.setLayout(shape1Layout);
        shape1Layout.setHorizontalGroup(
            shape1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shape1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bestSeller3minuman1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(shape1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        shape1Layout.setVerticalGroup(
            shape1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shape1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(bestSeller3minuman1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        bestSeller3makanan1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        bestSeller3makanan1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TOP 3 MAKANAN");

        javax.swing.GroupLayout shape2Layout = new javax.swing.GroupLayout(shape2);
        shape2.setLayout(shape2Layout);
        shape2Layout.setHorizontalGroup(
            shape2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shape2Layout.createSequentialGroup()
                .addGroup(shape2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shape2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(bestSeller3makanan1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(shape2Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel3)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        shape2Layout.setVerticalGroup(
            shape2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shape2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bestSeller3makanan1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shape2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shape1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(background1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 15, Short.MAX_VALUE)))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addComponent(shape2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(shape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(222, Short.MAX_VALUE))
            .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(background1Layout.createSequentialGroup()
                    .addContainerGap(352, Short.MAX_VALUE)
                    .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(0, 31, Short.MAX_VALUE)))
        );

        add(background1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GrafikGaris;
    private com.swing.background background1;
    private javax.swing.JLabel bestSeller3makanan;
    private javax.swing.JLabel bestSeller3makanan1;
    private javax.swing.JLabel bestSeller3minuman;
    private javax.swing.JLabel bestSeller3minuman1;
    private com.grafik.Chart chart1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelMinuman;
    private javax.swing.JTable makanan;
    private javax.swing.JTable makanan1;
    private javax.swing.JTable minuman;
    private javax.swing.JTable minuman1;
    private com.swing.Shape shape1;
    private com.swing.Shape shape2;
    // End of variables declaration//GEN-END:variables
}
