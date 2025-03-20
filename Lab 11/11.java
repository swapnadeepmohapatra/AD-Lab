package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_name", "username", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM table_name");

            out.println("<h2>Records from the Database:</h2>");
            out.println("<ul>");
            while (rs.next()) {
                out.println("<li>" + rs.getString("column_name") + "</li>");
            }
            out.println("</ul>");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Error fetching records from the database.");
        }

        out.println("</body></html>");
    }

    public void destroy() {
        // Cleanup code, if any
    }
}
