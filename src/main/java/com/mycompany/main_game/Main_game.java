/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.main_game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author GUPGHOSTTHAI71
 */
public class Main_game extends JFrame implements ActionListener{
    public static final int width = 1440;
    public static final int hight = 960;
    public static file_read file_img = new file_read();
    
    Main_menu mn = new Main_menu();
    Game g = new Game();
    Tutorail_menu t = new Tutorail_menu();
    
    
    public Main_game() {
        this.setSize(1440, 960);
        this.add(mn);
        this.revalidate();
        this.repaint();
        mn.BStart.addActionListener(this);
        mn.BTutorail.addActionListener(this);
        t.Bback.addActionListener(this);
        t.Bnext.addActionListener(this);
    }
    
    @Override 
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mn.BStart){
            this.setLocationRelativeTo(null);
            
            this.remove(mn);
            
            this.add(g);
            g.requestFocusInWindow();
            this.revalidate();
            this.repaint();
        }
        else if(e.getSource() == mn.BTutorail){
            //System.out.println("bt tutorail");
            this.setLocationRelativeTo(null);
            this.remove(mn);
            this.add(t);
            t.requestFocusInWindow();
            this.revalidate();
            this.repaint();
        }
        else if(e.getSource() == t.Bnext){
            if(t.page == 0){
                t.page = 1;
                t.repaint();
                
            }else{
                this.setLocationRelativeTo(null);
                this.remove(t);
                t.page = 0;
                this.add(mn);
                mn.requestFocusInWindow();
                this.revalidate();
                this.repaint();
            }
        }
        else if(e.getSource() == t.Bback){
            if(t.page == 1){
                t.page = 0;
                t.repaint();
                
            }else{
                this.setLocationRelativeTo(null);
                this.remove(t);
                t.page = 0;
                this.add(mn);
                mn.requestFocusInWindow();
                this.revalidate();
                this.repaint();
            }
        }
    }
    
    
    public static void main(String[] args) {
        
        JFrame window = new Main_game();
        window.setSize(width,hight);
        window.setResizable(false);
        window.setTitle("Ture");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
