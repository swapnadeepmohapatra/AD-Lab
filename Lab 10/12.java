package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

@WebServlet("/generatePDF")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            
            document.open();
            document.add(new Paragraph("Hello, this PDF is generated dynamically using iText!"));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
