package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/fileUpload")
public class HelloServlet extends HttpServlet {
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Set factory constraints
            factory.setSizeThreshold(1024*1024);
            File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(tempDir);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                // Parse the request
                List<FileItem> items = upload.parseRequest(request);

                for (FileItem item : items) {
                    // Process uploaded file
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = "your/server/directory/" + fileName;
                        File uploadedFile = new File(filePath);
                        item.write(uploadedFile);
                    }
                }

                // Send success response
                response.getWriter().println("Files uploaded successfully!");
            } catch (FileUploadException e) {
                throw new ServletException("Cannot parse multipart request.", e);
            } catch (Exception e) {
                throw new ServletException("Cannot write uploaded file to disk.", e);
            }
        } else {
            response.getWriter().println("No file uploaded!");
        }
    }
}
