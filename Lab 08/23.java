package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletOutputStream;
import java.io.IOException;

@WebServlet("/upload-files")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ServletInputStream in = request.getInputStream();
        ServletOutputStream out = response.getOutputStream();

        int data = -1;
        while ((data = in.read()) != -1) {
            out.write(data);
        }

        in.close();
        out.close();
    }
}
