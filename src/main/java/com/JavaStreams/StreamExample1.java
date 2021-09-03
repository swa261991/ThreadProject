package com.JavaStreams;

import java.util.Arrays;
import java.util.stream.IntStream;

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
    }
}
