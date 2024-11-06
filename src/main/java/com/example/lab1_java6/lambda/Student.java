package com.example.lab1_java6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private String name;
    private Boolean gender = false;
    private Double marks = 0.0;
}
