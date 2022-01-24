<%-- 
    Document   : header
    Created on : 13-gen-2022, 16.38.23
    Author     : paoloaliprandi
--%>

<%= session.getAttribute("username")%><input type="button" style="float: right" onclick="location.replace('LogoutServlet');" value="logout">
<hr>
