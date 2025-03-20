package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userChoice = request.getParameter("choice");

        if (userChoice.equals("a")) {
            response.sendRedirect("pageA.jsp");
        } else if (userChoice.equals("b")) {
            response.sendRedirect("pageB.jsp");
        } else {
            response.sendRedirect("errorPage.jsp");
        }
    }
}
