package com.JavaStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFileExample {
    public static void main(String[] args) throws IOException {
        String path = "E:\\Projects\\ThreadProject\\src\\main\\java\\com\\JavaStreams\\input.txt";

        Files.lines(Paths.get(path));
        Stream<String> namesStream = Files.lines(Paths.get(path));
        namesStream.forEach(System.out::println);
        System.out.println("-------- Using Collect -----------");
        namesStream = Files.lines(Paths.get(path));
        List<String> collect = namesStream.filter(x->x.startsWith("A")).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}

/*
OUTPUT
------
Adam
Keyin
Joe
Susan
Martha
Bill
Daniel
Michael
-------- Using Collect -----------
Adam

* */

