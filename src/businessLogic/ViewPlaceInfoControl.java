/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.ResultSet;

/**
 *
 * @author Yair Etzion
 */
public class ViewPlaceInfoControl {

    public ResultSet getPlaces(){
        
       String sql = "SELECT tblPlace.name, [street] & \" \" & [houseNumber] & \" , \" & [city] AS Expr1, tblPlace.email, tblPlace.phoneNumber\n" +
                        "FROM tblPlace\n" +
                        "ORDER BY tblPlace.name";
       
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
    
    public ResultSet getShowsPerPlace(String placeName){
       
       String sql = "SELECT tblShow.showNumber, tblArtist.stageName, tblShow.showDate, tblShow.status, tblShow.createDate, tblShow.ticketPrice, tblShow.minAge\n" +
                    "FROM tblPlace INNER JOIN (tblArtist INNER JOIN tblShow ON tblArtist.artistAlphaCode = tblShow.mainArtist) ON tblPlace.placeNumber = tblShow.place\n" +
                    "WHERE (((tblPlace.name) Like \""+placeName+"\"))";
       
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
}
