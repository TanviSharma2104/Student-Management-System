package com.example.studentManagement.resources;

import com.example.studentManagement.model.StudentDataModel;
import com.example.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class Student {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get/{id}")
    public StudentDataModel getStudent(@PathVariable int id)throws  Exception{
        return studentService.getStudent(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id)throws Exception{
        studentService.deleteStudent(id);
    }
    @PostMapping("/create/{name}/{university}/{adhar}/{age}")
    public int createStudent(@PathVariable String name, @PathVariable String university, @PathVariable String adhar, @PathVariable int age){
        return studentService.createStudent(name, university,adhar,age);
    }

    @PutMapping("/update/{id}/{name}/{university}/{adhar}/{age}")
    public StudentDataModel updateStudent(@PathVariable int id, @PathVariable String name, @PathVariable String university, @PathVariable String adhar, @PathVariable int age){
        return studentService.updateStudent(id, name, university, adhar, age);
    }

    @GetMapping("/getByUniv/{university}")
    public List<StudentDataModel> getStudentByUniversity(@PathVariable String university)throws Exception{
        return studentService.getStudentByUniversity(university);
    }

}
