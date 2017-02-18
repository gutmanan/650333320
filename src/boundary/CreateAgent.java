/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import businessLogic.HandsInTheAir;
import businessLogic.ReportProduceControl;
import businessLogic.ValidatorManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Shai Gutman
 */
public class CreateAgent extends javax.swing.JPanel {

    ReportProduceControl rpController = new ReportProduceControl();
    
    public CreateAgent() {
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

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Create Agent :");
        add(jLabel4);
        jLabel4.setBounds(30, 10, 170, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID Code :");
        add(jLabel2);
        jLabel2.setBounds(30, 70, 90, 15);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.setText(UUID.randomUUID().toString().substring(0,7));
        add(jTextField1);
        jTextField1.setBounds(130, 60, 170, 30);
        jTextField1.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("First Name :");
        add(jLabel3);
        jLabel3.setBounds(30, 110, 90, 15);
        add(jTextField2);
        jTextField2.setBounds(130, 100, 170, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Last Name :");
        add(jLabel5);
        jLabel5.setBounds(30, 150, 90, 15);
        add(jTextField3);
        jTextField3.setBounds(130, 140, 170, 30);
        add(jTextField4);
        jTextField4.setBounds(130, 180, 170, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Email :");
        add(jLabel6);
        jLabel6.setBounds(30, 190, 60, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("PhoneNumber :");
        add(jLabel7);
        jLabel7.setBounds(30, 230, 100, 15);
        add(jTextField5);
        jTextField5.setBounds(130, 220, 170, 30);
        add(jTextField6);
        jTextField6.setBounds(130, 260, 170, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Password :");
        add(jLabel8);
        jLabel8.setBounds(30, 270, 100, 15);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(60, 310, 90, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container3.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql = "SELECT tblAgent.ID FROM tblAgent WHERE (((tblAgent.ID) Like \""+jTextField1.getText()+"\"))";        
        try {
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            if (rs!=null && rs.next()){
                JOptionPane.showMessageDialog(null, "The agent alphanumeric code is already exsist");
                jTextField1.setText(UUID.randomUUID().toString().substring(0,7));
                return;
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something wrong. Please try again latter..");
             return;
        }

        if (!ValidatorManager.isAlphaCode(jTextField1.getText())){
            JOptionPane.showMessageDialog(null, "Please enter only numbers and chars to alpha code field");
            return;
        }
        
        if (!(ValidatorManager.isAlpha(jTextField2.getText()) && ValidatorManager.isAlpha(jTextField3.getText())) || jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "The first/last name field is incorrect or empty");
            return;
        }
        
        if (!(ValidatorManager.isValidEmailAddress(jTextField4.getText()))){
            JOptionPane.showMessageDialog(null, "The Email field is incorrect");
            return;
        }
        
        if (!(ValidatorManager.onlyContainsNumbers(jTextField5.getText()))){
            JOptionPane.showMessageDialog(null, "The phone field is incorrect.\n Please enter only numbers");
            return;
        }
        
        if (jTextField5.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "The password field is incorrect or empty");
            return;
        }
        
        String qry = ("INSERT INTO tblAgent (ID, firstName, lastName, phoneNumber, email, password) VALUES('"
                +jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"','"
                +jTextField4.getText()+"','"+jTextField5.getText()+"','"+jTextField6.getText()+"')");
                    
        HandsInTheAir.getDB().insert(qry);
        JOptionPane.showMessageDialog(null, "The agent was added successfuly!");
    }//GEN-LAST:event_jButton1ActionPerformed
        
    private PieDataset createDataset(HashMap<Integer, Double> map) {
        DefaultPieDataset result = new DefaultPieDataset();
        Double sum = 0.0;
        for (Double d : map.values()) {
            sum += d;
        }
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Double value = entry.getValue();
            result.setValue("Show"+" "+key, value/sum*100);
        }
        return result;
    }

    private JFreeChart createChart(PieDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
        PiePlot plot = (PiePlot3D)chart.getPlot();
        ImageIcon img = new ImageIcon(getClass().getResource("/imgs/container2.png"));
        chart.setBackgroundImage(img.getImage());
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.6f);
        plot.setBackgroundAlpha(0.25f);
        return chart;
    }
    
    public String formated(double d) {
        String s = String.valueOf(d);
        String[] result = s.split("\\.");
        return result[0]+"."+result[1].charAt(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
