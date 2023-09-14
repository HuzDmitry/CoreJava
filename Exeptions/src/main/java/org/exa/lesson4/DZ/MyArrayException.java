package org.exa.lesson4.DZ;

public abstract class MyArrayException extends Exception{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public MyArrayException(String message, int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
    }
}
