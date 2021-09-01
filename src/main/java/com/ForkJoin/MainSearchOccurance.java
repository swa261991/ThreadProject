package com.ForkJoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SearchTask extends RecursiveTask<Integer> {

    int arr[];
    int start, end;
    int searchEle;

    public SearchTask(int arr[], int start, int end, int searchEle) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.searchEle = searchEle;
    }

    @Override
    protected Integer compute() {
        int size = end - start + 1;
        if (size > 2500000) {
            int mid = (end + start) / 2;
            SearchTask task1 = new SearchTask(arr, start, mid, searchEle);
            SearchTask task2 = new SearchTask(arr, mid + 1, end, searchEle);
            task1.fork();
            task2.fork();
            int result = task1.join() + task2.join();
            return result;
        } else {
            return processSearch();
        }
        //return processSearch();
    }

    private Integer processSearch() {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == searchEle) {
                count++;
            }
        }
        return count;
    }
}

public class MainSearchOccurance {
    public static void main(String[] args) {
        int arr[] = new int[5000000];
        int searchEle = 7;
        int start = 0;
        int end = arr.length - 1;

        Random rand = new Random();
        for (int i = 0; i < 4999995; i++) {
            arr[i] = rand.nextInt(999999999);
            if (arr[i]==7)arr[i]=8;
        }
        arr[4999995] = 7;
        arr[4999996] = 7;
        arr[4999997] = 7;
        arr[4999998] = 7;
        arr[4999999] = 7;

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        //ForkJoinPool pool = ForkJoinPool.commonPool();
        SearchTask task = new SearchTask(arr, start, end, searchEle);
        long startTime = System.currentTimeMillis();
        int result = pool.invoke(task);
        System.out.printf("%d found %d times\n", searchEle, result);
        System.out.println("Search Time in milliseconds : "+(System.currentTimeMillis()-startTime));
    }
}

/*
OUTPUT
------
7 found 5 times
Search Time in milliseconds : 17

* */