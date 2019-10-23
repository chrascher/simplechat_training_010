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

import at.cgsit.training.beans.DemoBusinessBean;
import org.springframework.beans.factory.annotation.Autowired;

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

@WebServlet(name = "SimpleServlet" , urlPatterns = "/simple-servlet")
public class SimpleServlet extends HttpServlet {

    @Autowired
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
