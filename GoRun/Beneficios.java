import greenfoot.*;  


public class Beneficios extends Actor
{                                          /**R21 -  Mover Beneficios **/
    private int VELOCIDAD = 5;
    
    public void mover(){                  
                                          /**R21 - 1. Mover vidas y tesoros **/
        move(-VELOCIDAD);
    }
     
    public void elminarSiSaleDelMapa(){   /**R21 - 2. Identificar si llega al borde**/ 
        if(isAtEdge()){
            getWorld().removeObject(this); /**R21- 2.1 Eliminar del mapa**/ 
        }
        
        }
    
    public void act() {  
       elminarSiSaleDelMapa();
       mover();
    }  
}
