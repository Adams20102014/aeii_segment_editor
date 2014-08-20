/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.segmenteditor;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author s1407003
 */
public class New_ComboBox extends JLabel implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        if (value instanceof ImageIcon) {
            ImageIcon image = (ImageIcon) value;
            this.setIcon(image);
            this.setHorizontalAlignment(JLabel.CENTER);
            return this;
        } else {
            return null;
        }

    }
}
