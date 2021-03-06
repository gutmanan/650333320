/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import entity.Show;
import businessLogic.HandsInTheAir;
import businessLogic.PDFManager;
import businessLogic.ReportProduceControl;
import businessLogic.WindowManager;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
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
public class ReportProduce extends javax.swing.JPanel {

    ReportProduceControl rpController = new ReportProduceControl();
    
    public ReportProduce() {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel18 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        jScrollPane2.setViewportView(jList1);

        add(jScrollPane2);
        jScrollPane2.setBounds(50, 380, 230, 131);

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setText("Artists participated in selected show:");
        add(jLabel18);
        jLabel18.setBounds(50, 350, 360, 20);

        jButton2.setText("Printable document");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(530, 70, 180, 24);

        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 110, 680, 220);

        jButton1.setText("Produce report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(380, 70, 140, 24);

        jComboBox1.addItem("Select year");
        for(int i = 2010; i < 2018; i++) {
            jComboBox1.addItem(String.valueOf(i));
        }
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(200, 70, 140, 24);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Choose year:");
        add(jLabel2);
        jLabel2.setBounds(60, 70, 150, 20);

        titleLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Yearly Profit Report");
        add(titleLabel);
        titleLabel.setBounds(0, 10, 850, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/container3.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jComboBox1.getSelectedIndex()==0) {
            return;
        }
        setTable();
        jComboBox1.setEnabled(false);
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HandsInTheAir.getPDF().createPDF(1, "Muza Music "+jComboBox1.getSelectedItem().toString()+" Profit Report");
        PDFManager.PDFFile pdf1 = HandsInTheAir.getPDF().getPDFFile(1);
        try {
            pdf1.addTitlePage("Muza Music "+jComboBox1.getSelectedItem().toString()+" Profit Report");
            String[] titles = new String[]{"Show ID","Created By","Presale sales","Regular sales","Total income","Total cost","Profit"};
            ArrayList<String> row = new ArrayList();
            ArrayList<String> artists = new ArrayList<>();
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                row.clear();
                artists.clear();
                for (int j = 0; j < jTable1.getColumnCount(); j++) {
                    row.add(jTable1.getModel().getValueAt(i, j).toString());
                }
                pdf1.addTable(jTable1.getColumnCount(),1, titles, row.toArray(new String[row.size()]));
                ArrayList<String> rs = rpController.getParticipatedArtists(Integer.valueOf(jTable1.getModel().getValueAt(i, 0).toString()));
                artists.add(rpController.getShow(Integer.valueOf(jTable1.getModel().getValueAt(i, 0).toString())).getMainArtist().getArtistAlphaCode());
                for (String r : rs) {
                    artists.add(r);
                }
                pdf1.addList("Participated Artists:",artists);
            }
        } catch (DocumentException ex) {
            Logger.getLogger(ReportProduce.class.getName()).log(Level.SEVERE, null, ex);
        }
        HandsInTheAir.getPDF().getPDFFile(1).launchPDF();
    }//GEN-LAST:event_jButton2ActionPerformed
        
    public void setTable() {
        int year = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        DefaultTableModel model = new DefaultTableModel(); 
        jTable1.setModel(model);
        model.addColumn("Show ID"); 
        model.addColumn("Created By");
        model.addColumn("Presale sales");
        model.addColumn("Regular sales");
        model.addColumn("Total income");
        model.addColumn("Total cost");
        model.addColumn("Profit");
        
        for (Map.Entry<Integer, Double> entry : rpController.getProfitableShows(year).entrySet()) {
            Integer key = entry.getKey();
            Double value = entry.getValue();
            Show tmpShow = rpController.getShow(key);
            int presale = rpController.getPresaleAmonutPerShow(year).get(key)*tmpShow.getTicketPrice();
            int regular = rpController.getRegularAmonutPerShow(year).get(key)*tmpShow.getTicketPrice();
            
            model.addRow(new Object[]{key, tmpShow.getCreateAgent().getId(), presale, regular, presale+regular, 
                                      formated(presale+regular-value), formated(value)});
        }

        PieDataset dataset = createDataset(rpController.getProfitableShows(year));
        JFreeChart chart = createChart(dataset, "Profit Distribution");
        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel, getComponentCount()-1);
        chartPanel.setOpaque(false);
        chartPanel.setBounds(305, 335, 370, 240);
        chartPanel.setVisible(true);
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jTable1.getSelectedRow() > -1) {
                    final Show tmp = rpController.getShow(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString()));
                    DefaultListModel<String> dlm = new DefaultListModel<String>();
                    dlm.addElement(tmp.getMainArtist().getArtistAlphaCode());
                    for (String s : rpController.getParticipatedArtists(tmp.getShowNumber())) {
                        dlm.addElement(s);
                    }
                    jList1.setModel(dlm);
                }      
            }
        });
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
