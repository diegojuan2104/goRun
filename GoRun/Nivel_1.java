import greenfoot.*;  


public class Nivel_1 extends Mundos{
    
    
   public void agregarBloquesAlMundo(){ /**R1 - 1.1 **/
        Bloque1 bl = new Bloque1();
         addObject(bl,0,301);  
        int cont = 30;                    
        while(cont<800){
            Bloque1 b = new Bloque1();
            addObject(b,cont,301);  
            cont+=30;                    
        }       
    
   } 
   
   public void establecerDificultad(){    /**R19 - 1. Establecer dificultad nivel 1  */
       iteracionesPorEnemigo=450;
       iteracionesPorTesoro=150;
       iteracionesPorObstaculo1=120;
       iteracionesPorObstaculo2=500;
       iteracionesPorVida=1000;
       
       probabilidadEnemigo=15;
       probabilidadTesoro=60;
       probabilidadObstaculo1=30;
       probabilidadObstaculo2=50;
       probabilidadVida=5;
      
       segundos = 80;
    }
    
     
     public Nivel_1()
    {  
       showText("Reto: 20 Tesoros",700, 10); 
      agregarBloquesAlMundo();
       nivelDeJuego = 1;
       establecerDificultad();
      
    }
    }
 
    
   

    
 
