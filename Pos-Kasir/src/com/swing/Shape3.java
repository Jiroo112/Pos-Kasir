package com.swing;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Shape3 extends JPanel{
    public Shape3(){
        setOpaque(false);
    }
        public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }
    
    private int round= 70;
    
    @Override
    public void paint(Graphics grph){
        Graphics2D g2 = (Graphics2D) grph.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(0, 167, 157));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), round, round);
        g2.dispose();
        super.paint(grph);
    }
}
