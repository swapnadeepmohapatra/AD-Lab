package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Get the current session
        HttpSession session = request.getSession();

        // Get the session ID
        String sessionId = session.getId();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Current Session ID: " + sessionId);
        out.println("</body></html>");
    }
}
