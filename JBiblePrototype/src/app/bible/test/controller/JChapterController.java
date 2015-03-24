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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void setOnchapterClicked(int index) {
        openBibleFileForReading(bookController.getBookModel().getBookName(), index);
    }

    public JChapterModel getChapterModel() {
        return chapterModel;
    }

    public void openBibleFileForReading(String book_, int index) {
        StringBuffer bibleVerseContent = new StringBuffer();
        String book_name_to_open = "C:\\Users\\root\\Documents\\BibleProject\\"
                + "Jbible-master\\JBiblePrototype\\src\\res\\books\\" + book_ + ".txt";
        
//       String b = this.getClass().getResource("")
        Pattern p = Pattern.compile("(\\|+\\d+\\|)");
        Matcher m;
        String sVal = "";
        try (BufferedReader reader = new BufferedReader(
                new FileReader(book_name_to_open))) {
            String line_content;
            while ((line_content = reader.readLine()) != null) {
                m = p.matcher(line_content);
                while(m.find()){
                    sVal = m.group().replaceAll("\\|", "").trim();
                    if(index == Integer.parseInt(sVal)){
                        bibleVerseContent.append(line_content).append("\n\n");
                    }
                }
            }
        } catch (IOException fileErr) {
            fileErr.printStackTrace();
        }
        verseModel.setVerseBuffer(bibleVerseContent);
    }

}
