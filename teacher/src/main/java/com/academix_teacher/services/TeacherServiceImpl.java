package com.academix_teacher.services;

import com.academix_teacher.dao.TeacherDao;
import com.academix_teacher.dto.TeacherLogin;
import com.academix_teacher.dto.TeacherRequest;
import com.academix_teacher.entity.Teacher;
import com.academix_teacher.proxy.TeacherProxy;
import com.academix_teacher.security.JwtService;
import com.sharedclasses.AuthenticationResponse;
import com.sharedclasses.Role;
import com.sharedclasses.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Optional;


@Service
public class TeacherServiceImpl implements TeacherService{


    @Autowired
    private TeacherProxy proxy;
    @Autowired
    private TeacherDao teacherdao;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public StandardResponse addTeachertoOrg(Integer teacher_id, String teacher_org_code){

        StandardResponse org = proxy.addTeacherToOrg(teacher_id, teacher_org_code);
        if(org.getResult() == null){
            teacherdao.deleteById(teacher_id);
            return new StandardResponse("no organization exists with this code",null,false);
        }
        Optional<Teacher> savedTeacher = teacherdao.findById(teacher_id);
        if(savedTeacher.isEmpty()){
            teacherdao.deleteById(teacher_id);
            return new StandardResponse("no teacher found with this id",null,false);
        }
        System.out.println(org.getResult());
        Object tempOrg =  org.getResult();
        LinkedHashMap  res = (LinkedHashMap) tempOrg;
        savedTeacher.get().setTeacher_organization_id((Integer) res.get("organization_id"));
        teacherdao.save(savedTeacher.get());
        return new StandardResponse("teacher added to org successfully",savedTeacher.get(),true);
    }
    @Override
    public StandardResponse addTeacher(TeacherRequest teacher) {
        Optional<Teacher> tempTeacher = teacherdao.findByTeacherEmail(teacher.getTeacher_email());
        if(!tempTeacher.isEmpty()){
            return new StandardResponse("teacher already exists",null,false);
        }else{
            Teacher new_teacher = new Teacher();
            new_teacher.setTeacher_email(teacher.getTeacher_email());
            new_teacher.setTeacher_name(teacher.getTeacher_name());
            new_teacher.setTeacher_subject(teacher.getTeacher_subject());
            new_teacher.setTeacher_org_code(teacher.getTeacher_org_code());
            new_teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
            Teacher savedTeacher = teacherdao.save(new_teacher);
            return addTeachertoOrg(savedTeacher.getTeacher_id(), savedTeacher.getTeacher_org_code());
        }
    }
    @Override
    public StandardResponse addClassroom(Integer teacher_id, Integer classroom_id) {
        Optional<Teacher> tempTeacher = teacherdao.findById(teacher_id);
        if(tempTeacher.isEmpty()){
            return new StandardResponse("no teacher exists with this id",null,false);
        }
        tempTeacher.get().addClassroom(classroom_id);
        teacherdao.save(tempTeacher.get());
        return new StandardResponse("classroom added successfully",tempTeacher.get(),true);

    }

    @Override
    public StandardResponse authenticate(TeacherLogin teacher) {
        Optional<Teacher> tempteacher = teacherdao.findByTeacherEmail(teacher.getEmail());
        if(tempteacher.isEmpty()){
            return new StandardResponse("no teacher found with this id",null,false);
        }
        boolean matches = passwordEncoder.matches(teacher.getPassword(),tempteacher.get().getPassword() );
        if(!matches){
            return new StandardResponse("Bad credentials",null,false);
        }
        var jwtToken = jwtService.generateToken((UserDetails) tempteacher.get());
        AuthenticationResponse res = new AuthenticationResponse(jwtToken,tempteacher.get().getTeacher_id(), Role.TEACHER);
        return new StandardResponse("login successfull",res,true);
    }
}
