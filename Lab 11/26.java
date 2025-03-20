package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/complex-search")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String queryParam1 = req.getParameter("param1");
        String queryParam2 = req.getParameter("param2");

        // Implement complex search filter system here based on queryParam1 and queryParam2

        PrintWriter out = resp.getWriter();
        out.println("<html><body><h1>Complex Search Filter System</h1>");
        out.println("<p>Query Parameter 1: " + queryParam1 + "</p>");
        out.println("<p>Query Parameter 2: " + queryParam2 + "</p>");
        out.println("</body></html>");
    }
}
