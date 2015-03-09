/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bible.test.controller;

import app.bible.test.model.JVerseModel;
import java.util.Observable;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author root
 */
public class JVerseController {
    
    private JChapterController chapterController;
    private JVerseModel verseModel;
    private JTextArea textArea;
    private JList chapterList;
    private JBookController bookController;
    public JVerseController(JChapterController chapterController, JBookController bookController,
            JVerseModel verseModel, JList chapterList) {
        this.chapterController = chapterController;
        this.bookController = bookController;
        this.verseModel = verseModel;
        this.chapterList = (this.bookController.getBookList());
//        this.textArea = versArea;
    }
    
//    public void initializeVerse(){
//        this.textArea.setText(chapterController.openBibleFileForReading().toString());
//    }
//    
    
    
    
}
