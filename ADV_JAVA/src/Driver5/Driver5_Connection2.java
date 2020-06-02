package Driver5;

import java.sql.Connection;
import java.sql.DriverManager;

public class Driver5_Connection2 
{
    public static void main(String[] args)  throws Exception
    {
        Class.forName("com.ddtek.jdbc.oracle.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:datadirect:oracle://localhost:1521;SID=xe", "system", "system");
        
        if(con != null)
        {
            System.out.println("Connected with Oracle database using Type-5");
            System.out.println(con);
        }
    }
}
