
package com.panel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import koneksi.konek;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import com.buttonOnTable.TableActionCellEditor;
import com.buttonOnTable.TableActionCellRenderer;
import com.buttonOnTable.TableActionEvent;
import com.main.editBelanja;
import static com.panel.DataMenu.makanan;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

/**
 *
 * @author ASUS
 */
public class belanja extends javax.swing.JPanel {

    private Component rootPane;
    
    private editBelanja edit;
    

    /**
     * Creates new form riwayat
     */
    public belanja() {
        initComponents();
        data_table();
        usr();
        setTableAction();
        TableHeader();
    
        //getContentPane().setBackground(new Color(240, 240, 240));
        dateChooser1.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser1.hidePopup();
                }} 
        });
    }
    
        
    
        private String nama;
        public void setNama(String usr){
        String strnama = usr;
        this.nama = strnama;
        
        if(usr != null && !usr.isEmpty()){
            this.nama = usr;
        }
        }
        public void usr(){
        if(nama==null || nama.isEmpty()){
            try {
                Statement st = konek.GetConnection().createStatement();
                ResultSet rs = st.executeQuery("SELECT (username) FROM riwayat_login ORDER BY (id_riwayat) DESC LIMIT 1");
                if(rs.next()){
                nama = rs.getString("username");
                username.setText(nama);
                }  
            } catch (Exception e) {
            }
        }
        }
        public void setTableAction(){
             TableActionEvent event = new TableActionEvent(){
    
            @Override
            public void onDelete(int row) {
                if(table_belanja.isEditing()){
                 table_belanja.getCellEditor().stopCellEditing();
                }
                String kode_belanja = invoice.getText();
                try{
                Statement statement = (Statement)konek.GetConnection().createStatement();
                statement.executeUpdate("DELETE from belanja WHERE kode_belanja= ('" + kode_belanja + "' );");
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                invoice.setText("");
                UangBelanja.setText("");
                txtDate1.setText("");
                Keterangan.setText("");

        }catch (Exception t){
            JOptionPane.showMessageDialog(null, "Data Gagal Di HAPUS");
                
            }     
        DefaultTableModel model = (DefaultTableModel)table_belanja.getModel();
                 model.removeRow(row);
            }

           @Override
            public void onEdit(int row) {
                if(table_belanja.isEditing()){
                table_belanja.getCellEditor().stopCellEditing();
            }
            // Pastikan objek edit sudah diinisialisasi sebelum digunakan
                 if (edit != null) {
                 edit.setVisible(true);
            } else {
                // Handle kasus di mana objek edit belum diinisialisasi
                JOptionPane.showMessageDialog(null, "Form edit belum diinisialisasi.");
            }
                
                String tanggal = "yyyy-MM-dd";
                SimpleDateFormat fm = new SimpleDateFormat(tanggal);
                
                TableModel model = table_belanja.getModel();
                int indextTable =table_belanja.getSelectedRow();
                edit.txt_editkode.setText(table_belanja.getModel().getValueAt(row, 0).toString());
                edit.txt_edittanggal.setText(table_belanja.getModel().getValueAt(row, 1).toString());
                edit.txt_edituang.setText(table_belanja.getModel().getValueAt(row, 2).toString());
                edit.txt_editketerangan.setText(table_belanja.getModel().getValueAt(row, 3).toString());
                
                    try {
                Statement st = konek.GetConnection().createStatement();
                ResultSet rs = st.executeQuery("SELECT kode_belanja FROM belanja WHERE kode_belanja = '" + invoice + "';");
                 if (rs.next()) {
                String kode_belanja = rs.getString("kode_belanja");
                edit.txt_editkode.setText(kode_belanja);
                edit.txt_editkode.disable();
                }
                rs.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    }}
                    
    };
             this.edit = new editBelanja();
             
        
        table_belanja.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRenderer());
        table_belanja.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        }
                public void TableHeader(){
                JTableHeader header = table_belanja.getTableHeader();
        // Membuat renderer kustom
                header.setDefaultRenderer(new TableCellRenderer() {
                 @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel(value.toString());
                    label.setOpaque(true);
                    label.setBackground(new Color(77, 134, 156)); // Set your desired background color
                    label.setForeground(Color.white); // Set your desired foreground color
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    label.setPreferredSize(new Dimension(40,40));
                    label.setFont(new Font("Segoe UI",Font.BOLD, 14));
                
                return label;
            }
        });
        }
            public void data_table() { 
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("Kode Belanja");
            tbl.addColumn("Tanggal");
            tbl.addColumn("Uang Belanja");
            tbl.addColumn("Keterangan");
            tbl.addColumn("Action");
            table_belanja.setModel(tbl);
        try{
            Statement statement = (Statement)konek.GetConnection().createStatement();
            ResultSet res= statement.executeQuery("select * from belanja");
        while (res.next()) {
            tbl.addRow(new Object[] {
                res.getString("kode_belanja"),
                res.getDate("tanggal"),
                res.getInt("total"),
                res.getString("keterangan")
            });
         table_belanja.setModel(tbl);
        }
      }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "salah"); 
      }
            }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_belanja = new javax.swing.JTable();
        shape51 = new com.swing.Shape5();
        jLabel1 = new javax.swing.JLabel();
        invoice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDate1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        UangBelanja = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Keterangan = new javax.swing.JTextField();
        simpan = new com.button.button();
        background2 = new com.swing.background();

        dateChooser1.setForeground(new java.awt.Color(19, 93, 102));
        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txtDate1);

        setMinimumSize(new java.awt.Dimension(1088, 522));
        setPreferredSize(new java.awt.Dimension(1088, 522));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1020, 520));
        jPanel1.setPreferredSize(new java.awt.Dimension(1020, 520));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(0, 153, 153));
        title.setText("Belanja Harian");
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(0, 153, 153));
        username.setText("Username");
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, -1, -1));

        table_belanja.setBackground(new java.awt.Color(205, 232, 229));
        table_belanja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Belanja", "Tanggal", "Uang Belanja", "Keterangan", "Aksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_belanja.setRowHeight(38);
        table_belanja.setSelectionBackground(new java.awt.Color(122, 178, 178));
        table_belanja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_belanjaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_belanja);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 950, 240));

        shape51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kode Belanja");
        shape51.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, -1));

        invoice.setBackground(new java.awt.Color(238, 247, 255));
        invoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceMouseClicked(evt);
            }
        });
        invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceActionPerformed(evt);
            }
        });
        shape51.add(invoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tanggal");
        shape51.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 153, -1));

        txtDate1.setBackground(new java.awt.Color(238, 247, 255));
        shape51.add(txtDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 140, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Uang Belanja");
        shape51.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 135, -1));

        UangBelanja.setBackground(new java.awt.Color(238, 247, 255));
        UangBelanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UangBelanjaActionPerformed(evt);
            }
        });
        shape51.add(UangBelanja, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 135, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Keterangan");
        shape51.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 310, -1));

        Keterangan.setBackground(new java.awt.Color(238, 247, 255));
        Keterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeteranganActionPerformed(evt);
            }
        });
        shape51.add(Keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 312, 40));

        simpan.setBackground(new java.awt.Color(238, 247, 255));
        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/picture/simpan (2).png"))); // NOI18N
        simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanMouseClicked(evt);
            }
        });
        shape51.add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 68, 60, 40));

        jPanel1.add(shape51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 950, 160));
        jPanel1.add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 660));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void table_belanjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_belanjaMouseClicked
        // TODO add your handling code here:
        String tanggal = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tanggal);

        int row =table_belanja.getSelectedRow();
        invoice.setText(table_belanja.getModel().getValueAt(row, 0).toString());
        txtDate1.setText(table_belanja.getModel().getValueAt(row, 1).toString());
        UangBelanja.setText(table_belanja.getModel().getValueAt(row, 2).toString());
        Keterangan.setText(table_belanja.getModel().getValueAt(row, 3).toString());
    }//GEN-LAST:event_table_belanjaMouseClicked

    private void simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseClicked
        // TODO add your handling code here:
        String tanggal = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tanggal);
     
        String nama= username.getText();
        String kode_belanja = invoice.getText();
        String tanggal1 = txtDate1.getText();
        String uang_belanja = UangBelanja.getText();
        String keterangan = Keterangan.getText();

        try {
            Date date = fm.parse(tanggal1);
            Statement statement = (Statement)konek.GetConnection().createStatement();
            statement.executeUpdate("INSERT INTO belanja (username, kode_belanja, tanggal, total, keterangan)"
                    + "VALUES ('" + nama +"','" + kode_belanja +"','" + new java.sql.Date(date.getTime()) +"','" +
                    uang_belanja +"','" + keterangan + "');");
            statement.close();
            JOptionPane.showMessageDialog(this, "Simpan Berhasil");
} 
        catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Simpan Gagal. Terjadi kesalahan database.");
}       catch (ParseException ex) {
            Logger.getLogger(belanja.class.getName()).log(Level.SEVERE, null, ex);
        }
        data_table();
        setTableAction();
    }//GEN-LAST:event_simpanMouseClicked

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanActionPerformed

    private void KeteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KeteranganActionPerformed

    private void UangBelanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UangBelanjaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UangBelanjaActionPerformed

    private void invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceActionPerformed
        // TODO add your handling code here:
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(RIGHT(kode_belanja,3)) AS no_auto FROM belanja WHERE kode_belanja LIKE 'AB%'");
            if(rs.next()){
                String no_auto, nol_plus;
                int p;
                no_auto = Integer.toString(rs.getInt(1)+1);
                p = no_auto.length();
                nol_plus = "";
                for(int i=1;i<=3-p; i++){
                    nol_plus = nol_plus + "0";
                }
                invoice.setText("AB" + nol_plus + no_auto);
            }
        } catch (Exception e){
            invoice.setText("AB001");
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_invoiceActionPerformed

    private void invoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceMouseClicked
        // TODO add your handling code here:
        try {
            Statement st = konek.GetConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(RIGHT(kode_belanja,3)) AS no_auto FROM belanja WHERE kode_belanja LIKE 'AB%'");
            if(rs.next()){
                String no_auto, nol_plus;
                int p;
                no_auto = Integer.toString(rs.getInt(1)+1);
                p = no_auto.length();
                nol_plus = "";
                for(int i=1;i<=3-p; i++){
                    nol_plus = nol_plus + "0";
                }
                invoice.setText("AB" + nol_plus + no_auto);
            }
        } catch (Exception e){
            invoice.setText("AB001");
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_invoiceMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Keterangan;
    private javax.swing.JTextField UangBelanja;
    private com.swing.background background2;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JTextField invoice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.swing.Shape5 shape51;
    private com.button.button simpan;
    public static javax.swing.JTable table_belanja;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtDate1;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
