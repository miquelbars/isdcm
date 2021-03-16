<%-- 
    Document   : login
    Created on : 13-mar-2021, 10:36:32
    Author     : fiblabs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
if(session.getAttribute("user")!=null) //check for existing session
{
	response.sendRedirect("video.jsp");
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Application - Login</title>
    </head>
    <body>
        <div style="text-align: center">
            <h1>Login</h1>
            <form action="login" method="post">
                <label for="username">Usuario:</label>
                <input name="username" size="30" maxlength="255" required />
                <br><br>
                <label for="password">Password:</label>
                <input type="password" name="password" size="30" maxlength="255" required />
                <br>${errorMsg}
                <br><br>           
                <button type="submit">Login</button>
            </form>
            <br><br> 
            <a href="<%= request.getContextPath() %>/signup.jsp">No tienes cuenta? <b> Registrarse </b></a>
        </div>
    </body>
</html>
