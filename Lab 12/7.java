package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = request.getParameter("language");

        Cookie cookie = new Cookie("preferredLanguage", language);
        response.addCookie(cookie);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Your preferred language has been stored in a cookie!</h1>");
        out.println("<p>Preferred Language: " + language + "</p>");
        out.println("</body></html>");
    }
}
