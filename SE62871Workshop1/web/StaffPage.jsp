<%-- 
    Document   : StaffPage
    Created on : Mar 9, 2018, 10:57:01 PM
    Author     : Dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="myTag"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile Shop</title>
    </head>
    <body>
        <c:set var="user" value="${sessionScope.USER}"/>
        <c:if test="${empty user or user.role ne 2}">
            <h1>Access Denied!!!</h1>
        </c:if>
            
        <c:if test="${not empty user and user.role eq 2}">
            
            <font color="red">Welcome, ${user.fullname}.</font>
            <c:url var="logoutUrlRewriting" value="MiddleServlet">
                <c:param name="btnAction" value="Log out"/>
            </c:url>
            <a href="${logoutUrlRewriting}">Log out</a>
            
            <h1>Staff page</h1>
            <form action="MiddleServlet">
                <input type="text" name="txtSearch" value="${param.txtSearch}" />
                <input type="hidden" name="txtSearchType" value="IDorName" />
                <input type="submit" value="Search" name="btnAction" />
            </form><br/>
            
            <c:if test="${not empty param.txtSearch}">
                <c:set var="mobiles" value="${requestScope.SEARCHRESULT}"/>
                
                <c:if test="${not empty mobiles}">
                    <table border="solid 1px">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Year of production</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Not sale</th>
                                <th colspan="2">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="mobileItem" items="${mobiles}">
                                <tr>
                                <form action="MiddleServlet">
                                    <td>
                                        ${mobileItem.mobileID}
                                        <input type="hidden" name="txtMobileID" value="${mobileItem.mobileID}" />
                                    </td>
                                    <td>${mobileItem.mobileName}</td>
                                    <td>
                                        <input type="text" name="txtMobileDescription" value="${mobileItem.description}" />
                                    </td>
                                    <td>${mobileItem.yearOfProduction}</td>
                                    <td>
                                        <input type="number" name="txtMobileQuantity" value="${mobileItem.quantity}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtMobilePrice" value="${mobileItem.price}" />
                                    </td>
                                    <td>
                                        <input type="checkbox" name="chkNotSale"
                                               <c:if test="${mobileItem.notSale}">
                                                   checked="checked"
                                               </c:if> />
                                    </td>
                                    <td><input type="submit" value="Update" name="btnAction" /></td>
                                    <td><input type="submit" value="Delete" name="btnAction" /></td>
                                    <input type="hidden" value="${param.txtSearch}" name="txtLastSearchValue" />
                                </form>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    
                    <c:set var="error" value="${requestScope.UPDATEERROR}"/>
                    <c:if test="${not empty error.descriptionIsEmpty}">
                        <font color="red">${error.descriptionIsEmpty}</font><br/>
                    </c:if>
                    <c:if test="${not empty error.invalidQuantity}">
                        <font color="red">${error.invalidQuantity}</font><br/>
                    </c:if>
                    <c:if test="${not empty error.invalidPrice}">
                        <font color="red">${error.invalidPrice}</font><br/>
                    </c:if>
                        
                </c:if>
                
                <c:if test="${empty mobiles}">
                    <h3>No record is matched!!!</h3>
                </c:if>
                
            </c:if>
                    
            <form action="MiddleServlet">
                <c:set var="err" value="${requestScope.INSERTERROR}"/>
                <h2>Insert new mobile</h2>
                ID:<br/>
                <input type="text" name="txtMobileID" value="${param.txtMobileID}" /><br/>
                <c:if test="${not empty err.mobileIDIsEmpty}">
                    <font color="red">${err.mobileIDIsEmpty}</font><br/>
                </c:if>
                <c:if test="${not empty err.mobileIDIsExisted}">
                    <font color="red">${err.mobileIDIsExisted}</font><br/>
                </c:if>
                Name:<br/>
                <input type="text" name="txtMobileName" value="${param.txtMobileName}" /><br/>
                <c:if test="${not empty err.nameIsEmpty}">
                    <font color="red">${err.nameIsEmpty}</font><br/>
                </c:if>
                Description:<br/>
                <input type="text" name="txtDescription" value="${param.txtDescription}" /><br/>
                <c:if test="${not empty err.descriptionIsEmpty}">
                    <font color="red">${err.descriptionIsEmpty}</font><br/>
                </c:if>
                Price:<br/>
                <input type="text" name="txtPrice" value="${param.txtPrice}" /><br/>
                <c:if test="${not empty err.invalidPrice}">
                    <font color="red">${err.invalidPrice}</font><br/>
                </c:if>
                Year of production:<br/>
                <input type="number" name="txtYearOfProduction" value="${param.txtYearOfProduction}" /><br/>
                <c:if test="${not empty err.invalidYearOfProduction}">
                    <font color="red">${err.invalidYearOfProduction}</font><br/>
                </c:if>
                Quantity:<br/>
                <input type="number" name="txtQuantity" value="${param.txtQuantity}" /><br/>
                <c:if test="${not empty err.invalidQuantity}">
                    <font color="red">${err.invalidQuantity}</font><br/>
                </c:if>
                Not sale: 
                <input type="checkbox" name="chkNotSale"/><br/>
                <input type="submit" value="Insert" name="btnAction" />
            </form>

        </c:if>
    </body>
</html>