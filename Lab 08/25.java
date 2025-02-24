package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/error-servlet")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Get error code from request
        Integer errorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        // Get error message from request
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");

        // Display error message to the client in a user-friendly format
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Error " + errorCode + "</title></head><body>");
        out.println("<h1>Error " + errorCode + "</h1>");
        out.println("<p>" + errorMessage + "</p>");
        out.println("</body></html>");
    }
}
