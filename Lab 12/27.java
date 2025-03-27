package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.jms.*;
import jakarta.annotation.Resource;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Resource(mappedName = "jms/MyConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/MyQueue")
    private Queue queue;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Logic to process incoming messages asynchronously
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(queue);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    // Process incoming message asynchronously
                }
            });

            connection.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
