package com.button;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Fbutton extends JButton{
    private boolean over;
    private Color fill;
    private int strokeWidth;
    
    private Color filloriginal;
    private Color fillOver;
    
    public Fbutton(){
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        filloriginal = new Color(0, 167, 157);
        fillOver = new Color(21, 144, 135);
        fill = filloriginal;
        strokeWidth = 2;
        setOpaque(false);
        setBorder(null);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBackground(filloriginal);
        setForeground(Color.WHITE);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseExited(MouseEvent e) {
                fill = filloriginal;
                over = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                fill = fillOver;
                over = true;
            }
        });
    }
    
        protected void paintComponent(Graphics g) {
        if (!isOpaque()) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int s = strokeWidth;
            int w = getWidth() - (2 * s);
            int h = getHeight() - (2 * s);
            //gambar background
            g2d.setColor(fill);
            g2d.fillRoundRect(s, s, w, h, h, h);
            g2d.drawRoundRect(s, s, w, h, h, h);
        }
        super.paintComponent(g);
    }
}
