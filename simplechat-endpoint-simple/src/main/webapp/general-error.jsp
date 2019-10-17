<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="true"%>

<!doctype html>
<html>
    <head>
    ...
    </head>
    <body>
    <div align="center">
    	<h3> Ein Fehler ist aufgetreten </h3>
    </div>
        <ul>
            <li>Exception: ${requestScope['javax.servlet.error.exception']}</li>
            <li>Exception type: ${requestScope['javax.servlet.error.exception_type']}</li>
            <li>Exception message: ${requestScope['javax.servlet.error.message']}</li>
            <li>Request URI: ${requestScope['javax.servlet.error.request_uri']}</li>
            <li>Servlet name: ${requestScope['javax.servlet.error.servlet_name']}</li>
            <li>Status code: ${requestScope['javax.servlet.error.status_code']}</li>
        </ul>
    </body>
</html>
