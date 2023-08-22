package com.sharedclasses;


import java.util.ArrayList;
import java.util.List;


public class Teacher {

    private Integer teacher_id;
    private String teacher_name;
    private List<Integer> teacher_classroom_ids;

    private String teacher_email;
    private String teacher_subject;
    private Integer teacher_organization_id;

    private String teacher_org_code;

    List<Integer> teacher_posts = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String teacher_name, List<Integer> teacher_classroom_ids, String teacher_subject, Integer teacher_organization_id, String teacher_org_code, List<Integer> teacher_posts, String teacher_email) {
        this.teacher_name = teacher_name;
        this.teacher_classroom_ids = teacher_classroom_ids;
        this.teacher_subject = teacher_subject;
        this.teacher_organization_id = teacher_organization_id;
        this.teacher_org_code = teacher_org_code;
        this.teacher_posts = teacher_posts;
        this.teacher_email = teacher_email;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public List<Integer> getTeacher_classroom_ids() {
        return teacher_classroom_ids;
    }

    public void setTeacher_classroom_ids(List<Integer> teacher_classroom_ids) {
        this.teacher_classroom_ids = teacher_classroom_ids;
    }

    public String getTeacher_subject() {
        return teacher_subject;
    }

    public void setTeacher_subject(String teacher_subject) {
        this.teacher_subject = teacher_subject;
    }

    public Integer getTeacher_organization_id() {
        return teacher_organization_id;
    }

    public void setTeacher_organization_id(Integer teacher_organization_id) {
        this.teacher_organization_id = teacher_organization_id;
    }

    public List<Integer> getTeacher_posts() {
        return teacher_posts;
    }

    public void setTeacher_posts(List<Integer> teacher_posts) {
        this.teacher_posts = teacher_posts;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_classroom_id=" + teacher_classroom_ids +
                ", teacher_email='" + teacher_email + '\'' +
                ", teacher_subject='" + teacher_subject + '\'' +
                ", teacher_organization_id=" + teacher_organization_id +
                ", teacher_org_code='" + teacher_org_code + '\'' +
                ", teacher_posts=" + teacher_posts +
                '}';
    }
}
