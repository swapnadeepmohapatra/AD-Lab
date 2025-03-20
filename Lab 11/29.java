package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Servlet code to interact with message queue (e.g. JMS) can be implemented here
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // Servlet code to interact with message queue (e.g. JMS) can be implemented here
    }
}
