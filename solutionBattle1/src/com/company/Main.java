package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new java.io.InputStreamReader(System.in));
        try {
            String configMsg = bufferedReader.readLine();
            String[] configSplit = configMsg.split(",");
            Grid grid;
            if (configSplit.length > 1) {
                grid = new Grid(Integer.parseInt(configSplit[0]));
                for (int i = 1; i < configSplit.length; i++) {
                    String[] newSplit = configSplit[i].split(";");
                    grid.setPoint(Integer.parseInt(newSplit[0]), Integer.parseInt(newSplit[1]), 1);
                }
            } else {
                grid = new Grid(Integer.parseInt(configMsg));
            }
            System.out.println("ok");
            String configBlackSpotMsg = bufferedReader.readLine();
            String[] blackSpots = configBlackSpotMsg.split(",");
            ArrayList<BlackSpot> blackSpotsList = new ArrayList<>();
            for (int i = 0; i < blackSpots.length; i++) {
                blackSpots[i] = blackSpots[i].substring(1, blackSpots[i].length() - 1);
                String[] xy = blackSpots[i].split(";");
                blackSpotsList.add(new BlackSpot(Integer.valueOf(xy[0]), Integer.valueOf(xy[1])));
            }
            grid.fillGridWithBlackSpots(blackSpotsList);
            System.out.println("ok");
            String firstMsg = bufferedReader.readLine();
            Block block;
            if (firstMsg.toLowerCase().equals("start")) {
                block = grid.getFreeBlock();
                System.out.println("{" + block.getX1() + ";" + block.getY1() + "}" + "," + "{" + block.getX2() + ";" + block.getY2() + "}");
            } else {
                String[] firstSplit = firstMsg.split(",");
                firstSplit[0] = firstSplit[0].substring(1, firstSplit[0].length() - 1);
                firstSplit[1] = firstSplit[1].substring(1, firstSplit[1].length() - 1);
                for (int i = 0; i < 2; i++) {
                    String[] secondSplit = firstSplit[i].split(";");
                    grid.setPoint(Integer.parseInt(secondSplit[0]), Integer.parseInt(secondSplit[1]), 1);
                }
                block = grid.getFreeBlock();
                System.out.println("{" + block.getX1() + ";" + block.getY1() + "}" + "," + "{" + block.getX2() + ";" + block.getY2() + "}");
            }

            for (; ; ) {
                String msg = bufferedReader.readLine();
                if (msg.toLowerCase().equals("stop")) {
                    return;
                }
                String[] firstSplit = msg.split(",");

                firstSplit[0] = firstSplit[0].substring(1, firstSplit[0].length() - 1);
                firstSplit[1] = firstSplit[1].substring(1, firstSplit[1].length() - 1);
                for (int i = 0; i < 2; i++) {
                    String[] secondSplit = firstSplit[i].split(";");
                    grid.setPoint(Integer.parseInt(secondSplit[0]), Integer.parseInt(secondSplit[1]), 1);
                }
                block = grid.getFreeBlock();
                System.out.println("{" + block.getX1() + ";" + block.getY1() + "}" + "," + "{" + block.getX2() + ";" + block.getY2() + "}");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
