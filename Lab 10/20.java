package com.swapnadeep.week1.ad_lab_servlet;

import javax.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user-registration")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String step = request.getParameter("step");
        if (step == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Step parameter is required.");
            return;
        }
        
        switch (step) {
            case "1":
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                session.setAttribute("firstName", firstName);
                session.setAttribute("lastName", lastName);
                response.sendRedirect("registration-step2.html");
                break;
            case "2":
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                session.setAttribute("email", email);
                session.setAttribute("password", password);
                response.sendRedirect("registration-step3.html");
                break;
            case "3":
                String address = request.getParameter("address");
                session.setAttribute("address", address);
                // Additional processing if needed
                response.sendRedirect("registration-success.html");
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid step parameter.");
        }
    }
}
