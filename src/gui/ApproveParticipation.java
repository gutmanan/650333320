/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import core.Artist;
import core.Show;
import init.ApproveParticipationControl;
import init.DBManager;
import init.HandsInTheAir;
import init.WindowManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Shai Gutman
 */
public class ApproveParticipation extends javax.swing.JPanel {

    /**
     * Creates new form approveParticipation
     */
    public ApproveParticipation() {
        initComponents();
        setTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Date of creation:");
        add(jLabel22);
        jLabel22.setBounds(50, 370, 560, 20);

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Tickect price:");
        add(jLabel23);
        jLabel23.setBounds(50, 390, 560, 20);

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Minimum age:");
        add(jLabel24);
        jLabel24.setBounds(50, 410, 560, 20);

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Created by:");
        add(jLabel17);
        jLabel17.setBounds(50, 430, 560, 20);

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Selected show info:");
        add(jLabel18);
        jLabel18.setBounds(50, 260, 190, 20);

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Main artist:");
        add(jLabel20);
        jLabel20.setBounds(50, 290, 560, 20);

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Date:");
        add(jLabel21);
        jLabel21.setBounds(50, 310, 560, 20);

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Place:");
        add(jLabel19);
        jLabel19.setBounds(50, 330, 560, 20);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Status:");
        add(jLabel16);
        jLabel16.setBounds(50, 350, 560, 20);

        jScrollPane3.setViewportView(jTable3);

        add(jScrollPane3);
        jScrollPane3.setBounds(40, 70, 430, 150);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Approve Participation");
        add(jLabel3);
        jLabel3.setBounds(60, 20, 260, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container1.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 580);
    }// </editor-fold>//GEN-END:initComponents

    public void setTable() {
        DefaultTableModel model = new DefaultTableModel(); 
        jTable3.setModel(model);
        model.addColumn("ID"); 
        model.addColumn("Show");
        model.addColumn("Status");
        TableColumn tc = jTable3.getColumnModel().getColumn(2);
        tc.setCellEditor(jTable3.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(jTable3.getDefaultRenderer(Boolean.class));
        final ApproveParticipationControl apController = new ApproveParticipationControl();
        for (Map.Entry<String, String> entry : apController.getArtistsWaitingForApproval().entrySet()) {
            model.addRow(new Object[]{entry.getKey(), entry.getValue(), false});
        }
        jTable3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jTable3.getSelectedRow() > -1) {
                    jLabel20.setText("Main Artist:");
                    jLabel21.setText("Date:");
                    jLabel19.setText("Place:");
                    jLabel16.setText("Status:");
                    jLabel22.setText("Date of creation:");
                    jLabel23.setText("Ticket price:");
                    jLabel24.setText("Minimum age:");
                    jLabel17.setText("Created by:");
                    Show tmp = apController.getShowDetails(jTable3.getValueAt(jTable3.getSelectedRow(),1).toString());
                    if (tmp != null) {
                        jLabel20.setText(jLabel20.getText()+" "+tmp.getMainArtist().getArtistAlphaCode());
                        jLabel21.setText(jLabel21.getText()+" "+tmp.getShowDate());
                        jLabel19.setText(jLabel19.getText()+" "+tmp.getPlace().getPlaceNumber());
                        jLabel16.setText(jLabel16.getText()+" "+tmp.getStatus());
                        jLabel22.setText(jLabel22.getText()+" "+tmp.getCreateDate());
                        jLabel23.setText(jLabel23.getText()+" "+tmp.getTicketPrice());
                        jLabel24.setText(jLabel24.getText()+" "+tmp.getMinAge());
                        jLabel17.setText(jLabel17.getText()+" "+tmp.getCreateAgent().getId());
                    }
                }                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
