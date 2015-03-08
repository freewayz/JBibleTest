/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bible.test.model;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author root
 */
public class JChapterModel extends AbstractListModel<String>{
 
    
    private ArrayList<String> chapters;
    private int chpaterIndex;

    public void setChapters(ArrayList<String> chapters) {
        this.chapters = chapters;
        fireContentsChanged(this, 0, chapters.size());
    }

    public void setChpaterIndex(int chpaterIndex) {
        this.chpaterIndex = chpaterIndex;
    }

    public ArrayList<String> getChapters() {
        return chapters;
    }

    public int getChpaterIndex() {
        return chpaterIndex;
    }

    @Override
    public String toString() {
        return getChapters() + String.valueOf(getChpaterIndex());
    }

    @Override
    public int getSize() {
       return getChapters().size();
    }

    @Override
    public String getElementAt(int index) {
         return getChapters().get(index);
    }
    
    
    
}
