package Driver3;

import java.sql.Connection;
import java.sql.DriverManager;

public class Driver3_Connection2 
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("ids.sql.IDSDriver");
        
        Connection con = DriverManager.getConnection("jdbc:ids://localhost:12/conn?dsn=lit_dsn2", "system", "system");
        
        if(con != null)
        {
            System.out.println("Connected with ORACLE Database using Type-3!!");
            System.out.println(con);
        }
    }
}
