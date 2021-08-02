package com.ThreadPrograms;

public class MyRunnable implements Runnable{
    private volatile boolean active;
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    public MyRunnable() {

    }

    @Override
    public void run() {
        active = true;
        while (active) {
            System.out.println(name+" : active=true  "+Thread.currentThread().getName());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Came out of while loop "+active);
    }

    public void stop() {
        System.out.println("Executing stop for "+name+" "+Thread.currentThread().getName());
        System.out.println("Value set to active=false");
        active = false;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        active = true;
        active = false;
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable("first");
        Thread t1 = new Thread(myRunnable);
        t1.start();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myRunnable.stop();
            }
        });
        t3.start();
    }
}
