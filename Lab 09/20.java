package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code to handle multiple file types uploaded through a form and process them accordingly

        // Example code to get uploaded files
        Part filePart = request.getPart("file1");
        String fileName = filePart.getSubmittedFileName();
        InputStream fileContent = filePart.getInputStream();

        // Processing code based on file type
        // Add your code here to handle different file types appropriately

        // Send response back to client
        PrintWriter out = response.getWriter();
        out.println("Files uploaded and processed successfully!");
    }
}
