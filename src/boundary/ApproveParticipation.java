/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import businessLogic.ApproveParticipationControl;
import businessLogic.WindowManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Shai Gutman
 */
public class ApproveParticipation extends javax.swing.JPanel {
    
    public ApproveParticipation() {
        
        initComponents();
        setTable2();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel24 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Close Shows For this Artist :");
        add(jLabel24);
        jLabel24.setBounds(400, 70, 190, 20);

        jTable3.setModel(new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        }
    );
    jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable3MouseClicked(evt);
        }
    });
    jScrollPane3.setViewportView(jTable3);

    add(jScrollPane3);
    jScrollPane3.setBounds(400, 100, 200, 110);

    jTable1.setModel(new DefaultTableModel());
    jScrollPane1.setViewportView(jTable1);

    add(jScrollPane1);
    jScrollPane1.setBounds(400, 250, 200, 110);

    jTable2.setModel(new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    }
    );
    jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable2MouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(jTable2);

    add(jScrollPane2);
    jScrollPane2.setBounds(60, 100, 200, 110);

    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel8.setText("Artist participate in selected show :");
    add(jLabel8);
    jLabel8.setBounds(400, 230, 260, 15);
    add(jLabel5);
    jLabel5.setBounds(40, 494, 350, 30);

    titleLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    titleLabel.setText("Approve Participation");
    add(titleLabel);
    titleLabel.setBounds(0, 10, 850, 40);

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel4.setText("Shows Invatition :");
    add(jLabel4);
    jLabel4.setBounds(60, 70, 170, 20);

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel6.setText("Shows Details :");
    add(jLabel6);
    jLabel6.setBounds(60, 230, 130, 20);

    jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel7.setText("Date :");
    add(jLabel7);
    jLabel7.setBounds(60, 260, 110, 20);

    jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel9.setText("Created Date :");
    add(jLabel9);
    jLabel9.setBounds(60, 320, 110, 20);

    jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel10.setText("Main Artist :");
    add(jLabel10);
    jLabel10.setBounds(60, 290, 110, 20);

    jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel13.setText("Place Name :");
    add(jLabel13);
    jLabel13.setBounds(60, 380, 110, 20);

    jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel14.setText("Agent Invaited :");
    add(jLabel14);
    jLabel14.setBounds(60, 350, 110, 20);

    jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel15.setText("Min. Age :");
    add(jLabel15);
    jLabel15.setBounds(60, 410, 110, 20);

    jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel16.setText("Ticket Price :");
    add(jLabel16);
    jLabel16.setBounds(60, 440, 110, 20);

    jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel17.setText("Last day to approve :");
    add(jLabel17);
    jLabel17.setBounds(60, 470, 140, 20);

    jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    add(jLabel11);
    jLabel11.setBounds(200, 260, 110, 20);

    jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    add(jLabel12);
    jLabel12.setBounds(200, 290, 110, 20);

    jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    add(jLabel18);
    jLabel18.setBounds(200, 320, 110, 20);

    jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    add(jLabel19);
    jLabel19.setBounds(200, 350, 110, 20);

    jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    add(jLabel20);
    jLabel20.setBounds(200, 380, 110, 20);

    jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    add(jLabel21);
    jLabel21.setBounds(200, 410, 110, 20);

    jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    add(jLabel22);
    jLabel22.setBounds(200, 440, 110, 20);

    jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    add(jLabel23);
    jLabel23.setBounds(200, 470, 140, 20);

    jButton1.setText("Approve");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    add(jButton1);
    jButton1.setBounds(500, 460, 90, 30);
    jButton1.setEnabled(false);

    jButton2.setText("Not Agree");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    add(jButton2);
    jButton2.setBounds(600, 460, 90, 30);
    jButton2.setEnabled(false);

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container3.png"))); // NOI18N
    add(jLabel1);
    jLabel1.setBounds(0, 0, 850, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        con.approveParticipation((String) jTable2.getValueAt(jTable2.getSelectedRow(), 0),(int) jTable2.getValueAt(jTable2.getSelectedRow(), 1));
        setTable2();
        WindowManager.openWin(new ApproveParticipation());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        con.cancelParticipation((String) jTable2.getValueAt(jTable2.getSelectedRow(), 0),(int) jTable2.getValueAt(jTable2.getSelectedRow(), 1));
        setTable2();
        WindowManager.openWin(new ApproveParticipation());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked
        
    public void setTable2(){
        try{
            // TableModel definition
            jTable2.setModel(new DefaultTableModel());
            String[] tableColumnsName = {"Artist Invaited","Show Number"};
            DefaultTableModel aModel = (DefaultTableModel) jTable2.getModel();
            aModel.setColumnIdentifiers(tableColumnsName);
            jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    
                    if (jTable2.getSelectedRow() > -1) {
                        jButton1.setEnabled(true);
                        jButton2.setEnabled(true);
                        setTable1();
                        //Press.setEnabled(true);
                        }
                    else{
                        jButton1.setEnabled(false);
                        jButton2.setEnabled(false);
                    }
                }
            });
            
           ResultSet shows = con.getShowsInvatation();

            // Loop through the ResultSet and transfer in the Model
            java.sql.ResultSetMetaData rsmd = shows.getMetaData();
            int colNo = rsmd.getColumnCount();
            while(shows.next()){
                Object[] objects = new Object[colNo];
                // tanks to umit ozkan for the bug fix!
                for(int i=0;i<colNo;i++){
                    objects[i]=shows.getObject(i+1);
                }

                aModel.addRow(objects);
            }
            jTable2.setModel(aModel);
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewAgents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setTable1(){
        try {  
            jTable1.setModel(new DefaultTableModel(){

                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            });
            // TableModel definition
            String[] tableColumnsName = {"Artist Name","Status"};
            DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
            aModel.setColumnIdentifiers(tableColumnsName);
            
            ResultSet shows = null;
            
            shows = con.getArtistForShow((int) jTable2.getValueAt(jTable2.getSelectedRow(), 1));

            // Loop through the ResultSet and transfer in the Model
            java.sql.ResultSetMetaData rsmd = shows.getMetaData();
            int colNo = rsmd.getColumnCount();
            while(shows.next()){
                Object[] objects = new Object[colNo];
                // tanks to umit ozkan for the bug fix!
                for(int i=0;i<colNo;i++){
                    objects[i]=shows.getObject(i+1);
                }
                aModel.addRow(objects);
            }
            jTable1.setModel(aModel);
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewAgents.class.getName()).log(Level.SEVERE, null, ex);
        }
        setDetails();
       
  }
    
    public void setDetails(){
      
        try {
            jLabel11.setText("");
            jLabel12.setText("");
            jLabel18.setText("");
            jLabel19.setText("");
            jLabel20.setText("");
            jLabel21.setText("");
            jLabel22.setText("");
            jLabel23.setText("");    
            
            ResultSet rs = con.getShowDetails((int) jTable2.getValueAt(jTable2.getSelectedRow(), 1));
            
            Date showDate = null;
            while(rs.next()){
                jLabel11.setText(rs.getDate(2).toString());
                jLabel12.setText(rs.getString(1));
                jLabel18.setText(rs.getDate(4).toString());
                jLabel19.setText(rs.getString(7));
                jLabel20.setText(rs.getString(3));
                jLabel21.setText(rs.getString(6));
                jLabel22.setText(rs.getString(5));
                Date d = rs.getDate(4);
                d.setDate(d.getDate()+7);
                showDate = rs.getDate(4);
                jLabel23.setText(d.toString());
                setShowsTable(showDate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApproveParticipation.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        
    }
    
    public void setShowsTable(Date showDate){
        
        jTable3.setModel(new DefaultTableModel(){

                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            });
            // TableModel definition
            
        HashMap<Date,String> shows = con.getShowsForArtist((String) jTable2.getValueAt(jTable2.getSelectedRow(), 0), showDate);
        
        String[] tableColumnsName = {"Artist Name","Show Date"};
        
            DefaultTableModel aModel = (DefaultTableModel) jTable3.getModel();
            aModel.setColumnIdentifiers(tableColumnsName);

            
        for (Map.Entry<Date,String> entry : shows.entrySet()) {
            Object[] objects = new Object[2];
            objects[0] = entry.getKey();
            objects[1] = entry.getValue();
            aModel.addRow(objects);
        }
            
            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    private ApproveParticipationControl con = new ApproveParticipationControl();
    
}
