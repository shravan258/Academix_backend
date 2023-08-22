package com.academix_teacher.services;

import com.academix_teacher.dto.TeacherLogin;
import com.academix_teacher.dto.TeacherRequest;
import com.sharedclasses.StandardResponse;

public interface TeacherService {

    public StandardResponse addTeacher(TeacherRequest teacher);

    public StandardResponse addClassroom(Integer teacher_id, Integer classroom_id);

    public StandardResponse authenticate(TeacherLogin teacher);


}
