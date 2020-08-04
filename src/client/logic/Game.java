package client.logic;

import client.gui.Window;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Game{
    
    private Window window;
    private Player p1, p2;
    private Ball ball;
    
    public Game(){
        p1 = new Player(32, 250);
        p2 = new Player(568, 250);
        ball = new Ball(600, 250);
        window = new Window(this);
    }
    
    public Ball getBall(){
        return ball;
    }
    
    public Player getPlayer1(){
        return p1;
    }
    
    public Player getPlayer2(){
        return p2;
    }

}
