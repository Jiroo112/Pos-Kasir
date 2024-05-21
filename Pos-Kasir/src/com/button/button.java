package com.button;

import javax.swing.JButton;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class button extends JButton{
    public button(){
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(6, 6, 6, 6));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    @Override
    public void paint(Graphics graph){
        Graphics2D g2 = (Graphics2D) graph.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        int x = (width-size)/2;
        int y = (height-size)/2;
        g2.setColor(getBackground());
        g2.fillOval(x, y, size, size);
        super.paint(graph);
    }
}
