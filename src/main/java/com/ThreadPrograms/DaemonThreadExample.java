package com.ThreadPrograms;

import javafx.concurrent.Worker;

class DaemonWorker implements Runnable{

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Daemon thread is running...");
        }
    }
}

class NormalWorker implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Normal thread finished execution...!!!");
    }
}

public class DaemonThreadExample {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println(name);

        Thread t1 = new Thread(new DaemonWorker());
        Thread t2 = new Thread(new NormalWorker());
        t1.setDaemon(true);
        System.out.println(t1.isDaemon());
        t1.start();
        t2.start();
    }
}

/*
OUTPUT
------
main
true
Daemon thread is running...
Daemon thread is running...
Daemon thread is running...
Normal thread finished execution...!!!
*/
