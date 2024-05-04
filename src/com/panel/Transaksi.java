package com.panel;

import com.event.EventItem;
import com.main.Detail_transaksi;
import com.main.Karyawan;
import com.main.popUp_bayar;
import com.raven.swing.PanelItem;
import java.sql.ResultSet;
import java.sql.Statement;
import com.swing.ModelItem;
import com.swing.ScrollBar;
import com.swing.modelDetail;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import koneksi.konek;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Transaksi extends javax.swing.JPanel {
    
    private Detail_transaksi detail;
    private Karyawan home;
    private popUp_bayar bayar;

    public void setEvent(EventItem event) {
        this.event = event;
    }
    
    private EventItem event;
    private boolean click = false;
    

    public Transaksi() {
        initComponents();
        testData();
        testDetail();
        setLabeltrx();
        Scroll.setVerticalScrollBar(new ScrollBar());
        scroll2.setVerticalScrollBar(new ScrollBar());
        
    }
    
    


    public void AddItem(ModelItem data){
        Item item = new Item();
        item.setData(data);
        item.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me){
                if(SwingUtilities.isLeftMouseButton(me)){
                    event.itemClick(item, data);
                }
            }
        });
        panelItem1.add(item);
        panelItem1.repaint();
        panelItem1.revalidate();
    }
    
    public void refresh1(){
        panelItem2.removeAll();
        panelItem2.repaint();
        panelItem2.revalidate();
        total.setText("");
        jumlah.setText("");
    }
    
    public void delItem(detailItem detail, modelDetail detail2) {
        panelItem2.remove(detail);
        panelItem2.repaint();
        panelItem2.revalidate();
        System.out.println(detail2.getIdtrx());
        try {
            Statement st = konek.GetConnection().createStatement();
            st.executeUpdate("DELETE FROM detail_transaksi WHERE id_pembelian = '"+detail2.getIdtrx()+"'");
            JOptionPane.showMessageDialog(this, "data dihapus");
        } catch (Exception e) {
        }
    
    }
    
    public void jumlah(){
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(jumlah) AS jumlah FROM struk_penjualan WHERE kode_transaksi ='"+trx.getText()+"' ");
            rs.next();
            DecimalFormat q = new DecimalFormat("");
            jumlah.setText(q.format(rs.getInt("jumlah")));
        } catch (Exception e) {
        }
    }
    
    public void scanner(){
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT username FROM riwayat_login ORDER BY id_riwayat DESC LIMIT 1");
            while(rs.next()){
                user.setText(rs.getString("username"));
            }
        } catch (Exception e) {
        }
    }
    
    public void simpan(){
        String username = user.getText();
        String id = trx.getText();
        try {
            Statement st = konek.GetConnection().createStatement();
            st.executeUpdate("UPDATE transaksi SET username ");
        } catch (Exception e) {
        }
    }
    
    public void total(){
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(subtotal) AS total FROM struk_penjualan WHERE kode_transaksi = '"+trx.getText()+"' ");
            rs.next();
            DecimalFormat q = new DecimalFormat("");
            total.setText(String.valueOf(rs.getInt("total")));
        } catch (Exception e) {
            
        }
    }
    
    public void AddDetail(modelDetail detail){
        detailItem Ditem = new detailItem();
        Ditem.setData(detail);
        Ditem.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                if(SwingUtilities.isLeftMouseButton(me)){
                    click = true;
                    System.out.println(detail.getIdtrx());
                    delItem(Ditem, detail);
                }
            }
        });

        panelItem2.add(Ditem);
        panelItem2.repaint();
        panelItem2.revalidate();
    }
    
    public void testDetail(){
        setLabeltrx();
        System.out.println(trx.getText());
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT id_pembelian, kode_menu, nama_menu, gambar, harga, jumlah, subtotal FROM struk_penjualan WHERE kode_transaksi = '"+trx.getText()+"'");
            while(rs.next()){
                AddDetail(new modelDetail(rs.getInt("id_pembelian"),rs.getString("kode_menu"), rs.getString("nama_menu"), new ImageIcon(rs.getBytes("gambar")), rs.getInt("harga"), rs.getInt("jumlah"), rs.getInt("subtotal")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    
    public void testData(){
        
        setEvent(new EventItem(){
            @Override
            public void itemClick(Component com, ModelItem item) {
                //System.out.println(item.getItemID());
                setSelected(com);
                try {
                    Statement st = konek.GetConnection().createStatement();
                    ResultSet rs = st.executeQuery("SELECT stok FROM menu WHERE kode_menu= '"+item.getItemID()+"' ;");
                    if(rs.next()){
                        int stok = rs.getInt("stok");
                        if(stok!=0){
                            if(detail!=null){
                                detail.dispose();
                            }
                            detail = new Detail_transaksi();
                            detail.setVisible(true);
                            detail.setKode_makanan(item.getItemID());
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Stok sudah habis");
                        }
                    }
                    
                } catch (Exception e) {
                }
            }
            
        });
     
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT kode_menu, nama_menu, harga, gambar FROM menu");
            while(rs.next()){
                AddItem(new ModelItem(rs.getString("kode_menu"), rs.getString("nama_menu"), rs.getInt("harga"), new ImageIcon(rs.getBytes("gambar"))));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }
    
    public void setSelected(Component item) {
        for (Component com : panelItem1.getComponents()) {
            Item i = (Item) com;
            if (i.isSelected()) {
                i.setSelected(false);
            }
        }
        ((Item) item).setSelected(true);
    }
    public void date(){
        Timer t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date();
                SimpleDateFormat st = new SimpleDateFormat("hh:MM:ss a");
                
                String tanggal = st.format(dt);
                date.setText(tanggal);
            }
        });
        t.start();
    }
 
    public void setInvoice(){
        String no_transaksi;
        Date tgl_transaksi = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(kode_transaksi) AS invoice FROM transaksi");
            rs.next();
            rs.getString("invoice");
            if(rs.getString("invoice")==null){
                no_transaksi = ("T-001");
                try {
                    Statement dt = konek.GetConnection().createStatement();
                    dt.executeUpdate("INSERT INTO transaksi(kode_transaksi, tgl_transaksi) VALUES ('"+no_transaksi+"','"+dateformat.format(tgl_transaksi)+"')");
                    dt.close();
                } catch (Exception e) {
                }
            }
            
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void setLabeltrx(){
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(kode_transaksi) AS invoice FROM transaksi");
            while(rs.next()){
                trx.setText(rs.getString("invoice"));
            }
        } catch (Exception e) {
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Scroll = new javax.swing.JScrollPane();
        panelItem1 = new com.swing.PanelItem();
        usrndate = new com.swing.Shape();
        user = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        detailtrx = new com.swing.Shape();
        jLabel2 = new javax.swing.JLabel();
        trx = new javax.swing.JLabel();
        background1 = new com.swing.background();
        scroll2 = new javax.swing.JScrollPane();
        panelItem2 = new com.swing.PanelItem();
        shape2 = new com.swing.Shape();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jumlah = new javax.swing.JLabel();
        pictureBox2 = new com.swing.PictureBox();

        setBackground(new java.awt.Color(255, 255, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        Scroll.setBorder(null);
        Scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scroll.setViewportView(panelItem1);

        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setText("Username");

        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText("2023-07-12");

        javax.swing.GroupLayout usrndateLayout = new javax.swing.GroupLayout(usrndate);
        usrndate.setLayout(usrndateLayout);
        usrndateLayout.setHorizontalGroup(
            usrndateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usrndateLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(date)
                .addContainerGap())
        );
        usrndateLayout.setVerticalGroup(
            usrndateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usrndateLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(usrndateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user)
                    .addComponent(date))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pesanan ke :");

        trx.setForeground(new java.awt.Color(255, 255, 255));
        trx.setText("trx");

        scroll2.setBackground(new java.awt.Color(255, 255, 255));
        scroll2.setBorder(null);
        scroll2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll2.setViewportView(panelItem2);

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll2)
                .addContainerGap())
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout detailtrxLayout = new javax.swing.GroupLayout(detailtrx);
        detailtrx.setLayout(detailtrxLayout);
        detailtrxLayout.setHorizontalGroup(
            detailtrxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailtrxLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(detailtrxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(detailtrxLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trx, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        detailtrxLayout.setVerticalGroup(
            detailtrxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailtrxLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(detailtrxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jumlah :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total  :");

        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("Rp 10.000");

        jumlah.setForeground(new java.awt.Color(255, 255, 255));
        jumlah.setText("3");

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/cart_1.png"))); // NOI18N
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

        javax.swing.GroupLayout shape2Layout = new javax.swing.GroupLayout(shape2);
        shape2.setLayout(shape2Layout);
        shape2Layout.setHorizontalGroup(
            shape2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shape2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jumlah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shape2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        shape2Layout.setVerticalGroup(
            shape2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shape2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(shape2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(total)
                    .addComponent(jumlah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usrndate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailtrx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shape2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usrndate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailtrx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shape2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void pictureBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox2MouseClicked
        bayar = new popUp_bayar();
        bayar.setVisible(true);
        bayar.setIdtrx(trx.getText());
        bayar.setUsername(user.getText());
        bayar.setSubtotal(total.getText());
    }//GEN-LAST:event_pictureBox2MouseClicked

    private void pictureBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox2MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox2MouseEntered

    private void pictureBox2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox2MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox2MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scroll;
    private com.swing.background background1;
    private javax.swing.JLabel date;
    private com.swing.Shape detailtrx;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jumlah;
    private com.swing.PanelItem panelItem1;
    private com.swing.PanelItem panelItem2;
    private com.swing.PictureBox pictureBox2;
    private javax.swing.JScrollPane scroll2;
    private com.swing.Shape shape2;
    private javax.swing.JLabel total;
    private javax.swing.JLabel trx;
    private javax.swing.JLabel user;
    private com.swing.Shape usrndate;
    // End of variables declaration//GEN-END:variables

    public void add(ModelItem modelItem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
