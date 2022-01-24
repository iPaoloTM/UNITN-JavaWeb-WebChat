/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paolo.aliprandi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import paolo.aliprandi.obj.ListaStanze;
import paolo.aliprandi.obj.Stanza;

/**
 *
 * @author paoloaliprandi
 */
public class MostraStanzaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Stanza stanza = (Stanza) request.getAttribute("stanza");
       if (stanza==null) {
           String stanzanome =request.getParameter("stanzanome");
           
           ServletContext context = request.getServletContext();
           ListaStanze listastanze = (ListaStanze) context.getAttribute("listastanze");
           stanza = listastanze.get(stanzanome);
       }
       
       System.out.println("------MostraStanzaServlet------");
       System.out.println(stanza.getTitle());
       
       request.setAttribute("stanza", stanza);
       request.setAttribute("messaggi", stanza.getFormattedMessageList());
       
       RequestDispatcher rd=request.getRequestDispatcher("mostraStanza.jsp");
       rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
