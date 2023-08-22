package com.academix_student.services;

import com.academix_student.StudentDao.StudentDao;
import com.academix_student.StudentDto.StudentLogin;
import com.academix_student.StudentDto.StudentRequest;
import com.academix_student.entity.Student;
import com.academix_student.proxy.StudentProxy;
import com.academix_student.security.JwtService;
import com.sharedclasses.AuthenticationResponse;
import com.sharedclasses.Role;
import com.sharedclasses.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentdao;

    @Autowired
    private StudentProxy proxy;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public StandardResponse addStudentToClassroom(Integer student_id,String classcode){
        StandardResponse ans = proxy.addstudenttoclassroom(classcode, student_id);
        System.out.println(ans);
        return ans;
    }
    @Override
    public StandardResponse addStudent(StudentRequest student) {
        Student tempstudent = studentdao.findByStudentRoll(student.getStudent_roll(),student.getYear(),student.getBranch());
        if(tempstudent != null){
            return new StandardResponse("student with this credentials already exists",null,false);
        }
        Student new_student = new Student();
        new_student.setStudent_name(student.getStudent_name());
        new_student.setStudent_roll(student.getStudent_roll());
        new_student.setBranch(student.getBranch());
        new_student.setYear(student.getYear());
        new_student.setStudent_organization(student.getStudent_organization());
        new_student.setStudent_email(student.getStudent_email());
        new_student.setStudent_password(passwordEncoder.encode(student.getStudent_password()));
        Student saved_student = studentdao.save(new_student);
        return new StandardResponse("student created successfully",saved_student,true);
    }

    @Override
    public StandardResponse joinClassroom(Integer student_id,String classcode) {
        Optional<Student> tempstudent = studentdao.findById(student_id);
        if(tempstudent.isEmpty()){
            return new StandardResponse("student with this credentials not found",null,false);
        }
        StandardResponse res = addStudentToClassroom(student_id,classcode);
        System.out.println(res);
        if(res.getResult() == null){
            return new StandardResponse(res.getMessage(),null,false);
        }
        return new StandardResponse(res.getMessage(),tempstudent.get(),true);
    }

    @Override
    public StandardResponse authenticate(StudentLogin student) {
        Optional<Student> tempstudent = studentdao.findByStudentEmail(student.getEmail());
        if(tempstudent.isEmpty()){
            return new StandardResponse("no student found with this id",null,false);
        }
        boolean matches = passwordEncoder.matches(student.getPassword(),tempstudent.get().getPassword() );
        if(!matches){
            return new StandardResponse("Bad credentials",null,false);
        }
        var jwtToken = jwtService.generateToken((UserDetails) tempstudent.get());
        AuthenticationResponse res = new AuthenticationResponse(jwtToken,tempstudent.get().getStudent_id(), Role.STUDENT);
        return new StandardResponse("login successfull",res,true);
    }
}
