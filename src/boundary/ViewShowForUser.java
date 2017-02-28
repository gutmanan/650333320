/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import businessLogic.ReportProduceControl;
import businessLogic.ViewShowsForUserControl;
import businessLogic.WindowManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Shai Gutman
 */
public class ViewShowForUser extends javax.swing.JPanel {

    ReportProduceControl rpController = new ReportProduceControl();
    
    public ViewShowForUser() {
        if (WindowManager.getTmpUser()==null) return;
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

        newAccountFrame = new javax.swing.JInternalFrame();
        birthdayLabel = new javax.swing.JLabel();
        nicknameLabel = new javax.swing.JLabel();
        lastnameLabel = new javax.swing.JLabel();
        firstnameLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ticketPrice = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        internalWallpaper = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        viewGoogle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        newAccountFrame.setBorder(null);
        newAccountFrame.setTitle("Create new account");
        newAccountFrame.setMaximumSize(new java.awt.Dimension(525, 400));
        newAccountFrame.setMinimumSize(new java.awt.Dimension(525, 400));
        newAccountFrame.setPreferredSize(new java.awt.Dimension(525, 400));
        newAccountFrame.setVisible(false);
        newAccountFrame.getContentPane().setLayout(null);

        birthdayLabel.setText("Total Price :");
        newAccountFrame.getContentPane().add(birthdayLabel);
        birthdayLabel.setBounds(80, 190, 100, 14);

        nicknameLabel.setText("Number of Tickets To Buy :");
        newAccountFrame.getContentPane().add(nicknameLabel);
        nicknameLabel.setBounds(80, 110, 200, 14);

        lastnameLabel.setText(WindowManager.getTmpUser().getFirstName() +" "+WindowManager.getTmpUser().getLastName());
        newAccountFrame.getContentPane().add(lastnameLabel);
        lastnameLabel.setBounds(310, 70, 90, 14);

        firstnameLabel.setText("Ticket Price :");
        newAccountFrame.getContentPane().add(firstnameLabel);
        firstnameLabel.setBounds(80, 150, 110, 14);

        usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        usernameLabel.setText("Label :");
        newAccountFrame.getContentPane().add(usernameLabel);
        usernameLabel.setBounds(80, 30, 300, 22);

        jLabel2.setText("0");
        newAccountFrame.getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 190, 70, 14);

        jLabel3.setText("User Name : ");
        newAccountFrame.getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 70, 180, 14);

        ticketPrice.setText("price");
        newAccountFrame.getContentPane().add(ticketPrice);
        ticketPrice.setBounds(330, 150, 90, 14);

        jButton1.setText("Buy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        newAccountFrame.getContentPane().add(jButton1);
        jButton1.setBounds(310, 290, 80, 23);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        newAccountFrame.getContentPane().add(jButton2);
        jButton2.setBounds(400, 290, 90, 23);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        newAccountFrame.getContentPane().add(jComboBox1);
        jComboBox1.setBounds(320, 100, 50, 20);

        jLabel6.setText("Total tickets you bought :");
        newAccountFrame.getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 230, 180, 14);

        jLabel10.setText("jLabel10");
        newAccountFrame.getContentPane().add(jLabel10);
        jLabel10.setBounds(330, 230, 40, 14);

        internalWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container2.png"))); // NOI18N
        internalWallpaper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                internalWallpaperMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                internalWallpaperMousePressed(evt);
            }
        });
        newAccountFrame.getContentPane().add(internalWallpaper);
        internalWallpaper.setBounds(0, 0, 545, 370);

        add(newAccountFrame);
        newAccountFrame.setBounds(160, 50, 545, 370);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Show location (Google Maps) :");
        add(jLabel7);
        jLabel7.setBounds(350, 310, 260, 15);

        jTable1.setModel(new DefaultTableModel());
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 330, 220, 140);

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
    setTable2();

    add(jScrollPane2);
    jScrollPane2.setBounds(30, 70, 730, 210);

    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel8.setText("Artist participate in selected show :");
    add(jLabel8);
    jLabel8.setBounds(30, 310, 260, 15);

    jButton3.setText("Buy Tickets For This Show");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });
    add(jButton3);
    jButton3.setBounds(490, 490, 210, 60);
    jButton3.setEnabled(false);
    add(jLabel5);
    jLabel5.setBounds(40, 494, 350, 30);

    emailLabel.setText("* Presale allows you to buy till 4 tickets with discount");
    add(emailLabel);
    emailLabel.setBounds(40, 540, 390, 20);
    emailLabel.setVisible(false);

    titleLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    titleLabel.setText("View Shows");
    add(titleLabel);
    titleLabel.setBounds(0, 10, 850, 40);

    viewGoogle.setText("Click Here !");
    viewGoogle.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            viewGoogleActionPerformed(evt);
        }
    });
    add(viewGoogle);
    viewGoogle.setBounds(350, 340, 190, 30);

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container3.png"))); // NOI18N
    add(jLabel1);
    jLabel1.setBounds(0, 0, 850, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (con.buyTickets(jComboBox1.getSelectedIndex(),showsList.get(jTable2.getSelectedRow()),usernameLabel.getText()))
            WindowManager.openWin(new ViewShowForUser());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        newAccountFrame.setVisible(true);
        price = con.getTicketPriceForShow(showsList.get(jTable2.getSelectedRow()));
        ticketPrice.setText(String.valueOf(price));
        
        ResultSet rs = con.getTicketPerUser(showsList.get(jTable2.getSelectedRow()));
        
        jLabel10.setText("0");
        try {
            while(rs.next())
                jLabel10.setText(String.valueOf(rs.getInt(1)+rs.getInt(2)));
        } catch (SQLException ex) {
            Logger.getLogger(ViewShowForUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void internalWallpaperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_internalWallpaperMouseClicked
                 // TODO add your handling code here:
    }//GEN-LAST:event_internalWallpaperMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        newAccountFrame.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void internalWallpaperMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_internalWallpaperMousePressed
        
    }//GEN-LAST:event_internalWallpaperMousePressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int i = jComboBox1.getSelectedIndex();
                   
        discount = con.getDiscount();
        if (usernameLabel.getText().equals("Presale :"))
        jLabel2.setText(String.valueOf(price*i - price*i*discount/100));
        
        else
            jLabel2.setText(String.valueOf(price*i));
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void viewGoogleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewGoogleActionPerformed
       if (jTable2.getSelectedRow()<0) return;
        con.viewUrl((String) jTable2.getValueAt(jTable2.getSelectedRow(), 2));
    }//GEN-LAST:event_viewGoogleActionPerformed
        
    public void setTable2(){
        try {

            // TableModel definition
            String[] tableColumnsName = {"Show Date","Main Artist","Place Name","City","Ticket Price","Min. Age","Presale","Tickets Left"};
            DefaultTableModel aModel = (DefaultTableModel) jTable2.getModel();
            aModel.setColumnIdentifiers(tableColumnsName);
            jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    
                    if (jTable2.getSelectedRow() > -1) {
                        setTable1();
                        int num = con.isAbleToBuy(WindowManager.getTmpUser().getUserAlphaCode(), showsList.get(jTable2.getSelectedRow()),
                                (String) jTable2.getValueAt(jTable2.getSelectedRow(), 6), (int)jTable2.getValueAt(jTable2.getSelectedRow(), 7));
                        switch(num){
                            case 0:
                                jButton3.setEnabled(false);
                                jLabel5.setText("* Tickets were sold out");
                                break;
                            case 1:
                                jButton3.setEnabled(true);
                                usernameLabel.setText("Presale :");
                                emailLabel.setVisible(true);
                                jLabel5.setText("");
                                break;
                            case 2:
                                jButton3.setEnabled(true);
                                emailLabel.setVisible(false);
                                usernameLabel.setText("Regular Sale :");
                                jLabel5.setText("");
                                break;
                            case 3:
                                jButton3.setEnabled(false);
                                jLabel5.setText("* The regular sale will open soon");
                            case 4:
                                jButton3.setEnabled(false);
                                jLabel5.setText("* You under the age");

                            default:
                                jButton3.setEnabled(false);
                                if(((String) jTable2.getValueAt(jTable2.getSelectedRow(), 6)).equals("Yes"))
                                 jLabel5.setText("* You are not a fan. You can't buy tickets at presale");
                                break;
                        }
                        
                    }
                }
            });
            
            ResultSet shows = null;
            
            shows = con.getShows();
            
            
            // Loop through the ResultSet and transfer in the Model
            java.sql.ResultSetMetaData rsmd = shows.getMetaData();
            int colNo = rsmd.getColumnCount();
            while(shows.next()){
                if (shows.getDate(3).before(new Date())) continue;
                Object[] objects = new Object[colNo];
                // tanks to umit ozkan for the bug fix!
                for(int i=0;i<colNo-2;i++){
                    objects[i]=shows.getObject(i+3);
                }
                
                Date presale = shows.getDate(3);
                presale.setDate(presale.getDate()-21);
                if (new Date().before(presale))
                   objects[6] = "Yes";
                objects[7] = con.getNumOfTicketsLeft(shows.getInt(1));
                showsList.add(shows.getInt(1));
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
            String[] tableColumnsName = {"Artist Name"};
            DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
            aModel.setColumnIdentifiers(tableColumnsName);
            
            ResultSet shows = null;
            
            shows = con.getArtistForShow(showsList.get(jTable2.getSelectedRow()));

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
        
  }
  
    public void labelShow(int num){
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel firstnameLabel;
    private javax.swing.JLabel internalWallpaper;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JInternalFrame newAccountFrame;
    private javax.swing.JLabel nicknameLabel;
    private javax.swing.JLabel ticketPrice;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JButton viewGoogle;
    // End of variables declaration//GEN-END:variables
    private ViewShowsForUserControl con = new ViewShowsForUserControl();
    private ArrayList<Integer> showsList = new ArrayList<Integer>();
    private Double price = null;
    private int discount = 0;
}
