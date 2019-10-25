<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
    <head>
        <title>Hello World</title>
    </head>
    <body>
    <jsp:useBean id="helloWorld" class="at.cgsit.training.frontend.beans.HelloWorldController" />
    
        <f:view>
            <h:form id="mainForm">
            
                <h2><h:outputText value="Hello #{helloWorld.name}. We hope you enjoy Apache MyFaces"/></h2>
                <h2><h:outputText value="Hello Vorname #{helloWorld.vorname}. "/></h2>


                <h:commandLink action="back">
                    <h:outputText value="Home"/>
                </h:commandLink>
            
            </h:form>
            
        </f:view>
    </body>
</html>