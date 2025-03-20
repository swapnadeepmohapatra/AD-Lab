package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.http.*;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        synchronized (this) {
            HttpSession session = request.getSession(true);
            Integer count = (Integer) session.getAttribute("count");
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            session.setAttribute("count", count);

            response.getWriter().println("<h1>Number of visits: " + count + "</h1>");
        }
    }
}
