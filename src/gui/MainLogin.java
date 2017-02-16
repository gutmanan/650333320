/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import core.Agent;
import init.HandsInTheAir;

import init.WindowManager;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Shai Gutman
 */
public class MainLogin extends javax.swing.JFrame {

    /**
     * Creates new form MainLogin
     */
    public MainLogin() throws SQLException {
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

        newAccountFrame = new javax.swing.JInternalFrame();
        yearBox = new javax.swing.JComboBox<>();
        monthBox = new javax.swing.JComboBox<>();
        dayBox = new javax.swing.JComboBox<>();
        registerButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        birthdayLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        nicknameLabel = new javax.swing.JLabel();
        nicknameField = new javax.swing.JTextField();
        lastnameLabel = new javax.swing.JLabel();
        lastnameField = new javax.swing.JTextField();
        firstnameLabel = new javax.swing.JLabel();
        passwordLabel1 = new javax.swing.JLabel();
        firstnameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        uploadButton = new javax.swing.JButton();
        profileField = new javax.swing.JTextField();
        profileLabel = new javax.swing.JLabel();
        internalWallpaper = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        createUserBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        passwordArea = new javax.swing.JTextField();
        usernameArea = new javax.swing.JTextField();
        wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 725));
        setResizable(false);
        getContentPane().setLayout(null);

        newAccountFrame.setTitle("Create new account");
        newAccountFrame.setOpaque(false);
        newAccountFrame.setVisible(true);
        newAccountFrame.getContentPane().setLayout(null);

        Date today = new Date(new java.util.Date().getTime());
        int begin = today.getYear()-100;
        String[] years =  new String[100];
        for (int i = 0; i < 100; i++)
        years[i] = ""+((begin++)+1900);
        yearBox.setModel(new javax.swing.DefaultComboBoxModel<>(years));
        newAccountFrame.getContentPane().add(yearBox);
        yearBox.setBounds(330, 270, 70, 25);

        String[] months =  new String[12];
        for (int i = 0; i < 12; i++)
        months[i] = ""+(i+1);
        monthBox.setModel(new javax.swing.DefaultComboBoxModel<>(months));
        newAccountFrame.getContentPane().add(monthBox);
        monthBox.setBounds(250, 270, 70, 25);

        String[] days =  new String[31];
        for (int i = 0; i < 31; i++)
        days[i] = ""+(i+1);
        dayBox.setModel(new javax.swing.DefaultComboBoxModel<>(days));
        newAccountFrame.getContentPane().add(dayBox);
        dayBox.setBounds(170, 270, 70, 25);

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        newAccountFrame.getContentPane().add(registerButton);
        registerButton.setBounds(300, 320, 90, 26);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        newAccountFrame.getContentPane().add(cancelButton);
        cancelButton.setBounds(410, 320, 80, 26);

        birthdayLabel.setForeground(new java.awt.Color(0, 0, 0));
        birthdayLabel.setText("Birthday:");
        newAccountFrame.getContentPane().add(birthdayLabel);
        birthdayLabel.setBounds(90, 280, 90, 16);

        emailLabel.setForeground(new java.awt.Color(0, 0, 0));
        emailLabel.setText("Email:");
        newAccountFrame.getContentPane().add(emailLabel);
        emailLabel.setBounds(90, 240, 90, 16);

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        newAccountFrame.getContentPane().add(emailField);
        emailField.setBounds(170, 240, 150, 20);

        nicknameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nicknameLabel.setText("Nickname:");
        newAccountFrame.getContentPane().add(nicknameLabel);
        nicknameLabel.setBounds(90, 180, 90, 16);

        nicknameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicknameFieldActionPerformed(evt);
            }
        });
        newAccountFrame.getContentPane().add(nicknameField);
        nicknameField.setBounds(170, 180, 90, 20);

        lastnameLabel.setForeground(new java.awt.Color(0, 0, 0));
        lastnameLabel.setText("Last Name:");
        newAccountFrame.getContentPane().add(lastnameLabel);
        lastnameLabel.setBounds(280, 210, 90, 16);

        lastnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameFieldActionPerformed(evt);
            }
        });
        newAccountFrame.getContentPane().add(lastnameField);
        lastnameField.setBounds(360, 210, 90, 20);

        firstnameLabel.setForeground(new java.awt.Color(0, 0, 0));
        firstnameLabel.setText("First Name:");
        newAccountFrame.getContentPane().add(firstnameLabel);
        firstnameLabel.setBounds(90, 210, 90, 16);

        passwordLabel1.setForeground(new java.awt.Color(0, 0, 0));
        passwordLabel1.setText("Please upload a profile picture:");
        newAccountFrame.getContentPane().add(passwordLabel1);
        passwordLabel1.setBounds(250, 90, 200, 16);

        firstnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameFieldActionPerformed(evt);
            }
        });
        newAccountFrame.getContentPane().add(firstnameField);
        firstnameField.setBounds(170, 210, 90, 20);

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        newAccountFrame.getContentPane().add(passwordField);
        passwordField.setBounds(330, 60, 120, 20);

        passwordLabel.setForeground(new java.awt.Color(0, 0, 0));
        passwordLabel.setText("Password:");
        newAccountFrame.getContentPane().add(passwordLabel);
        passwordLabel.setBounds(250, 60, 90, 16);

        usernameLabel.setForeground(new java.awt.Color(0, 0, 0));
        usernameLabel.setText("Username:");
        newAccountFrame.getContentPane().add(usernameLabel);
        usernameLabel.setBounds(250, 30, 90, 16);

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        newAccountFrame.getContentPane().add(usernameField);
        usernameField.setBounds(330, 30, 120, 20);

        uploadButton.setText("Upload");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });
        newAccountFrame.getContentPane().add(uploadButton);
        uploadButton.setBounds(250, 135, 80, 26);

        profileField.setEditable(false);
        newAccountFrame.getContentPane().add(profileField);
        profileField.setBounds(250, 110, 200, 20);

        profileLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/defaultProfile.png"))); // NOI18N
        newAccountFrame.getContentPane().add(profileLabel);
        profileLabel.setBounds(90, 30, 139, 131);

        internalWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container2.png"))); // NOI18N
        newAccountFrame.getContentPane().add(internalWallpaper);
        internalWallpaper.setBounds(0, 0, 545, 370);

        getContentPane().add(newAccountFrame);
        newAccountFrame.setBounds(320, 230, 550, 400);

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

        createUserBtn.setForeground(new java.awt.Color(51, 51, 51));
        createUserBtn.setText("Create new account");
        createUserBtn.setBorder(null);
        createUserBtn.setBorderPainted(false);
        createUserBtn.setContentAreaFilled(false);
        createUserBtn.setFocusPainted(false);
        createUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserBtnActionPerformed(evt);
            }
        });
        getContentPane().add(createUserBtn);
        createUserBtn.setBounds(690, 560, 140, 16);

        loginBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setBorder(null);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setLabel("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        getContentPane().add(loginBtn);
        loginBtn.setBounds(697, 500, 310, 40);

        passwordArea.setBorder(null);
        passwordArea.setOpaque(false);
        passwordArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordAreaKeyPressed(evt);
            }
        });
        getContentPane().add(passwordArea);
        passwordArea.setBounds(730, 450, 280, 30);

        usernameArea.setBorder(null);
        usernameArea.setOpaque(false);
        usernameArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameAreaKeyPressed(evt);
            }
        });
        getContentPane().add(usernameArea);
        usernameArea.setBounds(730, 400, 280, 30);

        wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/muzaLogin.png"))); // NOI18N
        getContentPane().add(wallpaper);
        wallpaper.setBounds(0, 0, 1200, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        System.exit(1);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        openMain();
    }//GEN-LAST:event_loginBtnActionPerformed

    private void usernameBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameBtnKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            openMain();
        } 
    }//GEN-LAST:event_usernameBtnKeyPressed

    private void passwordBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordBtnKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            openMain();
        }
    }//GEN-LAST:event_passwordBtnKeyPressed

    private void createUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserBtnActionPerformed
        newAccountFrame.setVisible(true);
    }//GEN-LAST:event_createUserBtnActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void firstnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameFieldActionPerformed

    private void lastnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameFieldActionPerformed

    private void nicknameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicknameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicknameFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        newAccountFrame.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerButtonActionPerformed
    
    public void openMain() {
        if (usernameBtn.getText().equals("") || passwordBtn.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                "You must enter username & password",
                "Login error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (usernameBtn.getText().equals("Admin") && passwordBtn.getText().equals("Admin")) {
            WindowManager.setUser(2, null);
            this.dispose();
            WindowManager.startMain();
            return;
        } if (usernameBtn.getText().equals("Place") && passwordBtn.getText().equals("Place")) {
            WindowManager.setUser(4, null);
            this.dispose();
            WindowManager.startMain();
            return;
        } else {
            ResultSet rs = HandsInTheAir.getDB().query("SELECT tblAgent.*\n" +
                                                       "FROM tblAgent " +
                                                       "WHERE tblAgent.ID=\""+usernameBtn.getText()+"\"");
            try {
                while (rs.next()) {
                    if (rs.getString(6).equals(passwordBtn.getText())) {
                        WindowManager.setUser(1, new Agent(rs.getString(1), rs.getString(2), rs.getString(3), 
                                                           rs.getString(4), rs.getString(5), rs.getString(6)));
                        this.dispose();
                        WindowManager.startMain();
                        return;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(this,
                "Incorrect username or password",
                "Login error",
                JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createUserBtn;
    private javax.swing.JComboBox<String> dayBox;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton exitBtn;
    private javax.swing.JTextField firstnameField;
    private javax.swing.JLabel firstnameLabel;
    private javax.swing.JLabel internalWallpaper;
    private javax.swing.JTextField lastnameField;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JButton loginBtn;
    private javax.swing.JComboBox<String> monthBox;
    private javax.swing.JInternalFrame newAccountFrame;
    private javax.swing.JTextField nicknameField;
    private javax.swing.JLabel nicknameLabel;
    private javax.swing.JTextField passwordArea;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JTextField profileField;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton uploadButton;
    private javax.swing.JTextField usernameArea;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel wallpaper;
    private javax.swing.JComboBox<String> yearBox;
    // End of variables declaration//GEN-END:variables
}
