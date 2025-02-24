package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class HelloServlet extends HttpServlet {

    private Map<String, String> users = new HashMap<>();

    public HelloServlet() {
        users.put("admin", "password123");
        users.put("user", "123456");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (users.containsKey(username) && users.get(username).equals(password)) {
            response.getWriter().println("Login successful for user: " + username);
        } else {
            response.getWriter().println("Invalid username or password");
        }
    }
}
