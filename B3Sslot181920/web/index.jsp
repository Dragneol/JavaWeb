<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html>
    <head>
        <title>Struts 1 Basic</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <logic:messagesPresent>
            <html:messages id="error">
                <font color="red">
                <ul>
                    <li>${error}</li>
                </ul>
                </font>
            </html:messages>
        </logic:messagesPresent>
        <html:form action="Login.do">
            Username <html:text property="username" /><br/>
            Password <html:password property="password"/><br/>
            <html:submit value="Login" />
        </html:form>
    </body>
</html>
