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
@WebServlet("/login_controller.Login")
public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Users u = new Users();
		u.setPassword(request.getParameter("password"));
		u.setEmail(request.getParameter("email"));
		
		boolean result = UsersDao.validate(u);
		if(result==true)
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", request.getParameter("email"));
			response.sendRedirect("welcome.html");
		}
		else
		{
			out.print("Error in Login!!");
		}
	}

}
