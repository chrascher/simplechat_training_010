package at.cgsit.training;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

@WebServlet(name = "Simple Servlet two" , 
	urlPatterns = "/myServletTwo",
initParams = {
        @WebInitParam(name = "firstName", value = "John"),
        @WebInitParam(name = "lastName", value = "Doe")
    }
)
@RequestScoped
public class ServletTwo extends HttpServlet {

	@Inject
	private AppScopedTwo appInfo;
	
    private String defaultMessage;
    
    DecimalFormat df = new DecimalFormat("###.###");
    
    public void init() throws ServletException {
    	
    	double num = Math.random();
    	ServletConfig config = getServletConfig();   
    	
        String firstName = getInitParameter("firstName");
        String lastName = getInitParameter("lastName");
      
        defaultMessage = config.getServletName() + "name: " + firstName + " " + lastName + " time: " + df.format(num);         
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        appInfo.ping("text to log" );
        
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<div align=\"center\"><h1>" + defaultMessage + "</h1></div>");

    }
}
