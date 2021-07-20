package com.ThreadPrograms;

public class NeedSynchronized {
    public static int counter = 0;

    public static Thread getThread() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter++;
                }
            }
        });
        return t;
    }

    public static void process() {
        Thread t1 = getThread();
        Thread t2 = getThread();
        Thread t3 = getThread();
        Thread t4 = getThread();
        Thread t5 = getThread();
        Thread t6 = getThread();
        Thread t7 = getThread();
        Thread t8 = getThread();
        Thread t9 = getThread();
        Thread t10 = getThread();
        Thread t11 = getThread();
        Thread t12 = getThread();
        Thread t13 = getThread();
        Thread t14 = getThread();
        Thread t15 = getThread();
        Thread t16 = getThread();
        Thread t17 = getThread();
        Thread t18 = getThread();
        Thread t19 = getThread();
        Thread t20 = getThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();
        t16.start();
        t17.start();
        t18.start();
        t19.start();
        t20.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
            t11.join();
            t12.join();
            t13.join();
            t14.join();
            t15.join();
            t16.join();
            t17.join();
            t18.join();
            t19.join();
            t20.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter value : "+counter);
    }

    public static void main(String[] args) {
        process();
    }
}
