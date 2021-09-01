package com.ForkJoin;

import sun.java2d.pipe.SpanShapeRenderer;

import java.util.concurrent.ForkJoinPool;

public class MainForkJoinCaller {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(120);
        pool.invoke(simpleRecursiveAction);
    }
}
