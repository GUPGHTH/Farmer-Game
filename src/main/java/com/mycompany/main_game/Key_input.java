/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author GUPGHOSTTHAI71
 */
public class Key_input extends KeyAdapter{
    player p;
    farm_land f1,f2,f3,f5,f6,f4;
    Date_game d;
    private int[] price_seed = {30,40,30,10,30,30,30,30,30};
    private int[] price =      {15,20,15,15,15,20,50,55,25};
    
    
    public Key_input(player p,farm_land f1,farm_land f2,farm_land f3,farm_land f4,farm_land f5,farm_land f6,Date_game da){
        this.p = p;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f5 = f5;
        this.f6 = f6;
        this.d = da;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE){
            //System.out.println("space");
            if(p.center_x>=1200){
                if(p.center_y >= 600 && p.center_y <= 850){
                    //home
                    f1.increed_day();
                    f2.increed_day();
                    f3.increed_day();
                    f4.increed_day();
                    f5.increed_day();
                    f6.increed_day();
                    d.skip_day();
                           
                }
                else if (p.center_y >= 350 && p.center_y <= 500){
                    //shop
                    //buy
                    if(this.p.hold_item[0] == 1){
                        if(this.p.money >= this.price_seed[this.p.hold_item[0]]){
                            this.p.item[this.p.hold_item[0]][this.p.hold_item[1]] += 1;
                            this.p.money -= this.price_seed[this.p.hold_item[0]];
                        }
                    }
                    //sell
                    else if(this.p.hold_item[0] == 2){
                        if(this.p.item[this.p.hold_item[0]][this.p.hold_item[1]] >= 1){
                            if(this.p.hold_item[1] == Game.rng_plant){
                                this.p.item[this.p.hold_item[0]][this.p.hold_item[1]] -= 1;
                                this.p.money += this.price[this.p.hold_item[1]]*2;
                            }
                            else{
                                this.p.item[this.p.hold_item[0]][this.p.hold_item[1]] -= 1;
                                this.p.money += this.price[this.p.hold_item[1]];
                            }
                        }
                    }
                   
                }
            }
            if(p.center_x > f1.x && p.center_x < f1.x+f1.range_x){
                if (p.center_y > f1.y && p.center_y<f1.y+f1.renge_y){
                    f1.interrac(p.hold_item[0], p.hold_item[1], p);
                }
                else if (p.center_y > f4.y && p.center_y<f4.y+f4.renge_y){
                    f4.interrac(p.hold_item[0], p.hold_item[1], p);
                }
            }
            else if(p.center_x > f2.x && p.center_x < f2.x+f2.range_x){
                if (p.center_y > f2.y && p.center_y<f2.y+f2.renge_y){
                    f2.interrac(p.hold_item[0], p.hold_item[1], p);
                }
                else if (p.center_y > f5.y && p.center_y<f5.y+f5.renge_y){
                    f5.interrac(p.hold_item[0], p.hold_item[1], p);
                }
            }
            else if(p.center_x > f3.x && p.center_x < f3.x+f3.range_x){
                if (p.center_y > f3.y && p.center_y<f3.y+f3.renge_y){
                    f3.interrac(p.hold_item[0], p.hold_item[1], p);
                }
                else if (p.center_y > f6.y && p.center_y<f6.y+f6.renge_y){
                    f6.interrac(p.hold_item[0], p.hold_item[1], p);
                }
            }
            
            
        }
        else{
            p.keyPressed(e);
        }
            
        
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE){
            f1.keyRelesae(e);
        }
        else{
            p.keyRelesae(e);
        }
    }
}
