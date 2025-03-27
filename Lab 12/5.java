package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String[] data = {"Ram", "Sham", "Hari",};

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr><th>Name</th></tr>");
        for (String name : data) {
            out.println("<tr><td>" + name + "</td></tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
