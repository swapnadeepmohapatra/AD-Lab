package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/cart")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");

        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Shopping Cart:</h2>");

        if (cart == null || cart.isEmpty()) {
            out.println("<p>Your cart is empty.</p>");
        } else {
            out.println("<ul>");
            for (String item : cart.keySet()) {
                out.println("<li>" + item + " - Quantity: " + cart.get(item) + "</li>");
            }
            out.println("</ul>");
        }

        out.println("<h2>Add Items to Cart:</h2>");
        out.println("<form method='POST'>");
        out.println("Item Name: <input type='text' name='item' required><br>");
        out.println("Quantity: <input type='number' name='quantity' required><br>");
        out.println("<input type='submit' value='Add to Cart'>");
        out.println("</form>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        String item = request.getParameter("item");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (cart.containsKey(item)) {
            int currentQuantity = cart.get(item);
            cart.put(item, currentQuantity + quantity);
        } else {
            cart.put(item, quantity);
        }

        session.setAttribute("cart", cart);

        response.sendRedirect(request.getContextPath() + "/cart");
    }
}
