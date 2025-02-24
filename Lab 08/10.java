package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Form Submission Response</title></head><body>");

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        out.println("<h1>Hello, " + name + "</h1>");
        out.println("<p>Your Email: " + email + "</p>");

        out.println("</body></html>");
    }
}
