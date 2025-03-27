package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat")
public class HelloServlet {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connection opened. Session ID: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Message received: " + message);
        session.getAsyncRemote().sendText("Received message: " + message);
    }
}
