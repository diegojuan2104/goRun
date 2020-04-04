import greenfoot.*;  

public class Obstaculo2 extends Oponentes{  
   
    public static final int VELOCIDAD = 5; 
    
    public void  mover(){  /**R20 - 1.3 Mover obstaculo 2 **/
        move(-VELOCIDAD);
    }
    
    public void act() {   
        elminarSiSaleDelMapa();
        mover();
    }    
}
