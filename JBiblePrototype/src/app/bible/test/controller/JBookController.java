/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bible.test.controller;

import app.bible.test.model.JBookModel;
import app.bible.test.model.JChapterModel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author root
 */
public class JBookController {

    public static String[][] old = {
        {"Genesis", "50"},
        {"Exodus", "40"},
        {"Leveticus", "27"},
        {"Numbers", "36"},
        {"Deuteronomy", "34"},
        {"Joshua", "24"},
        {"Judges", "21"},
        {"Ruth", "4"},
        {"Samuel 1", "31"},
        {"Samuel 2", "24"},
        {"Kings 1", "22"},
        {"Kings 2", "25"},
        {"Chronicles 1", "29"},
        {"Chronicles 2", "36"},
        {"Ezra", "10"},
        {"Nehemiah", "13"},
        {"Esther", "10"},
        {"Job", "42"},
        {"Psalms", "150"},
        {"Proverbs", "31"},
        {"Ecclesiastes", "12"},
        {"Song of Solomon", "8"},
        {"Isaiah", "66"},
        {"Jeremiah", "52"},
        {"Lamentations", "5"},
        {"Ezeikel", "48"},
        {"Daniel", "12"},
        {"Hosea", "14"},
        {"Joel", "3"},
        {"Amos", "9"},
        {"Obadiah", "1"},
        {"Jonah", "4"},
        {"Micah", "7"},
        {"Nahum", "3"},
        {"Habakkuk", "3"},
        {"Zephaniah", "3"},
        {"Haggai", "2"},
        {"Zecharia", "14"},
        {"Malachi", "1"}
    };

    private JBookModel bookModel;
    private JChapterModel chapterModel;

    private JList bookList;
    private ArrayList<String> chapters;
    String oldtestament[] = new String[old.length];
    String oldChaptersNumbers[] = new String[old.length];

    public JBookController() {
    }

    public JBookController(JBookModel bookModel, JChapterModel chapterModel, JList bookList) {
        this.bookModel = bookModel;
        this.chapterModel = chapterModel;
        this.bookList = bookList;

    }

    public void setBookList() {
        for (int i = 0; i < old.length; i++) {
            oldtestament[i] = old[i][0];
            oldChaptersNumbers[i] = old[i][1];
        }
        ArrayList<String> books = new ArrayList<>();
        books.addAll(Arrays.asList(oldtestament));
        bookModel.setTestament(books);
    }

    int getChaptersLengths(String bookName) {
        int chapter_length = 0;
        for (int s = 0; s < oldtestament.length; s++) {
            if (oldtestament[s].equalsIgnoreCase(bookName)) {
                chapter_length = Integer.parseInt(oldChaptersNumbers[s]);
            }
        }
        return chapter_length;
    }

    public void addBookOnClick() {
        chapters = chapterModel.getChapters();
        bookList.addListSelectionListener(
                (ListSelectionEvent event) -> {
                    chapters.clear();
                    String currentItemClicked = (String) bookList.getSelectedValue();
                    bookModel.setBookName(currentItemClicked);
                    chapterModel.setChpaterIndex(getChaptersLengths((currentItemClicked)));
                    for (int i = 1; i <= getChaptersLengths(bookModel.getBookName()); i++) {
                        chapters.add("Chapter " + i);
                    }
                    chapterModel.setChapters(chapters);
                    
                }
        );
        bookList.revalidate();
    }

    public JList getBookList() {
        return bookList;
    }

    public JBookModel getBookModel() {
        return bookModel;
    }

    public JChapterModel getChapterModel() {
        return chapterModel;
    }

    
}
