package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/cookieCheck")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String cookieEnabled = "Cookies are ";
        if (request.getCookies() != null) {
            cookieEnabled += "enabled";
        } else {
            cookieEnabled += "disabled";
        }

        out.println("<html><head><title>Cookie Check</title></head>");
        out.println("<body><h1>" + cookieEnabled + "</h1></body></html>");
    }
}
