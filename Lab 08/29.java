package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.websocket.server.ServerEndpointConfig.Configurator;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/chat", configurator = ChatConfigurator.class)
public class ChatEndpoint {
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        StringWriter sw = new StringWriter();
        synchronized (sessions) {
            for (Session s : sessions) {
                if (!s.equals(session)) {
                    s.getBasicRemote().sendText(message);
                }
            }
        }
    }
}

class ChatConfigurator extends Configurator {
    @Override
    public <B> B getEndpointInstance(Class<B> endpointClass) throws InstantiationException {
        return (B) new ChatEndpoint();
    }
}
