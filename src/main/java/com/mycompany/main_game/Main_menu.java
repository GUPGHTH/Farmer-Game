/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author GUPGHOSTTHAI71
 */
public class Main_menu extends JPanel{

    
    private ImageIcon btst = new ImageIcon(file_read.button[0]);
    private ImageIcon bttt = new ImageIcon(file_read.button[2]);
    public JButton BStart= new JButton(btst);
    public JButton BTutorail= new JButton(bttt);
    public Main_menu(){
        setLayout(null);
        BTutorail.setBounds(700, 650, 512,256);
        BStart.setBounds(100,650,  512,256);
        add(BTutorail);
        add(BStart);
        
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.drawImage(file_read.main_manu_backgraound, 0, 0, 1440, 960, null, null);
        g2d.drawImage(file_read.main_menu_sign, 40, 40,1360,300,null,null);
        g2d.drawImage(file_read.word[0], 320, 140,100,100,null,null);
        g2d.drawImage(file_read.word[1], 420, 140,100,100,null,null);
        g2d.drawImage(file_read.word[2], 520, 140,100,100,null,null);
        g2d.drawImage(file_read.word[3], 620, 140,100,100,null,null);
        g2d.drawImage(file_read.word[4], 720, 140,100,100,null,null);
        g2d.drawImage(file_read.word[5], 720, 240,100,100,null,null);
        g2d.drawImage(file_read.word[1], 820, 140,100,100,null,null);
        g2d.drawImage(file_read.word[6], 920, 140,100,100,null,null);
        g2d.drawImage(file_read.word[7], 920, 40,100,100,null,null);
        g2d.drawImage(file_read.word[1], 1020, 140,100,100,null,null);
        g2d.drawImage(file_read.button[2],700,650,512,256,null,null);
        g2d.drawImage(file_read.button[0],100,650,512,256,null,null);
    }
}


    
    
    
 
