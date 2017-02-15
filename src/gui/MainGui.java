/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import init.WindowManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author Shai Gutman
 */
public class MainGui extends JFrame {

    /**
     * Creates new form MainGui
     */
    public MainGui() {
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genericBtn3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        userBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        genericBtn4 = new javax.swing.JButton();
        genericBtn2 = new javax.swing.JButton();
        genericBtn1 = new javax.swing.JButton();
        wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 725));
        setResizable(false);
        getContentPane().setLayout(null);

        genericBtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/paramBtn1.png"))); // NOI18N
        genericBtn3.setBorderPainted(false);
        genericBtn3.setContentAreaFilled(false);
        genericBtn3.setDisabledIcon(null);
        genericBtn3.setDisabledSelectedIcon(null);
        genericBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genericBtn3ActionPerformed(evt);
            }
        });
        getContentPane().add(genericBtn3);
        genericBtn3.setBounds(0, 340, 160, 46);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/arrowBtn.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(70, 610, 80, 65);

        if (WindowManager.getAuthValue() == 1)
        userBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/agentBtn.png"))); // NOI18N
        if (WindowManager.getAuthValue() == 2 || WindowManager.getAuthValue() == 4)
        userBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/repBtn.png"))); // NOI18N
        userBtn.setBorder(null);
        userBtn.setBorderPainted(false);
        userBtn.setContentAreaFilled(false);
        userBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userBtnActionPerformed(evt);
            }
        });
        getContentPane().add(userBtn);
        userBtn.setBounds(1070, 520, 130, 40);

        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/logoutBtn.png"))); // NOI18N
        logoutBtn.setBorder(null);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        getContentPane().add(logoutBtn);
        logoutBtn.setBounds(1070, 565, 130, 40);

        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/exitBtn.png"))); // NOI18N
        exitBtn.setBorder(null);
        exitBtn.setBorderPainted(false);
        exitBtn.setContentAreaFilled(false);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(exitBtn);
        exitBtn.setBounds(1070, 610, 130, 40);

        genericBtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/btn3.png"))); // NOI18N
        genericBtn4.setBorderPainted(false);
        genericBtn4.setContentAreaFilled(false);
        genericBtn4.setDisabledIcon(null);
        genericBtn4.setDisabledSelectedIcon(null);
        if(WindowManager.getAuthValue() == 4)
        genericBtn4.setVisible(false);
        genericBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genericBtn4ActionPerformed(evt);
            }
        });
        getContentPane().add(genericBtn4);
        genericBtn4.setBounds(0, 380, 160, 46);

        if (WindowManager.getAuthValue() == 2)
        genericBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/viewAgentBtn2.png"))); // NOI18N
        if (WindowManager.getAuthValue() == 4)
        genericBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/btn2dis.png"))); // NOI18N
        genericBtn2.setBorderPainted(false);
        genericBtn2.setContentAreaFilled(false);
        genericBtn2.setDisabledIcon(null);
        genericBtn2.setDisabledSelectedIcon(null);
        genericBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genericBtn2ActionPerformed(evt);
            }
        });
        getContentPane().add(genericBtn2);
        genericBtn2.setBounds(0, 300, 160, 46);

        if (WindowManager.getAuthValue() == 2)
        genericBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/createAgentBtn2.png"))); // NOI18N
        if (WindowManager.getAuthValue() == 4)
        genericBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/btn1dis.png"))); // NOI18N
        genericBtn1.setBorderPainted(false);
        genericBtn1.setContentAreaFilled(false);
        genericBtn1.setDisabledIcon(null);
        genericBtn1.setDisabledSelectedIcon(null);
        genericBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genericBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(genericBtn1);
        genericBtn1.setBounds(0, 260, 160, 46);

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/MuzaBack.png"))); // NOI18N
        getContentPane().add(wallpaper);
        wallpaper.setBounds(0, 0, 1200, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void genericBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genericBtn1ActionPerformed
        
    }//GEN-LAST:event_genericBtn1ActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        System.exit(1);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        
        
        try {
            WindowManager.closeMain();
        } catch (SQLException ex) {
            Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void userBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        WindowManager.returnWindow();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void genericBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genericBtn2ActionPerformed
        
    }//GEN-LAST:event_genericBtn2ActionPerformed

    private void genericBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genericBtn4ActionPerformed
        WindowManager.openWin(new ReportProduce());
    }//GEN-LAST:event_genericBtn4ActionPerformed

    private void genericBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genericBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genericBtn3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton genericBtn1;
    private javax.swing.JButton genericBtn2;
    private javax.swing.JButton genericBtn3;
    private javax.swing.JButton genericBtn4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton userBtn;
    private javax.swing.JLabel wallpaper;
    // End of variables declaration//GEN-END:variables
}
