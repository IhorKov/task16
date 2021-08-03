package com.company;

import java.util.logging.Logger;

public class Main {

    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {
        int[] arr = makeArrayOfRandomDig(10_000_000);
        double middleDig;

        Reader r1 = new Reader(arr,0,2_500_000);
        Reader r2 = new Reader(arr,2_500_000,5_000_000);
        Reader r3 = new Reader(arr,5_000_000,7_500_000);
        Reader r4 = new Reader(arr,7_500_000,10_000_000);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);

        long start = System.currentTimeMillis();

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        t4.join();
        t4.join();

        middleDig = getMiddleDigitalOfTreads(r1.getMiddleDigital(), r2.getMiddleDigital(),
                r3.getMiddleDigital(), r4.getMiddleDigital());

        log.info(String.valueOf(middleDig));

        long end = System.currentTimeMillis();

        log.info(String.valueOf(end - start));


    }
    public static int[] makeArrayOfRandomDig(int size) {
        int [] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10000);
        }
        return arr;
    }

    public static double getMiddleDigitalOfTreads(double...nums) {
        double result = 0;
        for (double i: nums) {
            result += i;
        }
        return (result / nums.length);
    }
}
