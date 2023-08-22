package com.academix_classroom.services;

import com.academix_classroom.Dto.ClassroomRequest;
import com.sharedclasses.StandardResponse;

public interface ClassroomService {

    public StandardResponse addClassroom(ClassroomRequest classroom, Integer teacher_id);

    public StandardResponse addStudentToClassroom(String classroom_code,Integer student_id);

}
