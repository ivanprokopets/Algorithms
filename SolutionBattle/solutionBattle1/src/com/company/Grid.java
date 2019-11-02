package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Grid {

    private int[][] gridData;
    private int size;
    private Random random;

    Grid(int p_size) {
        gridData = new int[p_size][p_size];
        this.size = p_size;
        random = new Random();
    }

    void setPoint(int p_x, int p_y, int p_value) {
        gridData[p_x][p_y] = p_value;
    }

    public int getPoint(int p_x, int p_y) {
        return gridData[p_x][p_y];
    }

    Block getFreeBlock() {
        for (; ; ) {
            int firstX = random.nextInt(size);
            int firstY = random.nextInt(size);
            if (gridData[firstX][firstY] == 0) {
                if ((firstX + 1 < size) && (gridData[(firstX + 1)][firstY] == 0)) {
                    setPoint(firstX, firstY, 1);
                    setPoint(firstX + 1, firstY, 1);
                    return new Block(firstX, firstY, firstX + 1, firstY);
                }

                if ((firstX - 1 >= 0) && (gridData[(firstX - 1)][firstY] == 0)) {
                    setPoint(firstX, firstY, 1);
                    setPoint(firstX - 1, firstY, 1);
                    return new Block(firstX, firstY, firstX - 1, firstY);
                }

                if ((firstY - 1 >= 0) && (gridData[firstX][(firstY - 1)] == 0)) {
                    setPoint(firstX, firstY, 1);
                    setPoint(firstX, firstY - 1, 1);
                    return new Block(firstX, firstY, firstX, firstY - 1);
                }

                if ((firstY + 1 < size) && (gridData[firstX][(firstY + 1)] == 0)) {
                    setPoint(firstX, firstY, 1);
                    setPoint(firstX, firstY + 1, 1);
                    return new Block(firstX, firstY, firstX, firstY + 1);
                }
            }
        }
    }

    public void fillGridWithBlackSpots(ArrayList<BlackSpot> blackSpots) {
        for (BlackSpot b : blackSpots) {
            gridData[b.getX()][b.getY()] = -1;
        }
    }

    public int[][] getGridData() {
        return gridData;
    }

    public void setGridData(int[][] p_grid) {
        this.gridData = p_grid;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random p_random) {
        this.random = p_random;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int p_n) {
        this.size = p_n;
    }
}
