package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
        name = "HelloServlet",
        urlPatterns = {"/hello"},
        initParams = {
                @WebInitParam(name = "SessionTimeout", value = "5")
        }
)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sessionTimeout = Integer.parseInt(getInitParameter("SessionTimeout"));
        request.getSession().setMaxInactiveInterval(sessionTimeout * 60);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("Session timeout set to " + sessionTimeout + " minutes.");
    }
}
