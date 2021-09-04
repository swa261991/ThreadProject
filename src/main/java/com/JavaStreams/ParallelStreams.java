package com.JavaStreams;

import java.util.stream.IntStream;

public class ParallelStreams {
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        long count = IntStream.rangeClosed(2, Integer.MAX_VALUE / 100).filter(ParallelStreams::isPrime).count();
        System.out.println("Num of primes: "+count);
        System.out.println("Time take: "+(System.currentTimeMillis()-currentTime));

        currentTime = System.currentTimeMillis();
        count = IntStream.rangeClosed(2, Integer.MAX_VALUE / 100).parallel().filter(ParallelStreams::isPrime).count();
        System.out.println("Num of primes (parallel): "+count);
        System.out.println("Time take (parallel): "+(System.currentTimeMillis()-currentTime));
    }

    public static boolean isPrime(long num) {
        if (num<=1) return false;
        if (num==2) return true;
        if (num%2==0) return false;

        //we check number is prime in range [0,sqrt(N)]
        long maxDivisor = (long) Math.sqrt(num);
        for (int i=3;i<maxDivisor;i+=2)
            if(num%i==0)
                return false;
            return true;
    }
}

/*
OUTPUT
------
Num of primes: 1358866
Time take: 18662
Num of primes (parallel): 1358866
Time take (parallel): 2773
* */