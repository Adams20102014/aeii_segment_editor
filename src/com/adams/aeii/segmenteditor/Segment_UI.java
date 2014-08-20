/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.segmenteditor;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Administrator
 */
public class Segment_UI extends JFrame {

    private final Segment_Attribute sa;
    private final Button btn;

    public Segment_UI() throws IOException {
        this.getContentPane().setPreferredSize(new Dimension(600, 650));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setLayout(null);
        this.setTitle("Segment Editor");

        ImageIcon icon = new ImageIcon(this.getClass().getResource("\\image\\aeii.png"));
        this.setIconImage(icon.getImage());

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); //To change body of generated methods, choose Tools | Templates.
            }
        });

        sa = new Segment_Attribute();
        btn = new Button(sa);

        this.getContentPane().add(sa.initJtSegmentAttribute());
        this.getContentPane().add(btn.initJpButton());
        this.setVisible(true);
    }

    public static void main(String[] args)  {
        
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                    Logger.getLogger(Segment_UI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    new Segment_UI();
                } catch (IOException ex) {
                    Logger.getLogger(Segment_UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

}
