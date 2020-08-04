package client.logic;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Ball {
    
    private int x0, y0;
    
    public Ball(int xi, int yi){
        x0 = xi;
        y0 = yi;
    }

    public int getX0() {
        return x0;
    }

    public int getX1() {
        return x0+32;
    }

    public int getY0() {
        return y0;
    }

    public int getY1() {
        return y0+32;
    }

}