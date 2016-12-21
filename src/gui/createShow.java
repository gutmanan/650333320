/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import core.Address;
import core.Agent;
import core.Artist;
import init.DBManager;
import init.Main;
import init.WindowManager;
import java.awt.Checkbox;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Shai Gutman
 */
public class createShow extends javax.swing.JPanel {

    /**
     * Creates new form createShow
     */
    public createShow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable() {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                    return String.class;
                    case 1:
                    return String.class;
                    case 2:
                    return Integer.class;
                    case 3:
                    return Double.class;
                    default:
                    return Boolean.class;
                }
            }
        };
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);
        jPanel1.setVisible(false);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Biography:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(310, 120, 230, 20);

        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(20, 20, 270, 220);

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Selected artist info:");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(310, 30, 190, 20);

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Facebook:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(310, 100, 230, 20);

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Agent:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(310, 60, 230, 20);

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Email:");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(310, 80, 230, 20);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/subContainer1.png"))); // NOI18N
        jPanel1.add(jLabel22);
        jLabel22.setBounds(0, 0, 650, 260);

        add(jPanel1);
        jPanel1.setBounds(25, 305, 650, 260);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/btnInvite.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(40, 250, 150, 40);

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Address:");
        add(jLabel15);
        jLabel15.setBounds(420, 130, 340, 20);

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Phone number:");
        add(jLabel14);
        jLabel14.setBounds(420, 110, 340, 20);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Representative ID:");
        add(jLabel13);
        jLabel13.setBounds(420, 190, 340, 20);

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Maximum capacity:");
        add(jLabel11);
        jLabel11.setBounds(420, 170, 340, 20);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Loacation:");
        add(jLabel12);
        jLabel12.setBounds(420, 150, 340, 20);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email:");
        add(jLabel10);
        jLabel10.setBounds(420, 90, 340, 20);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Name:");
        add(jLabel9);
        jLabel9.setBounds(420, 70, 340, 20);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Selected place info:");
        add(jLabel8);
        jLabel8.setBounds(420, 40, 170, 20);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Set ticket price:");
        add(jLabel6);
        jLabel6.setBounds(60, 190, 140, 20);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Set minimum age:");
        add(jLabel7);
        jLabel7.setBounds(60, 160, 140, 20);

        jTextField3.setPreferredSize(new java.awt.Dimension(30, 25));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        add(jTextField3);
        jTextField3.setBounds(250, 190, 140, 25);

        jTextField1.setPreferredSize(new java.awt.Dimension(30, 25));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(250, 160, 140, 25);

        jComboBox2.addItem("Select Place");
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        add(jComboBox2);
        jComboBox2.setBounds(250, 130, 140, 25);

        jComboBox1.addItem("Select Artist");
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(250, 100, 140, 25);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Available Places for date:");
        add(jLabel5);
        jLabel5.setBounds(60, 130, 180, 20);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Available Artists for date:");
        add(jLabel4);
        jLabel4.setBounds(60, 100, 180, 20);

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });
        add(jXDatePicker1);
        jXDatePicker1.setBounds(250, 70, 140, 24);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Create New Show");
        add(jLabel3);
        jLabel3.setBounds(60, 20, 230, 40);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Choose show's date:");
        add(jLabel2);
        jLabel2.setBounds(60, 70, 150, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container1.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        jXDatePicker1.setEditable(false);
        Date selectedDate = new Date(jXDatePicker1.getDate().getTime());
        ResultSet rs1 = Main.getDB().query("SELECT tblArtist.*\n" +
                                            "FROM tblAgent INNER JOIN tblArtist ON tblAgent.ID = tblArtist.agentID\n" +
                                            "WHERE (((tblArtist.agentID)=\""+WindowManager.getTmpAgent().getId()+"\"))");
        ResultSet rs2 = Main.getDB().query("SELECT tblPerformance.artistID\n" +
                                            "FROM tblShow INNER JOIN tblPerformance ON tblShow.ID = tblPerformance.showID\n" +
                                            "WHERE (((tblPerformance.showID)=[tblShow].[ID]) AND ((tblShow.date)=#"+selectedDate+"#))");  
        ResultSet rs3 = Main.getDB().query("SELECT tblPlace.*, tblFavoritePlace.agentID\n" +
                                            "FROM tblPlace INNER JOIN tblFavoritePlace ON tblPlace.ID = tblFavoritePlace.placeID\n" +
                                            "WHERE (((tblFavoritePlace.agentID)=\""+WindowManager.getTmpAgent().getId()+"\"))");    
        
        
        ResultSet rs4 = Main.getDB().query("SELECT tblPlace.*, tblShow.date, tblShow.place\n" +
                                            "FROM tblPlace INNER JOIN tblShow ON tblPlace.ID = tblShow.place\n" +
                                            "WHERE (((tblShow.date)=#"+selectedDate+"#) AND ((tblShow.place)=[tblPlace].[ID]))");  
        HashMap<String,String> availableAgents = new HashMap<>();
        HashMap<String,String> availableShows = new HashMap<>();
        try {
            while (rs1.next()) {
                availableAgents.put(rs1.getString(1), rs1.getString(2));
            }
            while (rs2.next()) {
                if (availableAgents.containsKey(rs2.getString(1))) {
                    availableAgents.remove(rs2.getString(1));
                }
            }
            for (String s : availableAgents.keySet()) {
                jComboBox1.addItem(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(createShow.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (rs3.next()) {
                availableShows.put(rs3.getString(1), rs3.getString(2));
            }
            while (rs4.next()) {
                if (availableShows.containsKey(rs4.getString(1))) {
                    availableShows.remove(rs4.getString(1));
                }
            }
            for (String s : availableShows.keySet()) {
                jComboBox2.addItem(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(createShow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        if (jComboBox2.getSelectedIndex()==0) {
            return;
        }
        jLabel9.setText("Name:");
        jLabel10.setText("Email:");
        jLabel14.setText("Phone number:");
        jLabel15.setText("Address:");
        jLabel12.setText("Location:");
        jLabel11.setText("Maximum capacity:");
        jLabel13.setText("Representative ID:");
        ResultSet rs = Main.getDB().query("SELECT tblPlace.*\n" +
                                            "FROM tblPlace\n" +
                                            "WHERE tblPlace.ID="+jComboBox2.getSelectedItem());
        try {
            while (rs.next()) {
                jLabel9.setText(jLabel9.getText()+" "+rs.getString(2));
                jLabel10.setText(jLabel10.getText()+" "+rs.getString(7));
                jLabel14.setText(jLabel14.getText()+" "+rs.getString(8));
                jLabel15.setText(jLabel15.getText()+" "+new Address(rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)).toString());
                jLabel12.setText(jLabel12.getText()+" "+rs.getString(9));
                jLabel11.setText(jLabel11.getText()+" "+rs.getString(10));
                jLabel13.setText(jLabel13.getText()+" "+rs.getString(11));
            }
        } catch (SQLException ex) {
            Logger.getLogger(createShow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (jComboBox2.getSelectedIndex()==0) {
            return;
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jXDatePicker1.getDate() == null) {
            return;
        }
        jPanel1.setVisible(true);
        jPanel1.setBounds(25, 305, 650, 260);
        Date selectedDate = new Date(jXDatePicker1.getDate().getDay(), jXDatePicker1.getDate().getMonth(), jXDatePicker1.getDate().getYear());
        ResultSet rs2 = Main.getDB().query("SELECT tblPerformance.artistID\n" +
                                            "FROM tblShow INNER JOIN tblPerformance ON tblShow.ID = tblPerformance.showID\n" +
                                            "WHERE (((tblPerformance.showID)=[tblShow].[ID]) AND ((tblShow.date)=#"+selectedDate+"#))");

        ResultSet rs1 = Main.getDB().query("SELECT tblAppreciation.appreciatedArtistID, tblArtist.*\n" +
                                          "FROM tblArtist INNER JOIN (tblAppreciation AS tblAppreciation_1 INNER JOIN tblAppreciation ON tblAppreciation_1.artistID = tblAppreciation.appreciatedArtistID) ON tblArtist.ID = tblAppreciation.artistID\n" +
                                          "WHERE (((tblArtist.ID)=[tblAppreciation_1].[appreciatedArtistID]) AND ((tblAppreciation.appreciatedArtistID)=\""+jComboBox1.getSelectedItem()+"\") AND ((tblArtist.active)=Yes))");
        
        final HashMap<String,Artist> availableAdditionalArtists = new HashMap<>();
        try {
            while (rs1.next()) {
                availableAdditionalArtists.put(rs1.getString(1), new Artist(rs1.getString(1), rs1.getString(2), 
                                                                            rs1.getString(3), rs1.getString(4), 
                                                                            rs1.getString(5), true, 
                                                                            new Agent(rs1.getString(7))));
            }
            while (rs2.next()) {
                if (availableAdditionalArtists.containsKey(rs2.getString(1))) {
                    availableAdditionalArtists.remove(rs2.getString(1));
                }
            }
            DefaultTableModel model = new DefaultTableModel(); 
            jTable3.setModel(model);
            model.addColumn("Name"); 
            model.addColumn("Invite");
            TableColumn tc = jTable3.getColumnModel().getColumn(1);
            tc.setCellEditor(jTable3.getDefaultEditor(Boolean.class));
            tc.setCellRenderer(jTable3.getDefaultRenderer(Boolean.class));
            for (Artist a : availableAdditionalArtists.values()) {
                model.addRow(new Object[]{a.getStageName(), false});
            }
        
            jTable3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (jTable3.getSelectedRow() > -1) {
                        jLabel20.setText("Agent:");
                        jLabel21.setText("Email:");
                        jLabel19.setText("Facebook:");
                        jLabel16.setText("Biography:");
                        ResultSet rs4 = DBManager.query("SELECT tblArtist.*\n" +
                                                        "FROM tblArtist " +
                                                        "WHERE tblArtist.ID=\""+jTable3.getValueAt(jTable3.getSelectedRow(),0).toString()+"\"");
                        try {
                            while (rs4.next()) {
                                 jLabel20.setText(jLabel20.getText()+" "+rs4.getString(7));
                                 jLabel21.setText(jLabel21.getText()+" "+rs4.getString(4));
                                 jLabel19.setText(jLabel19.getText()+" "+rs4.getString(5));
                                 jLabel16.setText(jLabel16.getText()+" "+rs4.getString(3));
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(createShow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }                
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(createShow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
}
