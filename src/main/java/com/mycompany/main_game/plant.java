/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_game;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author GUPGHOSTTHAI71
 */
public class plant extends Object{
    private int day;
    private int day_want;
    protected int harvest_type;
    //harvest_type : 0 = one time 1 = more
    protected int status;
    //status : 0 = seed , 1 = stage2 , 2 = waiting , 3 = ready , 4 = dead , 9 = null
    protected int season;
    //season : 0 = hot , 1 = rain , 2 = winter
    protected int plant_type;
    //0: corn 1: pumkin 2: cucumber 3: morning glory 4: long_beans 5: Pepper 6: cabbage 7: carrot 8:tomato 9: null
    protected String[] x = {"Corn","Pumkin","Cucumber","Morning glory","Long beans","Pepper","Cabbage","Carrot","Tomato","null"};
    protected int[] location_x = {60 ,60 ,60 ,75  ,60 ,90 ,75 ,75 ,90};
    protected int[] location_y = {50 ,30 ,50 ,-25 ,50 ,40 ,-25,-25,40};
    protected int[] size_x =     {170,170,170,150 ,170,120,150,150,120};
    protected int[] size_y =     {200,150,200,150 ,150,170,150,150,170};
    
    
    
    public plant(int type_plant) {
        this.day = 0;
        this.status = 0;
        this.plant_type = type_plant;
        if (type_plant == 0){
            this.day_want = 2;
            this.season = 0;
            this.harvest_type = 1;
        }
        else if(type_plant == 1){
            this.day_want = 3;
            this.season = 0;
            this.harvest_type = 1;
        }
        else if(type_plant == 2){
            this.day_want = 2;
            this.season = 0;
            this.harvest_type = 1;
        }
        else if(type_plant == 3){
            this.day_want = 1;
            this.season = 1;
            this.harvest_type = 0;
        }
        else if(type_plant == 4){
            this.day_want = 2;
            this.season = 1;
            this.harvest_type = 1;
        }
        else if(type_plant == 5){
            this.day_want = 3;
            this.season = 1;
            this.harvest_type = 1;
        }
        else if(type_plant == 6){
            this.day_want = 2;
            this.season = 2;
            this.harvest_type = 0;
        }
        else if(type_plant == 7){
            this.day_want = 3;
            this.season = 2;
            this.harvest_type = 0;
        }
        else if(type_plant == 8){
            this.day_want = 4;
            this.season = 2;
            this.harvest_type = 1;
        }
        else if(type_plant == 9){
            this.day_want = 99;
            this.season = 0;
            this.status = 9;
        }
    }
    public void incresd_day(){
        if(Game.date_season == this.season){
            if(this.status == 0){
                this.status = 1;
            }
            else if(this.status == 1){
                this.status = 2;
            }
            else if(this.status == 2){
                this.day += 1;
                if(this.day >= day_want){
                    this.status = 3;
                }
            }
        }
        else{
            if(this.status == 1 || this.status == 2 || this.status == 3){
                this.status = 4;
            }
        }
    }
    public void dead_plant(){
        if(this.season != Game.date_season){
            this.status = 4;
        }
    }
    
    public int harvest(){
        if(this.status == 3){
            if(this.harvest_type == 1){
                this.status = 2;
                this.day = 0;
                return 2;
            }
            else{
               
                return 3;
            }
        }
        return 1;
    }
    
    public void set_null(){
        this.status = 9;
        this.plant_type = 9;
    }
    
    public String show_day(){
        return "day : "+this.day+"day_want : "+this.day_want+"\n";
    }
    public void paint(Graphics g,int lo_x,int lo_y){
        if(this.status == 0){
            g.drawImage(file_read.plant_status[0], lo_x+120, lo_y+75, 50, 50, null, null);
        }
        else if(this.status == 1){
            g.drawImage(file_read.plant_status[1], lo_x+120, lo_y+75, 50, 50, null, null);
        }
        else if(this.status == 2){
            g.drawImage(file_read.plant_wait[this.plant_type], lo_x+location_x[this.plant_type], lo_y-location_y[this.plant_type], size_x[this.plant_type], size_y[this.plant_type], null, null);
        }
        else if(this.status == 3){
            g.drawImage(file_read.plant_raedy[this.plant_type],  lo_x+location_x[this.plant_type], lo_y-location_y[this.plant_type], size_x[this.plant_type], size_y[this.plant_type], null, null);
        }
        else if(this.status == 4){
            g.drawImage(file_read.plant_status[2], lo_x+120, lo_y+75, 80, 80, null, null);
        }
    }
    
    
}
