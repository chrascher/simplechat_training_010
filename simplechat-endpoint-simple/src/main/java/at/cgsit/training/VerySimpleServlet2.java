package at.cgsit.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerySimpleServlet2
 */
@WebServlet("/VerySimpleServlet2")
public class VerySimpleServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerySimpleServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		String res = request.getParameter("myparam");	
		
		writer.append("<div> Served at: VerySimpleServlet2: with param: <b>" + res + "</b></div>");
	
		writer.append("<br/><hr><h3>Parameter key value list:</h3>");
		
		Map<String, String[]> paramMap = request.getParameterMap();
		
		paramMap.forEach( (k,v)->{
				writer.append("<div>key: " + k + " value: " + v[0] + "</div>" );
			});
		
	}

}
