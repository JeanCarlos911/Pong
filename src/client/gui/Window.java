package client.gui;

import client.logic.Game;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Window extends JFrame{
    
    private int WIDTH, HEIGHT;
    
    public Window(Game game){
        WIDTH = 1360;
        HEIGHT = 768;

        addJButtons();
        drawBackground();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    private void drawBackground(){
        getContentPane().setBackground(Color.WHITE);
        
        JPanel left = new JPanel();
        left.setBounds(32, 32, (WIDTH-96)/2, HEIGHT-64);
        left.setBackground(Color.BLACK);
        add(left);
        
        JPanel right = new JPanel();
        right.setBounds(WIDTH/2 +16, 32, (WIDTH-96)/2, HEIGHT-64);
        right.setBackground(Color.BLACK);
        add(right);
    }

    private void addJButtons() {
        JButton close = new JButton("X");
        close.setBounds(WIDTH-60, 10, 50, 32);
        close.setBackground(Color.RED);
        close.setFocusable(false);
        close.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(close);
    }
    
}
