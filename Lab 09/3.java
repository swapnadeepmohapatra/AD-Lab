package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Hello, " + firstName + " " + lastName + "! Welcome to our website.</h2>");
        out.println("</body></html>");
    }
}
