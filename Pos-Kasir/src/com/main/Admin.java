package com.main;

import com.panel.DataMenu;
import com.panel.GrafikBaru;
import com.panel.Greeting;
import com.panel.Keuntungan;
import com.panel.editt;
import com.panel.Registrasi;
import com.panel.tambahmenu;
import com.panel.DataKaryawan;
import com.panel.belanja;
import com.panel.data_menu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Ferdi
 */
public class Admin extends javax.swing.JFrame {

    private data_menu damen;
    private Keuntungan keuntungan;
   // private GrafikBaru grafik;
    private editt edit;
    private tambahmenu tambah;
    private Greeting greet;
    private Registrasi regist;
    private DataKaryawan daker;
    private belanja belanja_harian;
    public Admin() {
       initComponents();
        setBackground(new Color(0, 0, 0, 0));
        tampilan1.event(this, background1);
        init();
    }
  public void init(){
       damen = new data_menu();
       keuntungan = new Keuntungan();
       //grafik = new GrafikBaru();
       edit = new editt();
       tambah = new tambahmenu();
       greet = new Greeting();
       regist = new Registrasi();
       daker = new DataKaryawan();
       belanja_harian = new belanja();
       
       mainPanel.setLayout(new BorderLayout());
       mainPanel.add(damen);
       
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
        pictureBox2 = new com.swing.PictureBox();
        pictureBox3 = new com.swing.PictureBox();
        pictureBox4 = new com.swing.PictureBox();
        pictureBox5 = new com.swing.PictureBox();
        belanja = new com.swing.PictureBox();
        logout = new com.swing.PictureBox();
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

        belanja.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/Belanja (2).png"))); // NOI18N
        belanja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                belanjaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                belanjaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                belanjaMouseExited(evt);
            }
        });

        logout.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/logout.png"))); // NOI18N
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout shape41Layout = new javax.swing.GroupLayout(shape41);
        shape41.setLayout(shape41Layout);
        shape41Layout.setHorizontalGroup(
            shape41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shape41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(shape41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(shape41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(shape41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pictureBox5, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(pictureBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(pictureBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(pictureBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(belanja, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        shape41Layout.setVerticalGroup(
            shape41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shape41Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(pictureBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(belanja, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pictureBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(shape41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
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
        belanja_harian.usr();
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
        //showForm(grafik);
        //grafik.updateChart();
    }//GEN-LAST:event_pictureBox4MouseClicked

    private void pictureBox4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox4MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox4MouseEntered

    private void pictureBox4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox4MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox4MouseExited

    private void pictureBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox5MouseClicked
        showForm(keuntungan);
    }//GEN-LAST:event_pictureBox5MouseClicked

    private void pictureBox5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox5MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox5MouseEntered

    private void pictureBox5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pictureBox5MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
    }//GEN-LAST:event_pictureBox5MouseExited

    private void belanjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_belanjaMouseClicked
        // TODO add your handling code here:
        showForm(belanja_harian);
    }//GEN-LAST:event_belanjaMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?");
        if (result == JOptionPane.YES_OPTION) {
            login log = new login();
            log.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Batal keluar");
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void belanjaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_belanjaMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_belanjaMouseEntered

    private void belanjaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_belanjaMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
    }//GEN-LAST:event_belanjaMouseExited

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR) {
        });
    }//GEN-LAST:event_logoutMouseExited

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
                if ("Nimbus".equals(info.getName())) {
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
    private com.swing.PictureBox belanja;
    private com.swing.PictureBox logout;
    public static final com.swing.MainPanel mainPanel = new com.swing.MainPanel();
    private com.swing.PictureBox pictureBox2;
    private com.swing.PictureBox pictureBox3;
    private com.swing.PictureBox pictureBox4;
    private com.swing.PictureBox pictureBox5;
    private com.swing.Shape4 shape41;
    private com.button.Tampilan tampilan1;
    // End of variables declaration//GEN-END:variables
}
