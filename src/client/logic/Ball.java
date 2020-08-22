package client.logic;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Ball extends JPanel{
    
    private Random random;
    private double x0, y0;
    private double direction, speed;
    
    public Ball(){
        random = new Random();
        restart();
        
        setBackground(Color.ORANGE);
        setSize(32, 32);
    }
    
    public void restart(){
        x0=664;
        y0=335;
        direction = Math.random()* 2 * Math.PI;
        speed = 7.0;
    }

    public void move(){
        if(y0<32 || y0>710){
            direction *= -1;
            direction += 2 * Math.PI;
        }
        if(x0<32)
            direction = Math.random()*Math.PI/2 - Math.PI/4;
        if(x0>1300)
            direction = Math.random()*Math.PI/2 + 3*Math.PI/4;
        
        x0 += speed * Math.cos(direction);
        y0 += speed * Math.sin(direction);
        
        setLocation((int)x0, (int)y0);
    }
    
}