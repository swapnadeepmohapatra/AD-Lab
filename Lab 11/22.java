package com.swapnadeep.week1.ad_lab_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.AsyncContext;

@WebServlet(urlPatterns = "/helloAsync", asyncSupported = true)
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><title>Asynchronous Servlet</title></head><body>");
        out.println("<h1>Asynchronous Processing for Long-Running Tasks</h1>");

        AsyncContext asyncContext = request.startAsync();
        asyncContext.start(() -> {
            try {
                // Simulating a long-running task
                Thread.sleep(5000);
                
                out.println("<p>Long-running task completed successfully!</p>");
                out.println("</body></html>");
                out.close();
                
                asyncContext.complete();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
