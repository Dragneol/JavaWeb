<%-- 
    Document   : newtag_file
    Created on : Mar 1, 2018, 8:14:31 AM
    Author     : dragneol
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@tag dynamic-attributes="params" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>
<%@attribute name="dataSource" required="true"%>
<%@attribute name="sqlStm" required="true"%>
<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>
<sql:setDataSource var="con" dataSource="${dataSource}"/>
<c:if test="${not empty con}">
    <sql:query var="rs" dataSource="${con}}">
        ${sqlStm}
        <c:forEach var="entry" items="${params}">
            <sql:param value="${entry.value}"/>
        </c:forEach>
    </sql:query>
</c:if>