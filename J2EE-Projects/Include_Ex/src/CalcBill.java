

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcBill")
public class CalcBill extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		int currentUnits = Integer.parseInt(request.getParameter("cbill"));
		int previousUnits = Integer.parseInt(request.getParameter("pbill"));
		Double unit_price = (Double)request.getAttribute("unit_price");
		
		double total_amount = (currentUnits-previousUnits)*unit_price;
		
		out.print("<hr>Your current month bill amount: " + total_amount);
		out.print("<hr>Response Added Successfully!!<hr>");
	}

}
