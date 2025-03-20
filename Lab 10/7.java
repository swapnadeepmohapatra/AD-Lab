package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = request.getParameter("language");
        
        Cookie languageCookie = new Cookie("preferredLanguage", language);
        languageCookie.setMaxAge(30 * 24 * 60 * 60); // Cookie expires in 30 days
        response.addCookie(languageCookie);
        
        response.getWriter().println("Preferred language set to: " + language);
    }
}
