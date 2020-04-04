import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Obstaculo extends Oponentes
{
    public static final int VELOCIDAD = 5; 
   
    public void  mover(){ /**R20 - 1.2 Mover obstaculo 1 **/
        move(-VELOCIDAD);
    }

    public void act(){ 
        elminarSiSaleDelMapa();
        mover();
    }    
}
