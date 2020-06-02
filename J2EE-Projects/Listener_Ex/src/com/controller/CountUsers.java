package com.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CountUsers
 *
 */
@WebListener
public class CountUsers implements HttpSessionListener {

    public CountUsers() 
    {
       
    }
    int currentUser=0, totalUser=0;
    public void sessionCreated(HttpSessionEvent se)  
    { 
        currentUser++;
        totalUser++;
        System.out.println("Total number of users login: " + totalUser);
        System.out.println("Number of users currently connected: " + currentUser);
    }

    public void sessionDestroyed(HttpSessionEvent se)  
    { 
         currentUser--;
         System.out.println("Total number of users login: " + totalUser);
         System.out.println("Number of users currently connected: " + currentUser);
    }
	
}
