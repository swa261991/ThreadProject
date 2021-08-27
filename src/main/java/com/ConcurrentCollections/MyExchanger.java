package com.ConcurrentCollections;

import java.util.concurrent.Exchanger;

/**
 * With the help of Exchanger -> two threads can exchange objects
 *
 * exchange() -> exchanging objects is done via one of the two exchange()
 * methods
 *
 * 	For example: genetic algorithms, training neural networks
 *
 */

class FirstWorker1 implements Runnable {

    private int counter;
    private Exchanger<Integer> exchanger;

    public FirstWorker1(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        while (true) {

            counter = counter + 1;
            System.out.println("FirstWorker incremented the counter: " + counter);

            try {
                System.out.println("FirstWorker about to exchange value "+counter);
                counter = exchanger.exchange(counter);
                System.out.println("FirstWorker exchanged value with other Thread "+counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SecondWorker1 implements Runnable {

    private int counter;
    private Exchanger<Integer> exchanger;

    public SecondWorker1(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        while (true) {

            counter = counter - 1;
            System.out.println("SecondWorker decremented the counter: " + counter);

            try {
                System.out.println("SecondWorker about to exchange value "+counter);
                counter = exchanger.exchange(counter);
                System.out.println("SecondWorker exchanged value with other Thread "+counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyExchanger {

    public static void main(String[] args) {

        Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(new FirstWorker1(exchanger)).start();
        new Thread(new SecondWorker1(exchanger)).start();

    }
}

/*
OUTPUT
-------
FirstWorker incremented the counter: 1
FirstWorker about to exchange value 1
SecondWorker decremented the counter: -1
SecondWorker about to exchange value -1
SecondWorker exchanged value with other Thread 1
FirstWorker exchanged value with other Thread -1
FirstWorker incremented the counter: 0
FirstWorker about to exchange value 0
SecondWorker decremented the counter: 0
SecondWorker about to exchange value 0
SecondWorker exchanged value with other Thread 0
FirstWorker exchanged value with other Thread 0
FirstWorker incremented the counter: 1
FirstWorker about to exchange value 1
SecondWorker decremented the counter: -1
SecondWorker about to exchange value -1
SecondWorker exchanged value with other Thread 1
FirstWorker exchanged value with other Thread -1
FirstWorker incremented the counter: 0
FirstWorker about to exchange value 0
SecondWorker decremented the counter: 0
SecondWorker about to exchange value 0
SecondWorker exchanged value with other Thread 0
FirstWorker exchanged value with other Thread 0
FirstWorker incremented the counter: 1
FirstWorker about to exchange value 1
SecondWorker decremented the counter: -1
SecondWorker about to exchange value -1
SecondWorker exchanged value with other Thread 1
FirstWorker exchanged value with other Thread -1
FirstWorker incremented the counter: 0
FirstWorker about to exchange value 0
SecondWorker decremented the counter: 0
SecondWorker about to exchange value 0
SecondWorker exchanged value with other Thread 0
FirstWorker exchanged value with other Thread 0
FirstWorker incremented the counter: 1
FirstWorker about to exchange value 1
SecondWorker decremented the counter: -1
SecondWorker about to exchange value -1
SecondWorker exchanged value with other Thread 1
FirstWorker exchanged value with other Thread -1
FirstWorker incremented the counter: 0
FirstWorker about to exchange value 0
SecondWorker decremented the counter: 0
SecondWorker about to exchange value 0
SecondWorker exchanged value with other Thread 0
FirstWorker exchanged value with other Thread 0
FirstWorker incremented the counter: 1
FirstWorker about to exchange value 1
* */