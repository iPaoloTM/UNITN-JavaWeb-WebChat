/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paolo.aliprandi.obj;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author paoloaliprandi
 */
public class ListaStanze extends HashMap<String, Stanza> {
    
    private final String PRE="<li><a href=MostraStanzaServlet?stanzanome=";
    private final String MID=">";
    private final String POST="</a></li>";
    
    public String getFormattedRoomList() {
         String s="<h2>Non ci sono ancora stanze</h2>";
        if (!this.isEmpty()){
            Collection<Stanza> c=this.values();
            s="<h2>Entra in una delle stanze disponibili:</h2><ul>";
            for (Stanza r:c) {
                s=s+PRE+r.getEncodedTitle()+MID+r.titolo+POST;
            }
            s=s+"</ul>";
        }
        return s;
    }
    
}
