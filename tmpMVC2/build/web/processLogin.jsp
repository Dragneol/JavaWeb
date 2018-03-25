<%-- 
    Document   : processLogin
    Created on : Feb 8, 2018, 7:14:36 AM
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
        <jsp:useBean id="login" class="beans.LoginBean" scope="session"></jsp:useBean>
        <%--<jsp:setProperty name="login" property="username" value='<%= request.getParameter("txtUsername") %>'></jsp:setProperty>
        <jsp:setProperty name="login" property="password" value='<%= request.getParameter("txtPassword") %>'></jsp:setProperty>
        
        <jsp:setProperty name="login" property="username" param="txtUsername"/>
        <jsp:setProperty name="login" property="password" param="txtPassword"/>
        --%>
        
        <jsp:setProperty name="login" property="*"/>
        
        <%
        String location = "invalid.html";
        if (login.checkLogin()) {
            %>
            
            <%
//            location = "search.jsp";
              
            System.out.println("Chay toi day");
        }//end if
        response.sendRedirect(location);
        %>
        
        
        
        <br/>
        Test:
        Username : <jsp:getProperty name="login" property="user"/><br/>
        Username : <jsp:getProperty name="login" property="pass"/>
    </body>
</html>
