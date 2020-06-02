

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String un = request.getParameter("username");
		String ps = request.getParameter("password");
		out.println("Username::: "+un);
		out.println("Password::: "+ps);
		
		if(un.equals(ps))
			out.println("LogIn Success...");
		else
			out.println("Invalid username or password");
		
		out.print("Response back to client directly....");
	}

}
