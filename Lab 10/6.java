package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String userAgent = request.getHeader("User-Agent");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>User-Agent Info</title></head><body>");
        out.println("<h1>User-Agent String:</h1>");
        out.println("<p>" + userAgent + "</p>");
        out.println("</body></html>");
    }
}
