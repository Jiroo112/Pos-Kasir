/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.buttonOnTable;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ASUS
 */
public class TableActionCellRenderer extends DefaultTableCellRenderer{
    
    public TableActionCellRenderer(){
        setVerticalAlignment(SwingConstants.CENTER);
    }
  
    @Override
    public Component getTableCellRendererComponent (JTable jtable, Object o, boolean isSelected, boolean bln1, int row, int column){
       Component com =super.getTableCellRendererComponent(jtable, o, isSelected, bln1, row, column);
       
        PanelAction action = new PanelAction();
        if(isSelected==false && row % 2== 0){
            action.setBackground(com.getBackground());
        }else{
            action.setBackground(com.getBackground());
        }
        
       return action;
    }
            
}
