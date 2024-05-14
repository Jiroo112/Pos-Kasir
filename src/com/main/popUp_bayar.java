package com.main;

import com.panel.Transaksi;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import koneksi.konek;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class popUp_bayar extends javax.swing.JFrame {


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getIdtrx() {
        return idtrx;
    }

    public void setIdtrx(String idtrx) {
        this.idtrx = idtrx;
    }
    
    private String idtrx;
    private String username;
    private String subtotal;
    private popUp_berhasil done;
    private Transaksi main;

    public popUp_bayar() {
        initComponents();
        done = new popUp_berhasil();
        setBackground(new Color(0, 0, 0, 0));
        documentListener();
    }
    
    
    public void documentListener(){
        pembayaran.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                kembalian();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                kembalian();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                kembalian();
            }
        });
    }
    public void kembalian(){
        int bayar = 0;
        int subtotal =0;
        
        try{
            if(pembayaran.getText().equals("")){
                bayar = 0;
            }
            else{
                bayar = Integer.parseInt(pembayaran.getText());
                subtotal = Integer.parseInt(getSubtotal());
            }
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Mohon diisi dengan angka!!");
        }
        
        int jumlah = bayar - subtotal;
        kembali.setText(String.valueOf(jumlah));
    }
    
    public void simpan(){
        
        String username = getUsername();
        String id = getIdtrx();
        int bayar = Integer.parseInt(pembayaran.getText());
        int subtotal = Integer.parseInt(getSubtotal());
        int jumlah = Integer.parseInt(kembali.getText());
        if(bayar<subtotal){
            JOptionPane.showMessageDialog(null, "Pembayaran Kurang");
        }
        else{
            try {
                Statement st = konek.GetConnection().createStatement();
                st.executeUpdate("UPDATE transaksi SET username = '"+username+"', total = '"+subtotal+"', bayar = '"+bayar+"', kembalian = '"+jumlah+"' WHERE kode_transaksi = '"+id+"'");
                invoice();
                done.setVisible(true);
                report();
                System.out.println("berhasil");
                this.dispose();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    public void invoice(){
        String no_transaksi;
        Date tgl_transaksi = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(kode_transaksi) AS invoice FROM transaksi");
            rs.next();
            long id = Long.parseLong(rs.getString("invoice").substring(2, rs.getString("invoice").length()));
                id++;
                no_transaksi = ("T-" + String.format("%03d", id));
                try {
                    Statement dt = konek.GetConnection().createStatement();
                    dt.executeUpdate("INSERT INTO transaksi(kode_transaksi, tgl_transaksi) VALUES ('"+no_transaksi+"','"+dateformat.format(tgl_transaksi)+"')");
                    dt.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
        } catch (Exception e) {
            
        }
    }
    
    public void report(){
        try {
            String report = ("C:\\Users\\ok\\Documents\\NetBeansProjects\\Post-Test\\src\\com\\report\\struk.jrxml");
            Connection koneksi = konek.GetConnection();
            HashMap hash = new HashMap();
            JasperReport Jrp = JasperCompileManager.compileReport(report);
            JasperPrint pr = JasperFillManager.fillReport(Jrp, hash,koneksi);
            JasperViewer.viewReport(pr,false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shape1 = new com.swing.Shape();
        background21 = new com.swing.background2();
        pictureBox1 = new com.swing.PictureBox();
        jLabel1 = new javax.swing.JLabel();
        pembayaran = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        kembali = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        fbutton1 = new com.button.Fbutton();
        bayar = new com.button.Fbutton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/RawLogo.png"))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Bayar :");

        pembayaran.setBackground(new java.awt.Color(255, 255, 255));
        pembayaran.setForeground(new java.awt.Color(0, 0, 0));
        pembayaran.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pembayaran.setBorder(null);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Kembalian :");

        kembali.setForeground(new java.awt.Color(0, 0, 0));
        kembali.setText("0");

        fbutton1.setText("Batal");
        fbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbutton1ActionPerformed(evt);
            }
        });

        bayar.setText("Bayar");
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background21Layout = new javax.swing.GroupLayout(background21);
        background21.setLayout(background21Layout);
        background21Layout.setHorizontalGroup(
            background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background21Layout.createSequentialGroup()
                .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background21Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(background21Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pembayaran)
                            .addComponent(jSeparator1)
                            .addComponent(kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addGroup(background21Layout.createSequentialGroup()
                                .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(background21Layout.createSequentialGroup()
                                .addComponent(fbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        background21Layout.setVerticalGroup(
            background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kembali)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(background21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout shape1Layout = new javax.swing.GroupLayout(shape1);
        shape1.setLayout(shape1Layout);
        shape1Layout.setHorizontalGroup(
            shape1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shape1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        shape1Layout.setVerticalGroup(
            shape1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shape1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        simpan();
    }//GEN-LAST:event_bayarActionPerformed

    private void fbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbutton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_fbutton1ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
 
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(popUp_bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popUp_bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popUp_bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popUp_bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popUp_bayar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.background2 background21;
    private com.button.Fbutton bayar;
    private com.button.Fbutton fbutton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel kembali;
    private javax.swing.JTextField pembayaran;
    private com.swing.PictureBox pictureBox1;
    private com.swing.Shape shape1;
    // End of variables declaration//GEN-END:variables
}
