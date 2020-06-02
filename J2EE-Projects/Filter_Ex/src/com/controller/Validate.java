package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Validate
 */

//The servlet URL and Filter URL must be same
@WebFilter("/com.controller.Register")
public class Validate implements Filter {

    /**
     * Default constructor. 
     */
    public Validate() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String roll = request.getParameter("roll");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		if(roll.equals(""))
			out.print("Please enter a roll number!!");
		else if(name.equals(""))
			out.print("Name field should not be blank!!");
		else if(age<0)
			out.print("Age should not be -ve!!");
		else
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
