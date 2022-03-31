package be.aewyn.path;

import java.io.Serial;
import java.io.Serializable;

public class Punt implements Serializable {
    private final int X;
    private final int Y;
    private static final long serialVersionUID = 1L;

    public Punt(int x, int y) {
        X = x;
        Y = y;
    }

    @Override
    public String toString() {
        return X + " " + Y;
    }

    public int getX(){
        return X;
    }

    public int getY(){
        return Y;
    }
}
