package com.academix_teacher.Controller;
import com.academix_teacher.dto.TeacherLogin;
import com.academix_teacher.dto.TeacherRequest;
import com.academix_teacher.proxy.TeacherProxy;
import com.academix_teacher.services.TeacherService;
import com.sharedclasses.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    @Autowired
    private TeacherProxy proxy;

    @Autowired
    private TeacherService teacherservice;


    @PostMapping("/addTeacher")
    public StandardResponse addteacher(@RequestBody TeacherRequest teacher){
        return teacherservice.addTeacher(teacher) ;
    }

    @GetMapping("/teacher/{id}/addclassroom/{classroom_id}")
    public StandardResponse addClassroom(@PathVariable Integer id, @PathVariable Integer classroom_id){
        return teacherservice.addClassroom(id,classroom_id);
    }

    @PostMapping("/teacher/authenticate")
    public StandardResponse loginTeacher(@RequestBody TeacherLogin teacher){
        return teacherservice.authenticate(teacher);
    }
}
