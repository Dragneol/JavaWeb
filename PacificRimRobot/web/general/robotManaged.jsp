<%-- 
    Document   : generalManageRobot
    Created on : Apr 25, 2018, 10:10:35 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/errorPage.jsp" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .hiddenDivImg{
                display: none;
                position: fixed;
                top: 0;
                right: 0; 
                width: auto;
                height: 100vh;
                z-index: 1;
            }

            .originImg:hover + .hiddenDivImg{
                display: block;
            }
        </style>
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h3>Welcome, General
            <s:property value="%{#session.AUTHORIZED.firstName}"/>
            <s:property value="%{#session.AUTHORIZED.middleName}"/>
            <s:property value="%{#session.AUTHORIZED.lastName}"/>
        </h3>
        <s:form action="robot-manipulate">
            <s:textfield label="Robot Name" name="searchField" value="%{searchField}"/>
            <s:submit label="Search"/>
        </s:form>

        <s:if test="%{searchField == null || searchField == '' || message != ''}">
            <h3><s:property value="message"/></h3>
        </s:if>
        <s:else>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Image</th>
                        <th>Robot</th>
                        <th>Available</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator var="jeager" value="list" status="counter">
                        <s:form theme="simple" action="robot-info">
                            <tr>
                                <td><s:property value="%{#counter.count}"/></td>
                                <td><img class="originImg" style="width : 100px ; height: 150px;"
                                         src="img/<s:property value="#jeager.imgLink"/>" />
                                    <div class="hiddenDivImg" >
                                        <image style="height: 100%" src="img/<s:property value="#jeager.imgLink"/>"/>
                                    </div>
                                </td>
                                <td><s:property value="%{#jeager.name}"/></td>
                                <td><s:checkbox name="available" value="%{#jeager.available}"/></td>
                                <td>
                                    <s:hidden name="searchField" value="%{searchField}"/>
                                    <s:hidden name="name" value="%{#jeager.name}"/>
                                    <s:submit label="View" value="view"/>
                                </td>
                            </tr>
                        </s:form>
                    </s:iterator>
                </tbody>
            </table>
        </s:else>
    </body>
</html>
