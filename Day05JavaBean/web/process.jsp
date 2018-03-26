<%-- 
    Document   : process
    Created on : Dec 8, 2017, 1:50:16 PM
    Author     : Dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:useBean id="loginBean" class="javabean.LoginBean"/>
        <jsp:setProperty name="loginBean" property="username" param="txtUsername"/>
        <jsp:setProperty name="loginBean" property="password" param="txtPassword"/>
        <%
            String role = loginBean.checkLogin();
        %>
        Role : <input type="text" name="" value="<%= role%>" /><br/>
        Role = <%= loginBean.checkLogin()%><br/>
        Role ${role}
    </body>
</html>
