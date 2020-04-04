import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Nivel_3 extends Mundos
{  
       public void agregarBloquesAlMundo(){
         Bloque3 b3 = new Bloque3();
         addObject(b3,0,304);  
        int cont = 30;                    
        while(cont<800){
            Bloque3 b = new Bloque3();
            addObject(b,cont,304);  
            cont+=30;                    
        }

      } 
     
   
   
    public void establecerDificultad(){  /**R19 - 3. Establecer dificultad nivel 3  */
       iteracionesPorEnemigo=130;
       iteracionesPorTesoro=150;
       iteracionesPorObstaculo1=120;
       iteracionesPorObstaculo2=220;
       iteracionesPorVida=800;
       
       probabilidadEnemigo=10;
       probabilidadTesoro=75;
       probabilidadObstaculo1=40;
       probabilidadObstaculo2=70;
       probabilidadVida=5;
      
       segundos = 100;
    }
    
    public Nivel_3()
    {  
       showText("Reto: 15 Tesoros",700, 10); 
       agregarBloquesAlMundo();
       nivelDeJuego = 3; 
       establecerDificultad();
       
        
    }
   
  
}
