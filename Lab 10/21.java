package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/shoppingcart")
public class HelloServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new ShoppingCart());
        }
        
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        
        String item = request.getParameter("item");
        String action = request.getParameter("action");
        
        if (item != null && action != null) {
            if (action.equals("add")) {
                cart.addItem(item);
            } else if (action.equals("remove")) {
                cart.removeItem(item);
            }
        }
        
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Session-based Shopping Cart</h1>");
        response.getWriter().println("<h3>Items in Cart:</h3>");
        response.getWriter().println(cart.getItems());
        response.getWriter().println("<br><br>");
        response.getWriter().println("<form action='/shoppingcart' method='GET'>");
        response.getWriter().println("Add Item: <input type='text' name='item'>");
        response.getWriter().println("<input type='hidden' name='action' value='add'>");
        response.getWriter().println("<input type='submit' value='Add'>");
        response.getWriter().println("</form>");
        response.getWriter().println("<form action='/shoppingcart' method='GET'>");
        response.getWriter().println("Remove Item: <input type='text' name='item'>");
        response.getWriter().println("<input type='hidden' name='action' value='remove'>");
        response.getWriter().println("<input type='submit' value='Remove'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }
    
    static class ShoppingCart {
        List<String> items = new ArrayList<>();
        
        void addItem(String item) {
            items.add(item);
        }
        
        void removeItem(String item) {
            items.remove(item);
        }

        public List<String> getItems() {
            return items;
        }
    }
}
