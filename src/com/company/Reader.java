package com.company;

public class Reader implements Runnable{

    private int[] arr;
    private int from;
    private int to;
    private double middleDigital;

    public Reader(int[] arr, int from, int to) {
        this.arr = arr;
        this.from = from;
        this.to = to;
    }

    public double getMiddleDigital() {
        return middleDigital;
    }

    @Override
    public void run() {

        double result = 0;

        for (int i = from; i < to; i++) {
            result += arr[i];
        }

        middleDigital = result / (to - from);
    }
}
