/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bible.test;

import java.util.Arrays;

/**
 *
 * @author root
 */
public class ChapterMatcher {

    public static void main(String[] args) {
       
        String c = "Chapter 10";
//        System.out.println(Arrays.toString(c.split("\\s")));
        System.out.println(c.split("\\s")[1]);
//        System.out.println( c.substring(c.length() - 1));
    }
}
