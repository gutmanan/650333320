/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author Yair Etzion
 */
public class MainLoginControl {
    
    public MainLoginControl(){
        
    }
    
    
    public boolean newUser(String username, String nickname, String firstname, String lastname, String email, String password,Date birthdate,Icon profileLabel){
        
        if (!(ValidatorManager.isAlpha(firstname) && ValidatorManager.isAlpha(lastname)) || firstname.isEmpty() || lastname.isEmpty()){
            JOptionPane.showMessageDialog(null, "The first/last name field is incorrect or empty");
            return false;
        }
        
        if (!(ValidatorManager.isValidEmailAddress(email))){
            JOptionPane.showMessageDialog(null, "The Email field is incorrect");
            return false;
        }
 
        if (nickname.isEmpty()){
            JOptionPane.showMessageDialog(null, "The nickname field is incorrect or empty");
            return false;
        }
        
        if (password.isEmpty()){
            JOptionPane.showMessageDialog(null, "The password field is incorrect or empty");
            return false;
        }
        
        if (!checkExsist(email))
            return false;
        
        Timestamp ts = new Timestamp(birthdate.getTime());
        String qry = "INSERT INTO tblUser (userAlphaCode, firstName, lastName, nickname, birthday, email, image, password)"
                                   + "VALUES('"+username+"','"+firstname+"','"+lastname+"','"+nickname+"',\""+ts+"\",'"+email+"',\""+profileLabel+"\",'"+password+"')";
        if (DBManager.insert(qry) == -2) {
            JOptionPane.showMessageDialog(null,
                "Congratulations your account was created successfully!",
                "Account was created",
                JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }
    
    public boolean checkExsist(String email){
        
        try {
            String sql = "SELECT tblUser.email\n" +
                        "FROM tblUser\n" +
                        "WHERE (((tblUser.email) Like \""+email+"\"));";
            
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            if (rs!=null && rs.next()){
                JOptionPane.showMessageDialog(null, "The email is already exsist");
                return false;
            }
            
            sql = "SELECT tblAgent.email\n" +
                        "FROM tblAgent\n" +
                        "WHERE (((tblAgent.email) Like \""+email+"\"));";
            
            rs = HandsInTheAir.getDB().query(sql);
            if (rs!=null && rs.next()){
                JOptionPane.showMessageDialog(null, "The email is already exsist");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreatePlaceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
                     
        return true;    

    }
}
