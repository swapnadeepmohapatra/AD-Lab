package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Greeting Servlet</title></head>");
        out.println("<body>");

        if (hour < 12) {
            out.println("<h1>Good Morning!</h1>");
        } else if (hour < 18) {
            out.println("<h1>Good Afternoon!</h1>");
        } else {
            out.println("<h1>Good Evening!</h1>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
