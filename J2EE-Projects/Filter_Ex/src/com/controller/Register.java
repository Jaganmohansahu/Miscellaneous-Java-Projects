package com.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/com.controller.Register")
public class Register extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String roll = request.getParameter("roll");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		out.print("<hr>Roll: " + roll);
		out.print("<hr>Name: " + name);
		out.print("<hr>Age: " + age);
	}
}
