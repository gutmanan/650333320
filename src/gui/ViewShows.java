/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import init.ReportProduceControl;
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
public class ViewShows extends javax.swing.JPanel {

    ReportProduceControl rpController = new ReportProduceControl();
    
    public ViewShows() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("View Shows :");
        add(jLabel4);
        jLabel4.setBounds(30, 10, 170, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 60, 780, 420);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container3.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 580);
    }// </editor-fold>//GEN-END:initComponents
        
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
