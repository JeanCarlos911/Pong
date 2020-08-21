package client.logic;

import client.gui.Window;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Game{
    
    private Window window;
    private Player p1, p2;
    private Ball ball;
    
    private boolean W, S, UP, DOWN;
    private final double SPEED = 1;
    
    public Game(){
        p1 = new Player(32, 250);
        p2 = new Player(568, 250);
        ball = new Ball(600, 250);
        window = new Window(this);
        start();
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
    
    private void start(){
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        Runnable task1 = () -> {
            if(W && p1.getY0() > 10){
                p1.sumY0(-SPEED);
            }
            if(UP && p2.getY0() > 10){
                p2.sumY0(-SPEED);
            }
            if(S && p1.getY0() < 570){
                p1.sumY0(SPEED);
            }
            if(DOWN && p2.getY0() < 570){
                p2.sumY0(SPEED);
            }
            window.repaint();
        };

        // init Delay = 0, repeat the task every 16 milliseconds
        ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task1, 0, 1, TimeUnit.MILLISECONDS);
    }

    public void setW(boolean b) {
        W = b;
    }

    public void setS(boolean b) {
        S = b;
    }

    public void setUp(boolean b) {
        UP = b;
    }

    public void setDown(boolean b) {
        DOWN = b;
    }

}
