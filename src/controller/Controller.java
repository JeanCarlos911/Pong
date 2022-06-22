package controller;

import model.Ball;
import model.Player;
import model.Player1;
import model.Player2;
import view.Window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Controller {
    private final Ball ball;
    private final Player p1, p2;
    private boolean keyW, keyS, keyUp, keyDown;
    
    public Controller(){
        Window window = new Window();
        window.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                if((int)e.getKeyChar() == 27)
                    System.exit(0);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == 'w')
                    keyW = true;
                if(e.getKeyChar() == 's')
                    keyS = true;
                if(e.getKeyCode() == KeyEvent.VK_UP)
                    keyUp = true;
                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    keyDown = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar() == 'w')
                    keyW = false;
                if(e.getKeyChar() == 's')
                    keyS = false;
                if(e.getKeyCode() == KeyEvent.VK_UP)
                    keyUp = false;
                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    keyDown = false;
            }
        });

        // sustitución de liskov
        p1 = new Player1();
        window.addPlayer(1, p1);
        
        p2 = new Player2();
        window.addPlayer(0, p2);
        
        ball = new Ball(p1, p2, window);
        window.add(ball, 1);
        
        run();
    }
    
    private void step(){
        // activa movimiento de la bola
        if(keyDown || keyS || keyUp || keyW) {
            ball.start();
        }

        // movimiento del jugador de la izquierda
        if(keyW && p1.getY0() > 0){
            p1.sumY0(-1);
        }
        if(keyS && p1.getY0() < 577){
            p1.sumY0(1);
        }

        //movimiento del jugador de la derecha
        if(keyUp && p2.getY0() > 0){
            p2.sumY0(-1);
        }
        if(keyDown && p2.getY0() < 577){
            p2.sumY0(1);
        }

        // visual change
        p1.repaint();
        p2.repaint();
    }

    public void run(){
        long lastTime = System.nanoTime();
        final double nsCode = 1000000000.0 / 120.0;
        double delta = 0;
        
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime) / nsCode;
            lastTime = now;
            
            while(delta >= 1.0){
                step();
                ball.move();
                delta--;
            }
        } 
   }
}
