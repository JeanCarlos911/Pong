package client.gui;

import client.logic.Game;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Window extends JFrame{
    
    public Window(Game game){
        drawBackground();
        
        setSize(1280, 720);
        setLocationRelativeTo(this);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void drawBackground(){
        getContentPane().setBackground(new Color(0, 0, 0));
    }
    
}
