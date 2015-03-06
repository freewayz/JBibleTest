/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bible.ui;

import controllers.ChapterController;
import controllers.VerseController;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import models.BookModel;
import models.ChapterModel;
import models.VerseModel;

/**
 *
 * @author root
 */

/*implement Observer so that the JTextArea can be updated when the Model changees
 using the observer pattern
 */
public class BibleUI extends javax.swing.JPanel implements Observer {

    /**
     * Creates new form BibleUI
     */
    public BibleUI() {
        /*
         instantiate variables of the model and Controller in the correct order
         that wont give a null pointer exception
         */

        model = new ChapterModel(new BookModel(1, "old"), 1);
        vmodel = new VerseModel(1, jTextArea1, model);
        vmodel.addObserver(this);
        initComponents();
        control = new ChapterController(books1.getList(), chapters1.getModel());
        vcontrol = new VerseController(chapters1.getList(), vmodel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        books1 = new app.bible.ui.Books();
        chapters1 = new app.bible.ui.Chapters(model);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 0));

        chapters1.setBackground(new java.awt.Color(204, 204, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Settings");

        jButton2.setText("Speaker");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(books1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chapters1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(books1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(chapters1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bible.ui.Books books1;
    private app.bible.ui.Chapters chapters1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
   //create extra variables
    private ChapterModel model;
    private ChapterController control;
    private VerseModel vmodel;
    private VerseController vcontrol;

    /*override method update of interface Observer in other to update
     the JTextArea with the updated model when notified by the model
     */
    @Override
    public void update(Observable o, Object arg) {
        List list=vmodel.getVerses();
        Iterator itr= list.iterator();
        
        while(itr.hasNext()){
            jTextArea1.append(itr.next().toString());
            jTextArea1.append("\n");
        }
    }
}
