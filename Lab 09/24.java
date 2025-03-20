package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@WebServlet("/")
@ServerEndpoint(value = "/hello")
public class HelloServlet {

    @OnMessage
    public String onMessage(String message, Session session) {
        System.out.println("Received message from client: " + message);
        return "Hello from server!";
    }
}
