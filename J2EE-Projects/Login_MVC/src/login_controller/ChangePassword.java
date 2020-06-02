package login_controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login_db.Users;
import login_model.UsersDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/login_controller.ChangePassword")
public class ChangePassword extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		Users u = new Users();
		u.setPassword(request.getParameter("cpsw"));
		u.setEmail((String)session.getAttribute("email"));
		
		boolean result = UsersDao.validate(u);
		if(result==false)
		{
			out.print("Enter a valid current password!!");
		}
		else
		{
			String newpass = request.getParameter("npsw");
			String cnfpass = request.getParameter("cnpsw");
			if(newpass.equals(cnfpass))
			{
				u.setPassword(newpass);
				UsersDao.doChangePassword(u);
			}
			else
			{
				out.print("Password does not match!!");
			}
		}
	}

}
