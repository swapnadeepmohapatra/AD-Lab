package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.*;
import java.util.Properties;

@WebServlet("/sendEmail")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String to = request.getParameter("email");
        String subject = "Test Email";
        String messageText = "This is a test email sent from Java Web Application using JavaMail API.";

        // SMTP server configuration
        String host = "smtp.gmail.com";
        String user = "your_email@gmail.com";
        String password = "your_password";

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);

            response.getWriter().println("Email sent successfully to " + to);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
