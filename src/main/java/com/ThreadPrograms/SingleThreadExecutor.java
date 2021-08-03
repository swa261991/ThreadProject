package com.ThreadPrograms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id "+id+" is in work - thread id: "+Thread.currentThread().getName());
        long duration = (long) (Math.random()*5);
        try {
            System.out.println("Sleeping for "+duration+" seconds");
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SingleThreadExecutor {
    public static void main(String[] args) {
        //it is single thread that will execute the tasks sequentially
        //so one after another
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Task(i));
        }
    }
}

/*
* OUTPUT
Task with id 0 is in work - thread id: pool-1-thread-1
Sleeping for 4 seconds
Task with id 1 is in work - thread id: pool-1-thread-1
Sleeping for 0 seconds
Task with id 2 is in work - thread id: pool-1-thread-1
Sleeping for 0 seconds
Task with id 3 is in work - thread id: pool-1-thread-1
Sleeping for 0 seconds
Task with id 4 is in work - thread id: pool-1-thread-1
Sleeping for 2 seconds
* */
