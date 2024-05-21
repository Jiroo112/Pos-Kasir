package com.panel;

import java.awt.Color;
import java.sql.Statement;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import koneksi.konek;

public class DataMenu extends javax.swing.JPanel {
    public DataMenu() {
        initComponents();
        
        makanan();
        minuman(); 

        kolomCari.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                cariMenu(kolomCari.getText().trim());
            }
            public void removeUpdate(DocumentEvent e) {
                cariMenu(kolomCari.getText().trim());
            }
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }
    private void cariMenu(String keyword) {
        DefaultTableModel tblMakanan = (DefaultTableModel) makanan.getModel();
        DefaultTableModel tblMinuman = (DefaultTableModel) minuman.getModel();

        tblMakanan.setRowCount(0);
        tblMinuman.setRowCount(0);

        try {
            PreparedStatement psMakanan;
            PreparedStatement psMinuman;

            if (keyword.isEmpty()) {
                psMakanan = konek.GetConnection().prepareStatement("SELECT nama_menu, harga, stok FROM menu WHERE kode_menu LIKE '%MA%'");
                psMinuman = konek.GetConnection().prepareStatement("SELECT nama_menu, harga, stok FROM menu WHERE kode_menu LIKE '%MI%'");
            } else {
                psMakanan = konek.GetConnection().prepareStatement("SELECT nama_menu, harga, stok FROM menu WHERE nama_menu LIKE ? AND kode_menu LIKE '%MA%'");
                psMakanan.setString(1, "%" + keyword + "%");

                psMinuman = konek.GetConnection().prepareStatement("SELECT nama_menu, harga, stok FROM menu WHERE nama_menu LIKE ? AND kode_menu LIKE '%MI%'");
                psMinuman.setString(1, "%" + keyword + "%");
            }

            ResultSet rsMakanan = psMakanan.executeQuery();
            while (rsMakanan.next()) {
                tblMakanan.addRow(new Object[]{
                    rsMakanan.getString("nama_menu"),
                    rsMakanan.getString("harga"),
                    rsMakanan.getString("stok")
                });
            }
            ResultSet rsMinuman = psMinuman.executeQuery();
            while (rsMinuman.next()) {
                tblMinuman.addRow(new Object[]{
                    rsMinuman.getString("nama_menu"),
                    rsMinuman.getString("harga"),
                    rsMinuman.getString("stok")
                });
            }

            psMakanan.close();
            psMinuman.close();
            rsMakanan.close();
            rsMinuman.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private String getKodeMenu(String namaMenu) {
    String kodeMenu = "";
    try {
        PreparedStatement ps = konek.GetConnection().prepareStatement("SELECT kode_menu FROM menu WHERE nama_menu = ?");
        ps.setString(1, namaMenu);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            kodeMenu = rs.getString("kode_menu");
        }
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return kodeMenu;
}

   private void tampilkanStokDanDeskripsi(String namaMenu) {
    try {
        String kodeMenu = getKodeMenu(namaMenu);
        
        // Tampilkan Deskripsi
        String queryDeskripsi = "SELECT deskripsi FROM menu WHERE kode_menu = ?";
        PreparedStatement psDeskripsi = konek.GetConnection().prepareStatement(queryDeskripsi);
        psDeskripsi.setString(1, kodeMenu);
        
        ResultSet rsDeskripsi = psDeskripsi.executeQuery();
        
        String deskripsi = "";
        if (rsDeskripsi.next()) {
            deskripsi = rsDeskripsi.getString("deskripsi");
        } else {
            deskripsi = "kosong";
        }
        rsDeskripsi.close();
        psDeskripsi.close();
        
        // Tampilkan Stok
        String queryStok = "SELECT SUM(dt.jumlah) AS total_terjual FROM detail_transaksi dt "
                + "JOIN transaksi t ON dt.kode_transaksi = t.kode_transaksi "
                + "WHERE dt.kode_menu = ? AND t.tgl_transaksi >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)";
        PreparedStatement psStok = konek.GetConnection().prepareStatement(queryStok);
        psStok.setString(1, kodeMenu);
        
        ResultSet rsStok = psStok.executeQuery();
        
        int stokTerjual = 0;
        if (rsStok.next()) {
            stokTerjual = rsStok.getInt("total_terjual");
        }
        rsStok.close();
        psStok.close();
        
        
        String IsiDeskdanStok = "Deskripsi: " + deskripsi + "<br/>" +
                               "Stok Terjual Dalam Sebulan Terakhir Adalah: " + stokTerjual;
        deskrStok.setText("<html>" + IsiDeskdanStok);
        
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
}
   public void makanan(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Makanan");
        tbl.addColumn("Harga");
        tbl.addColumn("Stok");
        makanan.setModel(tbl);
        makanan.getTableHeader().setBackground(new Color(64,64,64));
        makanan.getTableHeader().setForeground(Color.BLACK);
         makanan.setRowHeight(25);
        makanan.setSelectionBackground(new Color(0, 153, 153, 80));
        makanan.setShowGrid(false);
        makanan.setShowHorizontalLines(true);
        makanan.getTableHeader().setResizingAllowed(false);
        makanan.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(makanan);
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT nama_menu, harga, stok FROM menu WHERE kode_menu LIKE '%MA%'");
            while(rs.next()){
                tbl.addRow(new Object[]{
                    rs.getString("nama_menu"),
                    rs.getString("harga"),
                    rs.getString("stok")
                });
                makanan.setModel(tbl);
            }
        } catch (Exception e) {
        }
    }

    public void minuman(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Minuman");
        tbl.addColumn("Harga");
        tbl.addColumn("Stok");
        minuman.setModel(tbl);
        minuman.getTableHeader().setBackground(new Color(64,64,64));
        minuman.getTableHeader().setForeground(Color.BLACK);
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT nama_menu, harga, stok FROM menu WHERE kode_menu LIKE '%MI%'");
            while(rs.next()){
                tbl.addRow(new Object[]{
                    rs.getString("nama_menu"),
                    rs.getString("harga"),
                    rs.getString("stok")
                });
                minuman.setModel(tbl);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.swing.background();
        jScrollPane1 = new javax.swing.JScrollPane();
        kolomCari = new javax.swing.JTextField();
        labelFotoklik = new javax.swing.JLabel();
        deskrStok = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jSeparator1 = new javax.swing.JSeparator();
        tambahbt = new com.button.Fbutton();
        editbt = new com.button.Fbutton();

        setLayout(new java.awt.BorderLayout());

        background1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setFocusCycleRoot(true);
        jScrollPane1.setFocusable(false);
        jScrollPane1.setHorizontalScrollBar(null);

        minuman.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        minuman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Minuman", "Harga", "Stok"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        minuman.setFocusable(false);
        minuman.setRowHeight(25);
        minuman.setSelectionBackground(new java.awt.Color(0, 153, 153, 80));
        minuman.setShowGrid(false);
        minuman.setShowHorizontalLines(true);
        minuman.getTableHeader().setResizingAllowed(false);
        minuman.getTableHeader().setReorderingAllowed(false);
        minuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minumanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(minuman);

        background1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 710, 210));

        kolomCari.setBackground(new java.awt.Color(255, 255, 255));
        kolomCari.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        kolomCari.setForeground(new java.awt.Color(0, 0, 0));
        kolomCari.setBorder(null);
        background1.add(kolomCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 470, 40));

        labelFotoklik.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        background1.add(labelFotoklik, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, 210, 220));

        deskrStok.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deskrStok.setForeground(new java.awt.Color(165, 15, 2));
        background1.add(deskrStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 220, 170));

        makanan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        makanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        makanan.setRowHeight(25);
        makanan.setSelectionBackground(new java.awt.Color(0, 153, 153, 80));
        makanan.setShowGrid(false);
        makanan.setShowHorizontalLines(true);
        makanan.getTableHeader().setResizingAllowed(false);
        makanan.getTableHeader().setReorderingAllowed(false);
        makanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                makananMouseClicked(evt);
            }
        });
        makanan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                makananPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(makanan);

        background1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 710, 220));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        background1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 470, -1));

        tambahbt.setText("Tambah");
        tambahbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbtActionPerformed(evt);
            }
        });
        background1.add(tambahbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 100, 50));

        editbt.setText("Edit");
        editbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtActionPerformed(evt);
            }
        });
        background1.add(editbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 100, 50));

        add(background1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void makananPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_makananPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_makananPropertyChange

    private void makananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_makananMouseClicked
        int indexMakanan = makanan.getSelectedRow();
        if (indexMakanan != -1) {
            String kode_menu = makanan.getValueAt(indexMakanan, 0).toString();
            tampilkanStokDanDeskripsi(kode_menu);

        }
        try {
            String namaMenu = (String) makanan.getValueAt(makanan.getSelectedRow(), 0);
            PreparedStatement ps = konek.GetConnection().prepareStatement("SELECT * FROM menu WHERE nama_menu = ?");
            ps.setString(1, namaMenu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                byte[] img = rs.getBytes("gambar");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myimg = im.getScaledInstance(labelFotoklik.getWidth(), labelFotoklik.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myimg);
                labelFotoklik.setIcon(newImage);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_makananMouseClicked

    private void minumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minumanMouseClicked
        int indexMinuman = minuman.getSelectedRow();
        if (indexMinuman != -1) {
            String kode_menu = makanan.getValueAt(indexMinuman, 0).toString();
            tampilkanStokDanDeskripsi(kode_menu);
        }
        try {
            String namaMenu = (String) minuman.getValueAt(minuman.getSelectedRow(), 0);
            PreparedStatement ps = konek.GetConnection().prepareStatement("SELECT * FROM menu WHERE nama_menu = ?");
            ps.setString(1, namaMenu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                byte[] img = rs.getBytes("gambar");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myimg = im.getScaledInstance(labelFotoklik.getWidth(), labelFotoklik.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myimg);
                labelFotoklik.setIcon(newImage);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace untuk debug
        }
    }//GEN-LAST:event_minumanMouseClicked

    private void tambahbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtActionPerformed
     tambahmenu tm = new tambahmenu();
    tm.setVisible(true);
     SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_tambahbtActionPerformed

    private void editbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtActionPerformed
      int indexMakanan = makanan.getSelectedRow();
    int indexMinuman = minuman.getSelectedRow();
    
    if (indexMakanan != -1) {
        editMakanan();
    } else if (indexMinuman != -1) {
        editMinuman();
    } else {
        JOptionPane.showMessageDialog(this, "Pilih makanan atau minuman yang ingin diubah.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}                                    

private void editMakanan() {
    TableModel model = makanan.getModel();
    int indexMakanan = makanan.getSelectedRow();
    String namaMakanan = model.getValueAt(indexMakanan, 0).toString();
    String hargaMakanan = model.getValueAt(indexMakanan, 1).toString();

    editt p = new editt();
    p.setVisible(true);
    p.txt_nama.setText(namaMakanan);
    p.txt_harga.setText(hargaMakanan);

    try {
        Statement st = konek.GetConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT kode_menu FROM menu WHERE nama_menu = '" + namaMakanan + "';");
        if (rs.next()) {
            String kodeMenu = rs.getString("kode_menu");
            p.txt_kode.setText(kodeMenu);
            p.txt_kode.disable();
        }
        rs.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}

private void editMinuman() {
    TableModel model = minuman.getModel();
    int indexMinuman = minuman.getSelectedRow();
    String namaMinuman = model.getValueAt(indexMinuman, 0).toString();
    String hargaMinuman = model.getValueAt(indexMinuman, 1).toString();

    String kodeMenu = getKodeMenu(namaMinuman);

    editt p = new editt();
    p.setVisible(true);
    
    p.txt_nama.setText(namaMinuman);
    p.txt_harga.setText(hargaMinuman);
    p.txt_kode.setText(kodeMenu);
    p.txt_kode.disable();
    }//GEN-LAST:event_editbtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.background background1;
    private javax.swing.JLabel deskrStok;
    private com.button.Fbutton editbt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField kolomCari;
    private javax.swing.JLabel labelFotoklik;
    public static final javax.swing.JTable makanan = new javax.swing.JTable();
    public static final javax.swing.JTable minuman = new javax.swing.JTable();
    private com.button.Fbutton tambahbt;
    // End of variables declaration//GEN-END:variables

}