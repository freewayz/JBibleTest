/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.bible.test

import java.util.regex.*


def word = 'Act |1|1 The Book of Act '
def saying = """ Now is the time for all good men and women to come to the aid of their country"""

//def p = ~/(\w+en)/
//def pat = ~/(\|+\d+\|+\d)/
//def pat2 = ~/(\|?\d)/
//def matcher = pat2.matcher(word)
//def count = matcher.getCount()
//println "Matches = ${count}"
//for(i in 0..< count ){
//    println matcher[i]
//}





Pattern expr = Pattern.compile("(\\|?\\d)")
Matcher mat = expr.matcher(word)
println(mat.getCount())

for( i in 0..< mat.getCount()){
    println mat[i]
}