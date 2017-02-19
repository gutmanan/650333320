/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.ResultSet;
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
    
    public void newAgent(String id, String firstName, String lastName, String phoneNumber, String email, String password){
        
        String qry = ("INSERT INTO tblAgent (ID, firstName, lastName, phoneNumber, email, password) VALUES('"
                +id+"','"+firstName+"','"+lastName+"','"+phoneNumber+"','"+email+"','"+password+"')");
                
        HandsInTheAir.getDB().insert(qry);
        JOptionPane.showMessageDialog(null, "The agent was added successfuly!");
        
    }
  
}
