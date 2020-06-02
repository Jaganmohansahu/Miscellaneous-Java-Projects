package JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

/** CREATE A PROCEDURE FIRST
create or replace procedure proc_insert(r number, n varchar2, c number)
is
begin
    Insert into Student (roll, name, cgpa) values(r, n, c);
end proc_insert;
/
*/
public class CallableProcudure 
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        Connection con = Provider.getOracleConnection();
        
        CallableStatement cst = con.prepareCall("{call proc_insert(?, ?, ?)}");
        System.out.println("Enter roll, name & cgpa: ");
        
        cst.setInt(1, sc.nextInt());
        cst.setString(2, sc.next());
        cst.setDouble(3, sc.nextDouble());
        cst.execute();
        
        System.out.println("Procedure executed successfully!!");
    }
}
