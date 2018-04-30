<%-- 
    Document   : pilot
    Created on : Apr 22, 2018, 11:45:31 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page errorPage="/error.jsp" %>
<!DOCTYPE html>
<html>
    <body>         
        <!--<h3>Welcome, ${sessionScope.AUTHORIZED.firstName} ${sessionScope.AUTHORIZED.lastName}</h3>-->
        <h3>Welcome, <s:property value="%{#session.AUTHORIZED.firstName}"/>
            <s:property value="%{#session.AUTHORIZED.lastName}"/></h3>
            <s:url action="pilot-info" id="mine">
                <s:param name="username" value="%{#session.AUTHORIZED.username}"/>
            </s:url>
            <s:a value="%{mine}"><img src="img/<s:property value='%{#session.AUTHORIZED.imgLink}'/>" width="200" height="200"/></s:a>
        <h4>Your team : <s:property value="%{#session.AUTHORIZED.groupCode}"/></h4>
        <table>
            <thead>
            <th>Profile</th>
            <th>Name</th>
        </thead>
        <tbody>
            <s:iterator value="%{#session.PARTNER}">
                <tr>
                    <td><img src="img/<s:property value='imgLink'/>" width="200" height="200"/></td>
                    <td><s:property value="firstName" /></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
    <s:url id="jeager" action="view-detail">
        <s:param name="name" value="%{#session.JEAGER}"/>
    </s:url>
    <s:a value="%{jeager}">View Robot</s:a>
</body>
</html>
