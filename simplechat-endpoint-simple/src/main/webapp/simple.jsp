<%@ page import="java.text.DecimalFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: cgssc
  Date: 01.01.2019
  Time: 00:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>CGS-IT Training</title>
</head>
<body>
<div align="center">
    <h3> Random Number:</h3>

<%
    double num = Math.random();
    DecimalFormat df = new DecimalFormat("###.###");

    if (num > 0.50) {
%>
<h2>Success !</h2><p>(<%= df.format(num) %>)</p>
<%
} else {
%>
<h2> The number is too low ... </h2><p>(<%= df.format(num) %>)</p>
<%
    }  
   if (num > 0.75) {
%>
<h2> dieNummer ist größer als 0,75 </h2>	   
<%
   }
%>
<a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
<p><%=request.getRequestURI() %> </p>

</div>
</body>
</html>
