import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String htmlForm = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>Simple Form</title>" +
                "</head>" +
                "<body>" +
                "<h1>Simple HTML Form</h1>" +
                "<form>" +
                "First Name: <input type='text' name='firstName'><br>" +
                "Last Name: <input type='text' name='lastName'><br>" +
                "<input type='submit' value='Submit'>" +
                "</form>" +
                "</body>" +
                "</html>";

        response.getWriter().println(htmlForm);
    }
}
