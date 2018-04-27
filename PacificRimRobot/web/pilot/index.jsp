<%-- 
    Document   : pilot
    Created on : Apr 22, 2018, 11:45:31 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <body>         
        <h3>Welcome, ${sessionScope.AUTHORIZED.firstName} ${sessionScope.AUTHORIZED.lastname}</h3>
    </body>
</html>
