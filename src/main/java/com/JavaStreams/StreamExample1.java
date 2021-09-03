package com.JavaStreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample1 {
    public static void main(String[] args) {
        int[] nums = {1,5,3,-2,9,12};
        Arrays.stream(nums).forEach(System.out::println);
        int sum = Arrays.stream(nums).sum();
        System.out.println("Sum: "+sum);

        IntStream.range(0,5).forEach(x-> System.out.print(x+" "));
        System.out.println();
        IntStream.range(0,10).filter(x->x>4).forEach(x-> System.out.print(x+" "));
        System.out.println();
        IntStream.range(0,10).filter(x->x%2==0).forEach(x-> System.out.print(x+" "));
        System.out.print("\n");
        String[] names = {"Adam", "Daniel", "Martha", "Kevin", "Ben", "Joe", "Brad", "Susan"};
        Stream.of(names).forEach(System.out::println);
        System.out.println("-------- sorted asc ----------");
        Stream.of(names).sorted().forEach(System.out::println);
        System.out.println("-------- sorted desc ----------");
        Stream.of(names).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("-------- starts with ----------");
        Stream.of(names).filter(x-> x.startsWith("A")).forEach(System.out::println);
    }
}

/*
OUTPUT
------

1
5
3
-2
9
12
Sum: 28
0 1 2 3 4
5 6 7 8 9
0 2 4 6 8
Adam
Daniel
Martha
Kevin
Ben
Joe
Brad
Susan
-------- sorted asc ----------
Adam
Ben
Brad
Daniel
Joe
Kevin
Martha
Susan
-------- sorted desc ----------
Susan
Martha
Kevin
Joe
Daniel
Brad
Ben
Adam
-------- starts with ----------
Adam


* */