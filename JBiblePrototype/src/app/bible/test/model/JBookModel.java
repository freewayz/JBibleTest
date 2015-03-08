/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bible.test.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author root
 */
public class JBookModel extends AbstractListModel<String>{
 
    
    private String bookName;
    private ArrayList<String> testament;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setTestament(ArrayList<String> testament) {
        this.testament = testament;
        fireContentsChanged(this, 0, testament.size());
    }

    public ArrayList<String> getTestament() {
        return testament;
    }

    @Override
    public String toString() {
        return getBookName();
    }

    @Override
    public int getSize() {
        return getTestament().size();
    }

    @Override
    public String getElementAt(int index) {
        return getTestament().get(index);
    }
    
    
    
    
    
    
}
