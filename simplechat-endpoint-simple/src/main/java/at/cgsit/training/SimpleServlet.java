package at.cgsit.training;

import at.cgsit.training.beans.DemoBusinessBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "SimpleServlet" , urlPatterns = "/mySimpleservlet")
public class SimpleServlet extends HttpServlet {

    @Inject
    DemoBusinessBean bean;


    private String defaultMessage;
    DecimalFormat df = new DecimalFormat("###.###");
    
    public void init() throws ServletException {
        
    	double num = Math.random();
    	
        defaultMessage = "Hello World Servlet: Number: " + df.format(num);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        bean.calculate();

    	double num = Math.random();
    	
        PrintWriter out = response.getWriter();
        
        out.println("<div align=\"center\"><h1>" + defaultMessage + "</h1></div>");
        
        out.println("<div align=\"center\"><h1> doGetNumber:"+ df.format(num) + "</h1></div>");
        
        
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedString = localDateTime.format(formatter);
        
        out.println("<br/><div align=\"center\"><h1>local date: " + formattedString + "</h1></div>");

    }
}
