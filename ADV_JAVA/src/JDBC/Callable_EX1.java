package JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

/* FIRST CREATE PROCUDURE
    create or replace procedure proc_delete(r number)
    is
    begin
        Delete from student where roll=r;
    end proc_delete;
    /
*/
public class Callable_EX1 
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        Connection con = Provider.getOracleConnection();
        
        CallableStatement cst = con.prepareCall("{call proc_delete(?)}");
        System.out.println("Enter roll to delete record: ");
        cst.setInt(1, sc.nextInt());
        cst.executeUpdate();
        
        System.out.println("PL/SQL procedure executed successfully!!");
    }
}
