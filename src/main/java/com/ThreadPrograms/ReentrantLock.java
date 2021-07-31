package com.ThreadPrograms;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class Worker {
    private Lock lock = new java.util.concurrent.locks.ReentrantLock();
    private Condition condition  = lock.newCondition();

    public void producer() throws InterruptedException {
        lock.lock();
        System.out.println("Producer method...");
        condition.await();
        for (int i = 0; i < 10; i++) {
            System.out.println("Produce again...");
        }
        lock.unlock();
    }

    public void consumer() throws InterruptedException {
        lock.lock();
        Thread.sleep(2000);
        System.out.println("Calling signal() method in consumer method...");
        condition.signal();
        lock.unlock();
        System.out.println("Leaving consumer method...");
        System.out.println("Now I will print Om Namah Shivay 100 times");
        for (int i = 0; i < 10; i++) {
            System.out.println("Om Namah Shivay");
        }
    }
}

public class ReentrantLock {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
    }
}

/* OUTPUT
Producer method...
Calling signal() method in consumer method...
Leaving consumer method...
Now I will print Om Namah Shivay 10 times
Om Namah Shivay
Produce again...
Produce again...
Produce again...
Produce again...
Om Namah Shivay
Om Namah Shivay
Om Namah Shivay
Produce again...
Produce again...
Produce again...
Produce again...
Produce again...
Produce again...
Om Namah Shivay
Om Namah Shivay
Om Namah Shivay
Om Namah Shivay
Om Namah Shivay
Om Namah Shivay
* */
