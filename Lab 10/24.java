package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        String userInput = request.getParameter("input");
        
        try {
            String url = "jdbc:mysql://localhost:3306/database";
            String username = "root";
            String password = "password";
            Connection connection = DriverManager.getConnection(url, username, password);
            
            String sqlQuery = "SELECT * FROM users WHERE username = '" + userInput + "'";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery();
            
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            
            if(resultSet.next()) {
                out.println("<h2>SQL Injection Vulnerability Test Result:</h2>");
                out.println("<p>User input: " + userInput + "</p>");
                out.println("<p>Unsafe SQL query executed successfully.</p>");
            } else {
                out.println("<h2>SQL Injection Vulnerability Test Result:</h2>");
                out.println("<p>User input: " + userInput + "</p>");
                out.println("<p>No data found using the unsafe SQL query.</p>");
            }
            
            out.println("</body></html>");
            
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
