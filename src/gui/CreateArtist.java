/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import init.ReportProduceControl;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
public class CreateArtist extends javax.swing.JPanel {

    ReportProduceControl rpController = new ReportProduceControl();
    
    public CreateArtist() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        profileLabel = new javax.swing.JLabel();
        profileField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Create Artist :");
        add(jLabel4);
        jLabel4.setBounds(30, 10, 170, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Alpha Code :");
        add(jLabel2);
        jLabel2.setBounds(30, 70, 90, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Stage Name :");
        add(jLabel3);
        jLabel3.setBounds(30, 110, 90, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("FaceBook :");
        add(jLabel5);
        jLabel5.setBounds(30, 150, 90, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Choose signature picture :");
        add(jLabel6);
        jLabel6.setBounds(30, 250, 200, 10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Biography :");
        add(jLabel11);
        jLabel11.setBounds(340, 70, 110, 15);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(130, 60, 150, 30);
        jTextField1.setEditable(false);
        add(jTextField2);
        jTextField2.setBounds(130, 100, 150, 30);
        add(jTextField4);
        jTextField4.setBounds(130, 140, 150, 30);
        add(jTextField9);
        jTextField9.setBounds(440, 60, 350, 150);
        add(jTextField5);
        jTextField5.setBounds(130, 180, 150, 30);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(580, 440, 90, 40);

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(710, 440, 90, 40);

        uploadButton.setText("Upload");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });
        add(uploadButton);
        uploadButton.setBounds(30, 300, 80, 20);

        profileLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/defaultProfile.png"))); // NOI18N
        add(profileLabel);
        profileLabel.setBounds(260, 230, 200, 100);

        profileField.setEditable(false);
        add(profileField);
        profileField.setBounds(30, 270, 200, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Email :");
        add(jLabel7);
        jLabel7.setBounds(30, 190, 110, 15);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container3.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File chosen = chooser.getSelectedFile();
        String filename = chosen.getAbsolutePath();
        profileField.setText(filename);
        profileLabel.setIcon(new ImageIcon(filename));
    }//GEN-LAST:event_uploadButtonActionPerformed
        
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField profileField;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
}
