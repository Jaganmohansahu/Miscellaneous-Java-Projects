

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FindBill")
public class FindBill extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.print("<h2>The following is the Bill particulars...</h2><hr>");
		
		request.setAttribute("unit_price", 3.50);	//set additional value to request
		
		int currentUnits = Integer.parseInt(request.getParameter("cbill"));
		int previousUnits = Integer.parseInt(request.getParameter("pbill"));
		
		out.print("<hr>Previous Month Bill (units): "+previousUnits);
		out.print("<hr>Current Month Bill (units): "+currentUnits);
		
		RequestDispatcher rd = request.getRequestDispatcher("CalcBill");
		rd.include(request, response);
		
		out.print("<hr>Please pay bill before 10th of next month!!<hr>");
	}

}
