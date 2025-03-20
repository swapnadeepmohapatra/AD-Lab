package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        
        PrintWriter out = response.getWriter();
        
        if(name != null && !name.isEmpty() && email != null && !email.isEmpty()) {
            out.println("<h2>Form submitted successfully!</h2>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Email: " + email + "</p>");
        } else {
            out.println("<h2>Error: Please fill all form fields.</h2>");
        }
    }
}
