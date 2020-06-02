package JDBC;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

public class BatchEX 
{
    public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getOracleConnection();
        Statement st = con.createStatement();
        
        String sql1 = "Insert into student (roll, name) values(112,'x')";
        String sql2 = "Insert into student (roll, name) values(113,'y')";
        String sql3 = "Delete from student where name='Raja'";
        
        st.addBatch(sql1);
        st.addBatch(sql2);
        st.addBatch(sql3);
        
        int status[] = st.executeBatch();
        System.out.println(Arrays.toString(status));
    }
}
