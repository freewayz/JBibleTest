/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bible.test.model;

import java.util.Observable;

/**
 *
 * @author root
 */
public class JVerseModel extends Observable{
    
    private StringBuffer verseBuffer;

    public  JVerseModel(){
        
    }
    
    
    public StringBuffer getVerseBuffer() {
        return verseBuffer;
    }

    public void setVerseBuffer(StringBuffer verseBuffer) {
        this.verseBuffer = verseBuffer;
        notifyObservers();
    }
    
    
}
