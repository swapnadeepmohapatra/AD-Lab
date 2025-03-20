package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/chat")
public class HelloServlet extends HttpServlet {

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void open(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void close(Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void handleMessage(String message, Session session) throws IOException {
        for (Session s : sessions) {
            if (!s.equals(session)) {
                s.getBasicRemote().sendText(message);
            }
        }
    }
}

