package client.gui;

import client.logic.Game;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Window extends JFrame{
    
    private final int WIDTH = 1360, HEIGHT = 768;
    private JPanel left,right, lP1, lP2;
    private Game game;
    
    public Window(Game g){
        game = g;

        createJPanels();
        addJButtons();
        drawInstances();
        drawBackground();
        
        listener();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }
    
    private void createJPanels(){
        left = new JPanel();
        left.setLayout(null);
        
        right = new JPanel();
        right.setLayout(null);
        
        lP1 = new JPanel();
        left.add(lP1);
        
        lP2 = new JPanel();
        right.add(lP2);
    }
    
    private void drawBackground(){
        getContentPane().setBackground(Color.WHITE);
        
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
        close.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(close);
        
    }

    private void drawInstances() {
        lP1.setBackground(Color.WHITE);
        lP2.setBackground(Color.WHITE);
        
        repaint();
    }
    
    @Override
    public void repaint(){
        lP1.setBounds(game.getPlayer1().getX0(), game.getPlayer1().getY0(), 32, 128);
        lP2.setBounds(game.getPlayer2().getX0(), game.getPlayer2().getY0(), 32, 128);
    }

    private void listener() {
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                if((int)e.getKeyChar() == 27)
                    System.exit(0);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == 'w')
                    game.setW(true);
                if(e.getKeyChar() == 's')
                    game.setS(true);
                if(e.getKeyCode() == KeyEvent.VK_UP)
                    game.setUp(true);
                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    game.setDown(true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar() == 'w')
                    game.setW(false);
                if(e.getKeyChar() == 's')
                    game.setS(false);
                if(e.getKeyCode() == KeyEvent.VK_UP)
                    game.setUp(false);
                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    game.setDown(false);
            }
        });
    }

}