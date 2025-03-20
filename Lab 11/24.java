package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.*;
import java.nio.file.Files;

@WebServlet("/fileHandler")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        Part filePart = request.getPart("file");

        if (filePart.getSize() > 1048576) { // File size greater than 1MB not allowed
            response.getWriter().write("File size exceeds the limit of 1MB.");
            return;
        }

        if (!Files.probeContentType(filePart.getSubmittedFileName()).equals("text/plain")) {
            response.getWriter().write("Only text files are allowed.");
            return;
        }

        File file = new File("/path/to/secure/directory", fileName);
        try (InputStream fileContent = filePart.getInputStream();
             OutputStream fileOutputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileContent.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, length);
            }
            response.getWriter().write("File uploaded successfully.");
        } catch (Exception e) {
            response.getWriter().write("File upload failed. Error: " + e.getMessage());
        }
    }

}
