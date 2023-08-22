package com.academix_classroom.services;


import com.academix_classroom.Dao.ClassroomDao;
import com.academix_classroom.Dto.ClassroomRequest;
import com.academix_classroom.Proxy.ClassroomProxy;
import com.academix_classroom.entity.Classroom;
import com.sharedclasses.StandardResponse;
import com.sharedclasses.UniqueCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService{

    @Autowired
    private ClassroomDao classroomdao;

    @Autowired
    private ClassroomProxy proxy;

    public StandardResponse addClassroomToTeacher(Integer teacher_id, Integer classroom_id){
        return proxy.addClassroom(teacher_id, classroom_id);
    }
    @Override
    public StandardResponse addClassroom(ClassroomRequest classroom, Integer teacher_id) {
        Classroom savedclassroom = classroomdao.findByClassroomName(classroom.getClassroom_name());
        if(savedclassroom != null){
            return new StandardResponse("classroom already exists",null,false);
        }
        Classroom new_classroom= new Classroom();
        new_classroom.setClassroom_description(classroom.getClassroom_description());
        new_classroom.setClassroom_name(classroom.getClassroom_name());
        new_classroom.setClassroom_subject(classroom.getClassroom_subject());
        new_classroom.setClassroom_code(UniqueCodeService.generateUniqueCode());
        new_classroom.setClassroom_teacher_id(teacher_id);
        new_classroom.setClassroom_organization_id(classroom.getClassroom_org_id());
        Classroom tempclassroom = classroomdao.save(new_classroom);
        addClassroomToTeacher(tempclassroom.getClassroom_teacher_id(),tempclassroom.getClassroom_id());
        return new StandardResponse("classroom created successfully",tempclassroom,true);
    }

    @Override
    public StandardResponse addStudentToClassroom(String classroom_code, Integer student_id) {
        Classroom tempClassroom = classroomdao.findByClassroomCode(classroom_code);
        System.out.println(tempClassroom);
        if(tempClassroom == null){

            return new StandardResponse("no classroom found with this id",null,false);
        }
        if(tempClassroom.getClassroom_students_id().contains(student_id)){

            return new StandardResponse("student already joined classroom",null,false);
        }
        tempClassroom.addStudents(student_id);
        classroomdao.save(tempClassroom);
        return new StandardResponse("student added to classroom successfully",tempClassroom,true);
    }
}
