package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String userInput = request.getParameter("userInput");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>SQL Injection Test</title></head><body>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "username", "password");
            Statement stmt = conn.createStatement();

            String query = "SELECT * FROM users WHERE username='" + userInput + "'";
            ResultSet rs = stmt.executeQuery(query);

            out.println("<h3>SQL Query Executed: " + query + "</h3>");
            out.println("<h3>Results:</h3>");
            while (rs.next()) {
                out.println("<p>" + rs.getString("username") + "</p>");
            }

            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h3>Error executing SQL query: " + e.getMessage() + "</h3>");
        }

        out.println("</body></html>");
    }
}
