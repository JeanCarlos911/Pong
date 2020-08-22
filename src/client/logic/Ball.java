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
    private int hit;
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
        hit = 0;
        speed = 0.0;
    }

    public void move(){
        switch(hit){
            case 1:
                speed = 1.0;
                break;
            case 2:
                speed = 2.0;
                break;
            case 3:
                speed = 3.0;
                break;
            case 4:
                speed = 4.0;
                break;
            case 5:
                speed = 5.0;
                break;
            case 7:
                speed = 6.0;
                break;
            case 9:
                speed = 8.0;
                break;
            case 12:
                speed = 9.0;
                break;
            case 15:
                speed = 10.0;
                break;
            case 20:
                speed = 11.0;
                break;
            case 30:
                speed = 12.0;
                break;
            case 40:
                speed = 13.0;
                break;
            case 60:
                speed = 14.0;
                break;
            case 80:
                speed = 14.5;
                break;
            case 100:
                speed = 15.0;
                break;
        }
        if(y0<32 || y0>710){
            direction *= -1;
            direction += 2 * Math.PI;
            hit++;
        }
        if(x0<32){
            direction = Math.random()*Math.PI/2 - Math.PI/4;
            hit++;
        }
        if(x0>1300){
            direction = Math.random()*Math.PI/2 + 3*Math.PI/4;
            hit++;
        }
        
        x0 += speed * Math.cos(direction);
        y0 += speed * Math.sin(direction);
        
        setLocation((int)x0, (int)y0);
    }
    
    public void start(){
        if(hit==0)
            hit++;
    }
    
}