<%-- 
    Document   : ItemGrid
    Created on : Mar 9, 2018, 10:57:01 PM
    Author     : Dragneol
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="mobileItem" required="true"%>

<%-- any content can be specified here e.g.: --%>
<form action="ServletController">
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
        <input type="text" name="txtMobileQuantity" value="${mobileItem.quantity}" />
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
    <td><input type="submit" value="Delete" name="btnAction" /></td>
    <td><input type="submit" value="Update" name="btnAction" /></td>
</form>