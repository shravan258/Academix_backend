package com.academix_student.controller;

import com.academix_student.StudentDto.StudentLogin;
import com.academix_student.StudentDto.StudentRequest;
import com.academix_student.services.StudentService;
import com.sharedclasses.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentservice;

    @PostMapping("/student/addstudent")
    public StandardResponse addStudent(@RequestBody StudentRequest student){
        return studentservice.addStudent(student);
    }

    @PostMapping("/student/authenticate")
    public StandardResponse authenticateStudent(@RequestBody StudentLogin student){
        return studentservice.authenticate(student);
    }

    @GetMapping("/student/{student_id}/joinclassroom/{classcode}")
    public StandardResponse joinClassroom(@PathVariable Integer student_id, @PathVariable String classcode){
        return studentservice.joinClassroom(student_id, classcode);
    }
}
