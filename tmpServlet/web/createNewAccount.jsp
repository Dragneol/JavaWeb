<%-- 
    Document   : createNewAccount
    Created on : Feb 6, 2018, 8:56:25 AM
    Author     : dragneol
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="day07.registration.RegistrationInsertError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
    </head>
    <body>
        <div>Create</div>
        <form action="ControllerServlet" method="POST">
            <c:set var="errors" value="${requestScope.INSERTERROR}"/>
            <c:if test="${not empty errors.usernameLengthErr}">
                Username* <input type="text" name="txtUsername" value="${param.txtUsername}" />(6 ~ 30 char)<br/>
            </c:if>
            Password* <input type="password" name="txtPassword" value="" />(6 ~ 30 char)<br/>
            Confirm* <input type="password" name="txtConfirm" value="" />(6 ~ 30 char)<br/>
            Last Name* <input type="text" name="txtLastname" value="${txtLastname}" />(6 ~ 30 char)<br/>
            <input type="submit" value="CreateAccount" name="btnAction" />
            <%--       
            <%
                RegistrationInsertError errors = (RegistrationInsertError) request.getAttribute("INSERTERROR");
            %>
            Username* <input type="text" name="txtUsername" value="<%= request.getParameter("txtUsername")%>" />(6 ~ 30 char)<br/>
            <%
                if (errors != null) {
                    if (errors.getUsernameLengthErr() != null) {
            %>
            <font color="red"><%= errors.getUsernameLengthErr()%></font>
            <%

                    }
                }

            %>
            Password* <input type="password" name="txtPassword" value="" />(6 ~ 30 char)<br/>
            <%                 if (errors != null) {
                    if (errors.getPasswordLengthErr() != null) {
            %>
            <font color="red"><%= errors.getPasswordLengthErr()%></font>
            <%

                    }
                }

            %>
            Confirm* <input type="password" name="txtConfirm" value="" />(6 ~ 30 char)<br/>
            <%                if (errors != null) {
                    if (errors.getConfirmNotMatchErr() != null) {
            %>
            <font color="red"><%= errors.getConfirmNotMatchErr()%></font>
            <%

                    }
                }

            %>
            Last Name* <input type="text" name="txtLastname" value="<%= request.getParameter("txtUsername")%>" />(6 ~ 30 char)<br/>
            <%                if (errors != null) {
                    if (errors.getLastnameLengthErr() != null) {
            %>
            <font color="red"><%= errors.getLastnameLengthErr()%></font>
            <%

                    }
                }

            %>
            <input type="submit" value="CreateAccount" name="btnAction" />
            <%                if (errors != null) {
                    if (errors.getUsernameExistedErr() != null) {
            %>
            <font color="red"><%= errors.getUsernameExistedErr()%></font>
            <%

                    }
                }

            %>
            --%>
        </form>
    </body>
</html>
