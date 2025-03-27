package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Connect to the external API
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the JSON response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder responseContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();

            // Parse the JSON response
            JSONArray jsonArray = new JSONArray(responseContent.toString());

            // Display the data in a user-friendly format
            out.println("<html><body>");
            out.println("<h1>Posts from External API:</h1>");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                out.println("<p><b>Title:</b> " + jsonObject.getString("title") + "</p>");
                out.println("<p><b>Body:</b> " + jsonObject.getString("body") + "</p>");
                out.println("<br>");
            }
            out.println("</body></html>");

            connection.disconnect();
        } catch (Exception e) {
            out.println("An error occurred: " + e.getMessage());
        }
    }
}

