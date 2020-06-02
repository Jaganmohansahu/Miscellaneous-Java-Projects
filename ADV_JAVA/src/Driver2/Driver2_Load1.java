package Driver2;
/* set classpath=;C:\IDSServer\classes\jdk14drv.jar; */
import java.sql.DriverManager;
import java.util.Enumeration;

public class Driver2_Load1 
{
    public static void main(String[] args)  throws Exception
    {
        Class.forName("oracle.jdbc.pool.OracleDataSource");  
        
        Enumeration e = DriverManager.getDrivers();
        while (e.hasMoreElements()) 
        {
            System.out.println(e.nextElement());           
        }
    } 
}
