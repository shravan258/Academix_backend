package com.academix_teacher.dto;

public class TeacherRequest {
    private String teacher_name;
    private String teacher_subject;
    private String teacher_org_code;

    private String password;

    private String teacher_email;

    public TeacherRequest() {
    }

    public TeacherRequest(String teacher_name, String password,String teacher_subject, String teacher_org_code,String teacher_email) {
        this.teacher_name = teacher_name;
        this.teacher_subject = teacher_subject;
        this.teacher_org_code = teacher_org_code;
        this.teacher_email = teacher_email;
        this.password = password;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_subject() {
        return teacher_subject;
    }

    public void setTeacher_subject(String teacher_subject) {
        this.teacher_subject = teacher_subject;
    }

    public String getTeacher_org_code() {
        return teacher_org_code;
    }

    public void setTeacher_org_code(String teacher_org_code) {
        this.teacher_org_code = teacher_org_code;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TeacherRequest{" +
                "teacher_name='" + teacher_name + '\'' +
                ", teacher_subject='" + teacher_subject + '\'' +
                ", teacher_org_code='" + teacher_org_code + '\'' +
                ", password='" + password + '\'' +
                ", teacher_email='" + teacher_email + '\'' +
                '}';
    }
}
