package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Weather API Integration</title></head><body>");

        try {
            URL url = new URL("https://api.weatherapi.com/v1/current.json?key=YOUR_API_KEY&q=London");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer responseData = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                responseData.append(inputLine);
            }
            in.close();

            out.println("<h2>Weather API Response Data:</h2><pre>");
            out.println(responseData.toString());
            out.println("</pre>");

        } catch (Exception e) {
            out.println("<h2>Error fetching data from Weather API</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
        }

        out.println("</body></html>");
        out.close();
    }
}
