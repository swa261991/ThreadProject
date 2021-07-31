package com.ThreadPrograms;

class Worker1 implements Runnable {
    private boolean terminated = false;
    private static final int SLEEP_MILLI = 500;
    int count=SLEEP_MILLI;

    @Override
    public void run() {
        terminated = false;
        while(!terminated) {
            System.out.println("Working class is running..."+count);
            try {
                Thread.sleep(SLEEP_MILLI);
                count = count+SLEEP_MILLI;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean isTerminated() {
        return terminated;
    }
    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }
}

public class VolatileExample {
    public static void main(String[] args) {
        Worker1 worker = new Worker1();
        Thread t1 = new Thread(worker);
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.setTerminated(true);
        System.out.println("Algorithm is terminated...");
    }
}
