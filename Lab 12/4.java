package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/customHeaders")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        response.addHeader("name", "Swapnadeep");
        response.addHeader("age", "20");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Custom Headers Set Successfully!</h1>");
        out.println("</body></html>");
    }
}
