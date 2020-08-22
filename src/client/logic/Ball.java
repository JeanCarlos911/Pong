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
        speed = 5.0;
    }

    public void move(){
        x0 += speed * Math.cos(direction);
        y0 += speed * Math.sin(direction);
        
        if(y0<32 || y0>710){
            direction *= -1;
            direction += 2 * Math.PI;
        }
        if(x0<32 || x0>1300){
            if(direction>0 && direction<Math.PI/2)
                direction = 180 - direction;
            else
                direction= (Math.sin(direction)<0)?-1:1 * ((Math.sin(direction)<0)?-(2 * Math.PI):0 + Math.acos(-1 * Math.cos(direction)));
        }
        setLocation((int)x0, (int)y0);
    }
    
}