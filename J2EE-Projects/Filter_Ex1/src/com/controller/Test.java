package com.controller;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Test
 */
@WebServlet("/com.controller.Test")
public class Test implements Servlet {

    public Test() 
    {
        System.out.println("Object Created for Servlet");
    }

	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("init() called for Servlet");
	}

	public void destroy() 
	{
		System.out.println("destroy() called for Servlet");
	}

	public ServletConfig getServletConfig() 
	{
		return null;
	}

	public String getServletInfo() 
	{
			return null; 
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		System.out.println("service() called for Servlet");
	}

}
