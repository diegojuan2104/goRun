import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TableroPrincipal extends World
{

    private Iniciar iniciar;
    private Instrucciones instrucciones;

    private int iteracionesSonido;

    GreenfootSound sound = new GreenfootSound("sonidoDeFondo1.mp3");

    public TableroPrincipal()
    {    
        super(800, 300, 1); 
        iteracionesSonido=0;
        agregarTextoAPantalla();
    }

    public void act(){
        verInstrucciones();
        iniciarJuego();
        reproducirSonido();  

    }
        
    public void iniciarJuego(){   
        if( Greenfoot.mouseClicked(iniciar)){  /** R1 - 1. Identificar si hay Orden de inicio de juego**/
            sound.stop();                      /**R1 - 1.1 Detener sonido de fondo del Tablero Principal **/
            Nivel_1 nivel = new Nivel_1();     /**R1 -1.2 Agregar nivel número  1 **/
            Greenfoot.setWorld(nivel);

        }
    }

    private void agregarTextoAPantalla()
    {
        iniciar = new Iniciar();
        addObject(iniciar,199,74);
        instrucciones = new Instrucciones();
        addObject(instrucciones,601,221);
    }

    public void reproducirSonido(){
        if(iteracionesSonido==0){
            sound.play();
            iteracionesSonido++;
        }
        if(sound.isPlaying()==false){
            iteracionesSonido=0;
        }
    }
    
    /**R23 - Ver instrucciones **/
    public void verInstrucciones(){ 
        if( Greenfoot.mouseClicked(instrucciones)){                /**R23 - 1. Identificar si hay Orden de ver instrucciones **/
            sound.stop();                                          
            InstruccionesDeJuego ins = new InstruccionesDeJuego(); /**R23 - 1.1 Establecer Pantalla de instrucciones**/
            Greenfoot.setWorld(ins);
        }
    }

}

