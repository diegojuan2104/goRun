import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

 
public class Nivel_2 extends Mundos
{
      public void agregarBloquesAlMundo(){
        Bloque2 b2 = new Bloque2();
         addObject(b2,0,301);  
        int cont = 30;                    
        while(cont<800){
            Bloque2 b = new Bloque2();
            addObject(b,cont,299);  
            cont+=30;                    
        }

   } 
    
    public void establecerDificultad(){  /**R19 - 2. Establecer dificultad nivel 2  */
        iteracionesPorEnemigo=325;
        iteracionesPorTesoro=110;
        iteracionesPorObstaculo1=150;
        iteracionesPorObstaculo2=430;
        iteracionesPorVida=1500;
        
        probabilidadEnemigo=15;
        probabilidadTesoro=100;
        probabilidadObstaculo1=30;
        probabilidadObstaculo2=60;
        probabilidadVida=5;
        
        segundos=60;

    }

    public Nivel_2()
    {   
        showText("Reto: 25 Tesoros",700, 10); 
        agregarBloquesAlMundo();
        nivelDeJuego = 2;
        establecerDificultad();
    }

 
}
