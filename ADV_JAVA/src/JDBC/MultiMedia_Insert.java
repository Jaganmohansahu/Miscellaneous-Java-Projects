package JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class MultiMedia_Insert 
{
    public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getOracleConnection();
        String sql = "insert into multi values(?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        
        FileInputStream fis = new FileInputStream("C:\\users\\jagan\\desktop\\62027.jpg");
        
        pst.setInt(1, 101);
        pst.setBinaryStream(2, fis, fis.available());
        
        int status = pst.executeUpdate();
        if(status>0)
            System.out.println("Multi-Media inserted successfully!!");
        else
            System.out.println("Error in insertion...");
        
        fis.close();
        con.close();
    }
}