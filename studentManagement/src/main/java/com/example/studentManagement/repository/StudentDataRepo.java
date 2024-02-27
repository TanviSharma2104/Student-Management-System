package com.example.studentManagement.repository;

import com.example.studentManagement.model.StudentDataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDataRepo {
    private Map<Integer, StudentDataModel> studentMap;
    public StudentDataRepo(){
        studentMap=new HashMap<>();
    }

    public StudentDataModel getStudentById(final int id){
        return studentMap.getOrDefault(id, null);
    }

    public void deleteStudent(final int id){
        studentMap.remove(id);
    }
    public StudentDataModel createStudent(final int id, final String name,final String university, final String adhar,final int age){
        StudentDataModel newStudent= new StudentDataModel(name, university, adhar, age,id);
        studentMap.put(id, newStudent);
        return newStudent;
    }
    public StudentDataModel updateStudent(final int id, final String name, final String university, final String adhar, final int age){
        StudentDataModel newStudent=getStudentById(id);
        newStudent.setAge(age);
        newStudent.setName(name);
        newStudent.setAdhar(adhar);
        newStudent.setUniversity(university);
        return newStudent;
    }

    public List<StudentDataModel> getStudentByUniversity(final String university){
        List<StudentDataModel> studentList=new ArrayList<>();
        for(StudentDataModel currStudent: studentMap.values()){
            if(currStudent.getUniversity().equals(university)){
                studentList.add(currStudent);
            }
        }
        return studentList;
    }
}
