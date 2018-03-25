<%-- 
    Document   : search
    Created on : Oct 27, 2017, 10:53:15 AM
    Author     : ngocnt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        Welcome, <s:property value="%{#session.FULLNAME}"/><br>
        <a href="logout">Logout</a>
        <h1>Search</h1>
        <s:form action="search">
            <s:textfield name="searchValue" label="Search"/>
            <s:submit value="Search"/>
        </s:form>
        <s:if test="%{!searchValue.isEmpty()}">
            <s:if test="%{listPet != null}">
                <h3>Result</h3>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Pet Name</th>
                            <th>Description</th>
                            <th>Date of Birth</th>
                            <th>Vaccine Description</th>
                            <th>Price</th>
                            <th>Approve</th>
                            <th>Update</th>

                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="%{listPet}" status="counter">
                            <s:form action="update" theme="simple">

                                <tr>
                                    <td>
                                        <s:property value="%{#counter.count}"/>
                                    </td>
                                    <td>
                                        <s:property value="%{petName}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="description" value="%{description}"/>
                                        <%--<s:property value="%{description}"/>--%>
                                    </td>
                                    <td>
                                        <s:property value="%{dob}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="vaccineDesp" value="%{vaccineDesp}"/>
                                        <%--<s:property value="%{vaccineDesp}"/>--%>
                                    </td>
                                    <td>
                                        <s:textfield name="price" value="%{price}"/>
                                        <%--<s:property value="%{price}"/>--%>
                                    </td>
                                    <td>
                                        <s:property value="%{approveReg}"/>
                                    </td>
                                    <td>
                                        <s:submit value="Update"/>
                                        <s:hidden name="petId" value="%{petId}"/>
                                        <s:hidden name="lastSearchValue" value="%{searchValue}"/>
                                    </td>
                                </tr>
                            </s:form>
                        </s:iterator>



                    </tbody>
                </table>


            </s:if>
            <s:else>
                <h3>No record found !!!</h3>
            </s:else>
        </s:if>
    </body>
</html>
