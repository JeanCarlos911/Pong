package client.logic;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Player {
    
    private byte score;
    private double x0, y0;
    
    public Player(int xi, int yi){
        x0 = xi;
        y0 = yi;
        score = 0;
    }

    public int getX0() {
        return (int)x0;
    }

    public int getX1() {
        return (int)x0+32;
    }

    public int getY0() {
        return (int)y0;
    }

    public int getY1() {
        return (int)y0+128;
    }

    public void sumY0(double y0) {
        this.y0 += y0;
    }
    
    public byte getScore() {
        return score;
    }
    
}
