/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adams.aeii.segmenteditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class Segment_Attribute {
//    private JPanel jp_segment_attribute;

    private JTabbedPane jt_segment_attribute;

    private JPanel jp_database;

    private JPanel jp_defence_bonus;
    private JPanel jp_consumption_steps;
    private JPanel jp_hp_return;
    private JPanel jp_segment_type;
    private JPanel jp_top_segment_id;
    private JPanel jp_team;
    private JPanel jp_access_map;
    private JPanel jp_occupied;
    private JPanel jp_destroyed;
    private JPanel jp_repaired;
    private JPanel jp_animated_tiles;
    private JPanel jp_map_mapping;
    private JPanel jp_image;

    private JLabel jl_defence_bonus;
    private JLabel jl_consumption_steps;
    private JLabel jl_hp_return;
    private JLabel jl_segment_type;
    private JLabel jl_top_segment_id;
    private JLabel jl_team;
    private JLabel jl_access_map;
    private JLabel jl_occupied;
    private JLabel jl_destroyed;
    private JLabel jl_repaired;
    private JLabel jl_animated_tiles;
    private JLabel jl_blue_team;
    private JLabel jl_red_team;
    private JLabel jl_green_team;
    private JLabel jl_black_team;
    private JLabel jl_access;
    private JLabel jl_destroyed_id;
    private JLabel jl_repaired_id;
    private JLabel jl_animated_tiles_id;
    private JLabel jl_map_mapping;
    private JLabel jl_image;

    private JTextField jt_defence_bonus;
    private JTextField jt_consumption_steps;
    private JTextField jt_hp_return;
    private JTextField jt_top_segment_id;
    private JTextField jt_access_map;
    private JTextField jt_blue_team;
    private JTextField jt_red_team;
    private JTextField jt_green_team;
    private JTextField jt_black_team;
    private JTextField jt_access;
    private JTextField jt_destroyed_id;
    private JTextField jt_repaired_id;
    private JTextField jt_animated_tiles_id;
    private JTextField jt_map_mapping;

    private JButton btn_blue_team;
    private JButton btn_red_team;
    private JButton btn_green_team;
    private JButton btn_black_team;
    private JButton btn_access;
    private JButton btn_destroyed;
    private JButton btn_repaired;
    private JButton btn_animated_tiles;
//    private JButton btn_map_mapping;

    private ButtonGroup bg_occupied;
    private ButtonGroup bg_destroyed;
    private ButtonGroup bg_repaired;
    private ButtonGroup bg_animated_tiles;

    private JRadioButton jr_occupied_yes;
    private JRadioButton jr_occupied_no;
    private JRadioButton jr_destroyed_yes;
    private JRadioButton jr_destroyed_no;
    private JRadioButton jr_repaired_yes;
    private JRadioButton jr_repaired_no;
    private JRadioButton jr_animated_tiles_yes;
    private JRadioButton jr_animated_tiles_no;

    private JComboBox jc_segment_type;
    private JComboBox jc_team;
    private JComboBox jc_map_mapping;
    
    private BufferedImage[]  map_image;
    private ImageIcon[] map_icon;
    private Map_Image mi;
    private New_ComboBox ncom;
    
    private final String[] str_segment_type = {"NONE", "0", "1", "2", "3"};
    private final String[] str_team = {"NONE", "-1", "0", "1", "2", "3"};

    public Segment_Attribute() {

    }

    public JTabbedPane initJtSegmentAttribute() throws IOException {
        jt_segment_attribute = new JTabbedPane();
        jt_segment_attribute.addTab("基础数据设定", this.initJpDatabase());
        jt_segment_attribute.setBounds(5, 0, 600, 600);
        return jt_segment_attribute;
    }

    public JPanel initJpDatabase() throws IOException {
        jp_database = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        jp_database.setLayout(null);
        jp_database.add(this.initJpDefenceBonus());
        jp_database.add(this.initJpConsumptionSteps());
        jp_database.add(this.initJpHpReturn());
        jp_database.add(this.initJpSegmentType());
        jp_database.add(this.initJpTopSegmentId());
        jp_database.add(this.initJpTeam());
        jp_database.add(this.initJpAccessMap());
        jp_database.add(this.initJpOccupied());
        jp_database.add(this.initJpDestroyed());
        jp_database.add(this.initJpRepaired());
        jp_database.add(this.initJpAnimatedTiles());
        jp_database.add(this.initJpMapMapping());
        jp_database.add(this.initJpImage());
//        jp_database.setBounds(x, y, width, height);
        return jp_database;
    }

    public JPanel initJpDefenceBonus() {
        jp_defence_bonus = new JPanel(new GridLayout(1, 2));
        jp_defence_bonus.setBorder(BorderFactory.createTitledBorder("防御加成值设定"));
        jl_defence_bonus = new JLabel("防御加成：");
        jt_defence_bonus = new JTextField(10);
        jp_defence_bonus.add(jl_defence_bonus);
        jp_defence_bonus.add(jt_defence_bonus);
//        jp_defence_bonus.setPreferredSize(new Dimension(200,200));
        return jp_defence_bonus;
    }

    public JPanel initJpConsumptionSteps() {
        jp_consumption_steps = new JPanel(new GridLayout(1, 2));
        jp_consumption_steps.setBorder(BorderFactory.createTitledBorder("消耗步数设定"));
        jl_consumption_steps = new JLabel("消耗步数：");
        jt_consumption_steps = new JTextField(10);
        jp_consumption_steps.add(jl_consumption_steps);
        jp_consumption_steps.add(jt_consumption_steps);
        return jp_consumption_steps;
    }

    public JPanel initJpHpReturn() {
        jp_hp_return = new JPanel(new GridLayout(1, 2));
        jp_hp_return.setBorder(BorderFactory.createTitledBorder("HP回复值设定"));
        jl_hp_return = new JLabel("HP回复值：");
        jt_hp_return = new JTextField(10);
        jp_hp_return.add(jl_hp_return);
        jp_hp_return.add(jt_hp_return);
        return jp_hp_return;
    }

    public JPanel initJpSegmentType() {
        jp_segment_type = new JPanel(new GridLayout(1, 2));
        jp_segment_type.setBorder(BorderFactory.createTitledBorder("图块类型设定"));
        jl_segment_type = new JLabel("图块类型：");
        jc_segment_type = new JComboBox(str_segment_type);
        jp_segment_type.add(jl_segment_type);
        jp_segment_type.add(jc_segment_type);
        return jp_segment_type;
    }

    public JPanel initJpTopSegmentId() {
        jp_top_segment_id = new JPanel(new GridLayout(1, 2));
        jp_top_segment_id.setBorder(BorderFactory.createTitledBorder("顶部修正图块编号设定"));
        jl_top_segment_id = new JLabel("顶部修正图块编号：");
        jt_top_segment_id = new JTextField(10);
        jp_top_segment_id.add(jl_top_segment_id);
        jp_top_segment_id.add(jt_top_segment_id);
        return jp_top_segment_id;
    }

    public JPanel initJpTeam() {
        jp_team = new JPanel(new GridLayout(1, 2));
        jp_team.setBorder(BorderFactory.createTitledBorder("所属队伍设定"));
        jl_team = new JLabel("所属队伍：");
        jc_team = new JComboBox(str_team);
        jp_team.add(jl_team);
        jp_team.add(jc_team);
        return jp_team;
    }

    public JPanel initJpAccessMap() {
        jp_access_map = new JPanel(new FlowLayout());
        jp_access_map.setBorder(BorderFactory.createTitledBorder("准入图块数量设定"));
        jl_access_map = new JLabel("准入图块数量：");
        jt_access_map = new JTextField(10);
        jl_access = new JLabel("准入图块编号列表：");
        jt_access = new JTextField(10);
        jt_access.setEditable(false);
        btn_access = new JButton("选择图块");
        btn_access.addActionListener(new Chooser_Segment_Listener(this));
//        btn_access.setEnabled(false);
        jp_access_map.add(jl_access_map);
        jp_access_map.add(jt_access_map);
        jp_access_map.add(jl_access);
        jp_access_map.add(jt_access);
        jp_access_map.add(btn_access);
        return jp_access_map;
    }

    public JPanel initJpOccupied() {
        jp_occupied = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp_occupied.setBorder(BorderFactory.createTitledBorder("判断是否可被占领"));
        jl_occupied = new JLabel("是否可被占领：");
        bg_occupied = new ButtonGroup();
        jr_occupied_yes = new JRadioButton("是");
        jr_occupied_no = new JRadioButton("否");
        jr_occupied_yes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_blue_team.setEnabled(true);
                btn_red_team.setEnabled(true);
                btn_green_team.setEnabled(true);
                btn_black_team.setEnabled(true);
            }
        });
        jr_occupied_no.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_blue_team.setEnabled(false);
                btn_red_team.setEnabled(false);
                btn_green_team.setEnabled(false);
                btn_black_team.setEnabled(false);
                setJtBlueTeam("");
                setJtRedTeam("");
                setJtGreenTeam("");
                setJtBlackTeam("");
            }
        });
        bg_occupied.add(jr_occupied_yes);
        bg_occupied.add(jr_occupied_no);
        jl_blue_team = new JLabel("被蓝队占领后的图块编号：");
        jl_red_team = new JLabel("被红队占领后的图块编号：");
        jl_green_team = new JLabel("被绿队占领后的图块编号：");
        jl_black_team = new JLabel("被黑队占领后的图块编号：");
        jt_blue_team = new JTextField(10);
        jt_blue_team.setEditable(false);
        jt_red_team = new JTextField(10);
        jt_red_team.setEditable(false);
        jt_green_team = new JTextField(10);
        jt_green_team.setEditable(false);
        jt_black_team = new JTextField(10);
        jt_black_team.setEditable(false);
        btn_blue_team = new JButton("选择图块");
        btn_blue_team.addActionListener(new Chooser_Segment_Listener(this));
        btn_blue_team.setEnabled(false);
        btn_red_team = new JButton("选择图块");
        btn_red_team.addActionListener(new Chooser_Segment_Listener(this));;
        btn_red_team.setEnabled(false);
        btn_green_team = new JButton("选择图块");
        btn_green_team.addActionListener(new Chooser_Segment_Listener(this));
        btn_green_team.setEnabled(false);
        btn_black_team = new JButton("选择图块");
        btn_black_team.addActionListener(new Chooser_Segment_Listener(this));
        btn_black_team.setEnabled(false);

        jp_occupied.add(jl_occupied);
        jp_occupied.add(jr_occupied_yes);
        jp_occupied.add(jr_occupied_no);
        jp_occupied.add(jl_blue_team);
        jp_occupied.add(jt_blue_team);
        jp_occupied.add(btn_blue_team);
        jp_occupied.add(jl_red_team);
        jp_occupied.add(jt_red_team);
        jp_occupied.add(btn_red_team);
        jp_occupied.add(jl_green_team);
        jp_occupied.add(jt_green_team);
        jp_occupied.add(btn_green_team);
        jp_occupied.add(jl_black_team);
        jp_occupied.add(jt_black_team);
        jp_occupied.add(btn_black_team);
        jp_occupied.setPreferredSize(new Dimension(330, 160));
        return jp_occupied;
    }

    public JPanel initJpDestroyed() {
        jp_destroyed = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp_destroyed.setBorder(BorderFactory.createTitledBorder("判断是否可被破坏"));
        jl_destroyed = new JLabel("是否可被破坏：");
        bg_destroyed = new ButtonGroup();
        jr_destroyed_yes = new JRadioButton("是");
        jr_destroyed_no = new JRadioButton("否");
        jr_destroyed_yes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_destroyed.setEnabled(true);
            }
        });
        jr_destroyed_no.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_destroyed.setEnabled(false);
                setJtDestroyedId("");
            }
        });
        bg_destroyed.add(jr_destroyed_yes);
        bg_destroyed.add(jr_destroyed_no);
        jl_destroyed_id = new JLabel("被破坏后的图块编号：");
        jt_destroyed_id = new JTextField(10);
        jt_destroyed_id.setEditable(false);
        btn_destroyed = new JButton("选择图块");
        btn_destroyed.addActionListener(new Chooser_Segment_Listener(this));
        btn_destroyed.setEnabled(false);
//        btn_destroyed.setPreferredSize(new Dimension(80,30));

        jp_destroyed.add(jl_destroyed);
        jp_destroyed.add(jr_destroyed_yes);
        jp_destroyed.add(jr_destroyed_no);
        jp_destroyed.add(jl_destroyed_id);
        jp_destroyed.add(jt_destroyed_id);
        jp_destroyed.add(btn_destroyed);
        jp_destroyed.setPreferredSize(new Dimension(300, 80));
        return jp_destroyed;
    }

    public JPanel initJpRepaired() {
        jp_repaired = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp_repaired.setBorder(BorderFactory.createTitledBorder("判断是否可被修复"));
        jl_repaired = new JLabel("是否可被修复：");
        bg_repaired = new ButtonGroup();
        jr_repaired_yes = new JRadioButton("是");
        jr_repaired_no = new JRadioButton("否");
        jr_repaired_yes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_repaired.setEnabled(true);
            }
        });
        jr_repaired_no.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_repaired.setEnabled(false);
                setJtRepairedId("");
            }
        });
        bg_repaired.add(jr_repaired_yes);
        bg_repaired.add(jr_repaired_no);
        jl_repaired_id = new JLabel("被修复后的图块编号：");
        jt_repaired_id = new JTextField(10);
        jt_repaired_id.setEditable(false);
        btn_repaired = new JButton("选择图块");
        btn_repaired.addActionListener(new Chooser_Segment_Listener(this));
        btn_repaired.setEnabled(false);

        jp_repaired.add(jl_repaired);
        jp_repaired.add(jr_repaired_yes);
        jp_repaired.add(jr_repaired_no);
        jp_repaired.add(jl_repaired_id);
        jp_repaired.add(jt_repaired_id);
        jp_repaired.add(btn_repaired);
        jp_repaired.setPreferredSize(new Dimension(300, 80));
        return jp_repaired;
    }

    public JPanel initJpAnimatedTiles() {
        jp_animated_tiles = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp_animated_tiles.setBorder(BorderFactory.createTitledBorder("判断是否是动画图块"));
        jl_animated_tiles = new JLabel("是否是动画图块：");
        bg_animated_tiles = new ButtonGroup();
        jr_animated_tiles_yes = new JRadioButton("是");
        jr_animated_tiles_yes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_animated_tiles.setEnabled(true);
            }
        });
        jr_animated_tiles_no = new JRadioButton("否");
        jr_animated_tiles_no.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_animated_tiles.setEnabled(false);
                setJtAnimatedTilesId("");
            }
        });
        bg_animated_tiles.add(jr_animated_tiles_yes);
        bg_animated_tiles.add(jr_animated_tiles_no);
        jl_animated_tiles_id = new JLabel("动画图块编号：");
        jt_animated_tiles_id = new JTextField(10);
        jt_animated_tiles_id.setEditable(false);
        btn_animated_tiles = new JButton("选择图块");
        btn_animated_tiles.addActionListener(new Chooser_Segment_Listener(this));
        btn_animated_tiles.setEnabled(false);

        jp_animated_tiles.add(jl_animated_tiles);
        jp_animated_tiles.add(jr_animated_tiles_yes);
        jp_animated_tiles.add(jr_animated_tiles_no);
        jp_animated_tiles.add(jl_animated_tiles_id);
        jp_animated_tiles.add(jt_animated_tiles_id);
        jp_animated_tiles.add(btn_animated_tiles);
        jp_animated_tiles.setPreferredSize(new Dimension(280, 80));
        return jp_animated_tiles;
    }

    public JPanel initJpMapMapping() throws IOException {
        jp_map_mapping = new JPanel(new FlowLayout());
        jp_map_mapping.setBorder(BorderFactory.createTitledBorder("映射图块设定"));
        jl_map_mapping = new JLabel("映射图块编号：");
        jt_map_mapping = new JTextField(10);
        jt_map_mapping.setEditable(false);
        this.setMapIcon();
        jc_map_mapping = new JComboBox(getMapIcon());
        ncom = new New_ComboBox();
        jc_map_mapping.setRenderer(ncom);
        jc_map_mapping.setPreferredSize(new Dimension(48,26));
        jc_map_mapping.addActionListener(new ActionListener () {

           @Override
           public void actionPerformed(ActionEvent e) {
                jt_map_mapping.setText(String.valueOf(jc_map_mapping.getSelectedIndex()));
            }
            
       });

        jp_map_mapping.add(jl_map_mapping);
        jp_map_mapping.add(jt_map_mapping);
        jp_map_mapping.add(jc_map_mapping);
        return jp_map_mapping;
    }

    public JPanel initJpImage() {
        jp_image = new JPanel();
        jp_image.setBorder(BorderFactory.createTitledBorder("图块图片显示："));
        jl_image = new JLabel();
        jp_image.setPreferredSize(new Dimension(120,60));
        jp_image.add(jl_image);
        return jp_image;
    }
    
    public void setJlImage(BufferedImage image) {
        ImageIcon  imageicon = new ImageIcon(image);
        jl_image.setIcon(imageicon);
//        jl_image.setBackground(Color.black);
    }
    
    public void setJtDefenceBonus(String defence_bonus) {
        this.jt_defence_bonus.setText(defence_bonus);
    }

    public String getJtDefenceBonus() {
        return this.jt_defence_bonus.getText();
    }

    public void setJtConsumptionSteps(String consumption_steps) {
        this.jt_consumption_steps.setText(consumption_steps);
    }

    public String getJtConsumptionSteps() {
        return this.jt_consumption_steps.getText();
    }

    public void setJtHpReturn(String hp_return) {
        this.jt_hp_return.setText(hp_return);
    }

    public String getJtHpReturn() {
        return this.jt_hp_return.getText();
    }

    public void setJcSegmentType(String segment_type) {
        this.jc_segment_type.setSelectedItem(segment_type);
    }

    public String getJcSegmentType() {
        return (String) this.jc_segment_type.getSelectedItem();
    }

    public void setJtTopSegmentId(String top_segment_id) {
        this.jt_top_segment_id.setText(top_segment_id);
    }

    public String getJtTopSegmentId() {
        return this.jt_top_segment_id.getText();
    }

    public void setJcTeam(String team) {
        this.jc_team.setSelectedItem(team);
    }

    public String getJcTeam() {
        return (String) this.jc_team.getSelectedItem();
    }

    public void setJtAccessMap(String access_map) {
        this.jt_access_map.setText(access_map);
    }

    public String getJtAccessMap() {
        return this.jt_access_map.getText();
    }

    public void setOccupied(boolean occupied) {
        if (occupied == false) {
            this.jr_occupied_no.setSelected(true);
        } else if (occupied == true) {
            this.jr_occupied_yes.setSelected(true);
        }
    }

    public boolean getOccupied() {
        boolean temp = false;
        if (jr_occupied_yes.isSelected() == true) {
            temp = true;
        } else if (jr_occupied_no.isSelected() == false) {
            temp = false;
        }
        return temp;
    }

    public void setDestroyed(boolean destroyed) {
        if (destroyed == true) {
            this.jr_destroyed_yes.setSelected(true);
        } else if (destroyed == false) {
            this.jr_destroyed_no.setSelected(true);
        }
    }

    public boolean getDestroyed() {
        if (jr_destroyed_yes.isSelected() == true) {
            return true;
        } else if (jr_destroyed_no.isSelected() == true) {
            return false;
        }
        return false;
    }

    public void setRepaired(boolean repaired) {
        if (repaired == true) {
            this.jr_repaired_yes.setSelected(true);
        } else if (repaired == false) {
            this.jr_repaired_no.setSelected(true);
        }
    }

    public boolean getRepaired() {
        if (this.jr_repaired_yes.isSelected() == true) {
            return true;
        } else if (this.jr_repaired_no.isSelected() == true) {
            return false;
        }

        return false;
    }

    public void setAnimatedTiles(boolean animated_tiles) {
        if (animated_tiles == true) {
            this.jr_animated_tiles_yes.setSelected(true);
        } else if (animated_tiles == false) {
            this.jr_animated_tiles_no.setSelected(true);
        }
    }

    public boolean getAnimatedTiles() {
        if (this.jr_animated_tiles_yes.isSelected() == true) {
            return true;
        } else if (this.jr_animated_tiles_no.isSelected() == true) {
            return false;
        }

        return false;
    }

    public void setJtBlueTeam(String blue_team) {
        this.jt_blue_team.setText(blue_team);
    }

    public String getJtBlueTeam() {
        return this.jt_blue_team.getText();
    }

    public void setJtRedTeam(String red_team) {
        this.jt_red_team.setText(red_team);
    }

    public String getJtRedTeam() {
        return this.jt_red_team.getText();
    }

    public void setJtGreenTeam(String green_team) {
        this.jt_green_team.setText(green_team);
    }

    public String getJtGreenTeam() {
        return this.jt_green_team.getText();
    }

    public void setJtBlackTeam(String black_team) {
        this.jt_black_team.setText(black_team);
    }

    public String getJtBlackTeam() {
        return this.jt_black_team.getText();
    }

//    public void setJtAccess() {
//        
//    }
//    
//    public String getJtAccess() {
//        
//    }
    public void setJtDestroyedId(String destroyed_id) {
        this.jt_destroyed_id.setText(destroyed_id);
    }

    public String getJtDestroyedId() {
        return this.jt_destroyed_id.getText();
    }

    public void setJtRepairedId(String repaired_id) {
        this.jt_repaired_id.setText(repaired_id);
    }

    public String getJtRepairedId() {
        return this.jt_repaired_id.getText();
    }

    public void setJtAnimatedTilesId(String animated_tiles_id) {
        this.jt_animated_tiles_id.setText(animated_tiles_id);
    }

    public String getJtAnimatedTilesId() {
        return this.jt_animated_tiles_id.getText();
    }

    public void setJtMapMapping(String map_mapping) {
        this.jt_map_mapping.setText(map_mapping);
    }

    public String getJtMapMapping() {
        return this.jt_map_mapping.getText();
    }
    
    public JButton getBtnBlueTeam () {
        return btn_blue_team;
    }
    
    public JButton getBtnRedTeam() {
        return btn_red_team;
    }
    
    public JButton getBtnGreenTeam () {
        return btn_green_team;
    }
    
    public JButton getBtnBlackTeam () {
        return btn_black_team;
    }
    
    public JButton getBtnAccess () {
        return btn_access;
    }
    
    public JButton getBtnDestroyed () {
        return btn_destroyed;
    }
    
    public JButton getBtnRepaired () {
        return btn_repaired;
    }
    
    public JButton getBtnAnimatedTiles () {
        return btn_animated_tiles;
    }
    
    public void  setJcMapMapping(String map_mapping){
        this.jc_map_mapping.setSelectedIndex(Integer.parseInt(map_mapping));
    }
    
    public JComboBox getJcMapMapping() {
        return jc_map_mapping;
    }
    public void setMapIcon() throws IOException {
        mi = new Map_Image();
        this.map_image = mi.getMapImage();
        map_icon = new ImageIcon[map_image.length];
        for(int i = 0; i < map_image.length; i++) {
            map_icon[i] = new ImageIcon(map_image[i]);
        }
    }
    
    public ImageIcon[] getMapIcon() {
        return map_icon;
    }
}
