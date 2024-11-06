package com.example.lab1_java6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda {
   static List<Student> studentList = Arrays.asList(
            new Student("Nguyen Van Teo", true, 6.7),
            new Student("Tran Thi Thu Huong", false, 8.5),
            new Student("Pham Duc Cuong", true, 9.5),
            new Student("Le Thi My Hong", false,  6.5),
            new Student("Nguyen Van Ty", true, 8.0)
    );
    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
        demo4();
    }

    private static void demo4() {
        Demo4Inter demo4Inter = x -> System.out.println(x);
        demo4Inter.m1(2024);
    }

    private static void demo3() {
        Collections.sort(studentList,(sv1, sv2) -> sv1.getMarks().compareTo(sv2.getMarks()));
        studentList.forEach(sv ->{
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Marks: " + sv.getMarks());
            System.out.println();
        });
    }

    public static void demo1(){
        List<Integer> list = Arrays.asList(1, 9, 5, 3, 8, 10);
        list.forEach(n -> System.out.println(n));
    }
    public static void demo2(){

        studentList.forEach(
                sv -> {
                    System.out.println(">> Name: " + sv.getName());
                    System.out.println(">> Marks: " + sv.getMarks());
                    System.out.println();
                }
        );
    }
}

@FunctionalInterface
interface Demo4Inter{
    void m1(int x);
    default void m2(){}
    public static void m3(){}
}
