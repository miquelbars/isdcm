<%-- 
    Document   : error
    Created on : 13-mar-2021, 10:54:36
    Author     : fiblabs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Application</title>
    </head>
    <body>
        <center>
            <h1>Error</h1>
            <h2>${errorMsg ? errorMsg : "Ocurrió un error inesperado" }<br/> </h2>
        </center> 
    </body>
</html>
