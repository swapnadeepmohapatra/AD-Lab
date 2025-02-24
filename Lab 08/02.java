import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryparams")
public class QueryParamsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Query Parameters</title></head><body>");
        out.println("<h1>Query Parameters:</h1>");

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Age: " + age + "</p>");

        out.println("</body></html>");
    }
}

