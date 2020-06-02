package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Statement_Ex 
{
    public static void main(String[] args)  throws Exception
    {
        Connection con = Provider.getOracleConnection();
        //System.out.println(con);  //Check Connection
        
        String sql = null;
        boolean res;
          
        Statement st = con.createStatement();
      
        /** DDL OPERATION */
        //Drop table by java program...
        sql = "Drop table Student";
        res = st.execute(sql);
        System.out.println(res);
        System.out.println("Table Dropped!!");      
        
        //Create table by java program...
        sql = "Create table Student(roll number(4), name varchar2(20), cgpa number(3, 1), dob date)";
        res = st.execute(sql);
        System.out.println(res);
        System.out.println("Table Created!!");      
        
/*      Alter table
        -----------
        1. name to sname
        2. roll(4) to roll(10)
        3. dob delete
        4. roll number to roll varchar2     */
        sql = "Alter table Student rename column name to sname";
        System.out.println(sql);
        res = st.execute(sql);
        System.out.println(res);
        System.out.println("Table Altered!! (name->sname)");
        
        sql =  "Alter table Student modify roll number(10)";
        System.out.println(sql);
        res = st.execute(sql);
        System.out.println(res);
        System.out.println("Table Altered!! roll number(10)");
        
        sql =  "Alter table Student drop column dob";
        System.out.println(sql);
        res = st.execute(sql);
        System.out.println(res);
        System.out.println("Table Altered!! dob dropped");
        
        sql = "Alter table Student modify roll varchar2(10)";
        System.out.println(sql);
        res = st.execute(sql);
        System.out.println(res);
        System.out.println("Table Altered!! roll varchar(2)");

/*        Table Rename
        -------------
        1. Student to std   
        
        sql = "rename Student to std";
        res = st.execute(sql);
        System.out.println(res);
        System.out.println("Table Renamed!!");   */  

        /** DML OPERATION */
        int status = 0;
        
        sql = "Insert into student values (100, 'Jagan', 98.4)";
        System.out.println(sql);
        status = st.executeUpdate(sql);
        System.out.println(status);
        System.out.println("Record Inserted successfuly !!");
        sql = "Insert into student values (101, 'Rama', 88.6)";
        System.out.println(sql);
        status = st.executeUpdate(sql);
        System.out.println(status);
        System.out.println("Record Inserted successfuly !!");
        
        sql = "Update Student set sname='Hari' where roll=101";
        System.out.println(sql);
        status = st.executeUpdate(sql);
        System.out.println(res);
        System.out.println("Record Inserted successfuly !!");
        
        sql = "Delete from Student where roll=100";
        System.out.println(sql);
        status = st.executeUpdate(sql);
        System.out.println(status);
        System.out.println("Record Deleted successfuly !!");
        
        /** DRL/DQL OPERATION */
        sql = "Select * from Student";
        System.out.println(sql);
        ResultSet rs = st.executeQuery(sql);
        System.out.println(rs);
        while(rs.next())
        {
            System.out.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getDouble(3));
        }
        System.out.println("Record Displayed successfully!!");
    }
}