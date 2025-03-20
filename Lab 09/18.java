package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        ServletContext servletContext = request.getServletContext();
        String appName = (String) servletContext.getAttribute("applicationName");

        response.getWriter().println("<h1>Hello from HelloServlet</h1>");
        response.getWriter().println("<p>Application Name: " + appName + "</p>");
    }
}
