import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
  
 
    
  public class Enemigo extends Oponentes
  { 
    public static final int ITERACIONES_ANIMACION = 10;
    public static final int  CANTIDAD_IMAGENES = 4;
    
    private int indiceImagenes;
    private int contadorIteraciones;
    
    public static final int VELOCIDAD = 6;
   
     public void Enemigo(){
        indiceImagenes=0;
        contadorIteraciones=0;
        mover();
     }
    
    public void mover(){ /**R20 - 1.1. Mover Enemigo **/
        Mundos mundos = getWorldOfType(Mundos.class);
        move(-VELOCIDAD);
         if(contadorIteraciones>=ITERACIONES_ANIMACION){
            if(mundos.nivelDeJuego()==1){
                setImage("E"+indiceImagenes+".png");
            }else if(mundos.nivelDeJuego()==2){
                setImage("F"+indiceImagenes+".png");
            }else if(mundos.nivelDeJuego()==3){
                setImage("G"+indiceImagenes+".png");
            }
        if( indiceImagenes < CANTIDAD_IMAGENES-1 ) {
            indiceImagenes++;
        } else {
            indiceImagenes = 0;
        }
         contadorIteraciones=0;       
         
        }else{
         contadorIteraciones++;
        }
        
    }
    
    public void act(){  
        elminarSiSaleDelMapa();
        mover();
    }    
}
