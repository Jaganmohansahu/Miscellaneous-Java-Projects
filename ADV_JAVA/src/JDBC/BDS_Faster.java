package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

public class BDS_Faster {
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "system";
        String password = "system";
        
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(driver);
        bds.setUrl(url);
        bds.setUsername(username);
        bds.setPassword(password);
        
        //BasicDataSource will be faster than DriverManager
        //BDS creates object ones but DriverManager creates object = no. of connections
        
        long start, stop;
        
        //Connection by BasicDataSource
        start = System.currentTimeMillis();
        for(int i=0; i<1500; i++)
        {
            //System.out.println("Connected with ORACLE Database using BasicDataSource");
            Connection con = bds.getConnection();
            //System.out.println(con.hashCode());
            con.close();
        }
        stop = System.currentTimeMillis();
        System.out.println("Time taken by BDS = " + (stop-start));
        
        System.out.println("------------------------------");
        
        //Connection by DriverManager
        Class.forName(driver);
        start = System.currentTimeMillis();
        for(int i=0; i<50; i++)
        {
            //System.out.println("Connected with ORACLE Database using BasicDataSource");
            Connection con = DriverManager.getConnection(url, username, password);
            //System.out.println(con.hashCode());
            con.close();
        }
        stop = System.currentTimeMillis();
        System.out.println("Time taken by DriverManager = " + (stop-start));
    }
}
