package com.academix_student.services;

import com.academix_student.StudentDto.StudentLogin;
import com.academix_student.StudentDto.StudentRequest;
import com.sharedclasses.StandardResponse;

public interface StudentService {
    public StandardResponse addStudent(StudentRequest student);

    public StandardResponse joinClassroom(Integer student_id,String classcode);

    public StandardResponse authenticate(StudentLogin student);
}
