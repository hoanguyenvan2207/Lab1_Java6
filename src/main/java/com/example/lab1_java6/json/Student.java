package com.example.lab1_java6.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    String name;
    Boolean gender = false;
    Double marks = 0.0;
    Contact contact;
    List<String> subjects;

}
