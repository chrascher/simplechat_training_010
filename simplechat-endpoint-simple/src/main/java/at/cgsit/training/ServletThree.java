package at.cgsit.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.cgsit.training.beans.RequestScopedBean;

/**
 * Servlet implementation class ServletThree
 */
@WebServlet("/ServletThree")
public class ServletThree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	RequestScopedBean rsBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletThree() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
		String result = rsBean.calculate();
		
        PrintWriter out = response.getWriter();
        out.println("<div align=\"center\"><h1>Generated Number: " + result + "</h1></div>");

        
	}

}
