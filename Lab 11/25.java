package com.swapnadeep.week1.ad_lab_servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import jakarta.servlet.HttpServlet;
import jakarta.servlet.HttpServletRequest;
import jakarta.servlet.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Integrate with external APIs here to fetch real-time data (e.g., weather or news)
        // Display the fetched data here in the servlet response
        
        response.getWriter().println("<html><body><h1>Hello, Servlet!</h1></body></html>");
    }
}
