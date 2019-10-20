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

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.cgsit.training.beans.DemoBusinessBean;

/**
 * Servlet implementation class VerySimpleServlet
 * this servlet is not annotated. instead it is registered
 * as servlet in th web.xml file
 */
@RequestScoped
public class SimpleServletFour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	DemoBusinessBean bean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleServletFour() {
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
