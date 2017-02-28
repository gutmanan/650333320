/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import businessLogic.ChangeConstantControl;
import businessLogic.ValidatorManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shai Gutman
 */
public class ChangeConstants extends javax.swing.JPanel {
    
    public ChangeConstants() {
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

        placeExpLabel = new javax.swing.JLabel();
        lastUpdateField = new javax.swing.JTextField();
        placeIncField = new javax.swing.JTextField();
        placeIncLabel = new javax.swing.JLabel();
        showDurLabel = new javax.swing.JLabel();
        showDurField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        maxTicketsField = new javax.swing.JTextField();
        maxTicketsLabel = new javax.swing.JLabel();
        presaleDisLabel = new javax.swing.JLabel();
        presaleDisField = new javax.swing.JTextField();
        artistIncField = new javax.swing.JTextField();
        artistIncLabel = new javax.swing.JLabel();
        regSaleField = new javax.swing.JTextField();
        regSaleLabel = new javax.swing.JLabel();
        lastUpdateLabel = new javax.swing.JLabel();
        bDayTextField = new javax.swing.JTextField();
        bDayTextLabel = new javax.swing.JLabel();
        waitTimeField = new javax.swing.JTextField();
        waitTimeLabel = new javax.swing.JLabel();
        placeExpField = new javax.swing.JTextField();
        updateCheckBox = new javax.swing.JCheckBox();
        titleLabel = new javax.swing.JLabel();
        wallpaper = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        placeExpLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        placeExpLabel.setText("Place Expanse (%) :");
        add(placeExpLabel);
        placeExpLabel.setBounds(30, 110, 130, 15);
        add(lastUpdateField);
        lastUpdateField.setBounds(190, 60, 150, 30);
        lastUpdateField.setEditable(false);
        add(placeIncField);
        placeIncField.setBounds(190, 140, 150, 30);

        placeIncLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        placeIncLabel.setText("Place Income (%) :");
        add(placeIncLabel);
        placeIncLabel.setBounds(30, 150, 150, 15);

        showDurLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showDurLabel.setText("Show Duration (Hours) :");
        add(showDurLabel);
        showDurLabel.setBounds(30, 190, 160, 15);
        add(showDurField);
        showDurField.setBounds(190, 180, 150, 30);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(670, 390, 90, 40);
        jButton1.setEnabled(false);
        add(maxTicketsField);
        maxTicketsField.setBounds(620, 140, 150, 30);

        maxTicketsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        maxTicketsLabel.setText("Max presale tickes per user :");
        add(maxTicketsLabel);
        maxTicketsLabel.setBounds(440, 150, 190, 15);

        presaleDisLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        presaleDisLabel.setText("Presale Discount (%) :");
        add(presaleDisLabel);
        presaleDisLabel.setBounds(440, 110, 190, 15);
        add(presaleDisField);
        presaleDisField.setBounds(620, 100, 150, 30);
        add(artistIncField);
        artistIncField.setBounds(620, 60, 150, 30);

        artistIncLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        artistIncLabel.setText("Artist Income (%) :");
        add(artistIncLabel);
        artistIncLabel.setBounds(440, 70, 200, 15);
        add(regSaleField);
        regSaleField.setBounds(620, 180, 150, 30);

        regSaleLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        regSaleLabel.setText("Regular sale days :");
        add(regSaleLabel);
        regSaleLabel.setBounds(440, 190, 190, 15);

        lastUpdateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lastUpdateLabel.setText("Last update at :");
        add(lastUpdateLabel);
        lastUpdateLabel.setBounds(30, 70, 130, 15);
        add(bDayTextField);
        bDayTextField.setBounds(620, 220, 150, 70);

        bDayTextLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bDayTextLabel.setText("Birthday Text :");
        add(bDayTextLabel);
        bDayTextLabel.setBounds(440, 230, 190, 15);
        add(waitTimeField);
        waitTimeField.setBounds(190, 220, 150, 30);

        waitTimeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        waitTimeLabel.setText("Propasal Wait Days :");
        add(waitTimeLabel);
        waitTimeLabel.setBounds(30, 230, 140, 15);
        add(placeExpField);
        placeExpField.setBounds(190, 100, 150, 30);

        updateCheckBox.setText("Check if you want to update");
        updateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCheckBoxActionPerformed(evt);
            }
        });
        add(updateCheckBox);
        updateCheckBox.setBounds(30, 330, 210, 24);

        titleLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Change Constants");
        add(titleLabel);
        titleLabel.setBounds(0, 10, 850, 40);

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container3.png"))); // NOI18N
        add(wallpaper);
        wallpaper.setBounds(0, 0, 850, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Date today = new Date();
        Timestamp ts = new Timestamp(today.getTime());
        
        con.saveConstants(placeExpField.getText(),placeIncField.getText(),showDurField.getText(),artistIncField.getText(),presaleDisField.getText(),maxTicketsField.getText(),
           regSaleField.getText(),waitTimeField.getText(),bDayTextField.getText()) ;
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void updateCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCheckBoxActionPerformed
        if (updateCheckBox.isSelected())
            jButton1.setEnabled(true);
        else 
            jButton1.setEnabled(false);                                  
    }//GEN-LAST:event_updateCheckBoxActionPerformed
        
    public void setTable(){
        ResultSet rs = con.getConstants();
        try {
            while (rs.next()){
                lastUpdateField.setText(rs.getDate(1).toString());
                placeExpField.setText(rs.getString(2));
                placeIncField.setText(rs.getString(3));
                showDurField.setText(rs.getString(4));
                waitTimeField.setText(rs.getString(9));
                artistIncField.setText(rs.getString(5));
                presaleDisField.setText(rs.getString(6));
                maxTicketsField.setText(rs.getString(7));
                regSaleField.setText(rs.getString(8));
                bDayTextField.setText(rs.getString(10));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChangeConstants.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField artistIncField;
    private javax.swing.JLabel artistIncLabel;
    private javax.swing.JTextField bDayTextField;
    private javax.swing.JLabel bDayTextLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField lastUpdateField;
    private javax.swing.JLabel lastUpdateLabel;
    private javax.swing.JTextField maxTicketsField;
    private javax.swing.JLabel maxTicketsLabel;
    private javax.swing.JTextField placeExpField;
    private javax.swing.JLabel placeExpLabel;
    private javax.swing.JTextField placeIncField;
    private javax.swing.JLabel placeIncLabel;
    private javax.swing.JTextField presaleDisField;
    private javax.swing.JLabel presaleDisLabel;
    private javax.swing.JTextField regSaleField;
    private javax.swing.JLabel regSaleLabel;
    private javax.swing.JTextField showDurField;
    private javax.swing.JLabel showDurLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JCheckBox updateCheckBox;
    private javax.swing.JTextField waitTimeField;
    private javax.swing.JLabel waitTimeLabel;
    private javax.swing.JLabel wallpaper;
    // End of variables declaration//GEN-END:variables
    private ChangeConstantControl con = new ChangeConstantControl();
}
