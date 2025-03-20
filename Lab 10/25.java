package com.swapnadeep.week1.ad_lab_servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            URL url = new URL("https://api.example.com/data");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder jsonData = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
            reader.close();
            connection.disconnect();

            JSONArray jsonArray = new JSONArray(jsonData.toString());

            out.println("<html><body>");
            out.println("<h2>Data from External API:</h2>");
            out.println("<ul>");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                out.println("<li>" + jsonObject.getString("field1") + " - " + jsonObject.getInt("field2") + "</li>");
            }
            out.println("</ul>");
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("An error occurred: " + e.getMessage());
        }
    }

}
