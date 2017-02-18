/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Yair Etzion
 */
public class ChangeConstantControl {
    
    public ChangeConstantControl(){   
    }
    
    public ResultSet getConstants(){
        String sql = "SELECT tblConstants.*\n" +
                     "FROM tblConstants\n" +
                     "ORDER BY tblConstants.dateOfChange DESC;";
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        return rs;
    }
    
    public void saveConstants(Timestamp ts,String placeExpField,String placeIncField,String showDurField,String artistIncField,String presaleDisField,String maxTicketsField,String regSaleField,String waitTimeField, String bDayTextField){
        
        String sql = "INSERT INTO tblConstants (dateOfChange, placeExpanse, placeIncome, showDuration, artistIncome, presaleDiscount, maxPresaleTicketsPerUser, regularSaleDays, propasalWaitDays, birthdayText)"
                   + "VALUES(\""+ts+"\",'"+placeExpField+"','"+placeIncField+"','"+showDurField+"','"+artistIncField+"','"+presaleDisField+"','"+maxTicketsField+
                            "','"+regSaleField+"','"+waitTimeField+"','"+bDayTextField+"')";        
        
        HandsInTheAir.getDB().insert(sql);
        JOptionPane.showMessageDialog(null, "The constants was saved!");
    }
}
/*String qry = "INSERT INTO tblConstants (dateOfChange, placeExpanse, placeIncome, showDuration, artistIncome, presaleDiscount, maxPresaleTicketsPerUser, regularSaleDays, propasalWaitDays, birthdayText)"
                   + "VALUES(\""+ts+"\",'"+placeExpField.getText()+"','"+placeIncField.getText()+"','"+showDurField.getText()+"','"+artistIncField.getText()+"','"+presaleDisField.getText()+"','"+maxTicketsField.getText()+
                            "','"+regSaleField.getText()+"','"+waitTimeField.getText()+"','"+bDayTextField.getText()+"')";      */