package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/login")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple user authentication
        if ("admin".equals(username) && "admin123".equals(password)) {
            // Create a session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
