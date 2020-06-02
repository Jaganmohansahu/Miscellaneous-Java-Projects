package Driver4;

import java.sql.Connection;
import java.sql.DriverManager;

public class Driver4_Connection2
{
    public static void main(String[] args)  throws Exception
    {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
        
        if(con != null)
        {
            System.out.println("Connected with Oracle database using Type-4");
            System.out.println(con);
        }
    }
}
