import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public abstract class Mundos extends World
{  
    GreenfootSound sound1 = new GreenfootSound("sonidoDeFondo1.mp3");
    GreenfootSound sound2 = new GreenfootSound("sonidoDeFondo2.mp3");
    GreenfootSound sound3 = new GreenfootSound("sonidoDeFondo3.mp3");
    
    protected int iteracionesPorEnemigo;
    protected int iteracionesPorTesoro;
    protected int iteracionesPorObstaculo1;
    protected int iteracionesPorObstaculo2;
    protected int iteracionesPorVida;
    
    private int contadorDeTiempo;
    private int contIteracionesEnemigos;
    private int contIteracionesObstaculo1;
    private int contIteracionesObstaculo2;
    private int contIteracionesTesoros;
    private int contIteracionesSonido;
    private int contIteracionesVida;
    
    protected int probabilidadEnemigo;
    protected int probabilidadObstaculo1;
    protected int probabilidadObstaculo2;
    protected int probabilidadTesoro;
    protected int probabilidadVida;
     
    protected int segundos;
    protected int nivelDeJuego;
    
    public Mundos()
    {  

       super(800, 300, 1,false);         
       
       Runner runner = new Runner();     /**R1- 1.2.2    Agregar a Runner al mapa  **/
       addObject(runner,getWidth()/2,255);
       
       contIteracionesSonido=0;
       contadorDeTiempo=0;
       contIteracionesEnemigos = 0;
       contIteracionesObstaculo1= 0;
       contIteracionesObstaculo2=0;
       contIteracionesTesoros = 0;
       contIteracionesVida = 0;
       
       showText("Vidas:"+3, 170, 10); 
       showText("Tesoros:"+0, 60, 10); 

      
     }
     
     public void act(){
       reproducirSonidoDeFondo();
       mostrarNivel();
       contarTiempo();
       nivelDeJuego();
       generarVidas();
       generarEnemigos(); 
       generarTesoros();
       generarObstaculo1();
       generarObstaculo2();
     }
     
     public abstract void agregarBloquesAlMundo();               /**R1 -1.2.1 Agregar bloques a plataforma dependiendo del nivel **/
     
     public abstract void establecerDificultad();                /**R19 - Establecer dificultad*/

      /** R10 Genergar Enemigos */
     public void generarEnemigos(){
            
        if(contIteracionesEnemigos==iteracionesPorEnemigo){     /**R10 - 1. Identificar si  el contador de iteraciones de enemigos es igual a las iteraciones por enemigo. **/
            int probabilidad = Greenfoot.getRandomNumber(100);
             if(probabilidad<=probabilidadEnemigo){             /**R10 - 1.1 Identificar si la probabilidad generada es menor o igual a la establecida para generar el enemigo**/
                Enemigo enemigo = new Enemigo();                /**R10 - 1.1.1 Generar enemigo y agregarlo al mundo**/
                addObject(enemigo,getWidth()+60,260);
                contIteracionesEnemigos=0;
            }
        }else{
            contIteracionesEnemigos++;
        }
   }
      /** R11 Genergar Enemigos */
    public void generarTesoros(){
        if(contIteracionesTesoros==iteracionesPorTesoro){      /**R11 - 1. Identificar si  el contador de iteraciones de tesoros es igual a las iteraciones por tesoro. **/
            int probabilidad = Greenfoot.getRandomNumber(100);
   
            if(probabilidad<=probabilidadTesoro){              /**R11 - 1.1 Identificar si la probabilidad generada es menor o igual a la establecida para generar el tesoro**/
                Tesoro tesoro = new Tesoro();                  /**R11 - 1.1.1 Generar Tesoro y agregarlo al mundo**/
                addObject(tesoro,getWidth()-5,270);
                contIteracionesTesoros=0;
            }
        }else{
            contIteracionesTesoros++;
        
        }
    
    }
       /** R12 Generar Obstaculo1  */
      public void generarObstaculo1(){
        if(contIteracionesObstaculo1==iteracionesPorObstaculo1){  /**R12 - 1. Identificar si  el contador de iteraciones de obstaculos es igual a las iteraciones por obstaculo. **/
            int probabilidad = Greenfoot.getRandomNumber(100);    
           
            if(probabilidad<=probabilidadObstaculo1){             /**R12 - 1.1 Identificar si la probabilidad generada es menor o igual a la establecida para generar el obstaculo**/
                Obstaculo obstaculo = new Obstaculo();            /**R12 - 1.1.1 Generar obstaculo y agregarlo al mundo**/
                addObject(obstaculo,getWidth()-5,270);
                contIteracionesObstaculo1=0;
            }
        }else{
            contIteracionesObstaculo1++;
        }
    
    }
        /** R13 Generar Obstaculo2*/
       public void generarObstaculo2(){
        if(contIteracionesObstaculo2==iteracionesPorObstaculo2){ /**R13 - 1. Identificar si  el contador de iteraciones de obstaculo2 es igual a las iteraciones por obstaculo2. **/
            int probabilidad = Greenfoot.getRandomNumber(100);
           
            if(probabilidad<=probabilidadObstaculo2){            /**R13 - 1.1 Identificar si la probabilidad generada es menor o igual a la establecida para generar el obstaculo**/
                Obstaculo2 obstaculo2 = new Obstaculo2();        /**R13 - 1.1.1 Generar obstaculo2 y agregarlo al mundo**/
                addObject(obstaculo2,getWidth()-5,245);
                contIteracionesObstaculo2=0;
            }
        }else{
            contIteracionesObstaculo2++;
        }
    }
    
     /** R14 Generar vidas */
     public void generarVidas(){
         if(contIteracionesVida==iteracionesPorVida){             /**R14 - 1. Identificar si  el contador de iteraciones de vida es igual a las iteraciones por vida. **/
            int probabilidad = Greenfoot.getRandomNumber(100);
           
            if(probabilidad<=probabilidadVida){                   /**R14 - 1.1 Identificar si la probabilidad generada es menor o igual a la establecida para generar la vida**/  
                Vida vida = new Vida();                           /**R14 - 1.1.1 Generar vida y agregarla al mundo**/
                addObject(vida,getWidth()-5,278);
                contIteracionesVida=0;
            }                
          }else{
            contIteracionesVida++;
        }
     } 
     
       /** R15 Ganar juego  */
       public void ganarJuego(){                                         
            sound1.pause();sound2.pause();sound3.pause();         /**R15 - 1.Detener sonido de fondo   **/  
            Greenfoot.playSound("Ganar.mp3");                     /**R15 - 2. Reproducir sonido de: Ganar Juego  **/  
            
            Ganar ganar = new Ganar();                            /**R15 - 3.Mostrar texto de Ganar Juego  **/  
            addObject(ganar,getWidth()/2,getHeight()/2);         
            Greenfoot.stop();                                     /**R15 - 4. Parar ejecución del Juego**/  
        }
       
        /** R16 Perder juego  */
        public void perderJuego(){
            sound1.pause();sound2.pause();sound3.pause();         /**R16 - 1.Detener sonido de fondo   **/  
            Greenfoot.playSound("gameOver.mp3");                  /**R16 - 2. Reproducir sonido de: Perder Juego  **/  
           
            GameOver gameOver = new GameOver();                    /**R16 - 3. Mostrar texto de Perde Juego  **/  
            addObject(gameOver,getWidth()/2,getHeight()/2);
            Greenfoot.stop();                                      /**R16 - 4. Parar ejecución del Juego**/  
        }  
        
        /** R17 Resproducir sonido de fondo */
         public void reproducirSonidoDeFondo(){                           
         if(contIteracionesSonido==0){                             
            if(nivelDeJuego==1){                                   /**R17 - 1. Identificar si en nivel de juego es 1**/
                sound1.play();                                     /**R17 - 1.1 Reproducir sonido de nivel 1**/
            
            }else if(nivelDeJuego==2){                             /**R17 - 2. Identificar si en nivel de juego es 2**/
                sound2.play();                                     /**R17 - 2.1 Reproducir el sonido de nivel 2**/
            
            }else if(nivelDeJuego==3){                             /**R17 - 3. Identificar si en nivel de juego es 3**/
                sound3.play();                                     /**R17 - 3.1 Identificar si en nivel de juego es 3**/
            }  
            contIteracionesSonido++;
         }
       }
        
       /**R18 - Contar tiempo**/
       public void contarTiempo(){                                
        if(contadorDeTiempo==60){                                  /**R18 - 1. identificar si el contador de tiempo ha llegado a 60 **/
            segundos--;                                            /**R18 - 1.1 Restar un segundo**/
            contadorDeTiempo=0;
        }else{
           contadorDeTiempo++;
        }
        showText("Tiempo Restante:"+ segundos, 320, 10);          /**R18 - 1. Mostrar el contador de tiempo restante en el mapa **/ 
       
        if(segundos==0){
            perderJuego();
        }
       }                                                          
       
        
      public int nivelDeJuego(){
         return nivelDeJuego;
       }
    
      public void mostrarNivel(){
      showText("Nivel:"+nivelDeJuego, 470, 10); 
     }

}

  
