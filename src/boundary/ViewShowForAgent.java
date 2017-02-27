/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import businessLogic.ReportProduceControl;
import businessLogic.ViewShowsForAgentControl;
import businessLogic.ViewShowsForUserControl;
import businessLogic.WindowManager;
import static java.awt.image.ImageObserver.SOMEBITS;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Shai Gutman
 */
public class ViewShowForAgent extends javax.swing.JPanel {
    
    public ViewShowForAgent() {
        if (WindowManager.getTmpAgent()==null) return;
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

        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Press = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

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

    add(jScrollPane2);
    jScrollPane2.setBounds(30, 70, 730, 210);

    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel8.setText("Artist participate in selected show :");
    add(jLabel8);
    jLabel8.setBounds(30, 310, 260, 15);
    add(jLabel5);
    jLabel5.setBounds(40, 494, 350, 30);

    titleLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
    titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    titleLabel.setText("View Shows");
    add(titleLabel);
    titleLabel.setBounds(0, 0, 850, 40);

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel4.setText("Shows you created :");
    add(jLabel4);
    jLabel4.setBounds(30, 44, 170, 20);

    Press.setText("Click Here!");
    Press.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            PressActionPerformed(evt);
        }
    });
    add(Press);
    Press.setBounds(350, 330, 180, 140);
    Press.setEnabled(false);

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container3.png"))); // NOI18N
    add(jLabel1);
    jLabel1.setBounds(0, 0, 850, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void PressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PressActionPerformed
        con.getGoogleMapsLoc((String) jTable2.getValueAt(jTable2.getSelectedRow(), 3));
    }//GEN-LAST:event_PressActionPerformed
        
    public void setTable2(){
        try {

            // TableModel definition
            String[] tableColumnsName = {"No.","Show Date","Main Artist","Place Name","Status","Create date","Ticket Price","Min. Age","Tickets Left"};
            DefaultTableModel aModel = (DefaultTableModel) jTable2.getModel();
            aModel.setColumnIdentifiers(tableColumnsName);
            jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    
                    if (jTable2.getSelectedRow() > -1) {
                        setTable1();
                        Press.setEnabled(true);
                        }
                }
            });
            
            ResultSet shows = null;
            
            shows = con.getShowsCreated();

            // Loop through the ResultSet and transfer in the Model
            java.sql.ResultSetMetaData rsmd = shows.getMetaData();
            int colNo = rsmd.getColumnCount();
            while(shows.next()){
            
                Object[] objects = new Object[colNo];
                // tanks to umit ozkan for the bug fix!
                for(int i=0;i<colNo-1;i++){
                    objects[i]=shows.getObject(i+1);
                }
                
                objects[8] = con.getNumOfTicketsLeft(shows.getInt(1));
                //showsList.add(shows.getInt(1));
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
            
            shows = con.getArtistForShow((int) jTable2.getValueAt(jTable2.getSelectedRow(), 0));

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Press;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    private ViewShowsForAgentControl con = new ViewShowsForAgentControl();
    //private ArrayList<Integer> showsList = new ArrayList<Integer>();
}
