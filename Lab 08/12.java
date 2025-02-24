package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class HelloServlet extends HttpServlet {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(USERNAME.equals(username) && PASSWORD.equals(password)) {
            out.println("<h1>Login successful</h1>");
        } else {
            out.println("<h1>Login failed</h1>");
        }
    }
}
