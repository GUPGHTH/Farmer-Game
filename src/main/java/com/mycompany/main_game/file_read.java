/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author GUPGHOSTTHAI71
 */
public class file_read {
    public static Image[] item_img = new Image[10];
    public static Image[] plant_wait = new Image[10];
    public static Image[] plant_raedy = new Image[10];
    public static Image main_manu_backgraound;
    public static Image[] button = new Image[4];
    public static Image[] word = new Image[8];
    public static Image[] pic_tutorail = new Image[2];
    public static Image main_menu_sign;
    private String[] item_path = {"img\\item_corn.png",
        "img\\item_pumkin.png",
        "img\\item_cucumber.png",
        "img\\item_morning_glory.png",
        "img\\item_long_bean.png",
        "img\\item_pepper.png",
        "img\\item_cabbage.png",
        "img\\item_carrot.png",
        "img\\item_tomato.png",
        "img\\null.png"};
    
    private String[] word_path = {
        "img\\w1.png",
        "img\\w2.png",
        "img\\w3.png",
        "img\\w4.png",
        "img\\w5.png",
        "img\\w6.png",
        "img\\w7.png",
        "img\\w8.png",
    };
    public static Image[] location = new Image[3];
    public static Image rain_eff;
    public static Image[] farmland_img = new Image[3];
    public static Image[] plant_status = new Image[3];
    public static Image[][] pic_array = new Image[3][10];
    public static Image select;
    public static Image[] farmer = new Image[3];
    public static Image[] farmer_r = new Image[3];
    private String[] file_path_farmer = {
       "img\\farmer_std.png",
       "img\\famer_st1.png",
       "img\\famer_st2.png"
    };
    private String[] file_path_farmerr = {
       "img\\farmer_stdr.png",
       "img\\famer_st1r.png",
       "img\\famer_st2r.png"
    };
    private String[] file_path_plant = {
      "img\\seed.png",
       "img\\Start.png",
       "img\\dead_plant.png"
    };
    private String[] file_path_button = {
      "img\\button_st.png",
      "img\\bb.png",
      "img\\button_t.png",
      "img\\bn.png"
    };
    private String[] file_path_farmland = {
        "img\\farm_land_none.png",
        "img\\farm_land_wet.png",
        "img\\farm_land_empty.png"
    };
    private String[] file_path_location = { 
        "img\\shop.png",
        "img\\house.png",
        "img\\sign.png"
    };    
    private String[] file_path_wait = {
        "img\\wait_corn.png",
        "img\\wait_pumkin.png",
        "img\\wait_cucumber.png",
        "img\\wait_morning_glory.png",
        "img\\wait_long_bean.png",
        "img\\wait_pepper.png",
        "img\\wait_cabbage.png",
        "img\\wait_carrot.png",
        "img\\wait_tomato.png",
        "img\\null.png"
    };
    private String[] file_path_ready = {
        "img\\ready_corn.png",
        "img\\ready_pumkin.png",
        "img\\ready_cucumber.png",
        "img\\ready_morning_glory.png",
        "img\\ready_long_bean.png",
        "img\\ready_pepper.png",
        "img\\ready_cabbage.png",
        "img\\ready_carrot.png",
        "img\\ready_tomato.png",
        "img\\null.png"
    };
    private String[][] path_pic_araray={
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

    public file_read() {
        this.set_image_item();
        
        try {
            main_menu_sign = ImageIO.read(new File("img\\main_menu_sign.png"));
            rain_eff = ImageIO.read(new File("img\\rain_eff.png"));
            pic_tutorail[0] = ImageIO.read(new File("img\\p1.png"));
            pic_tutorail[1] = ImageIO.read(new File("img\\p2.png"));
            select = ImageIO.read(new File("img\\Select_item.png"));
            button[3] = ImageIO.read(new File(file_path_button[3]));
            
            
        } catch (Exception e) {
        }
        try {
            main_manu_backgraound = ImageIO.read(new File("img\\main_menu.png"));
            //System.out.println("not found");
        } catch (Exception e) {
            //System.out.println("not found");
        }
        
    }
    
    
    
    public void set_image_item(){
        for (int i= 0;i<10;i++){
            try {
               item_img[i] = ImageIO.read(new File(item_path[i])); 
               plant_wait[i] = ImageIO.read(new File(file_path_wait[i]));
               plant_raedy[i] = ImageIO.read(new File(file_path_ready[i]));
               
            } catch (Exception e) {
            }
            
        }
        for (int i = 0;i<3; i++){
            try {
                farmer[i] = ImageIO.read(new File(file_path_farmer[i]));
                farmer_r[i] = ImageIO.read(new File(file_path_farmerr[i]));
                farmland_img[i] = ImageIO.read(new File(file_path_farmland[i]));
                location[i] = ImageIO.read(new File(file_path_location[i]));
                plant_status[i] = ImageIO.read(new File(file_path_plant[i]));
                button[i] = ImageIO.read(new File(file_path_button[i]));
                for(int j = 0;j<10;j++){
                    pic_array[i][j] = ImageIO.read(new File(path_pic_araray[i][j]));
                }
                
            } catch (Exception e) {
            }
        }
        for(int i=0;i<8;i++){
            try {
                word[i] = ImageIO.read(new File(word_path[i]));
            } catch (Exception e) {
            }
        }
    }
}
