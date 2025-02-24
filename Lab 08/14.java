package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");
        
        // You can perform any necessary operations here
        
        request.setAttribute("param1", param1);
        request.setAttribute("param2", param2);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/anotherServlet");
        dispatcher.forward(request, response);
    }

}
