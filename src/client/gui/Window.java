package client.gui;

import client.logic.Player;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Window extends JFrame{
    
    private final int WIDTH = 1360, HEIGHT = 768;
    private JPanel left, right;
    
    public Window(){
        addJPanels();
        addJButtons();
        drawBackground();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void addPlayer(int i, Player p){
        if(i == 1)
            left.add(p);
        else
            right.add(p);
    }
    
    private void addJPanels(){
        left = new JPanel();
        left.setLayout(null);
        
        right = new JPanel();
        right.setLayout(null);
    }
    
    private void drawBackground(){
        getContentPane().setBackground(Color.green);
        
        left.setBounds(32, 32, (WIDTH-96)/2, HEIGHT-64);
        left.setBackground(Color.BLACK);
        add(left);
        
        right.setBounds(WIDTH/2 +16, 32, (WIDTH-96)/2, HEIGHT-64);
        right.setBackground(Color.BLACK);
        add(right);
    }

    private void addJButtons() {
        JButton close = new JButton("X");
        close.setBounds(WIDTH-50, 0, 50, 32);
        close.setBackground(Color.RED);
        close.setFocusable(false);
        close.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        add(close);
    }

}