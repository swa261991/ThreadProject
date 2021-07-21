package com.ThreadPrograms;

import java.util.ArrayList;
import java.util.List;

class Processor {
    private List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final Object lock = new Object();
    private int value = 0;

    public void producer() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == UPPER_LIMIT) {
                    System.out.println("Wait for removing items....");
                    lock.wait();
                } else {
                    System.out.println("Adding : "+value);
                    list.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == LOWER_LIMIT) {
                    System.out.println("Wait for adding items....");
                    lock.wait();
                } else {
                    System.out.println("Removing : "+list.remove(list.size()-1));
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Processor processor = new Processor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}

/*
OUTPUT
------
Adding : 0
Adding : 1
Adding : 2
Adding : 3
Adding : 4
Wait for removing items....
Removing : 4
Removing : 3
Removing : 2
Removing : 1
Removing : 0
Wait for adding items....
Adding : 5
Adding : 6
Adding : 7
Adding : 8
Adding : 9
Wait for removing items....

Process finished with exit code -1

*/