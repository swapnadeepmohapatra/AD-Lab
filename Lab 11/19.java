Here is the Java servlet page implementation using JWT for handling stateless authentication:

package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String secretKey = "mySecretKey";

        // Generate JWT token
        String token = Jwts.builder()
                .setSubject("username")
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .compact();

        // Send the JWT token back to the client
        out.println("JWT Token: " + token);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String token = request.getHeader("Authorization");
        String secretKey = "mySecretKey";

        try {
            // Parse and validate the JWT token
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String username = claims.getSubject();
            
            out.println("User authenticated: " + username);
        } catch (Exception e) {
            out.println("Invalid Token");
        }
    }
}


In the above code, the servlet `HelloServlet` uses JWT for handling stateless authentication. The servlet has two methods, `doPost` for generating the JWT token and sending it back to the client, and `doGet` for receiving the JWT token from the client, parsing and validating it.