package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logRequest(request);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello, Servlet!</h1>");
        out.println("</body></html>");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logRequest(request);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello, Servlet!</h1>");
        out.println("</body></html>");
    }
    
    private void logRequest(HttpServletRequest request) {
        try {
            String logPath = "request_log.txt";
            FileWriter fileWriter = new FileWriter(new File(logPath), true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Request received at " + new Date());
            printWriter.println("Headers:");
            
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                printWriter.println(headerName + ": " + request.getHeader(headerName));
            }
            
            printWriter.println("Parameters:");
            Map<String, String[]> parameters = request.getParameterMap();
            for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
                printWriter.print(entry.getKey() + ": ");
                for (String value : entry.getValue()) {
                    printWriter.print(value + ", ");
                }
                printWriter.println();
            }
            
            printWriter.println();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
