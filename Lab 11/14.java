package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;

@WebServlet("/api/resource")
public class HelloServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request to retrieve resource
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("GET request received to retrieve resource");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST request to create resource
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("POST request received to create resource");
    }
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle PUT request to update resource
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("PUT request received to update resource");
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle DELETE request to delete resource
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("DELETE request received to delete resource");
    }

}
