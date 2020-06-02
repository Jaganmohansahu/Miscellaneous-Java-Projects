

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String un = request.getParameter("username");
		String ps = request.getParameter("password");
		out.println("Username: "+un);
		out.println("Password: "+ps);
		
		RequestDispatcher rd = request.getRequestDispatcher("Validate");
		rd.forward(request, response);
		
		out.print("I am in LogIn Servlet...");
	}
	

}
