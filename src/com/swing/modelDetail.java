package com.swing;

import javax.swing.Icon;

public class modelDetail {

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public int getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(int ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getItemid() {
        return Itemid;
    }

    public void setItemid(String Itemid) {
        this.Itemid = Itemid;
    }

    public int getIdtrx() {
        return Idtrx;
    }

    public void setIdtrx(int Idtrx) {
        this.Idtrx = Idtrx;
    }

    public modelDetail(int Idtrx, String Itemid, String ItemName, Icon icon, int ItemPrice, int qty, int jumlah) {
        this.Idtrx = Idtrx;
        this.Itemid = Itemid;
        this.ItemName = ItemName;
        this.icon = icon;
        this.ItemPrice = ItemPrice;
        this.qty = qty;
        this.jumlah = jumlah;
    }


    private int Idtrx;
    private String Itemid;
    private String ItemName;
    private Icon icon;
    private int ItemPrice;
    private int qty;
    private int jumlah;
}
