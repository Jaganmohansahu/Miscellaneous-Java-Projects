package bank.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Provider 
{
    private static Connection con = null;
    
    //ORACLE Connection
    public static Connection getConnection()
    {
        Connection con = null;
        try {
            if(con == null)
            {
                Class.forName("oracle.jdbc.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
        
 /*   //MYSQL Connection
     public static Connection getMysqlConnection()
    {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lit", "root", "tiger");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }*/
}
