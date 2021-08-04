package com.ThreadPrograms;

public class VolatileExample {
    private static boolean running = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!running) {}
                System.out.println("Started.");
                while(running) {}
                System.out.println("Stopped.");
            }
        }).start();

        Thread.sleep(1000);
        System.out.println("Starting...");
        running = true;
        Thread.sleep(1000);
        System.out.println("Stopping...");
        running = false;
    }
}

/*
* OUTPUT
Starting...
Started.
Stopping...
* */
