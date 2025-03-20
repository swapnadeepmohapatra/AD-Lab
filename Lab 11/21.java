package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"report.csv\"");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "username", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM table");

            PrintWriter writer = response.getWriter();
            writer.println("ID,Name,Salary");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");

                writer.println(id + "," + name + "," + salary);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Failed to generate report.");
        }
    }
}


This servlet generates a CSV file dynamically from a database and allows the user to download it.