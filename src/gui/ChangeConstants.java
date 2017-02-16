/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import init.ReportProduceControl;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import utils.E_Cities;

/**
 *
 * @author Shai Gutman
 */
public class ChangeConstants extends javax.swing.JPanel {

    ReportProduceControl rpController = new ReportProduceControl();
    
    public ChangeConstants() {
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
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Create Place :");
        add(jLabel4);
        jLabel4.setBounds(30, 10, 170, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Place Expanse (%) :");
        add(jLabel3);
        jLabel3.setBounds(30, 110, 130, 15);
        add(jTextField2);
        jTextField2.setBounds(190, 60, 150, 30);
        jTextField2.setEditable(false);
        add(jTextField4);
        jTextField4.setBounds(190, 140, 150, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Place Income (%) :");
        add(jLabel6);
        jLabel6.setBounds(30, 150, 150, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Show Duration (Hours) :");
        add(jLabel7);
        jLabel7.setBounds(30, 190, 160, 15);
        add(jTextField5);
        jTextField5.setBounds(190, 180, 150, 30);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(670, 390, 90, 40);
        jButton1.setEnabled(false);
        add(jTextField7);
        jTextField7.setBounds(620, 140, 150, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Max presale tickes per user :");
        add(jLabel9);
        jLabel9.setBounds(440, 150, 190, 15);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Presale Discount (%) :");
        add(jLabel10);
        jLabel10.setBounds(440, 110, 190, 15);
        add(jTextField8);
        jTextField8.setBounds(620, 100, 150, 30);
        add(jTextField9);
        jTextField9.setBounds(620, 60, 150, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Artist Income (%) :");
        add(jLabel11);
        jLabel11.setBounds(440, 70, 200, 15);
        add(jTextField10);
        jTextField10.setBounds(620, 180, 150, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Regular sale days :");
        add(jLabel12);
        jLabel12.setBounds(440, 190, 190, 15);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Last update at :");
        add(jLabel13);
        jLabel13.setBounds(30, 70, 130, 15);
        add(jTextField11);
        jTextField11.setBounds(620, 220, 150, 70);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Birthday Text :");
        add(jLabel14);
        jLabel14.setBounds(440, 230, 190, 15);
        add(jTextField6);
        jTextField6.setBounds(190, 220, 150, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Propasal Wait Days :");
        add(jLabel15);
        jLabel15.setBounds(30, 230, 140, 15);
        add(jTextField3);
        jTextField3.setBounds(190, 100, 150, 30);

        jCheckBox1.setText("Check if you want to update");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        add(jCheckBox1);
        jCheckBox1.setBounds(30, 330, 170, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container3.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected())
            jButton1.setEnabled(true);
        else 
            jButton1.setEnabled(false);                                  
    }//GEN-LAST:event_jCheckBox1ActionPerformed
        
    public void setTable() {

    }
    
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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
