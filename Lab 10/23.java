package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Asynchronous Processing Example</title></head><body>");
        out.println("<h1>Asynchronous Processing Example</h1>");

        AsyncContext asyncContext = request.startAsync();
        asyncContext.setTimeout(60000); // 60 seconds

        out.println("<div id='progress' style='width: 300px; border: 1px solid black;'></div>");

        // Start a new thread for processing a large task
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(1000); // Simulating a long-running task
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int progress = i * 10;
                out.println("<script>document.getElementById('progress').style.width = '" + progress + "px';</script>");
                out.flush();
            }

            out.println("Task completed!");
            asyncContext.complete();
        }).start();

        out.println("</body></html>");
    }
}