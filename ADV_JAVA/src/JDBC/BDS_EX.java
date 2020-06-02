package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

public class BDS_EX {
    public static void main(String[] args) throws SQLException
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
        
        for(int i=0; i<5; i++)
        {
            System.out.println("Connected with ORACLE Database using BasicDataSource");
            Connection con = bds.getConnection();
            System.out.println(con.hashCode());
            con.close();
        }
    }
}
