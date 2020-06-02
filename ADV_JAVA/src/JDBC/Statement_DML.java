package JDBC;

import java.sql.Connection;
import java.sql.Statement;

public class Statement_DML 
{
    public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getOracleConnection();
        Statement st = con.createStatement();
        int status = 0;
        String sql = null;
        
        //Logic to Insert Records
        sql = "insert into student values(100, 'Raja', 8.5, '12-jan-90')";
        status = st.executeUpdate(sql);
        if(status > 0)
            System.out.println("Record Inserted!!");
        else
            System.out.println("Error in Insertion...");
        
        //Logic to Update Records
        sql = "update student set name='xyz', cgpa=9.8 where roll=100";
        status = st.executeUpdate(sql);
        if(status > 0)
            System.out.println("Record Updated!!");
        else
            System.out.println("Error in Updation...");
        
        //Logic to Delete Records
        sql = "delete from student where roll=100";
        status = st.executeUpdate(sql);
        if(status > 0)
            System.out.println("Record Deleted!!");
        else
            System.out.println("Error in Deletion...");      
    }
}
