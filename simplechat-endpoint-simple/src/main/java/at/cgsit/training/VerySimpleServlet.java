package at.cgsit.training;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.cgsit.training.beans.DemoBusinessBean;

/**
 * Servlet implementation class VerySimpleServlet
 */
public class VerySimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Inject
	DemoBusinessBean bean;
		
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerySimpleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		bean.calculate();
		
		response.getWriter().append("Served /verySimpleServlet").append(request.getContextPath());
		
		
		
	}

}
