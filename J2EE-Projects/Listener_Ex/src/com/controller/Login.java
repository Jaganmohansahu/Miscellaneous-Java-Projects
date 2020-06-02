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
 * Servlet implementation class Login
 */
@WebServlet("/com.controller.Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String un = request.getParameter("un");
		String ps = request.getParameter("ps");
		
		if(un.equals(ps))
		{
			HttpSession session = request.getSession();
			session.setAttribute("un", un);
			response.sendRedirect("com.controller.Welcome");
		}
		else
		{
			out.print("Login Failed!!");
		}
	}

}
