 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Personaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Runner extends Actor
{   
  
   
    
    public static final int CANTIDAD_IMAGENES = 10;
    public static final int FUERZA_DE_SALTO = 32;
    public static final int DESACELERACION = 2;
    public static final int ITERACIONES_ANIMACION = 2;
    
    private int vidas;
    private int velocidadVertical;
    private int tesorosCapturados;
   
    private int contadorIteraciones;
    private int indiceImagenes;
    
    private GreenfootImage[] animacionCorrer;
    
    
    public Runner() {

        vidas = 3;
        contadorIteraciones=0;
        velocidadVertical = 0;  
        indiceImagenes = 0;
        guardarImagenesDeAnimacionCorrer();
       
    }
          
    public void act() {
        capturarVida();
        capturarTesoro();
        correr();
        saltar();
        deslizar();
        perderVida();
        pasarDeNivel();
        }
        
    /** R2 Caer
      */                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
    public void caer() {
        if( !estaSobrePlataforma() ) {                                            
            velocidadVertical += DESACELERACION;
            setLocation(getX(), getY() + velocidadVertical);                      /**R2 - 2.Hacer Caer a Runner**/
        }
    }
   
    /** R3 Saltar
      */
    public void saltar() {
        if( hayOrdenDeSalto() && estaSobrePlataforma() && !hayOrdenDeDeslice()) {  /**R3 - 1. Identificar si hay orden de salto */   /**R3 - 1.1 Identificar que no haya orden de deslice */  
                                                                                   /**R3 - 1.2 Idenfificar si esta sobre plataforma*/  
            GreenfootImage saltar = new GreenfootImage("SALTO.PNG");   
            setImage(saltar);                                                      /**R3 - 1.2.1 Establecer Imagen de Salto*/
            Greenfoot.playSound("salto.mp3");                                      /**R3 - 1.2.2 Reproducir sonido de salto*/
            velocidadVertical = -FUERZA_DE_SALTO;
            setLocation(getX(), getY() + velocidadVertical);                       /**R3 - 1.2.3 Hacer saltar a Runner*/
        }
        caer();
    }
    
     /** R4 Deslizar
      */
    public void deslizar(){
        if(hayOrdenDeDeslice() && estaSobrePlataforma() ){                           /**R4 - 1. Identificar si hay orden de desliece */  /**R3 - 1.1 Idenfificar si esta sobre plataforma*/ 
                                                                                      
            GreenfootImage deslice = new GreenfootImage("deslizar.png");
            setImage(deslice);                                                       /**R4 - 1.1.1 Darle a Runner imagen de deslice */ 
            setLocation(getX(),275);                                                 /**R4 - 1.1.2 Hacer deslizar a Runner */ 
        }
        
        }
        
     /** R5 Perder Vida
      */
    public void perderVida(){
        Actor Oponentes;
        Oponentes =getOneIntersectingObject(Oponentes.class);
        Mundos mundos = getWorldOfType(Mundos.class);
        if(Oponentes!=null){                                                           /**R5- 1. Identificar si hay choque con algún obstáculo o enemigo*/                        
            Greenfoot.playSound("chocar.mp3");                                         /**R5 - 1.1 Reproducir sonido de perder vida */       
            
            if(vidas==0){                                                              /**R5 - 1.2 Identificar si es la ultima vida*/       
                mundos.perderJuego();                                                  /**R5 - Ejecutar R12 (Perder Juego) */       
            }else{
                getWorld().removeObject(Oponentes);                                    /**R5 - 1.3 Eliminar obstáculo o enemigo interceptado */       
                vidas--;                                                               /**R5 - 1.4 Restar una vida **/
            }
           getWorld().showText("Vidas:"+ vidas, 170, 10);                              /**R5 - 1.4. Rlefejar en el contador la vida restada **/
        }
    }    
    
    /** R6 Correr
      */
    public void correr(){
        
        if(!hayOrdenDeDeslice() && estaSobrePlataforma() ) {                           /**R6 - 1.Identificar si se está sobre plataforma **/  /**R 1.1 Identificar si no hay orden de deslice **/
            setLocation(getWorld().getWidth()/2,255);
           if(contadorIteraciones>=ITERACIONES_ANIMACION){                             /**R6 - 1.1.1 Identificar si se cumplen la iteraciones paara establecer la imagen i de la animación **/
            setImage(animacionCorrer[indiceImagenes]);                                 /**R6 - 1.1.1.1 Establecer imagen de animación**/
            if( indiceImagenes < CANTIDAD_IMAGENES-1 ) {
            indiceImagenes++;
           }else {
            indiceImagenes = 0;
        }
         contadorIteraciones=0;       
           }else{
         contadorIteraciones++;
           }
       }
    }
    
    /** R7 Capturar Tesoro
      */  
    public void capturarTesoro(){
           Actor Tesoro;
           Tesoro=getOneIntersectingObject(Tesoro.class); 
          if(Tesoro!=null){                                                            /**R7 - 1. Identificar si hay intersección con algún tesoro **/
            tesorosCapturados+=1;                                                      /**R7 - 1.1 Sumar +1 al contador de tesoros**/
            
            getWorld().removeObject(Tesoro);                                           /**R7 - 1.2 Eliminar objeto Tesoro del mundo**/
            Greenfoot.playSound("tesoro.mp3");                                         /**R7 - 1.3 Reproducir sonido: Capturar Tesoro**/
            
            getWorld().showText("Tesoros:"+ tesorosCapturados, 60, 10);                /**R7 - 1.4 Reflejar contador de tesoros capturados **/
          }  
    }
   
     /** R8 Capturar Vida
      */  
    
    public void capturarVida(){
           Actor Vida;
           Vida=getOneIntersectingObject(Vida.class); 
           if(Vida!=null){                                                             /**R8 - 1. Identificar si hay intersección  con alguna vida **/
               
               vidas+=1;                                                               /**R8 - 1.1 Sumar  +1 al contador de vidas**/
               getWorld().removeObject(Vida);                                          /**R8 - 1.2 Eliminar objeto vida del mundo**/ 
               
               Greenfoot.playSound("ganarVida.mp3");                                   /**R8 - 1.3 Reproducir sonido de : Capturar Vida **/
               getWorld().showText("Vidas:"+ vidas, 170, 10);                          /**R8 - 1.4 Reflejar contador de vidas capturadas **/
             }
        
    }  
     /** R9 Pasar de Nivel
      */  
        
       public void pasarDeNivel(){
           Mundos mundos = getWorldOfType(Mundos.class);
                                                                                          
           if(tesorosCapturados==20 && mundos.nivelDeJuego()==1){                       /**R9 - 1. Identificar si Runner se encuentra en el nivel 1**/
                                                                                        /**R9 - 1.1 Identificar si Runner tiene los tesoros necesarios para pasar de nivel 1**/
               Nivel_2 nivel = new Nivel_2();                                           /**R9 - 1.1.1  Crear Nivel 2 y agregarlo al mundo**/
               Greenfoot.setWorld(nivel);
               mundos.sound1.pause();
            } else if(tesorosCapturados==25 && mundos.nivelDeJuego()==2){                /**R9 - 2. Identificar si Runner se encuentra en el nivel 2**/
                                                                                         /**R9 - 2.1 Identificar si Runner tiene los tesoros necesarios para pasar de nivel 2**/
               Nivel_3 nivel = new Nivel_3();                                            /**R9 - 2.1.1  Crear Nivel 3 y agregarlo al mundo**/
               Greenfoot.setWorld(nivel);
               mundos.sound2.pause();
            
            }else if(tesorosCapturados==15 && mundos.nivelDeJuego()==3){                 /**R9 - 3. Identificar si Runner se encuentra en el nivel 3**/
                                                                                         /**R9 - 3.1 Identificar si Runner tiene los tesoros necesarios para para pasar el nivel 3  **/ 
                mundos.ganarJuego();                                                     /**R9 - 3.1.1 Ejecutar Requisito Ganar juego**/
            }
        }
      
    /** ALMACENAMIENTO DE IMAGENES DE ANIMACIÓN: CORRER**/
    public void guardarImagenesDeAnimacionCorrer() {
         animacionCorrer = new GreenfootImage[CANTIDAD_IMAGENES];
         for (int i = 0;i<CANTIDAD_IMAGENES;i++){
              animacionCorrer[i] = new GreenfootImage("c" + i+".png");
            }
        }
    
    /** IDENTIFICADORES**/
    public boolean hayOrdenDeSalto() {                                                    /**Identificador de salto **/
        return Greenfoot.isKeyDown("up");
    }
      public boolean estaSobrePlataforma() {                                              /** Identificador de si esta sobre plataforma */
        return getY() >= getWorld().getHeight()-55;
    }
      public boolean hayOrdenDeDeslice() {                                                /**Identificador de si orden de deslice */
        return Greenfoot.isKeyDown("down");
    }
}    

        
      
    
    
 
