/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paolo.aliprandi.obj;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.ServletContext;

/**
 *
 * @author paoloaliprandi
 */
public class Stanza {
    String titolo;
    ListaMessaggi listamessaggi;

    public Stanza(String titolo, ServletContext context) {
        this.titolo = titolo;
        listamessaggi = new ListaMessaggi();
        
        ListaStanze listastanze = (ListaStanze) context.getAttribute("listastanze");
        listastanze.put(titolo, this);
    }
    
    public String getTitle(){return titolo;}

    public String getEncodedTitle() {
        String encodedTitle=null;
        try {
            encodedTitle=URLEncoder.encode(titolo,"UTF-8");
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        System.out.println("Encoding "+titolo+"<->"+encodedTitle);
        return encodedTitle;
    }

    // ottieni la lista dei messaggi sotto forma di stringa formattata in HTML
        public String getFormattedMessageList(){
        return listamessaggi.getFormattedMessageList();
    }        
    // aggiungi un nuovo messaggio alla lista
    public void addMessage(String user, String testo) {
        Messaggio messaggio=new Messaggio(user,testo);
        listamessaggi.add(messaggio);
    }
    
    
    
}
