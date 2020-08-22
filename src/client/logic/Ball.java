package client.logic;

import client.gui.Window;
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
    private Player p1, p2;
    private Window window;
    
    public Ball(Player p1, Player p2, Window window){
        this.p1 = p1;
        this.p2 = p2;
        this.window = window;
        
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
            case 4:
                speed = 3.0;
                break;
            case 7:
                speed = 4.0;
                break;
            case 11:
                speed = 5.0;
                break;
            case 16:
                speed = 6.0;
                break;
            case 22:
                speed = 8.0;
                break;
            case 29:
                speed = 9.0;
                break;
            case 37:
                speed = 10.0;
                break;
            case 46:
                speed = 11.0;
                break;
            case 56:
                speed = 12.0;
                break;
            case 67:
                speed = 13.0;
                break;
            case 79:
                speed = 14.0;
                break;
            case 94:
                speed = 14.5;
                break;
            case 108:
                speed = 15.0;
                break;
        }
        if(y0<32 || y0>710){
            direction *= -1;
            direction += 2 * Math.PI;
            hit++;
        }
        if(x0<32){
            p2.sumScore();
            restart();
            window.repaint(p1.getScore(), p2.getScore());
        }
        if(95>=x0 && x0>=63 && p1.getY0()+2<= y0 && p1.getY1()+52>=y0+32){
            direction = Math.random()*Math.PI/2 - Math.PI/4;
        }
        
        if(x0>1300){
            p1.sumScore();
            restart();
            window.repaint(p1.getScore(), p2.getScore());
        }
        if(x0<=1264 && x0>=1232 && p2.getY0()+2<= y0 && p2.getY1()+52>=y0+32){
            direction = Math.random()*Math.PI/2 + 3*Math.PI/4;
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