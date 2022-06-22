package model;

import java.awt.Color;
import javax.swing.JPanel;

public abstract class Player extends JPanel{
    
    private byte score;
    private final int x0;
    private int y0;
    private final int speed;
    
    public Player(int xi, int yi, Color color){
        x0 = xi;
        y0 = yi;
        score = 0;
        speed = 7;
        
        setBackground(color);
        setBounds(x0, y0, 32, 128);
    }

    public int getY0() {
        return y0;
    }

    public int getY1() {
        return y0+128;
    }

    public void sumY0(int y0) {
        this.y0 += y0 * speed;
    }
    
    public byte getScore() {
        return score;
    }
    
    public void sumScore() {
        score++;
    }
    
    @Override
    public void repaint(){
        setLocation(x0, y0);
    }
}
