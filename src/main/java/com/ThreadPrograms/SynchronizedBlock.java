package com.ThreadPrograms;

public class SynchronizedBlock {
    public static int counter1 = 0;
    public static int counter2 = 0;

    public static void increment1() {
        synchronized (SynchronizedBlock.class) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter1++;
        }
    }

    public static void increment2() {
        synchronized (SynchronizedBlock.class) {
            counter2++;
        }
    }

    public static void process() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("Thread-1 : Before = "+counter1);
                    increment1();
                    System.out.println("Thread-1 : After  = "+counter1);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("Thread-2 : Before = "+counter2);
                    increment2();
                    System.out.println("Thread-2 : After  = "+counter2);
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter1 = "+counter1);
        System.out.println("Counter2 = "+counter2);
    }

    public static void main(String[] args) {
        process();
    }
}
