package com.example.studentManagement.service;

import com.example.studentManagement.model.StudentDataModel;
import com.example.studentManagement.repository.StudentDataRepo;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public class StudentService {
    @Autowired
    public StudentDataRepo studentDataRepo;

    public int createStudent(final String name, final String university, final String adhar, final int age){
        int randomID= (int) (Math.random() * 10);
        StudentDataModel studentDataModel=studentDataRepo.createStudent(randomID, name, university, adhar, age);
        return studentDataModel.getId();
    }
    public StudentDataModel getStudent(final int id)throws BadRequestException{
        StudentDataModel studentDataModel=studentDataRepo.getStudentById(id);
        if(studentDataModel==null){
            throw new BadRequestException("Invalid User");
        }
        return studentDataModel;
    }
    public void deleteStudent(final int id) throws BadRequestException {
        StudentDataModel studentDataModel=getStudent(id);
        studentDataRepo.deleteStudent(id);
    }

    public StudentDataModel updateStudent(final int id, final String name, final String university, final String adhar, final int age){
        StudentDataModel studentDataModel=studentDataRepo.getStudentById(id);
        return studentDataRepo.updateStudent(id, name, university, adhar, age);
    }

    public List<StudentDataModel> getStudentByUniversity(final String university)throws BadRequestException{
        List<StudentDataModel> studentList=studentDataRepo.getStudentByUniversity(university);
        if(studentList.isEmpty()){
            throw new BadRequestException("No Student with given University exists");
        }
        return studentList;
    }

}
