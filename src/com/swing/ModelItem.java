package com.swing;

import javax.swing.Icon;

public class ModelItem {

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int ItemID) {
        this.ItemID = ItemID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public ModelItem(int ItemID, String ItemName, double harga, Icon icon) {
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.harga = harga;
        this.icon = icon;
    }
    
    private int ItemID;
    private String ItemName;
    private double harga;
    private Icon icon;
}
