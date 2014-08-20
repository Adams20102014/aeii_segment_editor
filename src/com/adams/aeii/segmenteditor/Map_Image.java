/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.segmenteditor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author s1407003
 */
public class Map_Image {

    private BufferedImage[] map_image;
    private int stiles_count;
    private File stiles_dir;
    private File stiles;
    private final static int WIDTH = 20;
    private final static int HEIGHT = 20;

    public Map_Image() {

    }

    public void getStilesCount() {
        stiles_dir = new File("res\\img\\stiles");
        stiles_count = stiles_dir.listFiles(
                new FileFilter() {

                    @Override
                    public boolean accept(File pathname) {
                        if (pathname.isDirectory()) {
                            return false;
                        } else {
                            return pathname.isFile() && pathname.getName().endsWith(".png");
                        }
                    }
                }
        ).length;
    }
    
    public BufferedImage[] getMapImage() throws IOException {
        this.getStilesCount();
//        System.out.println(stiles_count);
        map_image = new BufferedImage[stiles_count];
        for(int i = 0; i < stiles_count; i++) {
            stiles = stiles_dir.listFiles()[i];
            map_image[i] = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            map_image[i].getGraphics().drawImage(ImageIO.read(stiles), 0, 0, WIDTH, HEIGHT, null);
        }
        return map_image;
    }
}
