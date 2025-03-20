package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            throw new CustomException("Custom Exception occurred");
        } catch (CustomException e) {
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", e.getMessage());
            try {
                response.sendRedirect("error.jsp");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class CustomException extends RuntimeException {

        public CustomException(String message) {
            super(message);
        }
    }
}
