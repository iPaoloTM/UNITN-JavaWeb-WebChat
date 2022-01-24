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
public class CreaStanzaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       ServletContext context = request.getServletContext();
       ListaStanze listastanze = (ListaStanze) context.getAttribute("listastanze");
       
       if (listastanze == null) {
           listastanze = new ListaStanze();
           context.setAttribute("listastanze", listastanze);
       }
       
       String titolo=request.getParameter("stanzatitolo");
       
        String error=null;
        if (titolo==null)  error="Titolo della stanza non specificato";
        else if (listastanze.get("titolo")!=null) error="stanza \""+titolo+"\" già esistente";
        if (error!=null) {
            request.setAttribute("errormsg", error);
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
        
        System.out.println("------CreaStanzaServlet------");
        System.out.println(titolo);
        
        Stanza stanza = new Stanza(titolo, context);
        request.setAttribute("stanza", stanza);
        RequestDispatcher rd=request.getRequestDispatcher("mostraStanza.jsp");
        rd.forward(request, response);
    }

}
