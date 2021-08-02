package com.ThreadPrograms;

class Worker1 implements Runnable {
    private volatile boolean terminated = false;
    private static final int SLEEP_MILLI = 500;
    private int count=SLEEP_MILLI;

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

    public void stop() {
        terminated = true;
    }

    public int getCount() {
        return count;
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
        while (true) {
            Worker1 worker = new Worker1();
            Thread t1 = new Thread(worker);
            t1.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            worker.stop();
            //worker.setTerminated(true);
            if(worker.getCount()>1000)
            System.out.println("Algorithm is terminated...");
        }
    }
}
