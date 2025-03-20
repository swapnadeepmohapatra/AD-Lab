package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String[] dataArray = {"Data1", "Data2", "Data3", "Data4"};

        out.println("<html><head><title>Simple HTML Table</title></head><body>");
        out.println("<table border=\"1\">");
        out.println("<tr><th>Data</th></tr>");
        for (String data : dataArray) {
            out.println("<tr><td>" + data + "</td></tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
    }
}
