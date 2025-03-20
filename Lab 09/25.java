package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.concurrent.atomic.AtomicLong;

@WebServlet("/filedownload")
public class HelloServlet extends HttpServlet {

    private final int BUFFER_SIZE = 4096;
    private final String FILE_NAME = "example.txt";
    private AtomicLong bytesDownloaded = new AtomicLong(0);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filePath = getServletContext().getRealPath("/WEB-INF/" + FILE_NAME);
        File downloadFile = new File(filePath);

        if (!downloadFile.exists()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().println("File not found");
            return;
        }

        String mimeType = getServletContext().getMimeType(filePath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", FILE_NAME);
        response.setHeader(headerKey, headerValue);

        byte[] buffer = new byte[BUFFER_SIZE];
        try (FileInputStream fis = new FileInputStream(downloadFile);
             BufferedInputStream bis = new BufferedInputStream(fis);
             OutputStream os = response.getOutputStream()) {

            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
                bytesDownloaded.addAndGet(bytesRead);
                System.out.println("Downloaded " + bytesDownloaded.get() + " bytes");
            }
        }
    }
}
