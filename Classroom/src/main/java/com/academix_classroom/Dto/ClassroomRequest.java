package com.academix_classroom.Dto;

public class ClassroomRequest {


    private String classroom_name;

    private String classroom_subject;

    private Integer classroom_teacher_id;

    private Integer classroom_org_id;

    private String classroom_description;

    public ClassroomRequest() {
    }

    public ClassroomRequest( String classroom_description ,String classroom_name, String classroom_subject, Integer classroom_teacher_id, Integer classroom_org_id) {
        this.classroom_name = classroom_name;
        this.classroom_subject = classroom_subject;
        this.classroom_teacher_id = classroom_teacher_id;
        this.classroom_org_id = classroom_org_id;
        this.classroom_description = classroom_description;
    }



    public String getClassroom_name() {
        return classroom_name;
    }

    public void setClassroom_name(String classroom_name) {
        this.classroom_name = classroom_name;
    }

    public String getClassroom_subject() {
        return classroom_subject;
    }

    public void setClassroom_subject(String classroom_subject) {
        this.classroom_subject = classroom_subject;
    }

    public Integer getClassroom_teacher_id() {
        return classroom_teacher_id;
    }

    public void setClassroom_teacher_id(Integer classroom_teacher_id) {
        this.classroom_teacher_id = classroom_teacher_id;
    }

    public Integer getClassroom_org_id() {
        return classroom_org_id;
    }

    public void setClassroom_org_id(Integer classroom_org_id) {
        this.classroom_org_id = classroom_org_id;
    }

    public String getClassroom_description() {
        return classroom_description;
    }

    public void setClassroom_description(String classroom_description) {
        this.classroom_description = classroom_description;
    }


    @Override
    public String toString() {
        return "ClassroomRequest{" +
                "classroom_name='" + classroom_name + '\'' +
                ", classroom_subject='" + classroom_subject + '\'' +
                ", classroom_teacher_id=" + classroom_teacher_id +
                ", classroom_org_id=" + classroom_org_id +
                ", classroom_description='" + classroom_description + '\'' +
                '}';
    }
}
