package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registration")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String step = request.getParameter("step");
        
        if (step.equals("1")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            
            session.setAttribute("firstName", firstName);
            session.setAttribute("lastName", lastName);
            
            // Display next form for step 2
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Step 2: Enter User Details</h2>");
            out.println("<form action='registration' method='post'>");
            out.println("Username: <input type='text' name='username'><br>");
            out.println("Password: <input type='password' name='password'><br>");
            out.println("<input type='hidden' name='step' value='2'>");
            out.println("<input type='submit' value='Submit Step 2'>");
            out.println("</form>");
            out.println("</body></html>");
        } else if (step.equals("2")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            
            // Display confirmation page
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Registration Confirmation</h2>");
            out.println("First Name: " + session.getAttribute("firstName") + "<br>");
            out.println("Last Name: " + session.getAttribute("lastName") + "<br>");
            out.println("Username: " + session.getAttribute("username") + "<br>");
            out.println("Password: " + session.getAttribute("password") + "<br>");
            out.println("</body></html>");
        }
    }
}
