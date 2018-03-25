<%-- 
    Document   : processLogin
    Created on : Feb 9, 2018, 3:39:34 PM
    Author     : dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process</title>
    </head>
    <body>
        <h1>Process Login...</h1>

        <jsp:useBean id="login" class="beans.LoginBean"/>

        <!-- when param are txtUsername and txtPassword--!>
        
        <%--
        <jsp:setProperty name="login" property="username" 
        value='<%= request.getParameter("txtUsername")%>'/>
        <jsp:setProperty name="login" property="password"
        value='<%= request.getParameter("txtPassword")%>'/>
        --%>

        <%--
        <jsp:setProperty name="login" property="username" param="txtUsername"/>
        <jsp:setProperty name="login" property="password" param="txtPassword"/>
        --%>
        
        <!-- when param are username and password (same name of attribute in loginBean--!>
        
        <%--
         <jsp:setProperty name="login" property="username"/>
         <jsp:setProperty name="login" property="password"/>
        --%>

        <jsp:setProperty name="login" property="*"/>

        Test<br/>
        Username : <jsp:getProperty name="login" property="username"/><br/>
        Password : <jsp:getProperty name="login" property="password"/><br/>

        <c:if test="${login.checkLogin()}">
            <jsp:forward page="search.jsp">
                <jsp:param name="" value=""/>
                <jsp:param name="" value=""/>
            </jsp:forward>
        </c:if>

        <jsp:forward page="invalid.html"></jsp:forward>
    </body>
</html>
