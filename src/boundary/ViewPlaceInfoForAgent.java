/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import businessLogic.ReportProduceControl;
import businessLogic.ViewPlaceInfoForAgentControl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Shai Gutman
 */
public class ViewPlaceInfoForAgent extends javax.swing.JPanel {

    ReportProduceControl rpController = new ReportProduceControl();
    
    public ViewPlaceInfoForAgent() {
        initComponents();
        setCombo();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        URLlabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        likeButton = new javax.swing.JButton();
        dislikeButton = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        titleLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("View Places");
        add(titleLabel);
        titleLabel.setBounds(0, 10, 850, 40);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(120, 60, 170, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Cover :");
        add(jLabel2);
        jLabel2.setBounds(320, 110, 90, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("City :");
        add(jLabel3);
        jLabel3.setBounds(20, 140, 90, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("House Number :");
        add(jLabel4);
        jLabel4.setBounds(20, 170, 110, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Email :");
        add(jLabel5);
        jLabel5.setBounds(20, 200, 90, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Phone Number :");
        add(jLabel6);
        jLabel6.setBounds(20, 230, 110, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Favorite Places :");
        add(jLabel7);
        jLabel7.setBounds(20, 310, 130, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Place Name :");
        add(jLabel8);
        jLabel8.setBounds(20, 70, 90, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Seats :");
        add(jLabel9);
        jLabel9.setBounds(320, 140, 90, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Platform :");
        add(jLabel10);
        jLabel10.setBounds(320, 170, 90, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Gear :");
        add(jLabel11);
        jLabel11.setBounds(320, 200, 90, 20);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Toilets:");
        add(jLabel12);
        jLabel12.setBounds(320, 230, 70, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Street Name :");
        add(jLabel14);
        jLabel14.setBounds(20, 110, 90, 20);
        add(jLabel13);
        jLabel13.setBounds(390, 110, 130, 20);
        add(jLabel15);
        jLabel15.setBounds(390, 140, 130, 20);
        add(jLabel16);
        jLabel16.setBounds(390, 170, 130, 20);
        add(jLabel17);
        jLabel17.setBounds(390, 200, 130, 20);
        add(jLabel18);
        jLabel18.setBounds(390, 230, 130, 20);
        add(jLabel19);
        jLabel19.setBounds(150, 110, 150, 20);
        add(jLabel20);
        jLabel20.setBounds(150, 140, 130, 20);
        add(jLabel21);
        jLabel21.setBounds(150, 170, 130, 20);
        add(jLabel22);
        jLabel22.setBounds(100, 200, 190, 20);
        add(jLabel23);
        jLabel23.setBounds(150, 230, 130, 20);
        add(jLabel24);
        jLabel24.setBounds(150, 260, 130, 20);
        add(URLlabel);
        URLlabel.setBounds(280, 260, 0, 0);

        jButton1.setText("View google maps");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(570, 90, 160, 160);

        likeButton.setText("Like");
        likeButton.setEnabled(false);
        likeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeButtonActionPerformed(evt);
            }
        });
        add(likeButton);
        likeButton.setBounds(300, 60, 90, 30);

        dislikeButton.setText("DisLike");
        dislikeButton.setEnabled(false);
        dislikeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dislikeButtonActionPerformed(evt);
            }
        });
        add(dislikeButton);
        dislikeButton.setBounds(400, 60, 90, 30);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Capacity :");
        add(jLabel25);
        jLabel25.setBounds(20, 260, 90, 20);

        jTable2.setModel(new DefaultTableModel());
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        setTable2();

        add(jScrollPane2);
        jScrollPane2.setBounds(20, 340, 470, 190);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container3.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        setDetails();
        if (con.CheckIfFavorite(places.get(jComboBox1.getSelectedIndex()))){
            likeButton.setEnabled(false);
            dislikeButton.setEnabled(true);
        }
        
        else{
            likeButton.setEnabled(true);
            dislikeButton.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jComboBox1.getSelectedIndex()<0) return;
        con.viewUrl(URLlabel.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

    }//GEN-LAST:event_jTable2MouseClicked

    private void likeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likeButtonActionPerformed
        con.addFavoritePlace(places.get(jComboBox1.getSelectedIndex()));
        setTable2();
        likeButton.setEnabled(false);
        dislikeButton.setEnabled(true);
        
    }//GEN-LAST:event_likeButtonActionPerformed

    private void dislikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dislikeButtonActionPerformed
        con.removeFavoritePlace(places.get(jComboBox1.getSelectedIndex()));
        setTable2();
        likeButton.setEnabled(true);
        dislikeButton.setEnabled(false);
    }//GEN-LAST:event_dislikeButtonActionPerformed
        
    public void setCombo(){
        try {
            ResultSet rs = con.getPlaces();
            
            while(rs.next()){
                places.add(rs.getInt(1));
                jComboBox1.addItem(rs.getString(2));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewPlaceInfoForAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setDetails(){
        
        try {

            ResultSet rs = con.getPlaceInfo(places.get(jComboBox1.getSelectedIndex()));
            
            while (rs.next()){
                jLabel19.setText(rs.getString(3));
                jLabel20.setText(rs.getString(5));
                jLabel21.setText(rs.getString(4));
                jLabel22.setText(rs.getString(7));
                jLabel23.setText(rs.getString(8));
                jLabel24.setText(rs.getString(10));
                URLlabel.setText(rs.getString(9));
                URLlabel.setVisible(false);
            }
            
            setOpenPlaceDetails();
        } catch (SQLException ex) {
            Logger.getLogger(ViewPlaceInfoForAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setOpenPlaceDetails(){
        
        try {
            ResultSet rs = con.getOpenPlaceDetails(places.get(jComboBox1.getSelectedIndex()));
            
            Boolean flg = false;
            while (rs.next()){
                flg = true;
                jLabel13.setText(rs.getString(2));
                jLabel15.setText(rs.getString(3));
                jLabel16.setText(rs.getString(4));
                jLabel17.setText(rs.getString(5));
                jLabel18.setText(rs.getString(6));
            }
            
            if (flg){
                jLabel13.setVisible(true);
                jLabel15.setVisible(true);
                jLabel16.setVisible(true);
                jLabel17.setVisible(true);
                jLabel18.setVisible(true);
            }
            
            else{
                jLabel13.setVisible(false);
                jLabel15.setVisible(false);
                jLabel16.setVisible(false);
                jLabel17.setVisible(false);
                jLabel18.setVisible(false);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewPlaceInfoForAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public void setTable2(){
        try {
            jTable2.setModel(new DefaultTableModel(){

                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            });
            
            // TableModel definition
            String[] tableColumnsName = {"Place Name","City","Email","Phone"};
            DefaultTableModel aModel = (DefaultTableModel) jTable2.getModel();
            aModel.setColumnIdentifiers(tableColumnsName);
            
            ResultSet places = null;
            
            places = con.getFavoritePlaces();
            
            
            // Loop through the ResultSet and transfer in the Model
            java.sql.ResultSetMetaData rsmd = places.getMetaData();
            int colNo = rsmd.getColumnCount();
            while(places.next()){
                Object[] objects = new Object[colNo];
                // tanks to umit ozkan for the bug fix!
                for(int i=0;i<colNo;i++){
                    objects[i]=places.getObject(i+1);
                }
                aModel.addRow(objects);
            }
            jTable2.setModel(aModel);
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewAgents.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel URLlabel;
    private javax.swing.JButton dislikeButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton likeButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    private ViewPlaceInfoForAgentControl con = new ViewPlaceInfoForAgentControl();
    private ArrayList<Integer> places = new ArrayList<Integer>();
}
