package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Dynamic Table</title></head><body>");
        out.println("<table border='1'><tr><th>Name</th><th>Age</th><th>City</th></tr>");
        out.println("<tr><td>John Doe</td><td>30</td><td>New York</td></tr>");
        out.println("<tr><td>Jane Smith</td><td>25</td><td>Los Angeles</td></tr>");
        out.println("<tr><td>Michael Johnson</td><td>35</td><td>Chicago</td></tr>");
        out.println("</table>");
        out.println("</body></html>");
    }
}
