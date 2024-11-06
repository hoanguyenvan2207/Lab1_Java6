package com.example.lab1_java6.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Json1 {
    public static void main(String[] args) throws IOException {
//        demo1();
        demo2();
    }

    private static void demo1() throws IOException {
        String path = "D:\\FPT POLYTECHNIC\\SOF3061_Java6\\Code\\Lab1_Java6\\src\\main\\java\\com\\example\\lab1_java6\\json\\student.json";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode student = mapper.readTree(new File(path));

        System.out.println(">> Name: " + student.get("name").asText());
        System.out.println(">> Gender: " + student.get("gender").asText());
        System.out.println(">> Mark: " + student.get("marks").asText());
        System.out.println(">> Contact: " + student.get("contact").get("email").asText());
        System.out.println(">> Phone: " + student.findValue("phone").asText());
        student.get("subjects").iterator().forEachRemaining(subject -> {
            System.out.println(">> Subject: " +subject.asText());
        });
    }

    private static void demo2() throws IOException {
        String path = "D:\\FPT POLYTECHNIC\\SOF3061_Java6\\Code\\Lab1_Java6\\src\\main\\java\\com\\example\\lab1_java6\\json\\students.json";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode student = mapper.readTree(new File(path));

        student.iterator().forEachRemaining(sv -> System.out.println(">> Name: " + sv.get("name").asText()));
    }
}
