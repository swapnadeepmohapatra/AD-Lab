package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("username") == null) {
            out.println("<html><body>");
            out.println("<h1>Login Page</h1>");
            out.println("<form method='post' action='/hello'>");
            out.println("Username: <input type='text' name='username'><br>");
            out.println("<input type='submit' value='Login'>");
            out.println("</form>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h1>Welcome, " + session.getAttribute("username") + "</h1>");
            out.println("</body></html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        response.sendRedirect("/hello");
    }
}
