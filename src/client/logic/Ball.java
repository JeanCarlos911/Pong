package client.logic;

import client.gui.Window;
import sounds.SClip;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Ball extends JPanel{

    private int hit;
    private double x0, y0;
    private double angle, speed;
    private boolean direction=true;
    private final Player p1, p2;
    private final Window window;
    private final SClip soundHit, soundPoint;
    
    public Ball(Player p1, Player p2, Window window) {
        this.p1 = p1;
        this.p2 = p2;
        this.window = window;

        restart();
        
        setBackground(Color.ORANGE);
        setSize(32, 32);
        soundHit = new SClip("sounds/hit.wav");
        soundPoint = new SClip("sounds/point.wav");
    }
    
    public void restart() {
        x0=664;
        y0=335;
        int direction = this.direction? -1: 1;
        this.direction = !this.direction;
        angle = direction * Math.random() * Math.PI / 2.0 - Math.PI / 4;
        hit = 0;
        speed = 0.0;
    }

    public void move() {
        switch (hit) {
            case 1 -> speed = 4.5;
            case 2 -> speed = 5.0;
            case 4 -> speed = 6.0;
            case 7 -> speed = 7.0;
            case 11 -> speed = 8.0;
            case 16 -> speed = 9.0;
            case 22 -> speed = 10.0;
            case 29 -> speed = 11.0;
            case 37 -> speed = 12.0;
            case 46 -> speed = 13.2;
            case 56 -> speed = 13.4;
            case 67 -> speed = 13.6;
            case 79 -> speed = 14.0;
            case 94 -> speed = 14.5;
            case 108 -> speed = 15.0;
        }
        if(y0<32 || y0>710){
            angle *= -1;
            angle += 2 * Math.PI;
            hit++;
            soundHit.play();
        }
        if(x0<32){
            p2.sumScore();
            restart();
            window.repaint(p1.getScore(), p2.getScore());
            soundPoint.play();
        }
        if(95>=x0 && x0>=63 && p1.getY0()+2<= y0 && p1.getY1()+52>=y0+32){
            angle = Math.random()*Math.PI/2 - Math.PI/4;
            soundHit.play();
        }
        
        if(x0>1300){
            p1.sumScore();
            restart();
            window.repaint(p1.getScore(), p2.getScore());
            soundPoint.play();
        }
        if(x0<=1264 && x0>=1232 && p2.getY0()+2<= y0 && p2.getY1()+52>=y0+32){
            angle = Math.random()*Math.PI/2 + 3*Math.PI/4;
            soundHit.play();
        }
        
        x0 += speed * Math.cos(angle);
        y0 += speed * Math.sin(angle);
        
        setLocation((int)x0, (int)y0);
    }
    
    public void start() {
        if(hit==0)
            hit++;
    }
    
}