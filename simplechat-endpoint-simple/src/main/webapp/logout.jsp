<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CGS IT-Solutoins Training </title>
</head>
<body>

<div align="center">
User '<%=request.getRemoteUser()%>' has been logged out.
<% session.invalidate(); %>
</div>

<br/>
<br/>

<div align="center">
	
	<a href="mylogin/test">Click here to go to test servlet</a>

</div>

<hr/>

</body>
</html>