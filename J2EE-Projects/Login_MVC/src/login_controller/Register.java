package login_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login_db.Users;
import login_model.UsersDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/login_controller.Register")
public class Register extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Users u = new Users();
		u.setEid(request.getParameter("eid"));
		u.setName(request.getParameter("name"));
		u.setPassword(request.getParameter("password"));
		u.setJob(request.getParameter("job"));
		u.setEmail(request.getParameter("email"));
		u.setSalary(request.getParameter("salary"));
		u.setPhone(request.getParameter("phone"));
		
		int status = UsersDao.save(u);
		if(status>0)
		{
			out.print("Register Successfull...");
		}
		else
		{
			out.print("Error in Registraion!!");
		}
	}
}
