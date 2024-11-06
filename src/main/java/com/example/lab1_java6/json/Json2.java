package com.example.lab1_java6.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Json2 {
    public static void main(String[] args) throws IOException {
//        demo1();
//        demo2();
//        demo3();
//        demo4();
//        demo5();
//        demo6();
        demo7();
    }
    private static void demo1() throws IOException {
        String path = "D:\\FPT POLYTECHNIC\\SOF3061_Java6\\Code\\Lab1_Java6\\src\\main\\java\\com\\example\\lab1_java6\\json\\student.json";

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> student = mapper.readValue(new File(path), Map.class);

        System.out.println(">> Name: " + student.get("name"));
        System.out.println(">> Gender: " + student.get("gender"));
        System.out.println(">> Mark: " + student.get("marks"));
        Map<String, Object> contact = (Map<String, Object>) student.get("contact");
        System.out.println(">> Phone: " + contact.get("email"));
        System.out.println(">> Phone: " + contact.get("phone"));
        List<String> subjects = (List<String>) student.get("subjects");
        subjects.forEach(subject -> System.out.println(">> Subject: " + subject));
    }

    private static void demo2() throws IOException {
        String path = "D:\\FPT POLYTECHNIC\\SOF3061_Java6\\Code\\Lab1_Java6\\src\\main\\java\\com\\example\\lab1_java6\\json\\students.json";

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> students = mapper.readValue(new File(path), List.class);
        students.forEach(student -> System.out.println(">> Name: " + student.get("name")));
    }

    private static void demo3() throws IOException {
        String path = "D:\\FPT POLYTECHNIC\\SOF3061_Java6\\Code\\Lab1_Java6\\src\\main\\java\\com\\example\\lab1_java6\\json\\student.json";

        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(new File(path), Student.class);

        System.out.println(">> Name: " + student.getName());
        System.out.println(">> Gender: " + student.getGender());
        System.out.println(">> Mark: " + student.getMarks());
        Contact contact = student.getContact();
        System.out.println(">> Phone: " + contact.getPhone());
        System.out.println(">> Phone: " + contact.getEmail());
        List<String> subjects = student.getSubjects();
        subjects.forEach(subject -> System.out.println(">> Subject: " + subject));
    }

    private static void demo4() throws IOException {
        String path = "D:\\FPT POLYTECHNIC\\SOF3061_Java6\\Code\\Lab1_Java6\\src\\main\\java\\com\\example\\lab1_java6\\json\\students.json";
        TypeReference<List<Student>> type = new TypeReference<List<Student>>() {};

        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = mapper.readValue(new File(path), type);
        students.forEach(student -> System.out.println(">> Name: " + student.getName()));

    }

    private static void demo5() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Nguyen Van Teo");
        student.put("marks", 7.5);
        student.put("gender", true);
        ObjectNode contact = student.putObject("contact");
        contact.put("email", "nguyenvanten@gmail.com");
        contact.put("phone", "0397235746");

        ArrayNode subject = student.putArray("subjects");
        subject.add("SOF304");
        subject.add("PDP2011");


        String json = mapper.writeValueAsString(student);

        mapper.writeValue(System.out, student);

        mapper.writeValue(new File("D:\\FPT POLYTECHNIC\\SOF3061_Java6\\Code\\Lab1_Java6\\src\\main\\java\\com\\example\\lab1_java6\\json\\student1.json"), student);
    }

    private static void demo6() throws IOException {
        Map<String, Object> contact = new HashMap<String, Object>();
        contact.put("email", "teo@gmail.com");
        contact.put("phone", "0826289426");

        List<String> subjects = Arrays.asList("WEB298", "SOF204");

        Map<String, Object> student = new HashMap<String , Object>();
        student.put("name", "Teo Nguyen Van");
        student.put("gender", true);
        student.put("marks", 6.0);
        student.put("contact", contact);
        student.put("subject", subjects);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(student);
        System.out.println(json);

        mapper.writeValue(System.out, student);

        mapper.writeValue(new File("D:\\FPT POLYTECHNIC\\SOF3061_Java6\\Code\\Lab1_Java6\\src\\main\\java\\com\\example\\lab1_java6\\json\\student1.json"), student);
    }

    private static void demo7() throws IOException {
        Contact contact = new Contact("hoanvph47429@fpt.edu.vn", "0375220702");
        List<String> subjects = Arrays.asList("SOF304", "COM304");
        Student student = new Student("Nguyen Van Hoa", true, 10.0, contact, subjects);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(student);

        mapper.writeValue(System.out, student);

        mapper.writeValue(new File("D:\\FPT POLYTECHNIC\\SOF3061_Java6\\Code\\Lab1_Java6\\src\\main\\java\\com\\example\\lab1_java6\\json\\student1.json"), student);
    }
}
