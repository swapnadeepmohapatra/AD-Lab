package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello Servlet</h1>");
        out.println("<p>This servlet stores user preferences in a database and loads them on the next visit.</p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user preferences from request parameters
        String preference1 = request.getParameter("preference1");
        String preference2 = request.getParameter("preference2");

        // Save user preferences in the database
        // Code for storing preferences in the database goes here

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Preferences saved successfully!</h1>");
        out.println("<p>Preference 1: " + preference1 + "</p>");
        out.println("<p>Preference 2: " + preference2 + "</p>");
        out.println("</body></html>");
    }
}
