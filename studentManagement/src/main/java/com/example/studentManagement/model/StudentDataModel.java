package com.example.studentManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentDataModel {
    public String name;
    public String university;
    public String adhar;
    public int age;
    public int id;
}
