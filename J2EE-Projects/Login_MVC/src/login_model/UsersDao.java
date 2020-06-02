package login_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import login_db.Provider;
import login_db.Users;

public class UsersDao {

	public static int save(Users u) 
	{
		int status = 0;
		
		try
		{
			Connection con = Provider.getConnection();
			
			String sql = "Insert into Users values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, u.getName());
			pst.setString(2, u.getEid());
			pst.setString(3, u.getPassword());
			pst.setString(4, u.getSalary());
			pst.setString(5, u.getJob());
			pst.setString(6, u.getEmail());
			pst.setString(7, u.getPhone());
			
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}

	public static boolean validate(Users u) 
	{
		boolean result = false;
		
		try
		{
			Connection con = Provider.getConnection();
			
			String sql = "Select * from users where email=? and password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				result = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static void doChangePassword(Users u) 
	{
		
	}

}
