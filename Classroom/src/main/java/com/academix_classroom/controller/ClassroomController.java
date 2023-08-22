package com.academix_classroom.controller;


import com.academix_classroom.Dto.ClassroomRequest;
import com.academix_classroom.services.ClassroomService;
import com.sharedclasses.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClassroomController {

    @Autowired
    private ClassroomService classroomservice;

    @PostMapping("teacher/{teacherid}/addclassroom")
    public StandardResponse addClassroom(@RequestBody ClassroomRequest classroom, @PathVariable Integer teacherid){
        return classroomservice.addClassroom(classroom,teacherid);
    }


    @GetMapping("addtoclassroom/{code}/student/{student_id}")
    public StandardResponse addstudenttoclassroom(@PathVariable String code, @PathVariable Integer student_id){
        return classroomservice.addStudentToClassroom(code,student_id);
    }


}
