<%-- 
    Document   : index
    Created on : Dec 8, 2017, 10:45:16 AM
    Author     : Dragneol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book Store</h1>
        <form action="MainController" method="POST">
            Please choose your book :
            <select name="listBook">
                <option value="B001-JSP-100">JSP</option>
                <option value="B002-Java-200">Java</option>
                <option value="B003-Android-300">Android</option>
                <option value="B004-XML-400">XML</option>
                <option value="B005-Servlet-500">Serlvet</option>
            </select><br/>
            <input type="submit" value="Add to Cart" name="action"/>
        </form>
        <br/>
        <a href="view.jsp">View your Cart</a>
    </body>
</html>
