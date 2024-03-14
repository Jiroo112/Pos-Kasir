package com.swing;

import com.raven.swing.WrapLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class PanelItem extends JPanel{
    public PanelItem(){
        setBackground(Color.white);
        setLayout(new WrapLayout(WrapLayout.LEFT, 10,10));
    }
}
