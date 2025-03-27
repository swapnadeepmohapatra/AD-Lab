package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userAgent")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userAgent = request.getHeader("User-Agent");
        out.println("<html><body>");
        out.println("<h1>User-Agent: " + userAgent + "</h1>");
        out.println("</body></html>");
    }
}
