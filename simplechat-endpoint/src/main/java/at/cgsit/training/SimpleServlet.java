package at.cgsit.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SimpleServlet" , urlPatterns = "/mySimpleservlet")
public class SimpleServlet extends HttpServlet {

    private String defaultMessage;

    public void init() throws ServletException {
        // Initialization code like set up database etc....
        defaultMessage = "Hello World Servlet ";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<div align=\"center\"><h1>" + defaultMessage + "</h1></div>");

    }
}
