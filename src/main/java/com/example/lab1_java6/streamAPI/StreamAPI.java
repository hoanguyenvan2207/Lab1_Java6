package com.example.lab1_java6.streamAPI;

import com.example.lab1_java6.lambda.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
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
    private static void demo1(){
        // c1
        Stream<Integer> stream1 = Stream.of(1,3,5,6,9);
        stream1.forEach(n -> System.out.println(n));

        // c2
        List<Integer> list = Arrays.asList(1,3,5,6,9);
        list.stream().forEach(m -> System.out.println(m));

    }

    private static void demo2(){
        List<Integer> list = Arrays.asList(1,3,5,6,9);
        List<Double> result = list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> Math.sqrt(n))
                .peek(d -> System.out.println(d))
                .collect(Collectors.toList());
    }

    private static void demo3(){
        List<Student> result = studentList.stream()
                .filter(sv -> sv.getMarks() >= 7)
                .peek(sv -> sv.setName(sv.getName().toUpperCase()))
                .collect(Collectors.toList());

        result.forEach(sv -> {
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Marks: " + sv.getMarks());
            System.out.println();
        });
    }

    private static void demo4(){
        double average = studentList.stream()
                .mapToDouble(sv ->  sv.getMarks())
                .average().getAsDouble();
        System.out.println("Average: " + average);

        double sum = studentList.stream()
                .mapToDouble(sv ->  sv.getMarks())
                .sum();
        System.out.println("Sum: " + sum);

        double min_marks = studentList.stream()
                .mapToDouble(sv ->  sv.getMarks())
                .min().getAsDouble();
        System.out.println("Min marks: " + min_marks);

        boolean all_passed = studentList.stream()
                .allMatch(sv -> sv.getMarks() >=5);
        System.out.println(("All passed: " + all_passed));

        Student min_sv = studentList.stream()
                .reduce(studentList.get(0), (min,sv) -> sv.getMarks() < min.getMarks() ? sv : min);
        System.out.println("Min sv: " + min_sv.getName());
    }
}
