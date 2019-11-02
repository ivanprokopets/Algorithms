package com.company;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        List lista = new List();

        Value value = null;

        for (int i = 0; i < 5; i++) {
            value = lista.add(i, value);
        }

        Value x = lista.add(5, value);
        lista.add(9, value);
        lista.add(6,value);
        x = lista.add(6, value);
        System.out.println("Searching element:" + lista.searchValueRecursion(2));
        lista.delete(6);

        Value f = lista.first;

        while (f != null) {
            System.out.print(f.value + " -> ");
            f = f.next;
        }
        System.out.println();
        long startTime = TimeUnit.MILLISECONDS.toMicros(System.nanoTime());
        lista.searchValue(2);
        long estimatedTime = TimeUnit.MILLISECONDS.toMicros(System.nanoTime())- startTime;
        System.out.println("Iterative search time: " + estimatedTime);
        long startTime1 = System.nanoTime();
        lista.searchValueRecursion(2);
        long estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("Recursive search time: " + estimatedTime1);
        if (estimatedTime > estimatedTime1) {
            System.out.println("Faster recursive search");
        } else {
            System.out.println("Faster iterative search");
        }

    }
}