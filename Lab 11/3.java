package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String color = request.getParameter("favoriteColor");

        out.println("<html><body>");
        out.println("<h1>Your favorite color is: " + color + "</h1>");
        out.println("</body></html>");

        out.close();
    }
}
