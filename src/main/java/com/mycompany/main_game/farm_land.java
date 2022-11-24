/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author GUPGHOSTTHAI71
 */
public class farm_land {
    protected int x;
    protected int y;
    protected int range_x = 300;
    protected int renge_y = 200;
    protected plant p;
    protected int status_farmland;
    // 0: none 1: empty 2: planting
    protected boolean wet;
    public farm_land(){
        
    }

    public farm_land(int x, int y ) {
        this.x = x;
        this.y = y;
        this.p = new plant(9);
        this.status_farmland = 0;
        this.wet = false;
    }
    
    public void set_plant(int pl){
        this.p = new plant(pl);
    }
    
    
    public void interrac(int item_1,int item_2,player play){
        if(item_1 == 0){
            if(item_2 == 0){
            //hoe
                if(this.status_farmland == 0){
                    this.status_farmland = 1;
                    this.wet = false;
                }
                else if(this.p.status == 4){
                    this.status_farmland = 1;
                    this.p.status = 9;
                    this.p.plant_type = 9;
                }
                else if(this.status_farmland == 2){
                    this.p.status = 9;
                    this.p.plant_type = 9;
                    this.status_farmland = 1;
                }
            }
            else if(item_2 == 1){
            //water can
                if(this.status_farmland == 1 || this.status_farmland == 2){
                    this.wet = true;
                }
            }
            else if(item_2 == 2){
            //busket
                if (p.harvest() == 2){
                    play.item[2][p.plant_type] += 1;
                }
                else if (p.harvest() == 3){
                    play.item[2][p.plant_type] += 1;
                    this.status_farmland = 1;
                    p.set_null();
                }
            }
        }
        else if(item_1 == 1){
            if(this.status_farmland == 1){
                if(play.item[play.hold_item[0]][play.hold_item[1]] > 0){
                    this.status_farmland = 2;
                    this.p = new plant(item_2);
                    play.item[play.hold_item[0]][play.hold_item[1]] -= 1;
                }
                
            }
        }
       
    }
    
    public void increed_day(){
        if(this.wet){
            this.p.incresd_day();
            this.wet = false;
        }
        else{
            this.wet = false;
        }
        if(this.status_farmland == 2){
            this.p.dead_plant();
        }
    }
    
    public void draw(Graphics2D g2d) throws IOException{
        g2d.setColor(new Color(136,58,42));
        //g2d.drawImage(ImageIO.read(new File("img\\famer.png")), x, y, 200, 200, null, null);
        //g2d.fillRect(x, y, 32, 32);
        //g2d.fillRect(x, y, 300, 200);
        if (this.status_farmland == 0) {
            g2d.drawImage(file_read.farmland_img[0], x, y, 300, 200, null, null);
        } else if(this.status_farmland == 1 || this.status_farmland == 2){
            if(this.wet){
                g2d.drawImage(file_read.farmland_img[1], x, y, 300, 200, null, null);
            }
            else{
                g2d.drawImage(file_read.farmland_img[2], x, y, 300, 200, null, null);
            }
        }
        this.p.paint(g2d, x, y);
            
    }
    public void keyPressed(KeyEvent k){
        int key=k.getKeyCode();
        this.p.incresd_day();
        System.out.println(((plant)this.p).show_day());
        
    }
    public void keyRelesae(KeyEvent k){
        int key=k.getKeyCode();
        
    }
}
