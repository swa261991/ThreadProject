package com.ConcurrentCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Integer> nums = Collections.synchronizedList(new ArrayList<>());
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    nums.add(i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    nums.add(i);
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
        System.out.println("Size of array: "+nums.size());
    }
}

/*
OUTPUT-1
------------
Exception in thread "Thread-1" java.lang.ArrayIndexOutOfBoundsException: 823
	at java.util.ArrayList.add(ArrayList.java:465)
	at com.ConcurrentCollections.ArrayListExample$2.run(ArrayListExample.java:21)
	at java.lang.Thread.run(Thread.java:748)
Size of array: 1148


OUTPUT-2 (After use of synchronizedList)
---------
Size of array: 2000

* */