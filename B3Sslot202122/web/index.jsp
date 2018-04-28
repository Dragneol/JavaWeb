<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html>
    <head>
        <title>Strut 1 Advance</title>
    </head>
    <body>
        <logic:messagesPresent>
            <html:messages id="error">
                <font color="red">
                <ul>
                    <li>${error}</li>
                </ul>
                </font>
            </html:messages>
        </logic:messagesPresent>
        <h1>Insert</h1>
        <html:form action="/Insert" onsubmit="return validateinsertForm(this);">
            Username <html:text property="username" /><br/>
            Password <html:password property="password"/><br/>
            Email <html:text property="email"/><br/>
            Phone Number<html:text property="phoneNo"/>Ex:0167-4484419
            <html:submit value="Insert"/>
        </html:form>
            <html:javascript formName="InsertForm"/>
    </body>
</html>
