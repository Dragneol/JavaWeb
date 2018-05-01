<%-- 
    Document   : index.jsp
    Created on : Apr 24, 2018, 10:25:52 PM
    Author     : DuongPTHSE62871
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<html>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="ai-video-wrapper">
            <h3>WHO ARE YOU?</h3>
            <a href="generalLogin">I'm General</a>
            <a href="pilotLogin">I'm Pilot</a>
            <h3>Don't join yet?</h3>
            <a href="pilotSignUp.jsp">Sign Up</a>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>

