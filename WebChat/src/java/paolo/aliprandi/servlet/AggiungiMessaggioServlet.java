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
public class AggiungiMessaggioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = request.getServletContext();
        ListaStanze listastanze = (ListaStanze) context.getAttribute("listastanze");
        
        String titolo = request.getParameter("stanzatitolo");
        String user=(String)(request.getSession().getAttribute("username"));
        String messagetxt = request.getParameter("messagetext");
        
        Stanza stanza = listastanze.get(titolo);
        stanza.addMessage(user, messagetxt);
        
        request.setAttribute("stanza", stanza);
        
        System.out.println("------AggiungiMessaggioServlet------");
        System.out.println(titolo);
        System.out.println(user);
        System.out.println(messagetxt);
        
        RequestDispatcher rd = request.getRequestDispatcher("MostraStanzaServlet");
        rd.forward(request, response);
        
    }

}
