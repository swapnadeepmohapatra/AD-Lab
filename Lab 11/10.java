package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/download")
public class HelloServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment;filename=sample.txt");

        PrintWriter out = response.getWriter();
        out.println("This is a text file for download.");
    }
}
