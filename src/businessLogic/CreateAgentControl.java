/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.swing.JOptionPane;

public class CreateAgentControl {

    public CreateAgentControl() {
    }
    
    public boolean checkIfExsist(String id){
        ResultSet rs = HandsInTheAir.getDB().query("SELECT tblAgent.ID\n" +
                                                "FROM tblAgent\n" +
                                                "WHERE (((tblAgent.ID) Like \""+id+"\"));");
        if (rs==null) return true;
        else{
            JOptionPane.showMessageDialog(null, "The agent is already exsists");
            return false;
        }
    }
    
    public boolean newAgent(String firstName, String lastName, String phoneNumber, String email, String password){
        
        String id = UUID.randomUUID().toString().substring(0,7);
        
        String sql = "SELECT tblAgent.ID FROM tblAgent WHERE (((tblAgent.ID) Like \""+id+"\"))";        
        try {
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            if (rs!=null && rs.next()){
                id = UUID.randomUUID().toString().substring(0,7);
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something wrong. Please try again latter..");
             return false;
        }
        
        if (!(ValidatorManager.isAlpha(firstName) && ValidatorManager.isAlpha(lastName)) || firstName.isEmpty() || lastName.isEmpty()){
            JOptionPane.showMessageDialog(null, "The first/last name field is incorrect or empty");
            return false;
        }
        
        if (!(ValidatorManager.isValidEmailAddress(email))){
            JOptionPane.showMessageDialog(null, "The Email field is incorrect");
            return false;
        }
        
        if (!(ValidatorManager.onlyContainsNumbers(phoneNumber))){
            JOptionPane.showMessageDialog(null, "The phone field is incorrect.\n Please enter only numbers");
            return false;
        }
        
        if (password.isEmpty()){
            JOptionPane.showMessageDialog(null, "The password field is incorrect or empty");
            return false;
        }
        
        String qry = ("INSERT INTO tblAgent (ID, firstName, lastName, phoneNumber, email, password) VALUES('"
                +id+"','"+firstName+"','"+lastName+"','"+phoneNumber+"','"+email+"','"+password+"')");
                
        HandsInTheAir.getDB().insert(qry);
        JOptionPane.showMessageDialog(null, "The agent was added successfuly!");
        
        return true;
    }
  
}
