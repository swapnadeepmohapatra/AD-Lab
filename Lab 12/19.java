package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    
    public void init() {
        // Initialization code to setup database connection
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code to store user preference in the database
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code to load user preferences from the database
    }

    public void destroy() {
        // Clean-up code to close database connection
    }
}
