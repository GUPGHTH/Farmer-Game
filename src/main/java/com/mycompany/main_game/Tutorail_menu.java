/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author GUPGHOSTTHAI71
 */
public class Tutorail_menu extends JPanel{
    private ImageIcon btst = new ImageIcon(file_read.button[3]);
    private ImageIcon bttt = bttt = new ImageIcon(file_read.button[1]);
    public JButton Bnext= new JButton(btst);;
    public JButton Bback= new JButton(bttt);;
    public int page;
    public Tutorail_menu() {
        setLayout(null);
        Bnext.setBounds(1050, 755, 256,128);
        Bback.setBounds(100,755,256,128);
        add(Bnext);
        add(Bback);
        this.page = 0;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.drawImage(file_read.main_manu_backgraound, 0, 0, 1440, 960, null, null);
        g2d.drawImage(file_read.pic_tutorail[this.page], 120,0,1200,900,null,null);
        g2d.drawImage(file_read.button[1], 100, 755, 256,128, null, null);
        g2d.drawImage(file_read.button[3], 1050, 755, 256,128, null, null);
    }
    
    
    
    
    
}
