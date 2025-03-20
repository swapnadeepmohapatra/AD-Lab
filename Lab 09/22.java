package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head><title>Shopping Cart</title></head>");
        out.println("<body>");
        out.println("<h1>Welcome to the Shopping Cart!</h1>");
        out.println("<p>Add items to your cart:</p>");
        out.println("<form method='post'>");
        out.println("<label for='item'>Item:</label>");
        out.println("<input type='text' id='item' name='item'>");
        out.println("<input type='submit' value='Add to Cart'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String item = request.getParameter("item");
        HttpSession session = request.getSession();

        List<String> cart = (List<String>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(item);
        session.setAttribute("cart", cart);

        response.sendRedirect("HelloServlet");
    }
}
