package com.company;

public class Block {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    Block(int p_x1, int p_y1, int p_x2, int p_y2) {
        this.x1 = p_x1;
        this.x2 = p_x2;
        this.y1 = p_y1;
        this.y2 = p_y2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int p_x1) {
        this.x1 = p_x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int p_y1) {
        this.y1 = p_y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int p_x2) {
        this.x2 = p_x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int p_y2) {
        this.y2 = p_y2;
    }
}
