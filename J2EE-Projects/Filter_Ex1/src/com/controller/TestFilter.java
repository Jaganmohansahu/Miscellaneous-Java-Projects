package com.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TestFilter
 */
@WebFilter("/com.controller.Test")
public class TestFilter implements Filter 
{

    public TestFilter() 
    {
    	System.out.println("Object Created for Filter");
    }

	public void destroy() 
	{
		System.out.println("destroy() called for Filter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		System.out.println("service() called for Filter");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
		System.out.println("init() called for Filter");
	}

}
