/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.segmenteditor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author s1407003
 */
public class Tile_Button extends JButton {

    private final int index;
    private final Segment_Lists sl;

    public Tile_Button(int index, Segment_Lists sl) {
        super(new ImageIcon(sl.getTileImage(index)));
        this.index = index;
        this.sl = sl;
        this.setPreferredSize(new Dimension(48, 48));
        this.setFocusable(false);
        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }
    
    public void  onClick() {
        sl.setIndex(index);
        sl.closeDialog();
    }
    
}
