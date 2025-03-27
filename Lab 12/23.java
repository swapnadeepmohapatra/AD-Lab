package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Progress Bar - Async Processing</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Progress Bar - Async Processing</h1>");
        out.println("<div id='progressBar' style='width: 300px; border: 1px solid #ccc;'>0%</div>");
        out.println("<script>");
        out.println("function updateProgress() {");
        out.println("  var progressBar = document.getElementById('progressBar');");
        out.println("  var width = 0;");
        out.println("  var id = setInterval(frame, 10);");
        out.println("  function frame() {");
        out.println("    if (width >= 100) {");
        out.println("      clearInterval(id);");
        out.println("    } else {");
        out.println("      width++;");
        out.println("      progressBar.style.width = width + '%';");
        out.println("      progressBar.innerHTML = width + '%';");
        out.println("    }");
        out.println("  }");
        out.println("}");
        out.println("updateProgress();");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }
}
