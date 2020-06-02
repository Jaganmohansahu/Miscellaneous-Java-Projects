package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/com.controller.Welcome")
public class Welcome extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("un");
		
		out.print("<center>");
		out.print("<img src='C:\\Users\\Jagan\\Desktop\\62027.jpg' width=400 height=400></img>");
		out.print("<br>Welcome: " + user);
		out.print("<hr><hr><a href='com.controller.Logout'>Logout</a>");
		out.print("<center>");
	}

}
