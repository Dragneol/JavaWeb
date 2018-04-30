<%-- 
    Document   : roboUpdater
    Created on : Apr 26, 2018, 9:54:23 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/error.jsp" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h3>Welcome, General
            <s:property value="%{#session.AUTHORIZED.firstName}"/>
            <s:property value="%{#session.AUTHORIZED.middleName}"/>
            <s:property value="%{#session.AUTHORIZED.lastName}"/>
        </h3>

        <h4>Edit Image</h4>
        <s:actionerror />
        <s:form action="uploadImg" method="post" enctype="multipart/form-data">
            <s:file name="userImage" label="Image" />
            <s:hidden name="searchField" value="%{searchField}"/>
            <s:hidden name="name" value="%{name}"/>
            <s:submit value="Upload" align="center" />
        </s:form>
        <hr>
        <h4>Jeager Info</h4>
        <form action="robot-update" method="POST">

            <%--
            <s:if test="%{userImageFileName != null && userImageFileName != ''}">
                <s:hidden name="imgLink" value="%{userImageFileName}"/>
            </s:if>
            <s:else>
                <s:hidden name="imgLink" value="img/%{jeager.imgLink}"/>
            </s:else>
            Jeager Info Image:	<img src="img/<s:property value="%{imgLink}"/>" width="100" height="100" /><br/>
            --%>

            <%--
            <s:if test="%{userImageFileName != null && userImageFileName != ''}">
                <s:hidden name="imgLink" value="img/${requestScope.userImageFileName}"/>
            </s:if>
            <s:else>
                <s:hidden name="imgLink" value="img/${requestScope.jeager.imgLink}"/>
            </s:else>
            Jeager Info Image:	<img src="img/<s:property value="%{imgLink}"/>" width="100" height="100" /><br/>
            --%>


            <s:hidden name="searchField" value="%{searchField}"/>
            <s:if test="%{userImageFileName != null && userImageFileName != ''}">
                <img src="img/${requestScope.userImageFileName}" width="200" height="200" /><br/>
                <input type="hidden" name="imgLink" value="${requestScope.userImageFileName}" /> 
            </s:if>
            <s:else>
                <img src="img/${requestScope.jeager.imgLink}" width="200" height="200" /><br/>
                <input type="hidden" name="imgLink" value="${requestScope.jeager.imgLink}" />
            </s:else>

            Robot <input type="text" name="name" value="<s:property value="%{jeager.name}"/>" readonly/><br/>
            Origin <input type="text" name="origin" value="<s:property value="%{jeager.origin}"/>" /><br/>
            Classified <input type="text" name="classified" value="<s:property value="%{jeager.classified}"/>" /><br/>
            Lauched Date <input type="date" name="date"  value="<s:date format="yyyy-MM-dd" name="%{jeager.dateLauched}"/>" /><br/>
            Kaiju Killed <input type="number" name="kaijuKilled" value="<s:property value="%{jeager.kaijuKilled}"/>"/><br/>
            Is Available <input type="checkbox" name="available" value="true" 
                                <s:if test="%{jeager.available}">
                                    checked="checked"
                                </s:if>
                                /><br/>
            <input type="submit" value="Update" name="action" />
        </form>
        <font color="red">
        <s:property value="%{message}"/>
        </font>
        <hr>
        <s:url action="robot-manipulate" id="back">
            <s:param name="searchField" value="%{searchField}"/>
        </s:url>
        <s:a href="%{back}">Back To Jeager Page</s:a>
    </body>
</html>
