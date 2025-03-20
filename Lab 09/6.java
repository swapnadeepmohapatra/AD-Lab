package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/setCookie")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a new cookie with the name "theme" and value "dark"
        Cookie cookie = new Cookie("theme", "dark");
        
        // Set the cookie to expire in 1 day (24 hours)
        cookie.setMaxAge(24 * 60 * 60);
        
        // Add the cookie to the response
        response.addCookie(cookie);
        
        response.setContentType("text/html");
        response.getWriter().println("Cookie set successfully for user preferences (dark mode).");
    }
}
