/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.segmenteditor;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Administrator
 */
public class Segment_Lists extends JFrame {

    private final JDialog chooser_segment;
    private int index = -1;
    private BufferedImage[] tiles;
    private final JPanel jp_btn;
    private int tile_count;
    private File tile_dir;
    private File tile;
    private Tile_Button btn[];
 

    private final static int WIDTH = 48;
    private final static int HEIGHT = 48;

    public Segment_Lists() throws IOException {
        chooser_segment = new JDialog(this);
        GridLayout gl = new GridLayout(0, 8);
        gl.setHgap(2);
        gl.setVgap(2);
        jp_btn = new JPanel(gl);
    }

    public void initComponent() throws IOException {
        chooser_segment.setTitle("Chooser Segment");
        chooser_segment.setResizable(false);
        
        JScrollPane sp = new JScrollPane(this.initJpBtn());
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setPreferredSize(new Dimension(48 * 8 + 20 + 2 * 7, 48 * 6 + 2 * 6));
        chooser_segment.setContentPane(sp);
        chooser_segment.pack();
        chooser_segment.setLocationRelativeTo(null);
        chooser_segment.setModal(true);
        chooser_segment.setVisible(true);
        
//        ImageIcon icon = new ImageIcon(this.getClass().getResource("\\image\\aeii.png"));
//        this.setIconImage(icon.getImage());
    }

    public JPanel initJpBtn() throws IOException {
        this.getTileCount();
//        System.out.println(tile_count);
        tiles = new BufferedImage[tile_count];
        btn = new Tile_Button[tile_count];
        for (int i = 0; i < tile_count; i++) {
            tile = new File("res\\img\\tiles\\tile_" + i + ".png");
            tiles[i] = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            tiles[i].getGraphics().drawImage(ImageIO.read(tile), 0, 0, WIDTH, HEIGHT, null);
            btn[i] = new Tile_Button(i, this);
            btn[i].setPreferredSize(new Dimension(48, 48));
            btn[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            jp_btn.add(btn[i]);
        }
        jp_btn.setBackground(Color.BLACK);
        return jp_btn;
    }

    public void getTileCount() {
        tile_dir = new File("data\\tiles");
        tile_count = tile_dir.listFiles(
                new FileFilter() {

                    @Override
                    public boolean accept(File pathname) {
                        if (pathname.isDirectory()) {
                            return false;
                        } else {
                            return pathname.isFile() && pathname.getName().endsWith(".dat");
                        }
                    }
                }
        ).length;
    }

    public int getIndex() {
        return this.index;
    }

    public void closeDialog() {
        this.dispose();
    }
    
    public void setIndex(int index) {
        this.index = index;
    }

    public BufferedImage getTileImage(int index) {
        return tiles[index];
    }

}
