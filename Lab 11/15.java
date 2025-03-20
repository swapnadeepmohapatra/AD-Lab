package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/register")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the step parameter to determine the current step in registration
        String step = request.getParameter("step");

        if (step == null) {
            // Initialize the registration process by setting step to 1
            request.getSession().setAttribute("step", 1);
            response.getWriter().println("Welcome to the User Registration Form - Step 1");
        } else {
            int currentStep = Integer.parseInt(step);

            if (currentStep == 1) {
                // Process step 1 data
                String username = request.getParameter("username");
                // Store data in session
                request.getSession().setAttribute("username", username);
                
                // Move to step 2
                request.getSession().setAttribute("step", 2);
                response.getWriter().println("Step 1 completed. Proceed to Step 2.");
            } else if (currentStep == 2) {
                // Process step 2 data
                String email = request.getParameter("email");
                // Store data in session
                request.getSession().setAttribute("email", email);
                
                // Move to step 3 or final step
                request.getSession().setAttribute("step", 3);
                response.getWriter().println("Step 2 completed. Proceed to Step 3 or final step.");
            } else {
                // Process final step or any additional steps
                response.getWriter().println("User Registration Completed Successfully!");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle form submission
        doGet(request, response);
    }
}
