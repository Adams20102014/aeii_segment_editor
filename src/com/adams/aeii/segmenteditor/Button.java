/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.segmenteditor;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class Button {

    private JButton btn_open;
    private JButton btn_save;
    private JPanel jp_Button;

    private final Segment_Attribute sa;

    public Button(Segment_Attribute sa) {
        this.sa = sa;
    }

    public void getEnabled(boolean save_enabled) {
        if (save_enabled == true) {
            btn_save.setEnabled(true);
        }
    }

    public JPanel initJpButton() {
        GridLayout gl = new GridLayout(1, 2);
        jp_Button = new JPanel(gl);
        gl.setHgap(20);
        btn_open = new JButton("打开图块文件");
        btn_open.addActionListener(new Button_Listener(sa,this));
//        btn_open.setHorizontalAlignment(LEFT);
        btn_save = new JButton("保存图块文件");
        btn_save.setEnabled(false);
        btn_save.addActionListener(new Button_Listener(sa,this));
        jp_Button.add(btn_open);
        jp_Button.add(btn_save);
        jp_Button.setBounds(200, 610, 250, 35);
        return jp_Button;
    }
}
