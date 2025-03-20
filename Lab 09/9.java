package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Form Submission Result</title></head>");
        out.println("<body>");

        if(name==null || name.isEmpty() || email==null || email.isEmpty()) {
            out.println("<h2 style='color:red;'>Error: Name and Email both are required fields.</h2>");
        } else {
            out.println("<h2>Form Submitted Successfully!</h2>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Email: " + email + "</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
