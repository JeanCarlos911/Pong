package client.logic;

import client.gui.Window;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Game {
    
    private Window window;
    private Player j1, j2;
    private Ball ball;
    
    public Game(){
        
        window = new Window(this);
    }
    
}
