/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.segmenteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Button_Listener implements ActionListener {

    private JFileChooser fileChooser;
    private File file;

    private String defence_bonus;
    private String consumption_steps;
    private String hp_return;
    private String segment_type;
    private String top_segment_id;
    private String team;
    private String access_map;
    private String blue_team = null;
    private String red_team = null;
    private String green_team = null;
    private String black_team = null;
    private String destroyed_id = null;
    private String repaired_id = null;
    private String animated_tiles_id = null;
    private String map_mapping;
    private String if_occupied;
    private String if_destroyed;
    private String if_repaired;
    private String if_animated_tiles;

    private boolean occupied;
    private boolean destroyed;
    private boolean repaired;
    private boolean animated_tiles;

    private static String file_name;
//    private File dir;

    private final Segment_Attribute sa;
    private final Button btn;
    private Segment_Lists sl;

    private boolean save_enabled = false;

    private int index;

    public Button_Listener(Segment_Attribute sa, Button btn) {
        this.sa = sa;
        this.btn = btn;
    }

    public void initSa() {
        sa.setJtDefenceBonus(defence_bonus);
        sa.setJtConsumptionSteps(consumption_steps);
        sa.setJtHpReturn(hp_return);
        sa.setJcSegmentType(segment_type);
        sa.setJtTopSegmentId(top_segment_id);
        sa.setJcTeam(team);
        sa.setJtAccessMap(access_map);
        sa.setOccupied(occupied);
        sa.setDestroyed(destroyed);
        sa.setRepaired(repaired);
        sa.setAnimatedTiles(animated_tiles);
        sa.setJtMapMapping(map_mapping);
        sa.setJcMapMapping(map_mapping);
    }

    public void getSa() {
        defence_bonus = sa.getJtDefenceBonus();
        consumption_steps = sa.getJtConsumptionSteps();
        hp_return = sa.getJtHpReturn();
        segment_type = sa.getJcSegmentType();
        top_segment_id = sa.getJtTopSegmentId();
        team = sa.getJcTeam();
        access_map = sa.getJtAccessMap();
        occupied = sa.getOccupied();
        if (occupied == true) {
            blue_team = sa.getJtBlueTeam();
            red_team = sa.getJtRedTeam();
            green_team = sa.getJtGreenTeam();
            black_team = sa.getJtBlackTeam();
            if_occupied = "true";
        } else {
            if_occupied = "false";
        }
        destroyed = sa.getDestroyed();
        if (destroyed == true) {
            destroyed_id = sa.getJtDestroyedId();
            if_destroyed = "true";
        } else {
            if_destroyed = "false";
        }
        repaired = sa.getRepaired();
        if (repaired == true) {
            repaired_id = sa.getJtRepairedId();
            if_repaired = "true";
        } else {
            if_repaired = "false";
        }
        animated_tiles = sa.getAnimatedTiles();
        if (animated_tiles == true) {
            animated_tiles_id = sa.getJtAnimatedTilesId();
            if_animated_tiles = "true";
        } else {
            if_animated_tiles = "false";
        }
        map_mapping = sa.getJtMapMapping();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("打开图块文件")) {
            try {
                sl = new Segment_Lists();
                sl.initComponent();
            } catch (IOException ex) {
                Logger.getLogger(Button_Listener.class.getName()).log(Level.SEVERE, null, ex);
            }
            index = sl.getIndex();
//            fileChooser = new JFileChooser("打开文件");
//            int state = fileChooser.showOpenDialog(fileChooser);
//            if (state == JFileChooser.APPROVE_OPTION) {
//                try {
//                    dir = fileChooser.getCurrentDirectory();
//                    file_name = fileChooser.getSelectedFile().getName();
//                    System.out.println(file_name);
//                    file = new File(dir, file_name);
            if (index >= 0) {
//                System.out.println(index);
//                System.out.println("data\\tiles\\tile_" + index + ".dat");
                try {
                    file = new File("data\\tiles\\tile_" + index + ".dat");
                    file_name = file.getAbsolutePath();
                    Scanner din = new Scanner(file);
                    defence_bonus = din.next().trim();
                    consumption_steps = din.next().trim();
                    hp_return = din.next().trim();
                    segment_type = din.next().trim();
                    top_segment_id = din.next().trim();
                    team = din.next().trim();
                    access_map = din.next().trim();
                    if (!top_segment_id.equals("-1")) {
                    }
                    if_occupied = din.next().trim();
//                    System.out.println(if_occupied);
                    if (if_occupied.equals("true")) {
                        blue_team = din.next().trim();
                        sa.setJtBlueTeam(blue_team);
                        sa.getBtnBlueTeam().setEnabled(true);
                        red_team = din.next().trim();
                        sa.setJtRedTeam(red_team);
                        sa.getBtnRedTeam().setEnabled(true);
                        green_team = din.next().trim();
                        sa.setJtGreenTeam(green_team);
                        sa.getBtnGreenTeam().setEnabled(true);
                        black_team = din.next().trim();
                        sa.setJtBlackTeam(black_team);
                        sa.getBtnBlackTeam().setEnabled(true);
                        occupied = true;
                    } else {
                        sa.setJtBlueTeam("");
                        sa.getBtnBlueTeam().setEnabled(false);
                        sa.setJtRedTeam("");
                        sa.getBtnRedTeam().setEnabled(false);
                        sa.setJtGreenTeam("");
                        sa.getBtnGreenTeam().setEnabled(false);
                        sa.setJtBlackTeam("");
                        sa.getBtnBlackTeam().setEnabled(false);
                        occupied = false;
                    }
                    if_destroyed = din.next().trim();
//                    System.out.println(if_destroyed);
//                    System.out.println(occupied);
                    if (if_destroyed.equals("true")) {
                        destroyed_id = din.next().trim();
                        sa.setJtDestroyedId(destroyed_id);
                        sa.getBtnDestroyed().setEnabled(true);
                        destroyed = true;
                    } else {
                        sa.setJtDestroyedId("");
                        sa.getBtnDestroyed().setEnabled(false);
                        destroyed = false;
                    }
                    if_repaired = din.next().trim();
//                    System.out.println(if_repaired);
//                    System.out.println(destroyed);
                    if (if_repaired.equals("true")) {
                        repaired_id = din.next().trim();
                        sa.setJtRepairedId(repaired_id);
                        sa.getBtnRepaired().setEnabled(true);
                        repaired = true;
                    } else {
                        sa.setJtRepairedId("");
                        sa.getBtnRepaired().setEnabled(false);
                        repaired = false;
                    }
                    if_animated_tiles = din.next().trim();
//                    System.out.println(if_animated_tiles);
//                    System.out.println(repaired);
                    if (if_animated_tiles.equals("true")) {
                        animated_tiles_id = din.next().trim();
                        sa.setJtAnimatedTilesId(animated_tiles_id);
                        sa.getBtnAnimatedTiles().setEnabled(true);
                        animated_tiles = true;
                    } else {
                        sa.setJtAnimatedTilesId("");
                        sa.getBtnAnimatedTiles().setEnabled(false);
                        animated_tiles = false;
                    }
//                    System.out.println(animated_tiles);
                    map_mapping = din.next().trim();
                    this.initSa();
                    save_enabled = true;
                    btn.getEnabled(save_enabled);
                    din.close();
                } catch (FileNotFoundException ex) {

                }
            }
        } else if (e.getActionCommand().equals("保存图块文件")) {
            try {
                this.getSa();
                PrintWriter writer = new PrintWriter(file_name);
                writer.println(defence_bonus);
                writer.println(consumption_steps);
                writer.println(hp_return);
                writer.println(segment_type);
                writer.println(top_segment_id);
                writer.println(team);
                writer.println(access_map);
                writer.println(if_occupied);
                if (if_occupied.equals("true")) {
                    writer.println(blue_team);
                    writer.println(red_team);
                    writer.println(green_team);
                    writer.println(black_team);
                }
                writer.println(if_destroyed);
                if (if_destroyed.equals("true")) {
                    writer.println(destroyed_id);
                }
                writer.println(if_repaired);
                if (if_repaired.equals("true")) {
                    writer.println(repaired_id);
                }
                writer.println(if_animated_tiles);
                if (if_animated_tiles.equals("true")) {
                    writer.println(animated_tiles_id);
                }
                writer.print(map_mapping);
                JOptionPane.showMessageDialog(fileChooser, "保存成功！", "提示对话框", JOptionPane.INFORMATION_MESSAGE);
                writer.close();
            } catch (FileNotFoundException ex) {

            }
        }
    }
}
