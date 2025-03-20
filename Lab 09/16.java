package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Process first step of the form
        String step1Data = request.getParameter("step1Data");
        session.setAttribute("step1Data", step1Data);

        // Forward to next step of the form
        RequestDispatcher dispatcher = request.getRequestDispatcher("/step2.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Additional processing for GET requests
    }
}
