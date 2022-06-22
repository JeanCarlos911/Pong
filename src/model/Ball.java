package model;

import view.Window;
import sound.SClip;

import java.awt.Color;
import javax.swing.JPanel;

public class Ball extends JPanel{
    private int hit;
    private double x0, y0;
    private double angle, speed;
    private int direction=1;
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
        soundHit = new SClip("sound/hit.wav");
        soundPoint = new SClip("sound/point.wav");
    }
    
    public void restart() {
        x0=664;
        y0=335;

        // se la pasa al próximo jugador
        angle = getRandomAngle();
        direction *= -1;

        // restablece velocidad
        hit = 0;
        speed = 0.0;
    }

    public void move() {
        speed = hit>0?hit*0.4+3:0;

        // pared superior
        if(y0<32 || y0>710){
            angle *= -1;
            angle += 2 * Math.PI;
            hit++;
            soundHit.play();
        }

        // pared izquierda
        if(x0<32){
            p2.sumScore();
            restart();
            window.repaint(p1.getScore(), p2.getScore());
            soundPoint.play();
        }

        // golpe de jugador izquierdo
        if(x0>=64 && x0<=96 && y0 >= p1.getY0()+2 && y0 <= p1.getY1()+20){
            angle = getRandomAngle();
            direction = 1;
            soundHit.play();
        }

        // pared derecha
        if(x0>1300){
            p1.sumScore();
            restart();
            window.repaint(p1.getScore(), p2.getScore());
            soundPoint.play();
        }

        // golpe de jugador derecho
        if(x0>=1232 && x0<=1264 && y0 >= p2.getY0()+2 && y0 <= p2.getY1()+20){
            angle = getRandomAngle();
            direction = -1;
            soundHit.play();
        }
        
        x0 += speed * Math.cos(angle) * direction;
        y0 += speed * Math.sin(angle);
        
        setLocation((int)x0, (int)y0);
    }
    
    public void start() {
        if(hit==0) {
            hit++;
        }
    }

    private double getRandomAngle() {
        return Math.random()*Math.PI/4+Math.PI/8;
    }
    
}