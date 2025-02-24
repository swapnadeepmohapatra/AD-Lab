package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String preferences = request.getParameter("preferences");

        session.setAttribute("username", username);
        session.setAttribute("preferences", preferences);

        response.setContentType("text/html");
        response.getWriter().println("<h1>Data stored in session</h1>");
        response.getWriter().println("<p>Username: " + username + "</p>");
        response.getWriter().println("<p>Preferences: " + preferences + "</p>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");
        String preferences = (String) session.getAttribute("preferences");

        response.setContentType("text/html");
        response.getWriter().println("<h1>Retrieved data from session</h1>");
        response.getWriter().println("<p>Username: " + username + "</p>");
        response.getWriter().println("<p>Preferences: " + preferences + "</p>");
    }
}
