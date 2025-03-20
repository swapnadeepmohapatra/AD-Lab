package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String step = request.getParameter("step");

        if (step.equals("step1")) {
            String name = request.getParameter("name");
            session.setAttribute("name", name);
            // Perform validation, if required
            response.sendRedirect("form_step2.jsp");
        } else if (step.equals("step2")) {
            String email = request.getParameter("email");
            session.setAttribute("email", email);
            // Perform validation, if required
            response.sendRedirect("form_step3.jsp");
        } else if (step.equals("step3")) {
            String address = request.getParameter("address");
            session.setAttribute("address", address);
            // Perform validation, if required
            response.sendRedirect("form_summary.jsp");
        }
    }
}
