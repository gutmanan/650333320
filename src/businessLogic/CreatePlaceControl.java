/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import entity.E_CITIES;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yair Etzion
 */
public class CreatePlaceControl {
    
    public CreatePlaceControl(){
        
    }
    
    public void newPlace(String name, String street, String houseNumber, String city, String email,
            String phoneNumber, String location, String maxCapacity, boolean check,String cover,
            boolean seats,boolean platform,boolean gear,boolean toilets){
        
        if (!checkExsist(name))
            return;
        if (!(ValidatorManager.isAlpha(name)) || name.length()==0){
            JOptionPane.showMessageDialog(null, "The name field is incorrect or empty");
            return;
        }
        if (!(ValidatorManager.isAlpha(street)) || street.length()==0){
            JOptionPane.showMessageDialog(null, "The street field is incorrect or empty");
            return;
        }
        if (!(ValidatorManager.onlyContainsNumbers(houseNumber)) || houseNumber.length()==0){
            JOptionPane.showMessageDialog(null, "The houseNumber field is incorrect or empty.\n Please enter only numbers");
            return;
        }
        if (!(ValidatorManager.isValidEmailAddress(email))){
            JOptionPane.showMessageDialog(null, "The Email field is incorrect. \n Example : abc@def.com");
            return;
        }
        if (!(ValidatorManager.onlyContainsNumbers(phoneNumber)) || phoneNumber.length()==0){
            JOptionPane.showMessageDialog(null, "The phoneNumber field is incorrect or empty. Please enter only numbers");
            return;
        }
        if (!(ValidatorManager.isValidURL(location))){
            JOptionPane.showMessageDialog(null, "The location field is incorrect or empty. \n Please enter full URL address from google maps");
            return;
        }
        if (!(ValidatorManager.onlyContainsNumbers(maxCapacity)) || maxCapacity.length()==0){
            JOptionPane.showMessageDialog(null, "The maxCapacity field is incorrect or empty. Please enter only numbers");
            return;
        }

        String sql = ("INSERT INTO tblPlace (name, street, houseNumber, city, country, email, phoneNumber, location, maxCapacity) VALUES('"
                +name+"','"+street+"','"+houseNumber+"','"
                +city+"','"+"Israel"+"','"+email+"','"+phoneNumber+"','"+location+"','"+maxCapacity+"')");
        
        HandsInTheAir.getDB().insert(sql);
        if (check==false)
            JOptionPane.showMessageDialog(null, "The place was added successfuly!");
        
        else newOpenPlace(cover, seats, platform, gear, toilets);
        
    }
    
    public boolean checkExsist(String name){
        
        try {
            String sql = "SELECT tblPlace.name FROM tblPlace WHERE (((tblPlace.name) Like \""+name+"\"))";
            
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            if (rs!=null && rs.next()){
                JOptionPane.showMessageDialog(null, "The place name exsist");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreatePlaceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
                     
        return true;    

    }
    
    public void newOpenPlace(String cover,boolean seats,boolean platform,boolean gear,boolean toilets){
            
        try {
            String sql = "SELECT tblPlace.placeNumber FROM tblPlace ORDER BY tblPlace.placeNumber DESC;";
            
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            
            String placeNum = null;
            if(rs.next())
                placeNum=rs.getString(1);
            
            sql = ("INSERT INTO tblOpenPlace (ID, cover, HasSeats, HasPlatform, HasGear, HasToilets) VALUES('"
                    +placeNum+"','"+cover+"','"+seats+"','"
                    +platform+"','"+gear+"','"+toilets+"')");
            
            HandsInTheAir.getDB().insert(sql);

            JOptionPane.showMessageDialog(null, "The open place was added successfuly!");
            
        } catch (SQLException ex) {
            Logger.getLogger(CreatePlaceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
    }
    
      
    public List<E_CITIES> ListOfCity(String country){
        List<E_CITIES> cityList = new ArrayList<E_CITIES>();
        
        for (E_CITIES city : E_CITIES.values()){
            if (country.equals(city.getCountry()) && !cityList.contains(city))
                cityList.add(city);
        }
        Collections.sort(cityList);
        return cityList;
    }
    
}
            
           /* String sql = "SELECT tblPlace.placeNumber FROM tblPlace ORDER BY tblPlace.placeNumber DESC;";
            
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            
            int placeNumber = 1;
            
            while (rs.next()){
                placeNumber++;
            }*/