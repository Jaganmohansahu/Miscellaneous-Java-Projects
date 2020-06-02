package JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

/** First CREATE FUNCTION
  create or replace function fun_max (r number, n varchar2, c number)
  return number
  is
  m number(3, 1);
  begin
       Insert into Student (roll, name, cgpa) values(r, n, c);
       Select max(cgpa) into m from student;
           return m;
           end fun_max;
       /
 */
public class CallableFunctioon 
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        Connection con = Provider.getOracleConnection();
        
        CallableStatement cst = con.prepareCall("{?= call fun_max(?, ?, ?)}");
        System.out.println("Enter roll, name & cgpa: ");
        
        cst.registerOutParameter(1, Types.DOUBLE);
        cst.setInt(2, sc.nextInt());
        cst.setString(3, sc.next());
        cst.setDouble(4, sc.nextDouble());
        cst.execute();
        
        System.out.println("PL/SQL function executed successfully!!");
        System.out.println("Maximum cgpa is: " + cst.getDouble(1));
    }
}