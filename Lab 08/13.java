package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.Scanner;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        
        try (Scanner scanner = new Scanner(fileContent)) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>File Content:</h2>");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                out.println(line + "<br>");
            }

            out.println("</body></html>");

        } catch (Exception e) {
            response.getWriter().println("Error reading file: " + e.getMessage());
        }
    }
}
