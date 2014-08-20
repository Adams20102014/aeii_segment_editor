/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.segmenteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Chooser_Segment_Listener implements ActionListener {

    private int index;
    private String str_index = null;
    private final Segment_Attribute sa;
    private Segment_Lists sl;

    public Chooser_Segment_Listener(Segment_Attribute sa) {
        this.sa = sa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sl = new Segment_Lists();
            sl.initComponent();
        } catch (IOException ex) {
            Logger.getLogger(Chooser_Segment_Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
        index = sl.getIndex();
//        System.out.println(index);
        if (index >= 0) {
            str_index = String.valueOf(index);
            if (e.getSource() == sa.getBtnBlueTeam()) {
                sa.setJtBlueTeam(str_index);
            } else if (e.getSource() == sa.getBtnRedTeam()) {
                sa.setJtRedTeam(str_index);
            } else if (e.getSource() == sa.getBtnGreenTeam()) {
                sa.setJtGreenTeam(str_index);
            } else if (e.getSource() == sa.getBtnBlackTeam()) {
                sa.setJtBlackTeam(str_index);
            } else if (e.getSource() == sa.getBtnAccess()) {
//            sa.setJtAccess(String.valueOf(index));
            } else if (e.getSource() == sa.getBtnDestroyed()) {
                sa.setJtDestroyedId(str_index);
            } else if (e.getSource() == sa.getBtnRepaired()) {
                sa.setJtRepairedId(str_index);
            } else if (e.getSource() == sa.getBtnAnimatedTiles()) {
                sa.setJtAnimatedTilesId(str_index);
            }
        }
        str_index = null;
    }

}
