package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.List;
import java.util.UUID;

@WebServlet("/fileUpload")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadPath = "C:/uploads"; // Directory to save the uploaded files

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            List<Part> fileParts = request.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList());

            for (Part part : fileParts) {
                String fileName = part.getSubmittedFileName();
                String fileExtension = fileName.substring(fileName.lastIndexOf(".")); // Get file extension
                String newFileName = UUID.randomUUID().toString() + fileExtension; // Generate unique file name

                part.write(uploadPath + File.separator + newFileName);
            }

            response.getWriter().println("Files uploaded successfully!");
        } catch (Exception e) {
            response.getWriter().println("Failed to upload files: " + e.getMessage());
        }
    }
}