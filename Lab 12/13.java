package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(false);
        
        if(session != null && session.getAttribute("username") != null) {
            out.println("<h1>Welcome, " + session.getAttribute("username") + "</h1>");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
