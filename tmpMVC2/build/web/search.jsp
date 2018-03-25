<%-- 
    Document   : search
    Created on : Feb 8, 2018, 7:40:39 AM
    Author     : dragneol
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
        <jsp:useBean id="login" scope="page" class="beans.LoginBean" scope="session"/>
        Welcome, <jsp:getProperty name="login" property="user"/>
        
        ${sessionScope.login.username} //sessionScope la lay scope, login la copy o tren trong id, username la copy trong property trong loginBean
        
        //co 5 para duoc truyen toi trang search
        <%= request.getParameter("username") %><br/>
        <%= request.getParameter("password") %><br/>
        <%= request.getParameter("btnAction") %><br/>
        <%= request.getParameter("par1") %><br/>
        <%= request.getParameter("par2") %><br/>
    </body>
</html>
