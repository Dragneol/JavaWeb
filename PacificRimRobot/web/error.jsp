<%-- 
    Document   : error.jsp
    Created on : Apr 25, 2018, 9:00:42 AM
    Author     : DuongPTHSE62871
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
    <body>
        <jsp:include page="header.jsp"/>
        <h3>Announcement</h3>
        <a>An error occurs</a>
        <font color="red">
        ${requestScope.ERROR}
        </font>
        <jsp:include page="footer.jsp"/>
    </body>
</html>