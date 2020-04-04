import greenfoot.*;  

public class InstruccionesDeJuego extends World
{
    private Volver volver;
  
    public InstruccionesDeJuego()
    {    
        super(800, 300, 1);      
        Volver volver = new Volver();
        addObject(volver,648,285);
        volver.setLocation(639,279);
        
        volver();
    }

    public void act(){
        volver();
    
    }
    private void volver()
    {   
        if( Greenfoot.mouseClicked(volver)){       /**R23 - 1.1.1 Identificar si hay orden de volver**/
            TableroPrincipal tab = new TableroPrincipal(); 
            Greenfoot.setWorld(tab);               /**R23 - 1.1.1.1 Establecer pantalla principal**/
        }
  
    }
}
