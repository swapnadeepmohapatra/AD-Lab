package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String acceptHeader = request.getHeader("Accept");

        if (acceptHeader != null && acceptHeader.contains("application/json")) {
            // Handling JSON response
            // Set response content type to JSON
            response.setContentType("application/json");
            // Write JSON response
            // <Your logic for JSON response here>
        } else if (acceptHeader != null && acceptHeader.contains("application/xml")) {
            // Handling XML response
            // Set response content type to XML
            response.setContentType("application/xml");
            // Write XML response
            // <Your logic for XML response here>
        } else {
            // Handling other response types
            response.setContentType("text/plain");
            // Write plain text response or handle the request accordingly
            // <Your logic for handling text/plain response here>
        }
    }
}
