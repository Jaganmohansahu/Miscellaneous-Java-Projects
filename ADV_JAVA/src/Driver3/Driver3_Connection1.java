package Driver3;

import java.sql.Connection;
import java.sql.DriverManager;

public class Driver3_Connection1 
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("ids.sql.IDSDriver");
        
        Connection con = DriverManager.getConnection("jdbc:ids://localhost:12/conn?dsn=lit_dsn1");
        
        if(con != null)
        {
            System.out.println("Connected with MS_ACCESS Database !!");
            System.out.println(con);
        }
    }
}
