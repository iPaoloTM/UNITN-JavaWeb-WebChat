<%-- 
    Document   : home
    Created on : 13-gen-2022, 16.30.03
    Author     : paoloaliprandi
--%>
<%@page import="paolo.aliprandi.obj.Stanza" %>
<%@page import="paolo.aliprandi.obj.ListaStanze" %>
<jsp:useBean id="listastanze" class="paolo.aliprandi.obj.ListaStanze" scope="application" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%=listastanze.getFormattedRoomList()%>
        <hr>
        <h2>Aggiungi una nuova stanza</h2>
        <form action="CreaStanzaServlet" method="post">
            <input type="text" name="stanzatitolo">
            <input type="submit" value="Crea nuova stanza">
        </form>
    </body>
</html>
