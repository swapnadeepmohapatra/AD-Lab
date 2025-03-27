package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/displayCookies")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        out.println("<html><head><title>Display Cookies</title></head><body>");
        out.println("<h1>Cookies sent by the browser:</h1>");

        if (cookies != null) {
            out.println("<ul>");
            for (Cookie cookie : cookies) {
                out.println("<li>Name: " + cookie.getName() + ", Value: " + cookie.getValue() + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>No cookies sent by the browser</p>");
        }

        out.println("</body></html>");
    }
}
