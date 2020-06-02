package Driver2;
/* Exclude ojdbc14.jar in library if present */
import java.sql.Connection;
import java.sql.DriverManager;

public class Driver2_Connection2 
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        Connection con = DriverManager.getConnection("jdbc:oracle:oci:@localhost:1521:xe", "system", "system");
        
        if(con != null)
        {
            System.out.println("Connected with ORACLE Database !!");
            System.out.println(con);
        }
    }
}
