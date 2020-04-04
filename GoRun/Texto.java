import greenfoot.*; 

public class Texto extends Actor
{
    private int velocidad;
    /**R22 Mover texto en esquinas **/
    public void mover(){
        if(getX()<200){            /**R22 - 1. Identificar si se encuentra en una esquina **/
            velocidad = 2;         
       
        }else if(getX()>600){      /**R22 - 1.1.1 Identificar si esta en el borde de nuevo **/
            velocidad = -2;        /**R22 - 1.1.1.1 Cambiarle el sentido al movimiento **/
        }
        move(velocidad);           /**R22 - 1.1 Mover texto **/
    } 
      
    public void act() 
    {  
       mover();
    }   

}
