package com.main;

//import com.panel.lupaterus;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.konek;

/**
 *
 * @author oser
 */
public class login extends javax.swing.JFrame {
    
    private scanrfid rfid;
    
    public login() {
        rfid = new scanrfid(this);
        initComponents();
        font();
        setBackground(new Color(0, 0, 0, 0));
        close1.event(rfid, background23);
    }
    public void font(){
        try {
            File fontStyle  = new File("src/com/font/Louis George Cafe Bold.ttf");
            File fontStyle2  = new File("src/com/font/Louis George Cafe Italic.ttf");
            File fontStyle3  = new File("src/com/font/Louis George Cafe.ttf");
            File fontStyle4  = new File("src/com/font/Louis George Cafe.ttf");
            File fontStyle5  = new File("src/com/font/Louis George Cafe Bold.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(55f);
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle2).deriveFont(16f);
            Font font3 = Font.createFont(Font.TRUETYPE_FONT, fontStyle3).deriveFont(12f);
            Font font4 = Font.createFont(Font.TRUETYPE_FONT, fontStyle4).deriveFont(16f);
            Font font5 = Font.createFont(Font.TRUETYPE_FONT, fontStyle5).deriveFont(14f);
            title.setFont(font);
            body.setFont(font2);
            fbutton1.setFont(font4);
            fbutton2.setFont(font4);
            label.setFont(font5);
            label1.setFont(font5);
            label2.setFont(font3);
            label3.setFont(font3);
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

        background23 = new com.swing.background2();
        body = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jname = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        jpw = new javax.swing.JPasswordField();
        label2 = new javax.swing.JCheckBox();
        label3 = new javax.swing.JLabel();
        fbutton1 = new com.button.Fbutton();
        fbutton2 = new com.button.Fbutton();
        title = new javax.swing.JLabel();
        pictureBox1 = new com.swing.PictureBox();
        close1 = new com.button.Close();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        body.setFont(new java.awt.Font("Kozuka Gothic Pro L", 1, 14)); // NOI18N
        body.setText("Mohon Masukkan Username dan Password Anda");

        label.setFont(new java.awt.Font("Kozuka Gothic Pro L", 1, 14)); // NOI18N
        label.setText("Username :");

        jname.setBackground(new java.awt.Color(115, 206, 191));
        jname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jname.setToolTipText("");

        label1.setFont(new java.awt.Font("Kozuka Gothic Pro L", 1, 14)); // NOI18N
        label1.setText("Password :");

        jpw.setBackground(new java.awt.Color(115, 206, 191));
        jpw.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jpw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jpwKeyTyped(evt);
            }
        });

        label2.setBackground(new java.awt.Color(255, 255, 255));
        label2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label2.setText("Tampilkan Password");
        label2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label2ActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Kozuka Gothic Pro L", 1, 12)); // NOI18N
        label3.setText("Lupa Password?");
        label3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label3MouseClicked(evt);
            }
        });

        fbutton1.setText("Login");
        fbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbutton1ActionPerformed(evt);
            }
        });

        fbutton2.setText("Scan RFID");
        fbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbutton2ActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        title.setForeground(new java.awt.Color(0, 153, 153));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Selamat Datang");
        title.setToolTipText("");

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/low.png"))); // NOI18N
        pictureBox1.add(close1);
        close1.setBounds(400, 0, 70, 30);

        javax.swing.GroupLayout background23Layout = new javax.swing.GroupLayout(background23);
        background23.setLayout(background23Layout);
        background23Layout.setHorizontalGroup(
            background23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background23Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(background23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background23Layout.createSequentialGroup()
                        .addGroup(background23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(body))
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background23Layout.createSequentialGroup()
                        .addGroup(background23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpw)
                            .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label)
                            .addComponent(label1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background23Layout.createSequentialGroup()
                                .addComponent(label2)
                                .addGap(8, 8, 8)))
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background23Layout.createSequentialGroup()
                        .addGroup(background23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fbutton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background23Layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );
        background23Layout.setVerticalGroup(
            background23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background23Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body)
                .addGap(32, 32, 32)
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpw, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label3)
                .addGap(37, 37, 37)
                .addComponent(fbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(background23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jpwKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpwKeyTyped
        // TODO add your handling code here:
        String password = jpw.getText();
        if (password.length() < 8 ) {
        }
    }//GEN-LAST:event_jpwKeyTyped

    private void label2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label2ActionPerformed
        // TODO add your handling code here:
        if (label2.isSelected()){
            jpw.setEchoChar((char)0);
        }
        else{
            jpw.setEchoChar('*');
        }
    }//GEN-LAST:event_label2ActionPerformed

    private void fbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbutton1ActionPerformed
        // TODO add your handling code here:
        String id = jname.getText();
        String pw = jpw.getText();

        try {
        Connection conn = konek.GetConnection();
        PreparedStatement st = conn.prepareStatement("SELECT username, password, jabatan FROM data_karyawan WHERE username=? AND password=?");
        st.setString(1, id);
        st.setString(2, pw);
        ResultSet rs1 = st.executeQuery();
            if(rs1.next()){
                String jabatan = rs1.getString("jabatan");
                if(jabatan.equals("Admin")){
                    this.setVisible(false);
                    Admin dashboard_admin = new Admin();
                    dashboard_admin.setVisible(true);
                    this.dispose();

                }
                else{
                    Karyawan dashboard_karyawan = new Karyawan();
                    dashboard_karyawan.setVisible(true);
                    this.dispose();
                }  
               } else {
                JOptionPane.showMessageDialog(null, "Username/Password salah","Message",JOptionPane.ERROR_MESSAGE);
               }     
            // Insert into riwayat_login
               PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO riwayat_login (username) VALUES (?)");
               insertStmt.setString(1, id);
               insertStmt.executeUpdate();

            // Menutup sumber daya
               rs1.close();
               st.close();
               insertStmt.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_fbutton1ActionPerformed

    private void fbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbutton2ActionPerformed
        rfid.setVisible(true);
    }//GEN-LAST:event_fbutton2ActionPerformed

    private void label3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label3MouseClicked
        // TODO add your handling code here:
        //lupaterus lp = new lupaterus();
        //lp.setVisible(true);
    }//GEN-LAST:event_label3MouseClicked

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
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.background2 background23;
    private javax.swing.JLabel body;
    private com.button.Close close1;
    private com.button.Fbutton fbutton1;
    private com.button.Fbutton fbutton2;
    private javax.swing.JTextField jname;
    private javax.swing.JPasswordField jpw;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JCheckBox label2;
    private javax.swing.JLabel label3;
    private com.swing.PictureBox pictureBox1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}