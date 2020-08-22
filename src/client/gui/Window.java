package client.gui;

import client.logic.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Window extends JFrame{
    
    private final int WIDTH = 1360, HEIGHT = 768;
    private JPanel left, right;
    private JLabel leftScore, rightScore;
    
    public Window(){
        addJPanels();
        addJButtons();
        addJLabels();
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

    private void addJLabels() {
        Font fontPixel = new Font("Agency FB", Font.PLAIN, 64);
        
        leftScore = new JLabel("00");
        leftScore.setForeground(Color.WHITE);
        leftScore.setFont(fontPixel);
        leftScore.setSize(64,64);
        leftScore.setLocation(576,0);
        left.add(leftScore);
        
        rightScore = new JLabel("00");
        rightScore.setForeground(Color.WHITE);
        rightScore.setSize(64,64);
        rightScore.setFont(fontPixel);
        right.add(rightScore);
    }

}