package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        JSONParser parser = new JSONParser();
        JSONObject jsonResponse = new JSONObject();

        try {
            JSONObject jsonRequest = (JSONObject) parser.parse(request.getReader());
            // Process the JSON user input here
            // Example: Extracting data from JSON input
            String name = (String) jsonRequest.get("name");

            // Prepare JSON response
            jsonResponse.put("message", "Hello, " + name + "! This is a JSON response.");

        } catch (ParseException e) {
            e.printStackTrace();
            jsonResponse.put("error", "Invalid JSON input");
        }

        out.print(jsonResponse.toJSONString());
        out.flush();
    }
}
