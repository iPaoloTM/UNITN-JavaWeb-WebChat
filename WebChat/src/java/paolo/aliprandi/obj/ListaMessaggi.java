/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paolo.aliprandi.obj;

import java.util.TreeSet;

/**
 *
 * @author paoloaliprandi
 */
public class ListaMessaggi extends TreeSet<Messaggio> {
    
    final String PRE="<li><span class='author'>";
    final String MID1="</span> : <span class='messaggetxt'>";
    final String MID2="</span> (<span class='date'>";
    final String POST="</date>)</li>";
    
    public String getFormattedMessageList(){
        String s="<p>Ci siamo solo noi qui, che tristezza...</p>";
        if (! this.isEmpty()){
        s="<ol>";
        for (Messaggio m:this){
           s=s+PRE+m.author+MID1+m.message+MID2+m.date.toString()+POST;
        }
        s=s+"</ol>";
        }
        return s;
    }
    
}
