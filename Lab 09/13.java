package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the session or create a new one if it doesn't exist
        HttpSession session = request.getSession();

        // Set session attributes
        session.setAttribute("username", "JohnDoe");
        session.setAttribute("email", "johndoe@example.com");

        // Retrieve session attributes
        String username = (String) session.getAttribute("username");
        String email = (String) session.getAttribute("email");

        // Prepare the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>User Session Management</h1>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("</body></html>");
    }
}
