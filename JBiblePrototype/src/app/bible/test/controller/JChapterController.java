/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bible.test.controller;

import app.bible.test.model.JChapterModel;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author root
 */
public class JChapterController {

    private JBookController bookController;
    private JChapterModel chapterModel;

    public JChapterController(JChapterModel chapterModel) {
        this.chapterModel = chapterModel;
        this.bookController = bookController;
        intializeChapter();
    }

    public void intializeChapter() {
        ArrayList<String> chapters = new ArrayList<>();
        if (chapters.isEmpty()) {
            for (int i = 1; i <= 50; i++) {
                chapters.add("Chapter " + i);
            }
            this.chapterModel.setChapters(chapters);
        }

    }

    public JChapterModel getChapterModel() {
        return chapterModel;
    }

}
