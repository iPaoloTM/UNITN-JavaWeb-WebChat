<%-- 
    Document   : login
    Created on : 13-gen-2022, 16.10.52
    Author     : paoloaliprandi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="alert" class="java.lang.String" scope="request" /> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Benvenuto</title>
    </head>
    <body>
        <%if (alert!=null) out.println(alert); %>
         
        <h1>Inserisci le tue credenziali per accedere</h1>
        <form action="ValidateServlet" method="post">
            <input type="text" name="username">
            <input type="password" name="password">
            <input type="submit" value="accedi">
        </form>
    </body>
</html>
