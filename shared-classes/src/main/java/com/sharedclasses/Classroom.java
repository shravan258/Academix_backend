package com.sharedclasses;


import java.util.ArrayList;
import java.util.List;


public class Classroom {


    private Integer classroom_id;

    private String classroom_name;
    private String classroom_code;
    private String classroom_subject ;
   private String  classroom_description;
   private Integer classroom_teacher_id;
   private Integer classroom_organization_id;

   List<Integer> classroom_posts_id = new ArrayList<Integer>();

   List<Integer> classroom_students_id = new ArrayList<Integer>();

    public Classroom() {
    }

    public Classroom(Integer classroom_id, String classroom_name ,String classroom_code, String classroom_subject, String classroom_description, Integer classroom_teacher_id, Integer classroom_organization_id, List<Integer> classroom_posts_id, List<Integer> classroom_students_id) {
        this.classroom_id = classroom_id;
        this.classroom_code = classroom_code;
        this.classroom_subject = classroom_subject;
        this.classroom_description = classroom_description;
        this.classroom_teacher_id = classroom_teacher_id;
        this.classroom_organization_id = classroom_organization_id;
        this.classroom_posts_id = classroom_posts_id;
        this.classroom_students_id = classroom_students_id;
    }

    public Integer getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(Integer classroom_id) {
        this.classroom_id = classroom_id;
    }

    public String getClassroom_name() {
        return classroom_name;
    }

    public void setClassroom_name(String classroom_name) {
        this.classroom_name = classroom_name;
    }

    public String getClassroom_code() {
        return classroom_code;
    }

    public void setClassroom_code(String classroom_code) {
        this.classroom_code = classroom_code;
    }

    public String getClassroom_subject() {
        return classroom_subject;
    }

    public void setClassroom_subject(String classroom_subject) {
        this.classroom_subject = classroom_subject;
    }

    public String getClassroom_description() {
        return classroom_description;
    }

    public void setClassroom_description(String classroom_description) {
        this.classroom_description = classroom_description;
    }

    public Integer getClassroom_teacher_id() {
        return classroom_teacher_id;
    }

    public void setClassroom_teacher_id(Integer classroom_teacher_id) {
        this.classroom_teacher_id = classroom_teacher_id;
    }

    public Integer getClassroom_organization_id() {
        return classroom_organization_id;
    }

    public void setClassroom_organization_id(Integer classroom_organization_id) {
        this.classroom_organization_id = classroom_organization_id;
    }

    public List<Integer> getClassroom_posts_id() {
        return classroom_posts_id;
    }

    public void setClassroom_posts_id(List<Integer> classroom_posts_id) {
        this.classroom_posts_id = classroom_posts_id;
    }

    public List<Integer> getClassroom_students_id() {
        return classroom_students_id;
    }

    public void setClassroom_students_id(List<Integer> classroom_students_id) {
        this.classroom_students_id = classroom_students_id;
    }

    public void addStudents (Integer student_id){
        classroom_students_id.add(student_id);
    }

    public void addPosts(Integer post_id){
        classroom_posts_id.add(post_id);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroom_id=" + classroom_id +
                ", classroom_name='" + classroom_name + '\'' +
                ", classroom_code='" + classroom_code + '\'' +
                ", classroom_subject='" + classroom_subject + '\'' +
                ", classroom_description='" + classroom_description + '\'' +
                ", classroom_teacher_id=" + classroom_teacher_id +
                ", classroom_organization_id=" + classroom_organization_id +
                ", classroom_posts_id=" + classroom_posts_id +
                ", classroom_students_id=" + classroom_students_id +
                '}';
    }
}
