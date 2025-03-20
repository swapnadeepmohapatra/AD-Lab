package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.io.Part;

@WebServlet("/fileUpload")
@MultipartConfig
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            part.write("C:\\uploads" + fileName);
        }
        response.getWriter().println("File(s) uploaded successfully");
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return "";
    }
}


This servlet can handle file uploads using multipart/form-data and saves the files on the server in the C:\uploads directory. The @MultipartConfig annotation is used to specify that the servlet expects multipart/form-data requests.