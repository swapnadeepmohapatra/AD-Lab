package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setHeader("CustomHeader", "This is a custom header set by the servlet");
        
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Hello Servlet</h1></body></html>");
    }
}
