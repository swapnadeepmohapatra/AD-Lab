package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            try {
                String jwt = token.substring(7);
                Jws<Claims> claims = Jwts.parserBuilder().setSigningKey("secret-key").build().parseClaimsJws(jwt);
                String username = claims.getBody().getSubject();

                response.getWriter().write("Hello, " + username + "!");
            } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT Token");
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No JWT Token found in Authorization header");
        }
    }
}
