<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<jsp:useBean id="helloWorld" class="at.cgsit.training.frontend.beans.HelloWorldController" />
 
<html>
    <head>
        <title>Hello World</title>
    </head>
    <body>
        <f:view>
            <h:form id="mainForm">
             
              <h:panelGrid columns="2">
                <h:outputLabel for="name" value="Please enter your name: " />
                <h:inputText id="name" value="#{helloWorld.name}"  label="username" maxlength="10"
                             size="15" required="true" requiredMessage="A Name is required" style="color:blue" accesskey="n" />
                <h:commandButton value="Press me" action="#{helloWorld.send}"/>
                <h:messages showDetail="true" showSummary="false"/>
              </h:panelGrid>
            </h:form>
            
        </f:view>
    </body>
</html>
