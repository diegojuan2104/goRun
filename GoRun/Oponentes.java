import greenfoot.*;  


public abstract class Oponentes extends Actor
{
   public abstract void mover();             /**R20 - 1.Mover Oponentes **/ 
    
    public void elminarSiSaleDelMapa(){
         if(getX()<0){                       /**R20 - 2. Identificar si llega al borde **/   
            getWorld().removeObject(this);   /**R20 - 2.1 Eliminar del mapa **/
         } 
    } 
}
