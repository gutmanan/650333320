/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Yair Etzion
 */
public class ViewAgentControl {
    
    public ViewAgentControl(){
        
    }
    
    public ResultSet getAgents(){
        
        String sql = "SELECT tblAgent.*, tblAgent.firstName\n" +"FROM tblAgent\n" +"ORDER BY tblAgent.firstName";

        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;

    }
    
    public ResultSet getArtists(String id){
        
        String sql = "SELECT tblArtist.agentID, tblArtist.stageName, tblArtist.email, tblArtist.facebook, tblArtist.IsActive FROM tblArtist WHERE (((tblArtist.agentID) Like \""+id+"\")) ORDER BY tblArtist.stageName";

        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;

    }
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
}
