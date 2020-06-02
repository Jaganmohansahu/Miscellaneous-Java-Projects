package JDBC;

import java.sql.Connection;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePointEx 
{
    public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getOracleConnection();
        con.setAutoCommit(false);
        
        String sql1 = "insert into student (roll, name) values(111, 'x')";
        String sql2 = "insert into student (roll, name) values(112, 'y')";
        String sql3 = "insert into student (roll, name) values(113, 'z')";
        
        Statement st = con.createStatement();
        int st1 = st.executeUpdate(sql1);
                  st.executeUpdate(sql1);
                  st.executeUpdate(sql1);
        
        Savepoint sp1 = con.setSavepoint();
        
        int st2 = st.executeUpdate(sql2);
                  st.executeUpdate(sql2);
                  
        Savepoint sp2 = con.setSavepoint();
        
        int st3 = st.executeUpdate(sql3);
        
        System.out.println("Status is: " + st1 +"\t"+ st2 +"\t"+ st3);
        con.rollback(sp2);
        con.commit();
    }
}
