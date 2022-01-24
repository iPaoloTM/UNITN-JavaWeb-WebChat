<%-- 
    Document   : mostraStanza
    Created on : 13-gen-2022, 17.07.19
    Author     : paoloaliprandi
--%>
<%@page import="paolo.aliprandi.obj.Stanza"%>
<jsp:useBean id="messaggi" class="java.lang.String" scope="request" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% Stanza stanza = (Stanza)request.getAttribute("stanza"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostra stanza</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <script>
            window.onload = function(){
                setInterval(function(){refresh();},10000);
            };
            function refresh() {
                console.log(document.getElementById("messageText").value)
                //reload page iif user is not writing a msg
                if (document.getElementById("messageText").value==="") {
                   location.replace("MostraStanzaServlet?stanzanome=<%=stanza.getEncodedTitle()%>");
                }
            }
        </script>
        <h2>Sei nella stanza "<%= stanza.getTitle() %>"</h2>
        <span id="messages"><%if (messaggi!=null) out.println(messaggi); %></span>
        <hr>
        <h2>Inserisci un nuovo messaggio</h2>
        <form action="AggiungiMessaggioServlet" method="post">
        <input type="hidden" id="roomTitle" name="stanzatitolo" value="<%=stanza.getTitle()%>">
        <input type="hidden" id="user" name="user" value="<%=session.getAttribute("username")%>">
        <input type="text" id="messagetext" name="messagetext">
        <input type="submit" value="Invia">
        </form>
        <hr>
        La pagina si ricarica automaticamente ogni 10 sec, ma se vuoi puoi ricaricarla manualmente: 
        <input type="button" onclick="refresh()" value="Ricarica"></button>
        <hr>
        <a href="home.jsp">Esci dalla stanza</a>
    </body>
</html>
