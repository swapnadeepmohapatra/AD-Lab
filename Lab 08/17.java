package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.Date;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Cookie cookie = new Cookie("myCookie", "hello");
        cookie.setMaxAge(60); // Set cookie expiration time to 60 seconds
        response.addCookie(cookie);

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("myCookie")) {
                    out.println("Cookie Name: " + c.getName());
                    out.println("<br/>");
                    out.println("Cookie Value: " + c.getValue());
                    out.println("<br/>");
                    out.println("Cookie Max Age: " + c.getMaxAge() + " seconds");
                    out.println("<br/>");
                    if (c.getMaxAge() > 0) {
                        Date expiry = new Date(System.currentTimeMillis() + (c.getMaxAge() * 1000));
                        out.println("Cookie Expires At: " + expiry);
                    } else {
                        out.println("Cookie Expires At: End of Session");
                    }
                }
            }
        } else {
            out.println("Cookie not set yet.");
        }

        out.close();
    }
}
