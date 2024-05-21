package com.panel;


import static com.panel.DataMenu.makanan;
import com.swing.ScrollBar;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import koneksi.konek;

public class data_menu extends javax.swing.JPanel {
    
    private editt edit;

    public data_menu() {
        initComponents();
        makanan();
        font();
        Scroll.setVerticalScrollBar(new ScrollBar());
        jSeparator1.setForeground(Color.BLACK);
        jSeparator2.setForeground(Color.BLACK);
        jSeparator3.setForeground(Color.BLACK);
        jSeparator4.setForeground(Color.BLACK);
    }
    
    public void font(){
        try {
            File fontStyle  = new File("src/com/font/Louis George Cafe Bold Italic.ttf");
            File fontStyle2  = new File("src/com/font/Louis George Cafe Italic.ttf");
            File fontStyle3  = new File("src/com/font/Louis George Cafe.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(36f);
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle2).deriveFont(12f);
            Font font3 = Font.createFont(Font.TRUETYPE_FONT, fontStyle3).deriveFont(12f);
            title.setFont(font);
            body.setFont(font2);
            detail.setFont(font);
            fbutton1.setFont(font3);
            fbutton2.setFont(font3);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void makanan(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Makanan");
        tbl.addColumn("Harga");
        tbl.addColumn("Stok");
        tabel1.setModel(tbl);
        tabel1.getTableHeader().setBackground(new Color(0, 167, 157));
        tabel1.getTableHeader().setForeground(Color.WHITE);
        tabel1.setRowHeight(25);
        tabel1.setSelectionBackground(new Color(0, 153, 153, 80));
        tabel1.setShowGrid(false);
        tabel1.setShowHorizontalLines(true);
        tabel1.getTableHeader().setResizingAllowed(false);
        tabel1.getTableHeader().setReorderingAllowed(false);
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT nama_menu, harga, stok FROM menu WHERE kode_menu LIKE '%MA%'");
            while(rs.next()){
                tbl.addRow(new Object[]{
                    rs.getString("nama_menu"),
                    rs.getString("harga"),
                    rs.getString("stok")
                });
                tabel1.setModel(tbl);
            }
        } catch (Exception e) {
        }
    }
    
    public void minuman(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Minuman");
        tbl.addColumn("Harga");
        tbl.addColumn("Stok");
        tabel1.setModel(tbl);
        tabel1.getTableHeader().setBackground(new Color(0, 167, 157));
        tabel1.getTableHeader().setForeground(Color.WHITE);
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT nama_menu, harga, stok FROM menu WHERE kode_menu LIKE '%MI%'");
            while(rs.next()){
                tbl.addRow(new Object[]{
                    rs.getString("nama_menu"),
                    rs.getString("harga"),
                    rs.getString("stok")
                });
                tabel1.setModel(tbl);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void setData(String itemId){
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT nama_menu, kode_menu, stok FROM menu WHERE nama_menu ='"+itemId+"' ");
            if(rs.next()){
                itemKode.setText(rs.getString("kode_menu"));
                itemName.setText(rs.getString("nama_menu"));
                itemName1.setText(rs.getString("stok"));
            }
        } catch (Exception e) {
        }
        
    }
    
    public void editmakanan(){
        TableModel model = tabel1.getModel();
        int indexMakanan = tabel1.getSelectedRow();
        String namaMakanan = model.getValueAt(indexMakanan, 0).toString();
        String hargaMakanan = model.getValueAt(indexMakanan, 1).toString();

        edit.txt_nama.setText(namaMakanan);
        edit.txt_harga.setText(hargaMakanan);

    try {
        Statement st = konek.GetConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT kode_menu FROM menu WHERE nama_menu = '" + namaMakanan + "';");
        if (rs.next()) {
            String kodeMenu = rs.getString("kode_menu");
            edit.txt_kode.setText(kodeMenu);
            edit.txt_kode.disable();
            edit.txt_kode.setForeground(Color.black);
        }
        rs.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        body = new javax.swing.JLabel();
        fbutton1 = new com.button.Fbutton();
        panelShadow1 = new Shape.PanelShadow();
        Scroll = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        panelShadow2 = new Shape.PanelShadow();
        detail = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        itemId = new javax.swing.JLabel();
        itemId1 = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        itemId2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        pictureBox1 = new com.swing.PictureBox();
        pictureBox3 = new com.swing.PictureBox();
        pictureBox2 = new com.swing.PictureBox();
        pictureBox4 = new com.swing.PictureBox();
        pictureBox5 = new com.swing.PictureBox();
        itemKode = new javax.swing.JLabel();
        itemName = new javax.swing.JLabel();
        itemName1 = new javax.swing.JLabel();
        fbutton2 = new com.button.Fbutton();

        setBackground(new java.awt.Color(231, 231, 231));
        setOpaque(false);

        title.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        title.setForeground(new java.awt.Color(0, 153, 153));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Daftar Menu");
        title.setToolTipText("");

        body.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        body.setForeground(new java.awt.Color(0, 153, 153));
        body.setText("Daftar makanan & minuman");

        fbutton1.setText("Makanan");
        fbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbutton1ActionPerformed(evt);
            }
        });

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        tabel1.setBackground(new java.awt.Color(255, 255, 255));
        tabel1.setForeground(new java.awt.Color(0, 0, 0));
        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel1.setGridColor(new java.awt.Color(255, 255, 255));
        tabel1.setOpaque(false);
        tabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabel1MouseEntered(evt);
            }
        });
        Scroll.setViewportView(tabel1);

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        panelShadow2.setBackground(new java.awt.Color(255, 255, 255));

        detail.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        detail.setForeground(new java.awt.Color(0, 153, 153));
        detail.setText("Detail Menu");

        itemId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemId.setForeground(new java.awt.Color(51, 51, 51));
        itemId.setText("Kode Makanan :");

        itemId1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemId1.setForeground(new java.awt.Color(51, 51, 51));
        itemId1.setText("Nama Makanan :");

        foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        itemId2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemId2.setForeground(new java.awt.Color(51, 51, 51));
        itemId2.setText("Stok");

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/minusIcon.png"))); // NOI18N
        pictureBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pictureBox1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pictureBox1MouseExited(evt);
            }
        });

        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/minusIcon.png"))); // NOI18N
        pictureBox1.add(pictureBox3);
        pictureBox3.setBounds(0, 0, 0, 0);

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/Tambah.png"))); // NOI18N
        pictureBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pictureBox2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pictureBox2MouseExited(evt);
            }
        });

        pictureBox4.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/editIcon.png"))); // NOI18N
        pictureBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pictureBox4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pictureBox4MouseExited(evt);
            }
        });

        pictureBox5.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/minusIcon.png"))); // NOI18N
        pictureBox4.add(pictureBox5);
        pictureBox5.setBounds(0, 0, 0, 0);

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemId)
                            .addComponent(itemId1)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemId2)
                            .addComponent(itemKode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(detail)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelShadow2Layout.createSequentialGroup()
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(itemName1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pictureBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(19, 19, 19))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(detail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(itemId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemKode, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(itemId1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemId2))
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(itemName1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pictureBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(pictureBox4, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        fbutton2.setText("Minuman");
        fbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbutton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62)
                        .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(title)
                    .addComponent(body)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbutton1ActionPerformed
        makanan();
        itemId.setText("Kode Makanan :");
        itemId1.setText("Nama Makanan :");
        itemId2.setText("Stok");
        itemKode.setText("");
        itemName.setText("");
        itemName1.setText("");
        foto.setIcon(null);
    }//GEN-LAST:event_fbutton1ActionPerformed

    private void fbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbutton2ActionPerformed
        minuman();
        itemId.setText("Kode Minuman :");
        itemId1.setText("Nama Minuman:");
        itemId2.setText("Stok");
        itemKode.setText("");
        itemName.setText("");
        itemName1.setText("");
        foto.setIcon(null);
    }//GEN-LAST:event_fbutton2ActionPerformed

    private void tabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabel1MouseEntered

    private void tabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel1MouseClicked
        int indexMakanan = tabel1.getSelectedRow();
        if (indexMakanan != -1) {
            String kode_menu = tabel1.getValueAt(indexMakanan, 0).toString();
            setData(kode_menu);
        }
        try {
            String namaMenu = (String) tabel1.getValueAt(tabel1.getSelectedRow(), 0);
            PreparedStatement ps = konek.GetConnection().prepareStatement("SELECT * FROM menu WHERE nama_menu = ?");
            ps.setString(1, namaMenu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                byte[] img = rs.getBytes("gambar");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myimg = im.getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myimg);
                foto.setIcon(newImage);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabel1MouseClicked

    private void pictureBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox2MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox2MouseEntered

    private void pictureBox2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox2MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox2MouseExited

    private void pictureBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox1MouseEntered

    private void pictureBox1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox1MouseExited

    private void pictureBox4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox4MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox4MouseEntered

    private void pictureBox4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox4MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox4MouseExited

    private void pictureBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox4MouseClicked
        edit = new editt();
        editmakanan();
        edit.setVisible(true);
        itemKode.setText("");
        itemName.setText("");
        itemName1.setText("");
        foto.setIcon(null);
    }//GEN-LAST:event_pictureBox4MouseClicked

    private void pictureBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseClicked
        String kode_menu = itemKode.getText();
        String nama_menu = itemName.getText();
        
        try {
            Statement st = konek.GetConnection().createStatement();
            st.executeUpdate("DELETE FROM menu WHERE kode_menu =('"+kode_menu+"') OR nama_menu = ('"+ nama_menu+"') ");
            JOptionPane.showMessageDialog(null, "Menu Berhasil Dihapus");
            itemKode.setText("");
            itemName.setText("");
            itemName1.setText("");
            foto.setIcon(null);
            
        } catch (Exception t) {
            JOptionPane.showMessageDialog(null, "Menu Gagal Dihapus");
        }
        makanan();
        minuman();
    }//GEN-LAST:event_pictureBox1MouseClicked

    private void pictureBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox2MouseClicked
        tambahmenu tamba = new tambahmenu();
        tamba.setVisible(true);
    }//GEN-LAST:event_pictureBox2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JLabel body;
    private javax.swing.JLabel detail;
    private com.button.Fbutton fbutton1;
    private com.button.Fbutton fbutton2;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel itemId;
    private javax.swing.JLabel itemId1;
    private javax.swing.JLabel itemId2;
    private javax.swing.JLabel itemKode;
    private javax.swing.JLabel itemName;
    private javax.swing.JLabel itemName1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private Shape.PanelShadow panelShadow1;
    private Shape.PanelShadow panelShadow2;
    private com.swing.PictureBox pictureBox1;
    private com.swing.PictureBox pictureBox2;
    private com.swing.PictureBox pictureBox3;
    private com.swing.PictureBox pictureBox4;
    private com.swing.PictureBox pictureBox5;
    private javax.swing.JTable tabel1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
