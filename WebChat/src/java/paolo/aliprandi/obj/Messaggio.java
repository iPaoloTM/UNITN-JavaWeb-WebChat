/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paolo.aliprandi.obj;

import java.util.Date;

/**
 *
 * @author paoloaliprandi
 */
public class Messaggio implements Comparable<Messaggio> {
    
    private static int maxSeqNumber=0;
    int seqNumber;
    Date date;
    String author;
    String message;
    
    public Messaggio(String author,String message) {
        date=new Date();
        seqNumber=++maxSeqNumber;
        this.author=author;
        this.message=message;
    }
    // l'aggiunta di questo metodo permette di aggingere messaggi a un Set ordinato
    @Override
    public int compareTo(Messaggio o) {
        return seqNumber-o.seqNumber;
    }
    
}
