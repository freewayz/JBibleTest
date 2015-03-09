/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bible.test.controller;

import app.bible.test.model.JChapterModel;
import app.bible.test.model.JVerseModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class JChapterController {

    private JBookController bookController;
    private JChapterModel chapterModel;
    private JVerseModel verseModel;

    public JChapterController(JBookController bookController, JChapterModel chapterModel, JVerseModel verseModel) {
        this.chapterModel = chapterModel;
        this.bookController = bookController;
        this.verseModel = verseModel;
        intializeChapter();
    }

    private void intializeChapter() {
        ArrayList<String> chapters = new ArrayList<>();
        if (chapters.isEmpty()) {
            for (int i = 1; i <= 50; i++) {
                chapters.add("Chapter " + i);
            }
            this.chapterModel.setChapters(chapters);
        }

    }
    
    public void setOnchapterClicked(){
            openBibleFileForReading(bookController.getBookModel().getBookName());
    }

    public JChapterModel getChapterModel() {
        return chapterModel;
    }

    public void openBibleFileForReading(String book_) {
        StringBuffer bibleVerseContent = new StringBuffer();
        String book_name_to_open = "C:\\Users\\root\\Documents\\BibleProject\\"
                + "Jbible-master\\JBiblePrototype\\src\\resources\\books\\" + book_ +".txt";
        try (BufferedReader reader = new BufferedReader(
                new FileReader(book_name_to_open))) {
            String line_content;
            while((line_content = reader.readLine()) != null){
                bibleVerseContent.append(line_content).append("\n\n");
            }
        }catch(IOException fileErr){
            fileErr.printStackTrace();
        }
//        System.out.println(bibleVerseContent);
        
        verseModel.setVerseBuffer(bibleVerseContent);
    }
}
