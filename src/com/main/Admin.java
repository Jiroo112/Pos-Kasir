package com.main;

import com.panel.DataMenu;
import com.panel.GrafikBaru;
import com.panel.Greeting;
import com.panel.Keuntungan;
import com.panel.editt;
import com.panel.Registrasi;
import com.panel.tambahmenu;
import com.panel.DataKaryawan;
import com.panel.data_menu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.io.File;

/**
 *
 * @author Ferdi
 */
public class Admin extends javax.swing.JFrame {

    private data_menu damen;
    private Keuntungan keuntungan;
    private GrafikBaru grafik;
    private editt edit;
    private tambahmenu tambah;
    private Greeting greet;
    private Registrasi regist;
    private DataKaryawan daker;
    public Admin() {
       initComponents();
        setBackground(new Color(0, 0, 0, 0));
        tampilan1.event(this, background1);
        init();
    }
  public void init(){
       damen = new data_menu();
       keuntungan = new Keuntungan();
       grafik = new GrafikBaru();
       edit = new editt();
       tambah = new tambahmenu();
       greet = new Greeting();
       regist = new Registrasi();
       daker = new DataKaryawan();
       
       mainPanel.setLayout(new BorderLayout());
       mainPanel.add(greet);
       
    }
  
  
    public void showForm(Component com){
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.swing.background();
        Dasboard = new javax.swing.JPanel();
        shape41 = new com.swing.Shape4();
        pictureBox1 = new com.swing.PictureBox();
        pictureBox2 = new com.swing.PictureBox();
        pictureBox3 = new com.swing.PictureBox();
        pictureBox4 = new com.swing.PictureBox();
        pictureBox5 = new com.swing.PictureBox();
        Header = new javax.swing.JPanel();
        tampilan1 = new com.button.Tampilan();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Dasboard.setOpaque(false);

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/Home [6499DE3].png"))); // NOI18N
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

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/Data menu [119D483].png"))); // NOI18N
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

        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/Employees data [7E4DA5E].png"))); // NOI18N
        pictureBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pictureBox3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pictureBox3MouseExited(evt);
            }
        });

        pictureBox4.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/Candle [0191BE5].png"))); // NOI18N
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

        pictureBox5.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/Report [48CFCAF].png"))); // NOI18N
        pictureBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pictureBox5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pictureBox5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pictureBox5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout shape41Layout = new javax.swing.GroupLayout(shape41);
        shape41.setLayout(shape41Layout);
        shape41Layout.setHorizontalGroup(
            shape41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shape41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(shape41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pictureBox5, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, shape41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(pictureBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(pictureBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                    .addComponent(pictureBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        shape41Layout.setVerticalGroup(
            shape41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shape41Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pictureBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(pictureBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(shape41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );

        Header.setOpaque(false);

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(1027, Short.MAX_VALUE)
                .addComponent(tampilan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tampilan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1087, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
//        damen.minuman();
//        damen.makanan();
    }//GEN-LAST:event_formWindowActivated

    private void pictureBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox2MouseClicked
        showForm(damen);
    }//GEN-LAST:event_pictureBox2MouseClicked

    private void pictureBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox2MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox2MouseEntered

    private void pictureBox2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox2MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox2MouseExited

    private void pictureBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pictureBox1MouseClicked

    private void pictureBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox1MouseEntered

    private void pictureBox1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox1MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox1MouseExited

    private void pictureBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox3MouseClicked
        showForm(daker);
    }//GEN-LAST:event_pictureBox3MouseClicked

    private void pictureBox3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox3MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox3MouseEntered

    private void pictureBox3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox3MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox3MouseExited

    private void pictureBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox4MouseClicked
        showForm(grafik);
        grafik.updateChart();
    }//GEN-LAST:event_pictureBox4MouseClicked

    private void pictureBox4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pictureBox4MouseEntered

    private void pictureBox4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_pictureBox4MouseExited

    private void pictureBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox5MouseClicked
        showForm(keuntungan);
    }//GEN-LAST:event_pictureBox5MouseClicked

    private void pictureBox5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pictureBox5MouseEntered

    private void pictureBox5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_pictureBox5MouseExited

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
                if ("Default".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dasboard;
    private javax.swing.JPanel Header;
    private com.swing.background background1;
    public static final com.swing.MainPanel mainPanel = new com.swing.MainPanel();
    private com.swing.PictureBox pictureBox1;
    private com.swing.PictureBox pictureBox2;
    private com.swing.PictureBox pictureBox3;
    private com.swing.PictureBox pictureBox4;
    private com.swing.PictureBox pictureBox5;
    private com.swing.Shape4 shape41;
    private com.button.Tampilan tampilan1;
    // End of variables declaration//GEN-END:variables
}
