package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Your email configuration
        String host = "smtp.gmail.com";
        String user = "your-email@example.com";
        String pass = "your-email-password";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Confirmation Email from HelloServlet");
            message.setText("Hello " + name + ",\n\nThis is a confirmation email from HelloServlet.");

            Transport.send(message);

            PrintWriter out = response.getWriter();
            out.println("<html><body><h1>Email confirmation sent successfully.</h1></body></html>");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}


This servlet handles form data (name and email) submitted by a user and sends a confirmation email to the provided email address.
You may need to add additional code to your `web.xml` if your servlet version requires it for mapping the servlet to a URL pattern.