package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("message", "Hello, World!");
        
        PrintWriter out = response.getWriter();
        out.println(jsonResponse);
    }
}
