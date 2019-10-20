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

import at.cgsit.training.AppScopedTwo;

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
	urlPatterns = "/simple-servlet-two",
initParams = {
        @WebInitParam(name = "firstName", value = "John"),
        @WebInitParam(name = "lastName", value = "Doe")
    }
)
@RequestScoped
public class SimpleServletTwo extends HttpServlet {

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
