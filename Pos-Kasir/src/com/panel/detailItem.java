package com.panel;

import com.swing.modelDetail;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;

public class detailItem extends javax.swing.JPanel {

    public detailItem() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public modelDetail getDetail() {
        return detail;
    }
    
    public void setData(modelDetail detail){
        this.detail = detail;
        picture.setImage(detail.getIcon());
        name.setText(detail.getItemName());
        DecimalFormat q = new DecimalFormat("");
        qty.setText(q.format(detail.getQty()));
        DecimalFormat p = new DecimalFormat("Rp");
        price.setText(p.format(detail.getItemPrice()));
    }
    
    public modelDetail detail;
    
    public void paint(Graphics graph){
        Graphics2D g2 = (Graphics2D) graph.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(0, 167, 157));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
        super.paint(graph);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        picture = new com.swing.PictureBox();
        name = new javax.swing.JLabel();
        qty = new javax.swing.JLabel();
        price = new javax.swing.JLabel();

        picture.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/picture/image1.png"))); // NOI18N

        name.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Nasi Lalapan 8");

        qty.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        qty.setForeground(new java.awt.Color(255, 255, 255));
        qty.setText("x1");

        price.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        price.setForeground(new java.awt.Color(255, 255, 255));
        price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        price.setText("Rp.3000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(qty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(picture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel name;
    private com.swing.PictureBox picture;
    private javax.swing.JLabel price;
    private javax.swing.JLabel qty;
    // End of variables declaration//GEN-END:variables
}
