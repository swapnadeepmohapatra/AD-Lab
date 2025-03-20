package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Set custom header
        response.setHeader("CustomHeader", "This is a custom header set by the server");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Custom Header Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Custom Header Example</h1>");
        out.println("<p>Custom header has been set in the response.</p>");

        // Retrieve custom header
        String customHeaderValue = response.getHeader("CustomHeader");
        out.println("<p>Value of CustomHeader: " + customHeaderValue + "</p>");

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
