/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 *
 * @author GUPGHOSTTHAI71
 */
public class player {
    private int x;
    private int y;
    private int i;
    protected int money;
    private int speedx = 0;
    private int speedy = 0;
    protected int center_x;
    protected int center_y;
    protected int[][] item= new int[3][9];
    protected int[] hold_item = {0,0};
    private boolean press_q = true;
    private boolean press_e = true;
    private boolean moving = false;
    private boolean left = true;
    private int counting = 0;
    private int picture_select = 0;
    
    
    private String[][] pic_araray={
        {"img\\hoe.png","img\\water_can.png","img\\busket.png","img\\null.png","img\\null.png","img\\null.png","img\\null.png","img\\null.png","img\\null.png"},
        {"img\\seed_corn.png",
        "img\\seed_pumkin.png",
        "img\\seed_cucumber.png",
        "img\\seed_morning_glory.png",
        "img\\seed_long_bean.png",
        "img\\seed_pepper.png",
        "img\\seed_cabbage.png",
        "img\\seed_carrot.png",
        "img\\seed_tomato.png",
        "img\\null.png"},
        {"img\\item_corn.png",
        "img\\item_pumkin.png",
        "img\\item_cucumber.png",
        "img\\item_morning_glory.png",
        "img\\item_long_bean.png",
        "img\\item_pepper.png",
        "img\\item_cabbage.png",
        "img\\item_carrot.png",
        "img\\item_tomato.png",
        "img\\null.png"}
    }; 
    
    /*
    index 0: item main;
    0 : hoe 1 : water can 2: busket
    index 1: seed;
    0: corn 1: pumkin 2: cucumber 3: morning glory 4: long_beans 5: Pepper 6: cabbage 7: carrot 8:tomato
    index 2: product;
    0: corn 1: pumkin 2: cucumber 3: morning glory 4: long_beans 5: Pepper 6: cabbage 7: carrot 8:tomato
    */
    
    Timer tm = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
            if(speedx != 0 || speedy != 0){
                moving = true;
                if(counting == 0 && picture_select == 0){
                    picture_select = 1;
                }
                counting += 1;
                if(counting == 20){
                    if(picture_select == 1){
                        picture_select = 2;
                    }else{
                        picture_select = 1;
                    }
                    counting = 0;
                }
            }
            else {
                moving = false;
                picture_select = 0;
            }
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    });
    
    public player(){
        
    }

    public player(int x, int y) {
        this.x = x;
        this.y = y;
        this.money = 100;
        tm.start();
    }
    public void update(){
        x+=speedx;
        y+=speedy;
        if(x<0){
            x=0;
            
        }
        if(y<100){
            y=100;
        }
        if(x>1230){
            x=1230;
        }
        if(y>730){
            y=730;
        }
        center_x = x+100;
        center_y = y+100;
    }
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.cyan);
        //g2d.fillRect(center_x, center_y, 2, 2);
        //System.out.println(this.x+" "+this.y);
        for (i=0; i<9; i++) {
            g2d.drawImage(file_read.pic_array[hold_item[0]][i], (300+(100*this.i)),0,100,75,null,null);
        }
        g2d.drawImage(file_read.select, (300+(100*this.hold_item[1])), 0,100,75,null,null);
        if(this.hold_item[0] != 0){
            Font f = new Font("Comic Sans MS", Font.BOLD, 18);
            g2d.setFont(f);
            for(i=0;i<9;i++){
                g2d.setColor(Color.BLACK);
                g2d.drawString(this.item_show(this.hold_item[0], i), (300+(100*i))+80, 70);
            }
        }
        if(this.left){
            g2d.drawImage(file_read.farmer[picture_select], x, y, 200, 200, null, null);
        }
        else{
            g2d.drawImage(file_read.farmer_r[picture_select], x, y, 200, 200, null, null);
        }
        
        
        //g2d.fillRect(center_x, center_y, 10, 10);
        //g2d.fillRect(x, y, 32, 32);
    }
    public String item_show(int x_1,int x_2){
        return "%2d".formatted(this.item[x_1][x_2]);
    }
    
    public String show_money(){
        return "$ : %d".formatted(this.money);
    }
    
    
    public void keyPressed(KeyEvent k){
        int key=k.getKeyCode();
        if(key==KeyEvent.VK_D){
            speedx = 5;
            this.left = false;
        }
        if(key == KeyEvent.VK_A){
            this.left = true;
            speedx = -5;
        }
        if(key==KeyEvent.VK_S){
            speedy = 5;
        }
        if(key == KeyEvent.VK_W){
            speedy = -5;
        }
        //change inventory
        if(key == KeyEvent.VK_1){
            this.hold_item[0] = 0;
        }
        if(key==KeyEvent.VK_2){
            this.hold_item[0] = 1;
        }
        if(key == KeyEvent.VK_3){
            this.hold_item[0] = 2;
        }
        if(key==KeyEvent.VK_Q){
            if(this.press_q){
                if(this.hold_item[1] == 0){
                    this.hold_item[1] = 8;
                    
                }
                else{
                    this.hold_item[1] -=1;
                }
                this.press_q = false; 
            }
        }
        if(key==KeyEvent.VK_E){
            if(this.press_e){
                if(this.hold_item[1] == 8){
                    this.hold_item[1] =0;
                }
                else{
                    this.hold_item[1] += 1;
                }
                this.press_e = false; 
            }
        }
        
    }
    public void keyRelesae(KeyEvent k){
        int key=k.getKeyCode();
        if(key==KeyEvent.VK_A){
            speedx = 0;
        }
        if(key == KeyEvent.VK_D){
            speedx = 0;
        }
        if(key==KeyEvent.VK_S){
            speedy = 0;
        }
        if(key == KeyEvent.VK_W){
            speedy = 0;
        }
        if(key == KeyEvent.VK_Q){
            this.press_q = true;
        }
        if(key == KeyEvent.VK_E){
            this.press_e = true;
        }
    }
        
    
    
}
