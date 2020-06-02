package Driver4;

import java.sql.DriverManager;
import java.util.Enumeration;

public class Driver4_Load1 
{
     public static void main(String[] args)  throws Exception
    {
        Class.forName("oracle.jdbc.OracleDriver");  
        
        Enumeration e = DriverManager.getDrivers();
        while (e.hasMoreElements()) 
        {
            System.out.println(e.nextElement());           
        }
    } 
}
