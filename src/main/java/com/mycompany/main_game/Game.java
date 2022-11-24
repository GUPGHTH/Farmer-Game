/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.util.Random;


/**
 *
 * @author GUPGHOSTTHAI71
 */
public class Game extends JPanel implements ActionListener{
    public static int date_season = 0;
    public static Random random = new Random();
    public static int rng_plant = Game.random.nextInt(9);
    public static boolean rain_status = false;
    public static file_read file_img;
    Timer loop;
    player py;
    farm_land f1,f2,f3,f5,f6,f4;
    Date_game d;
    int rng;
    
    
    public Game(){
        py = new player(100, 100);
        f1 = new farm_land(75, 300);
        f2 = new farm_land(475, 300);
        f3 = new farm_land(875, 300);
        f4 = new farm_land(75, 600);
        f5 = new farm_land(475, 600);
        f6 = new farm_land(875, 600);
        d = new Date_game(f1, f2, f3, f4, f5, f6);
        
        loop = new Timer(10,this);
        
        
  
        addKeyListener(new Key_input(py,f1,f2,f3,f4,f5,f6,d));
        setFocusable(true);
        loop.start();
    }
    
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        
        int i = 0;
        int start_inventory_x = 300;
        int inventory_x = 100;
        int inventory_y = 75;
        if(d.date_house >= 19){
            g2d.setColor(new Color(28, 53, 107));
            g2d.fillRect(0, 0, 1440, 250);
        }
        else if(d.date_house >= 17){
            g2d.setColor(new Color(255, 127, 64));
            g2d.fillRect(0, 0, 1440, 250);
        }
        else if(d.date_house >= 10){
            g2d.setColor(new Color(23, 255, 250));
            g2d.fillRect(0, 0, 1440, 250);
        }
        else{
            g2d.setColor(new Color(13, 113, 222));
            g2d.fillRect(0, 0, 1440, 250);
        }
        
        g2d.setColor(new Color(66,150,85));
        g2d.fillRect(0, 250, 1440, 960);
        Font f = new Font("Comic Sans MS", Font.BOLD, 18);
        g2d.setFont(f);
        for(i=0;i<9;i++){
            
            g2d.setColor(new Color(230, 165, 12));
            g2d.fillRect(start_inventory_x,0, inventory_x, inventory_y);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(start_inventory_x, 0, inventory_x, inventory_y);
            
            
            start_inventory_x += inventory_x;
        }
        try {
            d.update();
            
            g2d.drawImage(file_read.location[0], 1170, 150, 275, 400, null, null);
            g2d.drawImage(file_read.location[1], 1170, 550, 300, 300, null, null);
            g2d.drawImage(file_read.location[2], 1180, 400, 100, 100, null, null);
            g2d.drawImage(file_read.item_img[Game.rng_plant], 1190, 405, 50, 50, null, null);
            f1.draw(g2d);
            f2.draw(g2d);
            f3.draw(g2d);
            f4.draw(g2d);
            f5.draw(g2d);
            f6.draw(g2d);
            if(Game.rain_status){
                g2d.drawImage(file_img.rain_eff, 0, 0, 1440, 960, null, null);
            }
            py.draw(g2d);
            
            
            
            
            f = new Font("Comic Sans MS", Font.BOLD, 36);
            g2d.setFont(f);
            g2d.setColor(Color.BLACK);
            
            g2d.drawString(d.get_season(), 1200, 30);
            g2d.drawString(d.get_date(),1200, 80);
            g2d.drawString(d.get_time(), 1200, 130);
            g2d.drawString(py.show_money(), 20, 30);
            
            
            
            
        } catch (IOException ex) {
        }
    }

    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //py.update();
        repaint();
    }
}
class Date_game{
    int date_day;
    int date_house;
    int date_minute;
    int time_count= 0; 
    int time_set = 0;
    int rng;
    Random random = new Random();
    
    
    
    farm_land f1,f2,f3,f4,f5,f6;

    public Date_game(farm_land f1, farm_land f2, farm_land f3, farm_land f4, farm_land f5, farm_land f6) {
        this.date_day = 1;
        this.date_house = 7;
        this.date_minute = 0;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f5 = f5;
        this.f6 = f6;
    }
    public void update(){
        this.time_count += 1;
            if(this.time_count == 100){
                this.date_minute += 10;
                if(this.date_minute == 60){
                    this.date_house += 1;
                    this.date_minute = 0;
                }
                if(this.date_house == 20){
                    this.date_day += 1;
                    f1.increed_day();
                    f2.increed_day();
                    f3.increed_day();
                    f4.increed_day();
                    f5.increed_day();
                    f6.increed_day();
                    //System.out.println("Day : "+this.date_day);
                    this.date_house = 7;
                    this.date_minute = 0;
                    this.rain();

                    
                }
                if(this.date_day == 31){
                    Game.date_season += 1;
                    if(Game.date_season == 3){
                        Game.date_season = 0;
                    }
                    this.date_day = 1;
                }
                //System.out.println(this.date_house+":"+this.date_minute);
                time_count = 0;
            }
    }
    public void skip_day(){
        this.date_house = 7;
        this.date_minute = 0;
        this.date_day += 1;
        this.rain();
        if(this.date_day == 31){
            Game.date_season += 1;
            if(Game.date_season == 3){
                Game.date_season = 0;
                    }
                this.date_day = 1;
                           
        }
        Game.rng_plant = random.nextInt(9);
       
    }
    public void rain(){
        Game.rain_status = false;
                if(Game.date_season == 1){
                rng = random.nextInt(4);
                if(rng == 1){
                    Game.rain_status = true;
                    this.f1.wet = true;
                    this.f2.wet = true;
                    this.f3.wet = true;
                    this.f4.wet = true;
                    this.f5.wet = true;
                    this.f6.wet = true;
                }
            }
            else{
                rng = random.nextInt(9);
                if(rng == 1){
                    Game.rain_status = true;
                    this.f1.wet = true;
                    this.f2.wet = true;
                    this.f3.wet = true;
                    this.f4.wet = true;
                    this.f5.wet = true;
                    this.f6.wet = true;
                }
            }
               //System.out.println(rng);
    }
    public String get_date(){
        return "Day : "+this.date_day+"\n";
    }
    public String get_season(){
        String[] name_ss = {"Summer","Rain","Winter"};
        return name_ss[Game.date_season];
    }
    public String get_time(){
        String h,m;
        if(this.date_house < 10){
            h = "0%d".formatted(this.date_house);
        }else{
            h = "%d".formatted(this.date_house);
        }
        if(this.date_minute < 10){
            m = "0%d".formatted(this.date_minute);
        }
        else{
            m = "%d".formatted(this.date_minute);
        }
        return h+":"+m;
    }
}
