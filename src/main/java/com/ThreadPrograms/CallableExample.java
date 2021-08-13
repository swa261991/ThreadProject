package com.ThreadPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class Processor1 implements Callable<String> {

    private int id;
    private int randomInt;

    public Processor1(int id, int randomInt) {
        this.id = id;
        this.randomInt = randomInt;
    }

    @Override
    public String call() throws Exception {
        System.out.println("ID: "+id+" will be sleeping for "+(1000 * randomInt)+" milliseconds "+Thread.currentThread().getName());
        Thread.sleep(1000 * randomInt);
        System.out.println("ID: "+id+" processing completed. Executing next tasks. "+Thread.currentThread().getName());
        return "Id: "+id;
    }
}

public class CallableExample {
    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<String> future = executorService.submit(new Processor1(i, random.nextInt(4)+1));
            list.add(future);
        }

        System.out.println("Submitted all tasks...");

        for (Future<String> future: list) {
            try {
                System.out.println(future.get()+" "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}

/*
* OUTPUT

Submitted all tasks...
ID: 0 will be sleeping for 2000 milliseconds pool-1-thread-1
ID: 1 will be sleeping for 1000 milliseconds pool-1-thread-2
ID: 1 processing completed. Executing next tasks. pool-1-thread-2
ID: 2 will be sleeping for 2000 milliseconds pool-1-thread-2
ID: 0 processing completed. Executing next tasks. pool-1-thread-1
ID: 3 will be sleeping for 2000 milliseconds pool-1-thread-1
Id: 0 main
Id: 1 main
ID: 2 processing completed. Executing next tasks. pool-1-thread-2
ID: 4 will be sleeping for 3000 milliseconds pool-1-thread-2
Id: 2 main
ID: 3 processing completed. Executing next tasks. pool-1-thread-1
Id: 3 main
ID: 4 processing completed. Executing next tasks. pool-1-thread-2
Id: 4 main

* */