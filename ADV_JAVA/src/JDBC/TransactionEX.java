package JDBC;

import java.sql.Connection;
import java.sql.Statement;

public class TransactionEX 
{
    public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getOracleConnection();
        con.setAutoCommit(false);
        
        String sql1 = "insert into student (roll, name) values(111, 'x')";
        String sql2 = "insert into student (roll, name) values(112, 'y')";
        String sql3 = "delete from student where name='Jagan'";
        
        Statement st = con.createStatement();
        int st1 = st.executeUpdate(sql1);
        int st2 = st.executeUpdate(sql2);
        int st3 = st.executeUpdate(sql3);     
        System.out.println("Status is: " + st1 +"\t"+ st2 +"\t"+ st3);
        
        if(st1>0 && st2>0 && st3>0)
        {
            System.out.println("Transaction completed successfully!!");
            con.commit();
        }
        else
        {
            System.out.println("All transaction were not success so RollBack completed...");
            con.rollback();
        }
    }
}
