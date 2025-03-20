package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Integration with message queue (e.g., JMS) to process requests asynchronously
        
        // Add your asynchronous processing logic here
        
        // Example code (not actual JMS integration)
        String message = "Hello, World!";
        
        try {
            response.getWriter().println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
