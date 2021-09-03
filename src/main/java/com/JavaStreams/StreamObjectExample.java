package com.JavaStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamObjectExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Adam", true));
        students.add(new Student("Sue", false));
        students.add(new Student("Kevin", false));
        students.add(new Student("Joe", true));
        students.add(new Student("Daniel", true));

        students.stream().map(Student::getName).forEach(System.out::println);
        System.out.println("------- starts with -----------");
        students.stream().map(Student::getName).filter(x->x.startsWith("D")).forEach(System.out::println);
        System.out.println("------- print students --------");
        students.stream().filter(s->s.isLocal()==false).forEach(s->System.out.println(s.getName()));
        System.out.println("------- count -----------------");
        long count = students.stream().filter(s -> s.isLocal()).count();
        System.out.println(count);
        System.out.println("------- join  -----------------");
        String collect = students.stream().filter(s -> s.isLocal()).map(Student::getName).collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}

/*
OUTPUT
------
Adam
Sue
Kevin
Joe
Daniel
------- starts with -----------
Daniel
------- print students --------
Sue
Kevin
------- count -----------------
3
------- join  -----------------
Adam Joe Daniel

* */
