/*
 * (C) Copyright 2019 CGS IT-Solutions (http://www.cgs.at/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package at.cgsit.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.cgsit.training.beans.RequestScopedBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class ServletThree
 */
@WebServlet("/simple-servlet-three")
public class SimpleServletThree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	RequestScopedBean rsBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleServletThree() {
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
