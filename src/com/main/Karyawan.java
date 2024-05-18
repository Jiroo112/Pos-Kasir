package com.main;

import com.panel.Transaksi;
import com.panel.riwayat;
import com.swing.ModelItem;
import com.swing.modelDetail;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import koneksi.konek;

public class Karyawan extends javax.swing.JFrame {
    
    private Transaksi main;
    private popUp_bayar bayar;
    private riwayat riwayat_transaksi;
    private tanggal_riwayat tanggal;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    private String data;
    private int myInteger;
    private int oldValue = 0;
    private String oldCode;
    private String newCode;

    public Karyawan() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        tampilan1.event(this, background1);
        init();
    }
    
    
    public void init(){
       main = new Transaksi();
       mainPanel.setLayout(new BorderLayout());
       mainPanel.add(main);
       riwayat_transaksi = new riwayat();
    }
    
    public void showForm(Component com){
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    
    public void setMyInteger(int Value, int Value2){
        oldValue = myInteger;
        if(myInteger == 0){
            oldValue = Value2;
        }
        else{
            oldValue = myInteger;
        }
        myInteger = Value;
    }
    public void setId(String id, String id2){
        if(newCode==null){
            oldCode = id2;
        }
        else{
            oldCode = newCode;
        }
        newCode = id;
    }
    
    public void newInt(){
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(id_pembelian) AS id FROM detail_transaksi");
            while(rs.next()){
                setMyInteger(rs.getInt("id"), rs.getInt("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    
    public void kondisi(){
        newInt();
        if(myInteger>oldValue){
            detail();
        }
    }
    public void kondisi2(){
        delDetail();
        System.out.println(oldCode);
        System.out.println(newCode);
        System.out.println(myInteger);
        System.out.println(oldValue);
        if(!oldCode.equals(newCode)){
            main.refresh1();
        }
    }
    public void delDetail(){
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(kode_transaksi) AS invoice FROM transaksi");
            rs.next();
            setId(rs.getString("invoice"), rs.getString("invoice"));
            
        } catch (SQLException e) {
            e.getMessage();
        }
    }
    public void detail(){
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT id_pembelian, kode_menu, nama_menu, gambar, harga, jumlah, subtotal FROM struk_penjualan WHERE kode_transaksi = (SELECT MAX(kode_transaksi) FROM struk_penjualan) ORDER BY id_pembelian DESC LIMIT 1");
            while(rs.next()){
                main.AddDetail(new modelDetail(rs.getInt("id_pembelian"),rs.getString("kode_menu"), rs.getString("nama_menu"), new ImageIcon(rs.getBytes("gambar")), rs.getInt("harga"), rs.getInt("jumlah"), rs.getInt("subtotal")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        background1 = new com.swing.background();
        Dasboard = new javax.swing.JPanel();
        shape41 = new com.swing.Shape4();
        pictureBox1 = new com.swing.PictureBox();
        riwayat = new com.swing.PictureBox();
        Header = new javax.swing.JPanel();
        tampilan1 = new com.button.Tampilan();
        mainPanel = new com.swing.MainPanel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Dasboard.setOpaque(false);

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/buyIcon.png"))); // NOI18N
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

        riwayat.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/(2)riwayat.png"))); // NOI18N
        riwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                riwayatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout shape41Layout = new javax.swing.GroupLayout(shape41);
        shape41.setLayout(shape41Layout);
        shape41Layout.setHorizontalGroup(
            shape41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shape41Layout.createSequentialGroup()
                .addGroup(shape41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(riwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        shape41Layout.setVerticalGroup(
            shape41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shape41Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(riwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DasboardLayout = new javax.swing.GroupLayout(Dasboard);
        Dasboard.setLayout(DasboardLayout);
        DasboardLayout.setHorizontalGroup(
            DasboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shape41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DasboardLayout.setVerticalGroup(
            DasboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DasboardLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(shape41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(201, 201, 201))
        );

        Header.setOpaque(false);

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(1002, Short.MAX_VALUE)
                .addComponent(tampilan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tampilan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1062, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(Dasboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dasboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        main.setInvoice();
        //main.testDetail();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        main.date();
        main.jumlah();
        main.total();
        kondisi();
        kondisi2();
        main.scanner();
        main.setLabeltrx();
    }//GEN-LAST:event_formWindowActivated

    private void pictureBox1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox1MouseExited

    private void pictureBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox1MouseEntered

    private void pictureBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseClicked

        showForm(main);
        System.out.println("switch");
    }//GEN-LAST:event_pictureBox1MouseClicked

    private void riwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_riwayatMouseClicked
        // TODO add your handling code here:
        showForm(riwayat_transaksi);
    }//GEN-LAST:event_riwayatMouseClicked

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
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dasboard;
    private javax.swing.JPanel Header;
    private com.swing.background background1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private com.swing.MainPanel mainPanel;
    private com.swing.PictureBox pictureBox1;
    private com.swing.PictureBox riwayat;
    private com.swing.Shape4 shape41;
    private com.button.Tampilan tampilan1;
    // End of variables declaration//GEN-END:variables
}
