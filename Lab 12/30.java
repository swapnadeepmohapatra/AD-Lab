package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>" +
                    "<head><title>Hello Servlet</title></head>" +
                    "<body>" +
                    "<h1>Hello, this is a Servlet!</h1>" +
                    "</body>" +
                    "</html>");
    }
}
