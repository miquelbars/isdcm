<%-- 
    Document   : signup
    Created on : 13-mar-2021, 11:12:29
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
        <title>Web Application - Sign Up</title>
    </head>
    <body>
        <div style="text-align: center">
            <h1>Registro Usuarios</h1>
            <form action="user" method="post">
                <label for="nombre">Nombres:</label>
                <input name="nombre" size="30" required maxlength="255" />
                <br><br>
                <label for="apellido">Apellidos:</label>
                <input name="apellido" size="30" required maxlength="255" />
                <br><br>
                <label for="username">Usuario:</label>
                <input name="username" size="30" required maxlength="255" />
                <br><br>
                <label for="email">Correo Electrónico:</label>
                <input type="email" name="email" size="30" required maxlength="255" />
                <br><br>
                <label for="password">Contraseña:</label>
                <input type="password" name="password" size="30" required maxlength="255" />
                <br><br>
                <label for="passwordConfirmation">Repetir contraseña:</label>
                <input type="password" name="passwordConfirmation" size="30" required maxlength="255" />
                <br>${errorMsg}
                <br><br>           
                <button type="submit">Registrar Usuario</button>
            </form>
            <br><br>
            <a href="<%= request.getContextPath() %>/login.jsp">Ya tienes una cuenta? <b> Login </b></a>
        </div>
    </body>
</html>
